package practice.practice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practice.practice.dto.ArticleForm;
import practice.practice.entity.Article;
import practice.practice.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Slf4j
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
        log.info(form.toString());
        // System.out.println(form.toString());

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "redirect:/articles/" + saved.getId();
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = "+ id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/show";

    }

    @GetMapping("/articles")
    public String index(Model model) {

        List<Article> articleEntityList = articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){

        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {

        log.info(form.toString());

        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        if (target != null) {
            articleRepository.save(articleEntity); // ✔️ 기존과 동일하게 새 객체로 덮어씀
        }

        return "redirect:/articles/" + articleEntity.getId();
    }
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id) {


        Article target = articleRepository.findById(id).orElse(null);

        if (target != null) {

            articleRepository.delete(target);
        }

        return "redirect:/articles";


    }

}
