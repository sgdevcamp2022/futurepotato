package sg.userServer.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Getter
@Node(labels = {"Account"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
    @Id @GeneratedValue
    private Long id;

    private String profileImage;

    private String accountName;

    private String accountId;

    private long followingCount;
    private long followerCount;

    public Account(String accountId, String accountName) {
        this.accountId = accountId;
        this.accountName=accountName;
    }
}