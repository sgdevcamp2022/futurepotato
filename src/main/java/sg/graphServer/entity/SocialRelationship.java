//package sg.graphServer.entity;
//
//import lombok.Builder;
//import lombok.NonNull;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.neo4j.core.schema.GeneratedValue;
//import org.springframework.data.neo4j.core.schema.Id;
//import org.springframework.data.neo4j.core.schema.RelationshipProperties;
//import org.springframework.data.neo4j.core.schema.TargetNode;
//
//import java.time.LocalDateTime;
//
//@Builder
//@RelationshipProperties
//public class SocialRelationship {
//    @Id @GeneratedValue
//    private Long id;
//
//    @TargetNode @NonNull
//    private Account target;
//
//    @CreatedDate
//    private LocalDateTime createDT;
//
//}
