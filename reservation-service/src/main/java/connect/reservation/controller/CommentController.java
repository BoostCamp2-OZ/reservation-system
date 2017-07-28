package connect.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import connect.reservation.domain.Product;
import connect.reservation.domain.ReservationUserComment;
import connect.reservation.domain.User;
import connect.reservation.dto.UploadFile;
import connect.reservation.service.CommentService;
import connect.reservation.service.FileService;

@Controller
@RequestMapping("/comments")
public class CommentController {
	
	private final CommentService commentService;
	private final FileService fileService;
	
	@Autowired
	public CommentController(CommentService commentService, FileService fileService) {
		this.commentService = commentService;
		this.fileService = fileService;
	}

	@GetMapping("/write")
	public String mvWrite(Model model, @RequestParam("reservationId") int reservationId) {
		model.addAttribute("reserveName", commentService.getName(reservationId));
		model.addAttribute("reservationId", reservationId);
		Product product = new Product();
		product = commentService.getName(reservationId);
		
		model.addAttribute("productId", product.getId());
		model.addAttribute("productName", product.getName());
		
		return "reviewWrite";
	}
	
	@PostMapping("/write")
	//public String add(Model model, @RequestBody ReservationUserComment reservationUserComment) {
	public String add(HttpSession session, 
			@RequestParam("commentImg") MultipartFile[] files, 
			@RequestParam("comment") String comment, 
			@RequestParam("score") int score) {
		User currentUser = (User) session.getAttribute("currentUser");

		ReservationUserComment commentDomain = new ReservationUserComment();
		commentDomain.setProductId(3);
		commentDomain.setUserId(currentUser.getId());
		commentDomain.setScore(score);
		commentDomain.setComment(comment);
		
		int commentId = commentService.add(commentDomain);
		
		if(null != files) {
			UploadFile uploadFile = new UploadFile();
			uploadFile.setUserId(currentUser.getId());
			uploadFile.setCommentId(commentId);
			uploadFile.setPath(session.getServletContext().getRealPath("/"));
			uploadFile.setContentType("한줄평이미지");
			
			fileService.uploadFile(files, uploadFile);
		}
		return "redirect:/review";
	}
}
