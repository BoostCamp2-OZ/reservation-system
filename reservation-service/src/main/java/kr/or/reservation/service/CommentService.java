package kr.or.reservation.service;

import java.util.List;

import kr.or.reservation.domain.AVGForComment;
import kr.or.reservation.domain.Comment;

public interface CommentService {

	public List<Comment> selectByProductId(int productId);
	public AVGForComment selectAvgScoreByProductId(int producId);
	public List<?> getFileIdByCommentId(int commentId);
	public Long insert(Comment comment);
}
