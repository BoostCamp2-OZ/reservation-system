package connect.oz.reservation.file.service;

import connect.oz.reservation.file.domain.FileDomain;

public interface FileService {
    public FileDomain selectFileById(Long fileId);
}
