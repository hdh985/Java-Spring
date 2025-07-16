package practice.article.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import practice.article.entity.Article;
import practice.article.repository.ArticleRepository;

import java.util.ArrayList;


@AllArgsConstructor
@ToString
public class ArticleForm {

    private ArticleRepository articleRepository;
    private Long id;

    private String title;
    private String content;


    public Article toEntity() {

        return new Article(id, title, content, new ArrayList<>());
    }
}
