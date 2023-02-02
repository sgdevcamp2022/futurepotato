package s3.feed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import s3.feed.dto.CommentDto;
import s3.feed.entity.CommentEntity;
import s3.feed.entity.ReplyEntity;
import s3.feed.service.CommentService;

@RestController
//@RequestMapping("feed")
public class CommentController {
    @Autowired
    CommentService commentService;


    @PostMapping("/{accountId}/{postId}/comment")
    public CommentEntity createComments(@PathVariable("accountId")String accountId, @PathVariable("postId")Long postId, @RequestBody CommentDto.ReqCommentDto reqCommentDto){
        return commentService.createComment(accountId, postId, reqCommentDto.getComment());

    }

    @DeleteMapping("/{accountId}/comment/{commentId}")
    public void deleteComments(@PathVariable("accountId")String accountId, @PathVariable("commentId")Long commentId){
        commentService.deleteComment(accountId, commentId);

    }

    @PostMapping("/{accountId}/{commentId}/reply")
    public ReplyEntity createReplies(@PathVariable("accountId")String accountId, @PathVariable("commentId")Long commentId, @RequestBody CommentDto.ReqReplyDto reqReplyDto){
        return commentService.createReplies(accountId, commentId, reqReplyDto.getReply());

    }

    @DeleteMapping("/{accountId}/reply/{replyId}")
    public void deleteReplies(@PathVariable("accountId")String accountId, @PathVariable("replyId")Long replyId){
        commentService.deleteReply(accountId, replyId);

    }

}
