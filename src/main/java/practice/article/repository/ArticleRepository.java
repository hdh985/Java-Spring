package practice.article.repository;

import org.springframework.data.repository.CrudRepository;
import practice.article.entity.Article;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {

    @Override
    ArrayList<Article> findAll();

}
