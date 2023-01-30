package sg.fp.follow.entity;

import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDateTime;

public class IsBlocking {
    @Id @GeneratedValue
    private Long id;

    @TargetNode @NonNull
    private Account blocking;

    @CreatedDate @Property("create_dt")
    private LocalDateTime createDT;

    @LastModifiedDate @Property("update_dt")
    private LocalDateTime updateDT;
}
