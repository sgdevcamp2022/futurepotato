package s3.feed.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import s3.feed.entity.StoryEntity;
import s3.feed.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface StoryRepository extends Neo4jRepository<StoryEntity, Long> {
    @Query("MATCH (s:Story) WHERE id(s)=$storyId " +
            "MATCH (:Account{ accountId:$accountId })-[r:LIKES]->(s) " +
            "DELETE r")
    void deleteLike(String accountId, Long storyId);

    //좋아요 여부 확인
    @Query("MATCH (p:Story) WHERE id(p)=$storyId " +
            "MATCH (a:Account{ accountId:$accountId }) " +
            "RETURN EXISTS((a)-[:LIKES]->(p))")
    boolean isLike(String accountId, Long storyId);

}