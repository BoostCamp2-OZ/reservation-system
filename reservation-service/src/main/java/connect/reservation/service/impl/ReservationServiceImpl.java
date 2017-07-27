package connect.reservation.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import connect.reservation.dao.ProductDao;
import connect.reservation.dao.ReservationDao;
import connect.reservation.domain.ReservationInfo;
import connect.reservation.dto.Product;
import connect.reservation.dto.Reservation;
import connect.reservation.dto.ReservationCount;
import connect.reservation.service.ProductService;
import connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	final static int General = 0;
	
	private ReservationDao reservationDao;
	private ProductService productService;
	
	@Autowired
	public void setReservationInfoDao(ReservationDao reservationDao, ProductService productService) {
		this.reservationDao = reservationDao;
		this.productService = productService;
	}
	
	
	public Timestamp getDate(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return java.sql.Timestamp.valueOf(sdf.format(timestamp));
	}
	
	@Override
	@Transactional(readOnly = false)
	public int add(ReservationInfo reservationInfo) {		
		return reservationDao.insert(reservationInfo);
	}

	@Override
	public List<Reservation> get(int userId) {
		List<Reservation> list = reservationDao.select(userId);
		Double tempTotalPrice = 0.0;
		for(Reservation i : list) {
			List<Product> priceList = productService.getPriceInfo(i.getProductId());
			for(Product p : priceList) {
				System.out.print(p.getPriceType() +" / " + p.getDiscountPrice());
				switch (p.getPriceType()) {
					case 1:
						tempTotalPrice += i.getGeneralTicketCount()*p.getDiscountPrice();
						break;
					case 2:
						tempTotalPrice += i.getYouthTicketCount()*p.getDiscountPrice();
						break;
					case 3:
						tempTotalPrice += i.getChildTicketCount()*p.getDiscountPrice();
						break;
					default:
						break;
				}
			}
			i.setTotalPrice(tempTotalPrice);
			System.out.println(i.getId() +" / " + tempTotalPrice);
		}
		return list;
	}

	@Override
	public List<ReservationCount> getCount(int userId) {
		return reservationDao.selectCount(userId);
	}

	@Override
	public int modify(int id, int reservationType) {
		return reservationDao.update(id, reservationType);
	}
}
