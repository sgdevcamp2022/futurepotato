package sg.fp.follow.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.fp.follow.dto.AccountDTO;
import sg.fp.follow.dto.FollowDTO;
import sg.fp.follow.dto.ResponseDTO;
import sg.fp.follow.entity.Account;
import sg.fp.follow.service.FollowService;

@Slf4j
@RestController
public class FollowController {
    @Autowired
    private FollowService followService;

    //1. 팔로우
    @PostMapping("/follow")
    public ResponseEntity<?> follow(@RequestParam FollowDTO dto) {
        try {
            followService.follow(
                Account.builder().
                accountId(dto.getFollower().getAccountId())
                .accountName(dto.getFollower().getAccountName())
                .profilePic(dto.getFollower().getProfilePic())
                .build(),
                 Account.builder()
                .accountId(dto.getFollowing().getAccountId())
                .accountName(dto.getFollowing().getAccountName())
                .profilePic(dto.getFollowing().getProfilePic())
                .build()
            );
            log.info("{} is following {}", dto.getFollower().getAccountId(), dto.getFollowing().getAccountId());
            AccountDTO response = AccountDTO.builder()
                    .id(dto.getFollowing().getId())
                    .accountId(dto.getFollowing().getAccountId())
                    .accountName(dto.getFollowing().getAccountName())
                    .profilePic(dto.getFollowing().getProfilePic())
                    .build();
            return ResponseEntity.ok().body(response);
        }catch(Exception e){
            ResponseDTO response = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    //2. 팔로우 취소
    @DeleteMapping("/follow")
    public ResponseEntity<?> unfollow(@RequestParam FollowDTO dto) {
        try {
            followService.unfollow(
                    Account.builder().
                            accountId(dto.getFollower().getAccountId())
                            .accountName(dto.getFollower().getAccountName())
                            .profilePic(dto.getFollower().getProfilePic())
                            .build(),
                    Account.builder()
                            .accountId(dto.getFollowing().getAccountId())
                            .accountName(dto.getFollowing().getAccountName())
                            .profilePic(dto.getFollowing().getProfilePic())
                            .build()
                    );
            log.info("{} unfollows {}", dto.getFollower().getAccountId(), dto.getFollowing().getAccountId());
            return ResponseEntity.ok().build();
        }catch(Exception e){
            ResponseDTO response = ResponseDTO.<FollowDTO>builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    //3. 팔로잉 목록 조회
    @GetMapping("/{accountId}/following")
    public ResponseEntity<?> findFollowing(@PathVariable String accountId){

        return ResponseEntity.ok().body(followService.findFollowing(accountId));
    }

    //4. 팔로워 목록 조회
    @GetMapping("/{accountId}/follower")
    public ResponseEntity<?> findFollowers(@PathVariable String accountId){
        return ResponseEntity.ok().body(followService.findFollowers(accountId));
    }


}
