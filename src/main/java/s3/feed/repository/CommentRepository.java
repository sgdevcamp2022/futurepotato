package s3.feed.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import s3.feed.entity.CommentEntity;


public interface CommentRepository extends Neo4jRepository<CommentEntity, Long> {
    CommentEntity findByAccountId(String accountId);

    @Query("MATCH (a:Account{ accountId:$accountId })" +
            "MATCH (c:Comment) WHERE id(c)=$id " +
            "CREATE (a)-[:WRITES]->(c) ")
    void write(String accountId, Long id);
}
