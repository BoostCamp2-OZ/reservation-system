package connect.oz.reservation.comment.controller;

import connect.oz.reservation.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Repository
@RequestMapping("/api/comments")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/products/{productId}/offset/{offset}")
    public Map<String, Object> selectComments(Long productId, int offset) {
        return commentService.selectComments(productId, offset);
    }
}
