package sg.userServer.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import sg.userServer.domain.Account;

@Repository
public interface AccountRepository extends Neo4jRepository<Account,Long> {
//    List<UserEntity> findByUserFeild1(String userFeild1);
}
