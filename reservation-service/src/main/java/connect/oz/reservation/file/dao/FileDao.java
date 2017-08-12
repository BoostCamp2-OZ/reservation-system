package connect.oz.reservation.file.dao;

import connect.oz.reservation.file.domain.FileDomain;
import org.springframework.stereotype.Repository;


public interface FileDao {
    public FileDomain selectFileById(Long fileId);
}
