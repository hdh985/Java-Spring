package practice.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import practice.practice.entity.Article;
import practice.practice.repository.ArticleRepository;



@AllArgsConstructor
@ToString
public class ArticleForm {

    private ArticleRepository articleRepository;
    private Long id;

    private String title;
    private String content;


    public Article toEntity() {

        return new Article(id, title, content);
    }
}
