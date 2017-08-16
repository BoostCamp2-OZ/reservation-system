package connect.oz.reservation.login.service;

import connect.oz.reservation.login.dao.LoginDao;
import connect.oz.reservation.login.domain.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private LoginDao loginDao;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    @Transactional
    public boolean login(Users user) {
        Users existUser = selectUsers(user.getSnsId());
        if (existUser != null) {
            //update
            logger.info("이미 존재하는 아이디 입니다.~~~~~~");
            int count = loginDao.updateUser(user);
            if (count > 0) return true;
        } else {
            //insert
            logger.info("존재하지 않는 아이디 입니다.~~~~~~");
            Long id = loginDao.insertUser(user);
            if (id > 0) return true;
        }

        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public Users selectUsers(Long id) {
        return loginDao.selectBySnsId(id);
    }
}
