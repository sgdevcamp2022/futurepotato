package s3.feed.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import s3.feed.entity.ReplyEntity;

public interface ReplyRepository extends Neo4jRepository<ReplyEntity, Long> {

    @Query("MATCH (a:Account{ accountId:$accountId })" +
            "MATCH (r:Reply) WHERE id(r)=$id " +
            "CREATE (a)-[:WRITES]->(r) ")
    void write(String accountId, Long id);

}
