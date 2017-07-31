package connect.reservation.api;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import connect.reservation.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {
	private final CommentService commentService;
	
	public CommentRestController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/{productId}")
	public Map<String, Object> get(@PathVariable int productId, @RequestParam int start){
		return commentService.getList(productId, start*10, 10);
	}
}
