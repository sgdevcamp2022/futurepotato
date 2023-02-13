package s3.feed.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s3.feed.entity.*;
import s3.feed.exception.ForbiddenException;
import s3.feed.rabbitMq.CustomMessage;
import s3.feed.rabbitMq.RabbitmqProducer;
import s3.feed.repository.CommentRepository;
import s3.feed.repository.PostRepository;
import s3.feed.repository.ReplyRepository;
import s3.feed.repository.UserRepository;

import java.time.LocalDateTime;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    RabbitmqProducer rabbitmqProducer;

    public ResponseEntity createComment(String accountId, Long postId, String comment) throws JsonProcessingException {
        UserEntity userEntity = userRepository.findByAccountId(accountId);

        CommentEntity commentEntity = new CommentEntity(comment, userEntity.getAccountId(), LocalDateTime.now(), 0, userEntity.getProfileImage());
        commentEntity.addUser(userEntity);
        PostEntity postEntity = postRepository.findById(postId).get();
        postEntity.upCommentCount(postEntity.getCommentCount());
        postEntity.getCommentEntityList().add(commentEntity);
//        postEntity.addUser(userEntity);
        Long commentId = commentRepository.save(commentEntity).getId();
        postRepository.save(postEntity);
        /*rabbitMQ */

        CustomMessage customMessage = new CustomMessage(accountId, postEntity.getAccountId(), postEntity.getContent(),"댓글을 달았습니다.");
        rabbitmqProducer.sendMessage(customMessage);


        return ResponseEntity.ok("commentId "+commentId+" ,댓글 등록");
    }

    public ResponseEntity deleteComment(String accountId, Long commentId){
        CommentEntity commentEntity = commentRepository.findById(commentId).get();
        String commentWriter = commentEntity.getUserEntity().getAccountId();
        if(commentWriter.equals(accountId)) {
            commentRepository.deleteById(commentId);
        }
        else
            throw new ForbiddenException("권한이 없습니다.");
        return ResponseEntity.ok("댓글 삭제 성공");
    }
    public ResponseEntity createReplies(String accountId, Long commentId, String reply) throws JsonProcessingException {
        UserEntity userEntity = userRepository.findByAccountId(accountId);
        ReplyEntity replyEntity = new ReplyEntity(reply, userEntity.getAccountId(), LocalDateTime.now(), 0, userEntity.getProfileImage());
        replyEntity.addUser(userEntity);
        CommentEntity commentEntity = commentRepository.findById(commentId).get();
        commentEntity.getReplyEntityList().add(replyEntity);
        Long replyId = replyRepository.save(replyEntity).getId();

        commentRepository.save(commentEntity);
        /*rabbitMQ */

        CustomMessage customMessage = new CustomMessage(accountId, commentEntity.getAccountId(), commentEntity.getComment(),"대댓글을 달았습니다.");
        rabbitmqProducer.sendMessage(customMessage);

        return ResponseEntity.ok("replyId: "+replyId+" ,대댓글 등록");

    }

    public ResponseEntity deleteReply(String accountId, Long replyId){
        ReplyEntity replyEntity = replyRepository.findById(replyId).get();
        String replyWriter = replyEntity.getUserEntity().getAccountId();
        if(replyWriter.equals(accountId)) {
            replyRepository.deleteById(replyId);
        }
        else
            throw new ForbiddenException("권한이 없습니다.");
        return ResponseEntity.ok("대댓글 삭제 성공");
    }

}
