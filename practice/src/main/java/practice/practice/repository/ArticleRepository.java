package practice.practice.repository;

import org.springframework.data.repository.CrudRepository;
import practice.practice.entity.Article;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {

    @Override
    ArrayList<Article> findAll();
}
