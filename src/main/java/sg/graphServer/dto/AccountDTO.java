package sg.graphServer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {
    private long id;
    private String accountId;
    private String accountName;
    private String profilePic;
}
