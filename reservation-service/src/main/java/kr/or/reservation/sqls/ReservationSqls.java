package kr.or.reservation.sqls;

public class ReservationSqls {
	// img type을 정렬하여 하나의 데이터를 가져와야하는 상황이여서,
	// 다음과 같이 쿼리를 작성했습니다. 
<<<<<<< HEAD
	public static final String SELECT_ONE = "SELECT product.id , product.name ,product.sales_start , product.sales_end ,info.observation_time, info.place_lot ,img.file_id " + 
=======
	public static final String SELECT_BY_PRODUCT_ID = "SELECT product.id , product.name ,product.sales_start , product.sales_end ,info.observation_time, info.place_lot ,img.file_id " + 
>>>>>>> 0d95395487ea32084ee49af481f7933ef7c9a78a
			"FROM product LEFT OUTER JOIN display_info AS info  " + 
			"ON product.id = info.product_id  " + 
			"left OUTER JOIN product_image as img " + 
			"on product.id = img.product_id " + 
<<<<<<< HEAD
			"where product.id = :id " + 
			"order by img.type desc " + 
			"limit 1; ";
	public static final String SELECT_PRICE = "SELECT price_type,price,discount_rate FROM reservation.product_price where product_id = :id;";
=======
			"where product.id = :productId " + 
			"order by img.type desc " + 
			"limit 1; ";
	public static final String SELECT_PRICE = "SELECT price_type,price,discount_rate FROM product_price where product_id = :id;";
>>>>>>> 0d95395487ea32084ee49af481f7933ef7c9a78a

}
