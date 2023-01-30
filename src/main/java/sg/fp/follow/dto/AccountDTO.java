package sg.fp.follow.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {
    private String id;
    private String accountId;
    private String accountName;
    private String profilePic;
}
