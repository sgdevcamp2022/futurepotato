package sg.fp.follow.service;

import lombok.extern.slf4j.Slf4j;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.fp.follow.entity.Account;
import sg.fp.follow.entity.IsFollowing;
import sg.fp.follow.feign.AuthClient;
import sg.fp.follow.feign.UserClient;
import sg.fp.follow.repository.AccountRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FollowService {
    @Autowired
    private AccountRepository accountRepository;

    //1. 팔로우
    public Account follow(Account follower, Account following){
        final Account savedFollower = accountRepository.findByAccountId(follower.getAccountId());
        Account savedFollowing = accountRepository.findByAccountId(following.getAccountId());
        //validation
        if(savedFollowing==null){throw new RuntimeException("AccountId for following doesn't exists.");}
        //follow
        if(savedFollower.getFollowingList() == null){
            savedFollower.setFollowingList(new ArrayList<>());
        }
        savedFollower.getFollowingList()
                        .add(IsFollowing.builder()
                                .following(savedFollowing)
                                .build());

        return accountRepository.save(savedFollower);
    }

    //2. 팔로우 취소
    public Account unfollow(Account follower, Account following){
        //저장된 follower인지 확인 후
        final Account savedFollower = accountRepository.findByAccountId(follower.getAccountId());
        //저장
        List<Account> followingList = accountRepository.findFollowing(savedFollower.getAccountId());

        //validation
        if(followingList==null){throw new RuntimeException("AccountId for following doesn't exists.");}
        //follow
        if(savedFollower.getFollowingList() == null){
            savedFollower.setFollowingList(new ArrayList<>());
        }
        savedFollower.getFollowingList()
                .add(IsFollowing.builder()
                        .following(followingList)
                        .build());

        return accountRepository.unfollow(savedFollower.getAccountId(), following.getAccountId());
    }


    //3. 내가 팔로잉 하는 계정 조회
    public List<Account> findFollowing(String accountId){
        List<Account> following = accountRepository.findFollowing(accountId);
        log.info("found {} accounts that {} is following", following.size(), accountId);
        return following;
    }

    //4. 나를 팔로우 하는 계정 조회
    public List<Account> findFollowers(String accountId){
        List<Account> followers = accountRepository.findFollowers(accountId);
        log.info("found {} followers for {}", followers.size(), accountId);
        return followers;
    }

}
