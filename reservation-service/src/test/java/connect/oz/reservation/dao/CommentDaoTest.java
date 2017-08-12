package connect.oz.reservation.dao;

import connect.oz.reservation.comment.dao.CommentDao;
import connect.oz.reservation.comment.dto.CommentDto;
import connect.oz.reservation.comment.dto.CommentSummaryDto;
import connect.oz.reservation.config.RootApplicationContextConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;


    @Test
    public void shouldSelectComments() {
        Long proudctId = 1L;
        int offset = 0;
        int limit = 3;

        List<CommentDto> comments = commentDao.selectComments(proudctId, offset);
        Assert.assertNotNull(comments);
    }

    @Test
    public void shouldSelectCommentsSummary() {
        Long proudctId = 1L;

        CommentSummaryDto commentsSummary = commentDao.selectCommentSummary(proudctId);
        Assert.assertNotNull(commentsSummary);
    }
}
