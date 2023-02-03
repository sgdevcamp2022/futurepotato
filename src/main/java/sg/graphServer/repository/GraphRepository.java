package sg.graphServer.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import sg.graphServer.entity.Account;

import java.util.List;

@Repository
public interface GraphRepository extends Neo4jRepository<Account, Long> {

   @Query("MATCH (n:Account{ accountId:$id }) RETURN n")
   Account findByAccountId(String id);

    //팔로우
    @Query("MATCH (n1:Account{accountId:$id1})" +
            "MATCH (n2:Account{accountId:$id2}) " +
           "CREATE (n1)-[:IS_FOLLOWING]->(n2) ")
    void follow(String id1, String id2);
    //팔로잉 여부 조회
    @Query("MATCH (n1:Account{ accountId:$id1 }) " +
            "MATCH (n2:Account{ accountId:$id2 }) " +
            "RETURN EXISTS((n1)-[:IS_FOLLOWING]->(n2))")
    boolean isFollowing(String id1, String id2);
    //팔로우 취소
    @Query("MATCH (:Account{ accountId:$id1 })-[r:IS_FOLLOWING]->(:Account{ accountId:$id2 }) " +
            "DELETE r")
    void unfollow(String id1, String id2);
    //팔로워 목록 조회
    @Query("MATCH (:Account {accountId:$id})-[:IS_FOLLOWING]->(f:Account) " +
            "RETURN collect(f)")
    List<Account> findFollowing(String id);
    //팔로잉 목록 조회
    @Query("MATCH (:Account{accountId:$id})<-[:IS_FOLLOWING]-(f:Account) " +
            "RETURN collect(f)")
    List<Account> findFollowers(String id);

    //차단
    @Query("MATCH (n1:Account{accountId:$id1})" +
            "MATCH (n2:Account{accountId:$id2}) " +
            "OPTIONAL MATCH (n1)-[r]->(n2) " +
            "DELETE r " +
            "merge (n1)-[:IS_BLOCKING]->(n2) " +
            "WITH n1, n2 " +
            "OPTIONAL MATCH (n1)<-[r]-(n2) " +
            "DELETE r " +
            "merge (n1)-[:IS_BLOCKING]->(n2)")
    void block(String id1, String id2);
    //차단 여부 조회
    @Query("MATCH (n1:Account{ accountId:$id1 }) " +
            "MATCH (n2:Account{ accountId:$id2 }) " +
            "RETURN EXISTS((n1)-[:IS_BLOCKING]->(n2))" +
            "LIMIT 1")
    boolean isBlocking(String id1, String id2);
    //차단 취소
    @Query("MATCH (:Account{ accountId:$id1 })-[r:IS_BLOCKING]->(:Account{ accountId:$id2 }) " +
            "DELETE r")
    void unblock(String id1, String id2);
    //accountId가 차단 보낸 계정 목록 조회
    @Query("MATCH (:Account {accountId:$id})-[:IS_BLOCKING]->(b:Account) " +
            "RETURN collect(b)")
    List<Account> findBlocking(String id);
    //accountId가 차단 받은 계정 목록 조회
    @Query("MATCH (:Account {accountId:$id})<-[:IS_BLOCKING]-(b:Account) " +
            "RETURN collect(b)")
    List<Account> findBlockers(String id);



}
