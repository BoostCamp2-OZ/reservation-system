package connect.oz.reservation.comment.controller;

import connect.oz.reservation.comment.domain.CommentImage;
import connect.oz.reservation.comment.dto.CommentInsertDto;
import connect.oz.reservation.comment.service.CommentService;
import connect.oz.reservation.login.domain.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
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

    @PostMapping
    public Long registerReview(@ModelAttribute CommentInsertDto commentInsertDto, @RequestParam(name="file") MultipartFile[] files, HttpSession session)  {
        Users users = (Users) session.getAttribute("loginedUser");
        commentInsertDto.setFiles(files);
        commentInsertDto.setUserId(users.getId());

        logger.info("dto : {}", commentInsertDto);

        return commentService.insertComment(commentInsertDto);
    }
}
