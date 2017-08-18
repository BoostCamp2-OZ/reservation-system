package connect.oz.reservation.reservation.service;

import connect.oz.reservation.reservation.dao.ReservationDao;
import connect.oz.reservation.reservation.dto.MyReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {


    private ReservationDao reservationDao;

    @Autowired
    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MyReservationDto> selectReservation(long userId) {
        List<MyReservationDto> list = reservationDao.selectReservationByUserId(userId);
        for (MyReservationDto dto : list) {
            int totoalPrice = dto.getGeneralTotalPrice() + dto.getYouthTotalPrice() + dto.getChildTotalPrice();
            dto.setTotalPrice(totoalPrice);
        }
        return list;
    }

    @Override
    public int updateReservation(MyReservationDto reservation) {
        long id = reservation.getRid();
        int type = reservation.getReservationType();
        if(id > 0 && type > 0) {
            return reservationDao.updateReservation(id, type);
        }

        return 0;
    }
}
