package connect.oz.reservation.comment.service;

import java.util.Map;

public interface CommentService {
    Map<String,Object> selectComments(Long productId, int offset);
}
