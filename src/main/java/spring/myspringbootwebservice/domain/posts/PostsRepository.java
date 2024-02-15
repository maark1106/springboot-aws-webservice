package spring.myspringbootwebservice.domain.posts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메서드 자동 생성
// Entity 클래스와 기본 Entity Repository는 함께 위치해야 함
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
