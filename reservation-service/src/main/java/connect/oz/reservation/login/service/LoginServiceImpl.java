package connect.oz.reservation.login.service;

import connect.oz.reservation.login.dao.LoginDao;
import connect.oz.reservation.login.domain.Users;
import connect.oz.reservation.login.dto.NaverLoginUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private LoginDao loginDao;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao){
        this.loginDao = loginDao;
    }

    public Users login(NaverLoginUserDto naverLoginUserDto){
        if(loginDao.selectBySnsId(naverLoginUserDto.getId()) != null){
            //update
            logger.info("이미 존재하는 아이디 입니다.~~~~~~");
        }else{
            //insert
            logger.info("존재하지 않는 아이디 입니다.~~~~~~");
        }
        return null;
    }
}
