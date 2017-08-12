package connect.oz.reservation.file.dao;

import connect.oz.reservation.file.domain.FileDomain;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class FileDaoImpl implements  FileDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<FileDomain> rowMapper= BeanPropertyRowMapper.newInstance(FileDomain.class);

    public FileDaoImpl(DataSource dataSource){
        this.jdbc=new NamedParameterJdbcTemplate(dataSource);
    }
    @Override
    public FileDomain selectFileById(Long fileId) {
        Map<String,?> params= Collections.singletonMap("fileId",fileId);
        return jdbc.queryForObject(FileSqls.SELECT_FILE_BY_ID,params,rowMapper);
    }
}
