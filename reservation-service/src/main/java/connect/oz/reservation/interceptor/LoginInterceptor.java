package connect.oz.reservation.interceptor;

import connect.oz.reservation.login.domain.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("loginedUser");

        if (user == null) {
            session.setAttribute("redirectUrl", request.getServletPath());
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
