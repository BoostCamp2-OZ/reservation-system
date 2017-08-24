package connect.oz.reservation.file.service;

import connect.oz.reservation.file.dao.FileDao;
import connect.oz.reservation.file.domain.FileDomain;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FIleServieImpl implements FileService {

    @Value("${spring.uploadfile.root-directory}")
    private String localDirectory;

    private FileDao fileDao;

    @Autowired
    public FIleServieImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public FileDomain selectFileById(Long fileId) {

        return fileDao.selectFileById(fileId);
    }

    @Override
    @Transactional
    public Map<Long, Integer> uploadFile(long userId, MultipartFile[] files)  {
        Map<Long, Integer> fileIdList = new HashMap<Long, Integer>();

        files.toString();

        String curtime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String savePath = localDirectory + File.separator + curtime;

        // 실제 저장될 폴더가 없으면 폴더 생성
        if (!new File(savePath).isDirectory()) {
            new File(savePath).mkdirs();
        }

        for (MultipartFile file : files) {
            String contentType = file.getContentType();
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();

            String uuid = UUID.randomUUID().toString();
            String saveFileName = savePath + File.separator + uuid;

            //db 등록
            FileDomain f = new FileDomain();
            f.setUserId(userId);
            f.setContentType(contentType);
            f.setFileName(originalFilename);
            f.setSaveFileName(saveFileName);
            f.setFileLength(size);
            SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            Calendar cal = Calendar.getInstance();
            String now = formatter.format(cal.getTime());
            f.setCreateDate(Timestamp.valueOf(now));

            fileIdList.put(fileDao.insert(f),1);

            // try-with-resource 구문. close()를 할 필요가 없다. java 7 이상에서 가능


            try (InputStream in = file.getInputStream();
                 FileOutputStream fos = new FileOutputStream(saveFileName)) {
                int readCount = 0;
                byte[] buffer = new byte[512];

                while ((readCount = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, readCount);
                }

                //썸네일
                Thumbnails.of(new File(saveFileName))
                        .size(90, 90)
                        .outputFormat("jpg")
                        .toFiles(Rename.SUFFIX_DOT_THUMBNAIL);

                saveFileName += ".thumbnail.jpg";
                f.setSaveFileName(saveFileName);
                f.setType(2);
                fileIdList.put(fileDao.insert(f),2);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return fileIdList;
    }
}
