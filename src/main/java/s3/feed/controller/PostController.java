package s3.feed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import s3.feed.repository.PostRepository;
import s3.feed.repository.UserRepository;
import s3.feed.service.PostService;
import s3.feed.dto.PostDto;
import s3.feed.entity.PostEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping("feed")
public class PostController {

    private final PostService postService;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //게시물 한개 조회, 댓글, 대댓글까지 보여야함.
    @GetMapping("/media/{postId}")
    public PostDto.ResImageListDto getPosts(@PathVariable("postId")Long id){
        return postService.getImageList(id);
    }
    //게시물 생성
    @PostMapping("/{accountId}/media")
    public PostEntity uploadFile(@RequestPart List<MultipartFile> multipartFile, @RequestParam  String content,@PathVariable("accountId")  String accountId) {
        return postService.uploadFile(multipartFile, content, accountId);
    }
    //게시물 내용 수정
    @PatchMapping("/{accountId}/media/{postId}")
    public String updatePost(@PathVariable("postId")Long postId, @PathVariable("accountId") String accountId, @RequestParam String content){
        return postService.updatePost(postId, accountId, content);
    }
    //게시물 삭제
    @DeleteMapping("/{accountId}/media/{postId}")
    public void deleteFile(@PathVariable("postId")Long id, @PathVariable("accountId") String accountId) {
        postService.deletePost(id, accountId);
    }

}
//한명의 유저가 올린 모든 게시물 조회
//    @GetMapping("/media")
//    public UserDto.ResPostListDto getUserPosts(@RequestParam String name){
//        return postService.getUserPosts(name);
//    }