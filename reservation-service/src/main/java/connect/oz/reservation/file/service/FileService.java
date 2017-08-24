package connect.oz.reservation.file.service;

import connect.oz.reservation.file.domain.FileDomain;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileService {
    public FileDomain selectFileById(Long fileId);

    Map<Long, Integer> uploadFile(long userId, MultipartFile[] files);
}
