package connect.oz.reservation.comment.dao;

import connect.oz.reservation.comment.dto.CommentDto;
import connect.oz.reservation.comment.dto.CommentSummaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private int commentLimit;

    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<CommentDto> commentDtoRowMapper = BeanPropertyRowMapper.newInstance(CommentDto.class);
    private RowMapper<CommentSummaryDto> commentSummaryDtoRowMapper = BeanPropertyRowMapper.newInstance(CommentSummaryDto.class);

    public CommentDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<CommentDto> selectComments(Long productId, int offset) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("productId", productId);
        params.put("offset", offset);
        params.put("limit", commentLimit);

        return jdbc.query(CommentSqls.SELECT_COMMENTS, params, commentDtoRowMapper);
    }

    @Override
    public CommentSummaryDto selectCommentSummary(Long productId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("productId", productId);

        return jdbc.queryForObject(CommentSqls.SELECT_COMMENTS_SUMMARY, params, commentSummaryDtoRowMapper);
    }


}




