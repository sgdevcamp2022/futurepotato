package sg.fp.follow.dto;

import lombok.Data;

@Data
public class FollowDTO {
    AccountDTO follower;
    AccountDTO following;
}
