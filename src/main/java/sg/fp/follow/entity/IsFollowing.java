package sg.fp.follow.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDateTime;

@Builder
@Data
@RelationshipProperties
public class IsFollowing {

    @Id @GeneratedValue
    private Long id;

    @TargetNode @NonNull
    private Account following;

    @CreatedDate @Property("create_dt")
    private LocalDateTime createDT;

    @LastModifiedDate @Property("update_dt")
    private LocalDateTime updateDT;

}
