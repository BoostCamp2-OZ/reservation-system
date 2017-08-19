package connect.oz.reservation.reservation.service;

import connect.oz.reservation.product.dao.ProductDao;
import connect.oz.reservation.product.dto.DetailProductDto;
import connect.oz.reservation.reservation.dao.ReservationDao;
import connect.oz.reservation.reservation.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements  ReservationService{

    private ProductDao productDao;
    private ReservationDao reservationDao;

    @Autowired
    public ReservationServiceImpl(ProductDao productDao, ReservationDao reservationDao) {
        this.productDao = productDao;
        this.reservationDao = reservationDao;
    }

    @Override
    @Transactional(readOnly = true)
    public DetailProductDto selectReservableProduct(Long productId) {
        DetailProductDto detailProductDto = productDao.selectProductById(productId);
        detailProductDto.setFiles(productDao.selectProductImageListById(productId));
        detailProductDto.setPrices(productDao.selectProductPriceListById(productId));
        return detailProductDto;
    }

    @Override
    public long insertReservation(Reservation reservation) {
        return reservationDao.insertReservation(reservation);
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



}
