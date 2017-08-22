package connect.oz.reservation.comment.controller;

import org.springframework.stereotype.Controller;
import connect.oz.reservation.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;
    private int commentLimit;

    @Autowired
    public CommentController(CommentService commentService, int commentLimit) {
        this.commentService = commentService;
        this.commentLimit = commentLimit;
    }

    @GetMapping("/product/{productId}")
    public ModelAndView getReview(@PathVariable Long productId, Model model){

        Map<String, Object> commentData = commentService.selectComments(productId, 0 ,commentLimit);
        ModelAndView modelAndView = new ModelAndView("review");
        model.addAttribute("commentData",commentData);
        return modelAndView;

    }

    @RequestMapping("/reviewWrite/{productId:[\\d]+}")
    public ModelAndView reviewWrite(@PathVariable int productId) {
        ModelAndView mav = new ModelAndView("reviewWrite");
        mav.addObject("id", productId);
        return mav;
    }

}
