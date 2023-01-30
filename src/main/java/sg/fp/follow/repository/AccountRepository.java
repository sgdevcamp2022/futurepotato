package sg.fp.follow.repository;

import feign.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import sg.fp.follow.entity.Account;

import java.util.List;

public interface AccountRepository extends Neo4jRepository<Account, Long> {

    Account findByAccountId(String accountId);

    //나의 팔로워, 팔로잉 목록 조회
    @Query("MATCH (n:Account{accountId:{0}})-[:IS_FOLLOWING]->(f:Account) RETURN f")
    List<Account> findFollowing(@Param("accountId") String accountId);
    @Query("MATCH (n:Account{accountId:{0}})<-[:IS_FOLLOWING]-(f:Account) Return f")
    List<Account> findFollowers(@Param("accountId") String accountId);
    //팔로우 취소
    @Query("MATCH (follower:Account{ accountId:{0} })-[r:IS_FOLLOWING]->(following:Account{ accountId:{1} }) DELETE r")
    Account unfollow(String account1, String account2);

    //차단
    @Query("MATCH (blocker:Account{ accountId:{0} })-[r:IS_FOLLOWING]->(blocked:Account{ accountId:{1} }) DELETE r CREATE (blocker)-[:IS_BLOCKING]->(blocked)")
    Account block(String account1, String account2);
    //차단 여부 조회
    @Query("MATCH (n1:Account{ accountId:{0} }), (n2:Account{ accountId:{1} }) RETURN EXISTS((n1)-[:IS_BLOCKING]->(n2))")
    boolean isBlocking(String account1, String account2);
    //내가 차단한 계정 목록 조회
    @Query("MATCH (n:Account{accountId:{0}})-[:IS_BLOCKING]->(b:Account) Return b")
    List<Account> findBlocking(@Param("accountId") String accountId);
    //차단 취소
    @Query("MATCH (blocker:Account{ accountId:{0} })-[r:IS_BLOCKING]->(blocked:Account{ accountId:{1} }) DELETE r")
    Account unblock(String account1, String account2);



}
