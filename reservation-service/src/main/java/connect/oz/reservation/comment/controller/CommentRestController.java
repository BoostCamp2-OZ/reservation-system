package connect.oz.reservation.comment.controller;

import connect.oz.reservation.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/products/{productId}/offset/{offset}")
    public Map<String, Object> selectComments(@PathVariable Long productId, @PathVariable int offset) {
        return commentService.selectComments(productId, offset);
    }
}
