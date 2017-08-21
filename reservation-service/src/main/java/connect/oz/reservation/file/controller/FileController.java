package connect.oz.reservation.file.controller;

import connect.oz.reservation.file.domain.FileDomain;
import connect.oz.reservation.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@Controller
@RequestMapping("/files")
public class FileController {

    private FileService fileService;

    private String baseDiretory;

    @Autowired
    public FileController(FileService fileService, String baseDiretory) {
        this.fileService = fileService;
        this.baseDiretory = baseDiretory;
    }

    @GetMapping("/{fileId}")
    public void selectFileById(@PathVariable Long fileId, HttpServletResponse response){
        FileDomain file=fileService.selectFileById(fileId);

        String originalFilename=file.getFileName();
        String contentType="image/jpeg";
        long fileSize = file.getFileLength();
        String saveFileName=file.getSaveFileName();

        response.setHeader("Content-Disposition", "attachment; filename=\""+originalFilename+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", contentType);
        //response.setHeader("Content-Length", ""+ fileSize);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        File readFile=new File(saveFileName);
        if(!readFile.exists()){
            throw new RuntimeException("file not found");
        }

        FileInputStream fis = null;
        try{
            fis = new FileInputStream(readFile);
            FileCopyUtils.copy(fis, response.getOutputStream()); // 파일을 저장할때도 사용할 수 있다.
            response.getOutputStream().flush();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally {
            try {
                fis.close();
            }catch(Exception ex){
                // 아무것도 하지 않음 (필요한 로그를 남기는 정도의 작업만 함.)
            }
        }
    }
}
