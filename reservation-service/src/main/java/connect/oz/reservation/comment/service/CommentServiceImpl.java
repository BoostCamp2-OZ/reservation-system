package connect.oz.reservation.comment.service;

import connect.oz.reservation.comment.dao.CommentDao;
import connect.oz.reservation.comment.domain.CommentImage;
import connect.oz.reservation.comment.dto.CommentDto;
import connect.oz.reservation.comment.dto.CommentSummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<CommentImage> selectCommentImages(Long commentId) {
        return commentDao.selectCommentImages(commentId);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> selectComments(Long productId, int offset) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<CommentDto> comments = commentDao.selectComments(productId, offset);

        CommentSummaryDto commentsSummary = commentDao.selectCommentSummary(productId);

        result.put("comments", comments);
        result.put("commentsSummary", commentsSummary);
        return result;
    }


}
