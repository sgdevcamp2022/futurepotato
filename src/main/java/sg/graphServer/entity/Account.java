package sg.graphServer.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;
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

    private long followingCount;
    private long followerCount;

}