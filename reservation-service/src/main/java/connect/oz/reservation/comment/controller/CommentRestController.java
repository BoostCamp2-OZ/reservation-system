package connect.oz.reservation.comment.controller;

import connect.oz.reservation.comment.domain.CommentImage;
import connect.oz.reservation.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    private CommentService commentService;

    private int previewCommentLimit;
    private int commentLimit;

    @Autowired
    public CommentRestController(CommentService commentService, int previewCommentLimit, int commentLimit) {
        this.commentService = commentService;
        this.previewCommentLimit = previewCommentLimit;
        this.commentLimit = commentLimit;
    }

    @GetMapping("/{commentId}/images")
    public List<CommentImage> selectCommentImages(@PathVariable Long commentId) {
        return commentService.selectCommentImages(commentId);
    }

    @GetMapping("/products/{productId}/offset/{offset}")
    public Map<String, Object> selectComments(@PathVariable Long productId, @PathVariable int offset) {

        if(offset == 0){
            return commentService.selectComments(productId, 0 ,previewCommentLimit);
        }else{
            return commentService.selectComments(productId, offset,commentLimit);
        }

    }

}
