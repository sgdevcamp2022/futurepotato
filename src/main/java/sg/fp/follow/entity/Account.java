package sg.fp.follow.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.Set;


@Data
@Builder
@Node("Account")
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Property(name = "account_id")
    private String accountId;

    @Property(name = "account_name")
    private String accountName;

    @Property(name = "profile_pic")
    private String profilePic;

    @Relationship(type = "IS_FOLLOWING", direction = Relationship.Direction.OUTGOING)
    private List<IsFollowing> FollowingList;
    @Relationship(type = "IS_BLOCKING", direction = Relationship.Direction.OUTGOING)
    private List<IsBlocking> BlockingList;

    public Account(Long id, String accountId){ this.id = id; this.accountId = accountId; }
}
