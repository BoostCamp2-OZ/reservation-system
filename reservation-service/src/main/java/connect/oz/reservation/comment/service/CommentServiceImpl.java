package connect.oz.reservation.comment.service;

import connect.oz.reservation.comment.dao.CommentDao;
import connect.oz.reservation.comment.domain.CommentImage;
import connect.oz.reservation.comment.dto.CommentDto;
import connect.oz.reservation.comment.dto.CommentInsertDto;
import connect.oz.reservation.comment.dto.CommentSummaryDto;
import connect.oz.reservation.file.service.FileService;
import connect.oz.reservation.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;
    private FileService fileService;
    private ProductService productService;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao, FileService fileService, ProductService productService) {
        this.commentDao = commentDao;
        this.fileService = fileService;
        this.productService = productService;
    }

    @Override
    public List<CommentImage> selectCommentImages(Long commentId) {
        return commentDao.selectCommentImages(commentId);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> selectComments(Long productId, int offset) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<CommentDto> comments = commentDao.selectComments(productId, offset);

        CommentSummaryDto commentsSummary = commentDao.selectCommentSummary(productId);

        result.put("comments", comments);
        result.put("commentsSummary", commentsSummary);
        return result;
    }

    @Override
    @Transactional
    public Long insertComment(CommentInsertDto commentInsertDto)  {
        //리뷰 이미지 파일 업로드
        List<Long> fileIdList = fileService.uploadFile(commentInsertDto.getUserId(),commentInsertDto.getFiles());
        //리뷰 테이블 초기화
        long commentId = commentDao.insertComment(commentInsertDto);
        //리뷰 이미지 테이블 초기화
        CommentImage commentImage = new CommentImage();
        commentImage.setReservationUserCommentId(commentId);

        for(int i=0; i < fileIdList.size(); i++){
            commentImage.setFileId(fileIdList.get(i));
            commentDao.insertCommentImage(commentImage);
        }

        return commentId;
    }

}
