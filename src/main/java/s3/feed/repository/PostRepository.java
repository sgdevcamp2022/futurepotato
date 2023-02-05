package s3.feed.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import s3.feed.entity.PostEntity;

public interface PostRepository extends Neo4jRepository<PostEntity, Long> {

    @Query("MATCH (:Account{ accountId:$accountId })-[r:UPLOADED_LAST]->(last:Post)" +
            "RETURN last")
    PostEntity getLastPost(String accountId);

    @Query("MATCH (pre:Post) WHERE id(pre)=$prePostId " +
            "MATCH (:Account)-[r:UPLOADED_LAST]->(pre) " +
            "DELETE r " +
            "WITH pre " +
            "MATCH (last:Post) WHERE id(last)=$lastPostId " +
            "CREATE (last)-[:PREVIOUS]->(pre) ")
    void uploadMorePost(Long prePostId, Long lastPostId);

    @Query("MATCH (last:Post) WHERE id(last)=$id " +
            "MATCH (last)-[r:PREVIOUS]->(pre:Post) " +
            "RETURN pre")
    PostEntity getPrePost(Long id);

    @Query("MATCH (pre:Post) WHERE id(pre)=$id " +
            "MATCH (next:Post)-[r:PREVIOUS]->(pre) " +
            "RETURN next")
    PostEntity getNextPost(Long id);

    @Query("MATCH (a:Account{ accountId:$accountId }) " +
            "MATCH (pre:Post) WHERE id(pre)=$prePostId " +
            "CREATE (pre)<-[:UPLOADED_LAST]-(a) ")
    void setUploadLast(String accountId, Long prePostId);

    @Query("MATCH (pre:Post) WHERE id(pre)=$prePostId " +
            "MATCH (next:Post) WHERE id(next)=$nextPostId " +
            "CREATE (next)-[:PREVIOUS]->(pre) ")
    void setPrevious(Long prePostId, Long nextPostId);

    @Query("MATCH (p:Post) WHERE id(p)=$id " +
            "MATCH (:Post)-[r:PREVIOUS*]->(p) " +
            "RETURN COUNT(r)+1 ")
    Long getPostLevel(Long id);

    @Query("MATCH (last:Post) WHERE id(last)=$lastPostId " +
            "WITH size((last)-[:PREVIOUS*]->()) as depth " +
            "RETURN depth+1 ")
    Long getPostDepth(Long lastPostId);
}

