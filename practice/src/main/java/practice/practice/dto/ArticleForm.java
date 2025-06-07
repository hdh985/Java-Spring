package practice.practice.dto;

import practice.practice.entity.Article;
import practice.practice.repository.ArticleRepository;

public class ArticleForm {

    private ArticleRepository articleRepository;

    private String title;
    private String content;

    public ArticleForm(String title, String content) {

        this.title = title;
        this.content = content;

    }

    @Override

    public String toString() {

        return "ArticleForm {" +
                "title='" + title + '\'' +
                ",content='" + content + '\'' +
                '}';


    }

    public Article toEntity() {

        return new Article(null, title, content);
    }
}
