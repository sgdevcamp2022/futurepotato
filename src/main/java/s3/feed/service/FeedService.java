package s3.feed.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import s3.feed.dto.FeedDto;
import s3.feed.dto.PostDto;
import s3.feed.dto.SlicedResult;
import s3.feed.entity.PostEntity;
import s3.feed.entity.UserEntity;
import s3.feed.repository.PostRepository;
import s3.feed.repository.StoryRepository;
import s3.feed.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FeedService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;


    //게시물
    public SlicedResult<PostDto.ResImageListDto> searchPostBySlice(String accountId, Long lastSeenPostId, int pageSize){
        //page 시작번호=0, pageSize(한 페이지에 들어갈 게시물 수)는 클라이언트가 정함
        Pageable pageable = PageRequest.of(0, pageSize);

        List<PostDto.ResImageListDto> results = new ArrayList<>();
        Slice<PostDto.ResImageListDto> slicedPosts;
        /* (1) 첫 메인화면 (lastSeenPostId를 모르기 떄문에 lastSeenPostId=null) */
        if(lastSeenPostId==null) {
            //첫 페이지에 그릴 포스트 리스트
            List<PostEntity> firstPagePostList = postRepository.getPostsPerPageSize(accountId, pageSize);
            //Dto에 집어넣기
            for (PostEntity p : firstPagePostList) {
                results.add(postService.getImageList(p.getId()));
            }
            slicedPosts = firstPageIsLastPageForPost(pageable, results, postRepository.getPostList(accountId).size());
        } else{ /*(2) 스크롤링하면서 다음 페이지 정보를 불러옴 (lastSeenPostId를 앎)*/
            //현재 피드에 그려진 마지막 게시물의 생성일
            LocalDateTime lastSeenPostCreatedDt = postRepository.findById(lastSeenPostId).map(PostEntity::getCreatedDt).orElse(null);
            //그 생성일 이전에 생성된 게시물들 리스트
            List<PostEntity> unseenPostList = postRepository.getUnseenPostList(accountId,
                    lastSeenPostCreatedDt.getYear(),
                    lastSeenPostCreatedDt.getMonthValue(),
                    lastSeenPostCreatedDt.getDayOfMonth(),
                    lastSeenPostCreatedDt.getHour(),
                    lastSeenPostCreatedDt.getMinute(),
                    lastSeenPostCreatedDt.getSecond());
            //Dto에 집어넣기
            for (PostEntity p : unseenPostList) {
                results.add(postService.getImageList(p.getId()));
            }
            //무한 스크롤 처리를 위한 slices
            slicedPosts = checkLastPageForPost(pageable, results);
            log.info("slicedUnseenPostList={}, pageNum is {}", slicedPosts, slicedPosts.getNumber());
        }

        return SlicedResult.<PostDto.ResImageListDto>builder()
                .pagingState(slicedPosts.getPageable().toString())
                .isLast(slicedPosts.isLast())
                .content(slicedPosts.getContent()).build();
    }

    //스토리
    public SlicedResult<FeedDto.followingsWhoUploadedStoryDto> searchFollowingsWhoUploadedStoryBySlice(String accountId, String lastSeenFollowingId, int pageSize){
        //page 시작번호=0, pageSize(한 페이지에 들어갈 스토리 수)는 클라이언트가 정함
        Pageable pageable = PageRequest.of(0, pageSize);

        List<FeedDto.followingsWhoUploadedStoryDto> results = new ArrayList<>();
        Slice<FeedDto.followingsWhoUploadedStoryDto> slicedFollowings;

        /* (1) 첫 메인화면 (lastSeenFollowingId를 모르기 떄문에 lastSeenFollowingId=null) */
        if(lastSeenFollowingId==null) {
            //첫 페이지에 그릴 팔로잉 리스트
            List<UserEntity> firstPageFollowingList = userRepository.getFollowingsWhoUploadedStoryPerPageSize(accountId, pageSize);
            //Dto에 집어넣기
            for (UserEntity f : firstPageFollowingList) {
                results.add(FeedDto.followingsWhoUploadedStoryDto.builder()
                        .accountId(f.getAccountId())
                        .profileImage(f.getProfileImage())
                        .build());
            }
            slicedFollowings = firstPageIsLastPageForStory(pageable, results, userRepository.getFollowingsWhoUploadedStory(accountId).size());
        } else { /*(2) 스크롤링하면서 다음 페이지 정보를 불러옴 (lastSeenFollowingId를 앎)*/
            //현재 피드에 그려진 마지막 팔로우의 최신 스토리의 생성일
            LocalDateTime storyCreatedDtOfLastSeenFollowing = userRepository.getCreatedDtOfRecentStory(lastSeenFollowingId);
            //그 생성일 이전에 스토리를 올린 팔로우 리스트
            List<UserEntity> unseenFollowingsWhoUploadedStory = userRepository.getUnseenFollowingsWhoUploadedStory(accountId,
                    storyCreatedDtOfLastSeenFollowing.getYear(),
                    storyCreatedDtOfLastSeenFollowing.getMonthValue(),
                    storyCreatedDtOfLastSeenFollowing.getDayOfMonth(),
                    storyCreatedDtOfLastSeenFollowing.getHour(),
                    storyCreatedDtOfLastSeenFollowing.getMinute(),
                    storyCreatedDtOfLastSeenFollowing.getSecond());
            //Dto에 집어넣기
            for (UserEntity f : unseenFollowingsWhoUploadedStory) {
                results.add(FeedDto.followingsWhoUploadedStoryDto.builder()
                        .accountId(f.getAccountId())
                        .profileImage(f.getProfileImage())
                        .build());
            }
            //무한 스크롤 처리를 위한 slices
            slicedFollowings = checkLastPageForStory(pageable, results);
        }

        return SlicedResult.<FeedDto.followingsWhoUploadedStoryDto>builder()
                .pagingState(slicedFollowings.getPageable().toString())
                .isLast(slicedFollowings.isLast())
                .content(slicedFollowings.getContent()).build();
    }


    /* 무한 스크롤 방식 처리하는 메소드 */
    //게시물
    //(1)의 상황 : 첫 메인페이지에 부분적으로 그려진 게시물 수 < 메인페이지에 그려져야하는 총 게시물 수 -> 뒤에 더 있는 것으로 처리 (not last page)
    private Slice<PostDto.ResImageListDto> firstPageIsLastPageForPost(Pageable pageable,
                                                                      List<PostDto.ResImageListDto> postsInFirstPage,
                                                                      long totalPostListSize){
        boolean hasNext = false;
        if(postsInFirstPage.size() < totalPostListSize) hasNext=true;
        return new SliceImpl<>(postsInFirstPage, pageable, hasNext);
    }
    //(2)의 상황 : 보지 않은 게시물 총 갯수 > 요청한 페이지 사이즈 -> 뒤에 더 있는 것으로 처리  (not last page)
    private  Slice<PostDto.ResImageListDto> checkLastPageForPost(Pageable pageable, List<PostDto.ResImageListDto> results){
        boolean hasNext = false;
        if(results.size()> pageable.getPageSize()){
            hasNext=true;
            results.remove(pageable.getPageSize());
        }
        return new SliceImpl<>(results, pageable, hasNext);
    }

    //스토리
    //(1)의 상황 : 첫 메인페이지에 부분적으로 그려진 팔로잉 수 < 메인페이지에 그려져야하는 총 팔로잉 수 -> 뒤에 더 있는 것으로 처리 (not last page)
    private Slice<FeedDto.followingsWhoUploadedStoryDto> firstPageIsLastPageForStory(Pageable pageable,
                                                                       List<FeedDto.followingsWhoUploadedStoryDto> storiesInFirstPage,
                                                                      long totalStoryListSize){
        boolean hasNext = false;
        if(storiesInFirstPage.size() < totalStoryListSize) hasNext=true;
        return new SliceImpl<>(storiesInFirstPage, pageable, hasNext);
    }
    //(2)의 상황 : 보지 않은 팔로잉 총 갯수 > 요청한 페이지 사이즈 -> 뒤에 더 있는 것으로 처리
    private  Slice<FeedDto.followingsWhoUploadedStoryDto> checkLastPageForStory(Pageable pageable, List<FeedDto.followingsWhoUploadedStoryDto> results){
        boolean hasNext = false;
        if(results.size()> pageable.getPageSize()){
            hasNext=true;
            results.remove(pageable.getPageSize());
        }
        return new SliceImpl<>(results, pageable, hasNext);
    }

    /*프론트 test 용*/
    public FeedDto getPostList(String accountId){
        List<PostEntity> allPostList = postRepository.getPostList(accountId);
        List<PostDto.ResImageListDto> resPostList = new ArrayList<>();

        for(PostEntity p : allPostList){
            resPostList.add(postService.getImageList(p.getId()));
        }
        return FeedDto.builder().postList(resPostList).build();
    }

    public FeedDto getFollowingsWhoUploadedStory(String accountId){
        List<UserEntity> followingsWhoUploadedStory = userRepository.getFollowingsWhoUploadedStory(accountId);
        List<FeedDto.followingsWhoUploadedStoryDto> resStoryList = new ArrayList<>();

        for(UserEntity f : followingsWhoUploadedStory){
            resStoryList.add(FeedDto.followingsWhoUploadedStoryDto.builder()
                        .accountId(f.getAccountId())
                        .profileImage(f.getProfileImage())
                        .build());
        }
        return FeedDto.builder().storyList(resStoryList).build();
    }
}
