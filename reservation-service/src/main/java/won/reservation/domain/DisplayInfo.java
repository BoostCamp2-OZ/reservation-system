package won.reservation.domain;

import java.sql.Timestamp;

public class DisplayInfo {
	private int id;
	private int productId;
	private String observationTime;
	private Timestamp displayStart;
	private Timestamp displayEnd;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String homepage;
	private String email;
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	public DisplayInfo() {
		
	}
	
	public DisplayInfo(int id, int productId, String observationTime, Timestamp displayStart, Timestamp displayEnd,
			String placeName, String placeLot, String placeStreet, String tel, String homepage, String email,
			Timestamp createDate, Timestamp modifyDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.observationTime = observationTime;
		this.displayStart = displayStart;
		this.displayEnd = displayEnd;
		this.placeName = placeName;
		this.placeLot = placeLot;
		this.placeStreet = placeStreet;
		this.tel = tel;
		this.homepage = homepage;
		this.email = email;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getObservationTime() {
		return observationTime;
	}

	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}

	public Timestamp getDisplayStart() {
		return displayStart;
	}

	public void setDisplayStart(Timestamp displayStart) {
		this.displayStart = displayStart;
	}

	public Timestamp getDisplayEnd() {
		return displayEnd;
	}

	public void setDisplayEnd(Timestamp displayEnd) {
		this.displayEnd = displayEnd;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceLot() {
		return placeLot;
	}

	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}

	public String getPlaceStreet() {
		return placeStreet;
	}

	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "[DisplayInfo] id = "+ id +", productId = "+productId+", observationTime = "+observationTime
				+", displayStart = "+ displayStart +", displayEnd = " + displayEnd
				+", placeName = "+ placeName + ", placeLot = "+ placeLot+", placeStreet = " +placeStreet 
				+", tel = "+ tel +", homepage = "+ homepage +", email = " + email 
				+", createDate = "+ createDate +", modifyDate = " + modifyDate;
	}
}
