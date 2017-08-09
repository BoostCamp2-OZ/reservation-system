package connect.oz.reservation.product.dao;

import connect.oz.reservation.product.Dto.SimpleProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<SimpleProductDto> simpleProductRowMapper = BeanPropertyRowMapper.newInstance(SimpleProductDto.class);
    private RowMapper<Integer> integerRowMapper = BeanPropertyRowMapper.newInstance(Integer.class);

    @Autowired
    private int mainProductLimit;

    public ProductDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<SimpleProductDto> selectProducts(int offset) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("offset", offset);
        params.put("limit", mainProductLimit);
        return jdbc.query(ProductSqls.SELECT_PRODUCTS, params, simpleProductRowMapper);
    }

    @Override
    public List<SimpleProductDto> selectProductsByCategoryId(Long categoryId, int offset) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("offset", offset);
        params.put("limit", mainProductLimit);
        params.put("categoryId", categoryId);
        return jdbc.query(ProductSqls.SELECT_PRODUCTS_BY_CATEGORY_ID, params, simpleProductRowMapper);
    }

    @Override
    public int selectProductCount() throws EmptyResultDataAccessException{
        Map<String, Object> params = Collections.emptyMap();
        return jdbc.queryForObject(ProductSqls.SELECT_PRODUCTS_COUNT, params, Integer.class);
    }

    @Override
    public int selectProductCountByCategoryId(Long categoryId) throws EmptyResultDataAccessException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        return jdbc.queryForObject(ProductSqls.SELECT_PRODUCTS_COUNT_BY_CATEGORY_ID, params, Integer.class);
    }
}
