package s3.feed.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import s3.feed.entity.PostEntity;
import s3.feed.entity.StoryEntity;

import java.util.List;

public interface PostRepository extends Neo4jRepository<PostEntity, Long> {
    /*피드를 위한 인터페이스*/
    //무한 스크롤을 위한 인터페이스 : 자신을 포함한 팔로우한 사람들의 게시물 리스트 반환
    @Query("MATCH (p:Post)<-[:UPLOADED]-(a:Account {accountId:$accountId})-[:IS_FOLLOWING]->(f:Account)-[:UPLOADED]->(fp:Post)\n" +
            "unwind [p,fp] as posts\n" +
            "WITH posts\n" +
            "WHERE datetime({ year: toInteger(substring(toString(posts.createdDt), 0, 4)),\n" +
            "                 month: toInteger(substring(toString(posts.createdDt), 5, 2)),\n" +
            "                  day: toInteger(substring(toString(posts.createdDt), 8, 2)), \n" +
            "                  hour: toInteger(substring(toString(posts.createdDt), 11, 2)),\n" +
            "                  minute: toInteger(substring(toString(posts.createdDt), 14, 2)),\n" +
            "                  second: toInteger(substring(toString(posts.createdDt), 17, 2)) }) \n" +
            "                  < datetime({ year: $year, month: $month, day: $day, hour: $hour, minute: $minute, second: $second })\n" +
            "RETURN DISTINCT posts\n" +
            "ORDER BY posts.createdDt DESC ")
    List<PostEntity> getUnseenPostList(String accountId, int year, int month, int day, int hour, int minute, int second);


    //자신을 포함한 팔로우한 사람들의 게시물 리스트 반환
    @Query("MATCH (p:Post)<-[:UPLOADED]-(a:Account {accountId:$accountId})-[:IS_FOLLOWING]->(f:Account)-[:UPLOADED]->(fp:Post)\n" +
            "unwind [p,fp] as posts\n" +
            "RETURN DISTINCT posts\n" +
            "ORDER BY posts.createdDt DESC")
    List<PostEntity> getPostList(String accountId);

    //좋아요 취소
    @Query("MATCH (p:Post) WHERE id(p)=$postId " +
            "MATCH (:Account{ accountId:$accountId })-[r:LIKES]->(p) " +
            "DELETE r")
    void deleteLike(String accountId, Long postId);

    //좋아요 여부 확인
    @Query("MATCH (p:Post) WHERE id(p)=$postId " +
            "MATCH (a:Account{ accountId:$accountId }) " +
            "RETURN EXISTS((a)-[:LIKES]->(p))")
    boolean isLike(String accountId, Long postId);

}
