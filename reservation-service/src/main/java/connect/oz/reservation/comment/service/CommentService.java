package connect.oz.reservation.comment.service;

import connect.oz.reservation.comment.domain.CommentImage;
import connect.oz.reservation.comment.dto.CommentDto;
import connect.oz.reservation.comment.dto.CommentInsertDto;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<CommentImage> selectCommentImages(Long commentId);

    Map<String, Object> selectComments(Long productId, int offset);

    Long insertComment(CommentInsertDto comment);
}
