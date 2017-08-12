package connect.oz.reservation.file.service;

import connect.oz.reservation.file.dao.FileDao;
import connect.oz.reservation.file.domain.FileDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FIleServieImpl implements FileService {
    @Autowired
    FileDao fileDao;

    @Override
    public FileDomain selectFileById(Long fileId) {

        return fileDao.selectFileById(fileId);
    }
}
