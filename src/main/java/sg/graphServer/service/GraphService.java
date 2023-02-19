package sg.graphServer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.graphServer.entity.Account;
//import sg.graphServer.entity.SocialRelationship;
import sg.graphServer.repository.GraphRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
public class GraphService {
    @Autowired
    private GraphRepository graphRepository;

    //1. 소셜 관계 신청 : 팔로우, 차단
    @Transactional
    public void socialRequest(String request, String senderId, String recipientId){

        Account savedSender = graphRepository.findByAccountId(senderId);
        Account savedRecipient = graphRepository.findByAccountId(recipientId);
        String savedSenderId = savedSender.getAccountId();
        String savedRecipientId = savedRecipient.getAccountId();
        recipientValidate(savedSenderId, savedRecipientId);
        /* relationship validation */
        switch (request) {
            case "follow":
                //(1) 차단한 상태인지 확인
                if(!graphRepository.isBlocking(savedSenderId, savedRecipientId)
                        && !graphRepository.isBlocking(savedRecipientId, savedSenderId)){
                    //(2) 이미 팔로우한 상태인지 확인
                    if(!graphRepository.isFollowing(savedSenderId, savedRecipientId)){
                        //관련 속성 변경
                        savedSender.setFollowingCount(savedSender.getFollowingCount()+1);
                        savedRecipient.setFollowerCount(savedRecipient.getFollowerCount()+1);
                        log.info("Sender's FollowingCount = {}, Recipient's FollowerCount = {}", savedSender.getFollowingCount(), savedRecipient.getFollowerCount());
                        //변경된 속성 db에 반영
                        graphRepository.save(savedRecipient); graphRepository.save(savedSender);
                         //팔로우
                      graphRepository.follow(savedSenderId, savedRecipientId);
                  } else {throw new RuntimeException("already follow");}
                } else {throw new RuntimeException("already block");}
                break;
            case "block":
                //(1) 이미 block한 상태인지 확인
                if(!graphRepository.isBlocking(savedSenderId, savedRecipientId)
                        && !graphRepository.isBlocking(savedRecipientId, savedSenderId)){
                    if(savedSender.getFollowingCount()>=1 && savedRecipient.getFollowerCount()>=1) {
                        //관련 속성 변경
                        savedSender.setFollowingCount(savedSender.getFollowingCount() - 1);
                        savedRecipient.setFollowerCount(savedRecipient.getFollowerCount() - 1);
                        //변경된 속성 db에 반영
                        graphRepository.save(savedRecipient); graphRepository.save(savedSender);
                    }
                    //차단
                    graphRepository.block(savedSenderId, savedRecipientId);
                } else {throw new RuntimeException("already block");}
                break;
            default:
                throw new RuntimeException("Invalid request.");
        }
    }

    //2. 소셜 관계 신청 취소 : 팔로우 취소, 차단 취소
    @Transactional
    public void cancelSocialRequest(String request, String senderId, String recipientId){
        Account savedSender = graphRepository.findByAccountId(senderId);
        Account savedRecipient = graphRepository.findByAccountId(recipientId);
        String savedSenderId = graphRepository.findByAccountId(senderId).getAccountId();
        String savedRecipientId = graphRepository.findByAccountId(recipientId).getAccountId();
        recipientValidate(savedSenderId, savedRecipientId);
        /* relationship validation */
        switch (request) {
            case "follow":
                //애초에 follow한 상태인지 확인
                if(graphRepository.isFollowing(savedSenderId, savedRecipientId)) {
                    //관련 속성 변경
                    savedSender.setFollowingCount(savedSender.getFollowingCount()-1);
                    savedRecipient.setFollowerCount(savedRecipient.getFollowerCount()-1);
                    //변경된 속성 db에 반영
                    graphRepository.save(savedRecipient); graphRepository.save(savedSender);
                    graphRepository.unfollow(savedSenderId, savedRecipientId);
                } else {String msg = savedSenderId+" didn't follow "+savedRecipientId; throw new RuntimeException(msg);}
                break;
            case "block":
                //애초에 block한 상태인지 확인
                if(graphRepository.isBlocking(savedSenderId, savedRecipientId)) {
                    graphRepository.unblock(savedSenderId, savedRecipientId);
                } else {String msg = savedSenderId+" didn't block "+savedRecipientId; throw new RuntimeException(msg);}
                break;
            default:
                throw new RuntimeException("Invalid request.");
        }


    }

    //3. accountId가 소셜 관계 신청한 계정 목록 조회 : 팔로잉 목록, 블록킹 목록
    public List<Account> findRequest(String request, String accountId){

        String savedAccountId = graphRepository.findByAccountId(accountId).getAccountId();
        //validation : DB에 저장된 AccountId인지 확인
        if(savedAccountId==null){throw new RuntimeException("AccountId doesn't exists.");}

        switch (request) {
            case "following":
                List<Account> followingList = graphRepository.findFollowing(savedAccountId);
                log.info("found {} accounts that {} is following", followingList.size(), savedAccountId);
                return followingList;
            case "blocking":
                List<Account> blockingList = graphRepository.findBlocking(savedAccountId);
                log.info("found {} accounts that {} is blocking", blockingList.size(), savedAccountId);
                return blockingList;
            case "follower":
                List<Account> followerList = graphRepository.findFollowers(savedAccountId);
                log.info("found {} followers of {}", followerList.size(), savedAccountId);
                return followerList;
            case "blocker":
                List<Account> blockerList = graphRepository.findBlockers(savedAccountId);
                log.info("found {} blockers of {}", blockerList.size(), savedAccountId);
                return blockerList;
            default:
                throw new RuntimeException("Invalid request.");
        }
    }

    //4. 해당 relation 을 맺고 있는지 확인
    public boolean isRequesting(String request, String senderId, String recipientId){
        String savedSenderId = graphRepository.findByAccountId(senderId).getAccountId();
        String savedRecipientId = graphRepository.findByAccountId(recipientId).getAccountId();
        recipientValidate(savedSenderId, savedRecipientId);
        switch (request) {
            case "Follow":
                return graphRepository.isFollowing(savedSenderId, savedRecipientId);
            case "Block":
                return graphRepository.isBlocking(savedSenderId, savedRecipientId);
            default:
                throw new RuntimeException("Invalid request.");
        }
    }

    /* recipient validation */
    private void recipientValidate(String savedSenderId, String savedRecipientId){
        // 자신과 관계를 맺을 수 없음
        if(savedSenderId.equals(savedRecipientId)) {throw new RuntimeException("Invalid relationship.");}
        // DB에 저장된 상대인지 확인
        if(savedRecipientId==null){throw new RuntimeException("Recipient doesn't exists.");}
    }
}
