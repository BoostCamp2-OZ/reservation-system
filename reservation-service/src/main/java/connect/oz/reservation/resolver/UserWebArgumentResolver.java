package connect.oz.reservation.resolver;

import connect.oz.reservation.annotaion.AuthUser;
import connect.oz.reservation.login.domain.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserWebArgumentResolver implements HandlerMethodArgumentResolver{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean supportsParameter(MethodParameter parameter) { //이 어노테이션 너가 처리할 수 있어?라고 확인하는 method
        logger.info("[method] supportsParameter ");
        AuthUser loginedUser = parameter.getParameterAnnotation(AuthUser.class); // AuthUser어노테이션이 맞으면 true를 리턴해서 처리한다.
        if(loginedUser == null)
            return false;
        else
            return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //해당 어노테이션이 맞으면 user 값을 넣어준다.
        logger.info("[method] resolveArgument 실행 ");

        AuthUser loginedUser = parameter.getParameterAnnotation(AuthUser.class);

        if(loginedUser == null){
            return WebArgumentResolver.UNRESOLVED;
        }

        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
        HttpSession session = request.getSession();
        Users user = null;

        if(session != null || session.getAttribute("loginedUser") != null) {
            user = (Users) session.getAttribute("loginedUser");
            logger.info("[class] UserWebArgumentResolver [user] "+user.toString());
        }
        return user;
    }
}
