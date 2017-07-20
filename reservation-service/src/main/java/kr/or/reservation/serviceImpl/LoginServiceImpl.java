package kr.or.reservation.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.reservation.dao.LoginDao;
import kr.or.reservation.dto.NaverUserDTO;
import kr.or.reservation.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public boolean progressLogin(NaverUserDTO dto) {
		if(dto != null) {
			// email로 비어있는지 확인. 
			log.info("들어옴"+dto.getSnsId());
			if(loginDao.isEmpty(dto.getSnsId())) {
				log.info("비엇나?");
				loginDao.insert(dto);
			}
			// 비어 있지 않으면 로그인 성공 
			return true;
		}
		return false;
	}

	@Autowired
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	

}
