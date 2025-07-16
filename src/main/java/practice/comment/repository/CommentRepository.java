package practice.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import practice.comment.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticleId(Long articleId);

    @Query(value = "SELECT *FROM comment WHERE article_id = :articleId", nativeQuery = true)




    List<Comment> findByNickname(String nickname);





}
