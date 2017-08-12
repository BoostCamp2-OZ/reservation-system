package connect.oz.reservation.comment.dao;

import connect.oz.reservation.comment.dto.CommentDto;
import connect.oz.reservation.comment.dto.CommentSummaryDto;

import java.util.List;

public interface CommentDao {
    List<CommentDto> selectComments(Long productId, int offset);

    CommentSummaryDto selectCommentSummary(Long productId);
}
