package connect.oz.reservation.comment.service;

import connect.oz.reservation.comment.domain.CommentImage;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<CommentImage> selectCommentImages(Long commentId);

    Map<String, Object> selectComments(Long productId, int offset, int limit);

}
