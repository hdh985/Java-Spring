package practice.practice.repository;

import org.springframework.data.repository.CrudRepository;
import practice.practice.entity.Article;

public interface ArticleRepository extends CrudRepository<Article,Long> {

}
