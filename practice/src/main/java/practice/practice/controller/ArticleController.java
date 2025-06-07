package practice.practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practice.practice.dto.ArticleForm;
import practice.practice.entity.Article;
import practice.practice.repository.ArticleRepository;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {

        return "articles/new";

    }

    @PostMapping("/articles/create")

    public String createArticle(ArticleForm form) {

        System.out.println(form.toString());

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "" ;
    }



}
