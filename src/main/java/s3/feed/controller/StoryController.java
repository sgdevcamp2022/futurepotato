package s3.feed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import s3.feed.dto.StoryDto;
import s3.feed.entity.StoryEntity;
import s3.feed.service.StoryService;

@RestController
//@RequestMapping("feed")
public class StoryController {
    @Autowired
    StoryService storyService;


    //한명의 유저가 올린 모든 스토리 제공
    @GetMapping("/story/{accountId}/{image}")
    public StoryDto.ResStoryListDto getStory(@PathVariable("accountId")String accountId, @PathVariable("image")String image){
        return  storyService.getStory(accountId, image);
    }

    @PostMapping("/{accountId}/story")
    public StoryEntity uploadStory(@RequestPart MultipartFile multipartFile,@PathVariable("accountId") String accountId) throws InterruptedException {
       return storyService.uploadStory(multipartFile, accountId);
    }

    @DeleteMapping("/{accountId}/story/{storyId}")
    public void deleteStory(@PathVariable("storyId")Long id, @PathVariable String accountId){
    storyService.deleteStory(id, accountId);

    }
}

//    @DeleteMapping("/file")
//    public void deleteFile( @RequestParam String fileName) {
//        awsS3Service.deleteFile(fileName);
//    }