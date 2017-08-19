package connect.oz.reservation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvisor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String exception(Exception e){
        logger.error("EmptyResultDataAccessException 발생");
        return e.getMessage();
    }

    @ExceptionHandler(value = {NotInsertException.class})
    public Exception notInsertExcpetion(Exception e){
        logger.error("NotInsertException 발생");
        return e;
    }




}


