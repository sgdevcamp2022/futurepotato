package sg.fp.follow.dto;

import lombok.Data;

@Data
public class BlockDTO {
    AccountDTO blocker;
    AccountDTO blocking;
}
