package s3.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import s3.feed.entity.CommentEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class PostDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResImageListDto {
        public String content;
        public String accountId;
        public String profileImage;


        private LocalDateTime createdDt;

        private LocalDateTime modifiedDt;

        private int likeCount;
        private int commentCount;
        private boolean isMultyImage;
        private boolean isLikesCheck;
        public List<String> imageList = new ArrayList<>();

        public List<CommentEntity> commentEntityList = new ArrayList<>();
    }

}
