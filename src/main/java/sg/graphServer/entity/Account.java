package sg.graphServer.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Set;


@Data
@Builder
@Node(labels={"Account"})
public class Account {
    @Id @GeneratedValue
    private Long id;

    private String accountId;
    private String accountName;
    private String profileImage;

    @Relationship(type = "IS_FOLLOWING", direction = Relationship.Direction.OUTGOING)
    private Set<SocialRelationship> FollowingList;
    @Relationship(type = "IS_BLOCKING", direction = Relationship.Direction.OUTGOING)
    private Set<SocialRelationship> BlockingList;
}