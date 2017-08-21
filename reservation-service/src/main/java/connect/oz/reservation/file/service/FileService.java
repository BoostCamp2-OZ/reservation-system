package connect.oz.reservation.file.service;

import connect.oz.reservation.file.domain.FileDomain;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    public FileDomain selectFileById(Long fileId);

    List<Long> uploadFile(long userId, MultipartFile[] files);
}
