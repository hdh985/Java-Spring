package practice.comment.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.article.entity.Article;
import practice.article.repository.ArticleRepository;
import practice.comment.dto.CommentDto;
import practice.comment.entity.Comment;
import practice.comment.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId){

        //1. 댓글 조회
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        //2. 엔티티 -> DTO 변환
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for(int i = 0; i < comments.size(); i++){
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }

        //3. 결과 봔환
        return dtos;

    }
    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {

        //1. 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! " + "대상 게시글이 없습니다."));
        //2. 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);
        //3. 댓글 엔티티를 DB에 저장
        Comment created = commentRepository.save(comment);
        //4. DTO로 변환해 반환
        return CommentDto.createCommentDto(created);

    }

}
