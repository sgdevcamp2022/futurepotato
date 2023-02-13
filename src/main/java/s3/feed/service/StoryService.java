package s3.feed.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import s3.feed.dto.StoryDto;
import s3.feed.entity.*;
import s3.feed.exception.ForbiddenException;
import s3.feed.repository.StoryRepository;
import s3.feed.repository.UserRepository;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryService {
    private final UserRepository userRepository;
    private final PostService postService;
    private final StoryRepository storyRepository;
    private final AmazonS3 amazonS3;
    private final AmazonS3Client amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public StoryDto.ResStoryListDto getStory(String accountId) {
        UserEntity userEntity = userRepository.findByAccountId(accountId);
        StoryDto.ResStoryListDto resStoryListDto = new StoryDto.ResStoryListDto();

        List<StoryEntity> storyList = userEntity.getStoryList();
        for (StoryEntity storyEntity : storyList) {
            String storedImageUrl = amazonS3Client.getUrl(bucket, storyEntity.getImage()).toString();
            resStoryListDto.getStoryList().add(new StoryDto.ReqStoryListDto(storyEntity.getId(), storedImageUrl, storyEntity.getCreatedDt()));
        }
        return new StoryDto.ResStoryListDto(accountId, userEntity.getProfileImage(), resStoryListDto.getStoryList());
    }
    public ResponseEntity deleteStory(String accountId, Long storyId) {
        StoryEntity storyEntity = storyRepository.findById(storyId).get();
        String storyWriter = storyEntity.getUserEntity().getAccountId();
        if (storyWriter.equals(accountId)) {
            storyRepository.deleteById(storyEntity.getId());
            amazonS3.deleteObject(new DeleteObjectRequest(bucket, storyEntity.getImage()));
        } else {
            throw new ForbiddenException("권한이 없습니다.");
        }
        return ResponseEntity.ok("스토리 삭제 성공");
    }

    public StoryEntity uploadStory(MultipartFile multipartFile, String accountId) throws InterruptedException {

        UserEntity userEntity = userRepository.findByAccountId(accountId);

        String fileName = postService.createUuidFileName(multipartFile.getOriginalFilename());
        String profileImage = userEntity.getProfileImage();
        StoryEntity storyEntity = new StoryEntity(fileName, accountId, profileImage, LocalDateTime.now());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());
        storyEntity.addUser(userEntity);
        try (InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
        }

        userEntity.getStoryList().add(storyEntity);
        userRepository.save(userEntity);
        StoryEntity saveStoryEntity = storyRepository.save(storyEntity);
        Long storyId = saveStoryEntity.getId();
        dayThread();
        dayDelete(storyId);
        return storyEntity;
    }

    public void dayThread() throws InterruptedException {
        int day = 1000*60*60*24;
        Thread.sleep(day);
    }

    public void dayDelete(Long storyId) {
        StoryEntity storyEntity = storyRepository.findById(storyId).get();
        storyRepository.deleteById(storyEntity.getId());
        amazonS3.deleteObject(new DeleteObjectRequest(bucket, storyEntity.getImage()));
    }
}




/* public StoryEntity uploadStory(MultipartFile multipartFile, String accountId) throws InterruptedException {

        UserEntity userEntity = userRepository.findByAccountId(accountId);
        String fileName = postService.createUuidFileName(multipartFile.getOriginalFilename());
        String profileImage = userEntity.getProfileImage();
        StoryEntity storyEntity = new StoryEntity(fileName, accountId, profileImage, LocalDateTime.now());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());
        storyEntity.addUser(userEntity);
        try (InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
        }

        userEntity.getStoryList().add(storyEntity);
        userRepository.save(userEntity);

        return storyEntity;
    }*/