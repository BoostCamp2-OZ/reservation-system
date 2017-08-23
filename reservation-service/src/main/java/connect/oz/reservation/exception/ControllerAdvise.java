package connect.oz.reservation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvise {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler (EmptyResultDataAccessException.class)
    public ModelAndView resultException(EmptyResultDataAccessException e, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("404");

        logger.info(e.getLocalizedMessage());
        logger.info(e.getMessage());
        logger.info(request.getRequestURI());

        return mav;
    }
}
