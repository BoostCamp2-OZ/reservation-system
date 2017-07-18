package kr.or.connect.reservation.dto;

import java.sql.Timestamp;

public class ProductForDetail {
	Integer id;
	Integer categoryId;
	String name;
	String description;
	Timestamp salesStart;
	Timestamp salesEnd;
	Integer salesFlag;
	String event;
	Timestamp createDate;
	Timestamp modifyDate;
	String content;
	String observationTime;
	Timestamp displayStart;
	Timestamp displayEnd;
	String placeName;
	String placeLot;
	String placeStreet;
	String tel;
	String homepage;
	String email;
	
	
	
	
	public ProductForDetail() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Timestamp getSalesStart() {
		return salesStart;
	}


	public void setSalesStart(Timestamp salesStart) {
		this.salesStart = salesStart;
	}


	public Timestamp getSalesEnd() {
		return salesEnd;
	}


	public void setSalesEnd(Timestamp salesEnd) {
		this.salesEnd = salesEnd;
	}


	public Integer getSalesFlag() {
		return salesFlag;
	}


	public void setSalesFlag(Integer salesFlag) {
		this.salesFlag = salesFlag;
	}


	public String getEvent() {
		return event;
	}


	public void setEvent(String event) {
		this.event = event;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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


	@Override
	public String toString() {
		return "ProductForDetail [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", description="
				+ description + ", salesStart=" + salesStart + ", salesEnd=" + salesEnd + ", salesFlag=" + salesFlag
				+ ", event=" + event + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", content="
				+ content + ", observationTime=" + observationTime + ", displayStart=" + displayStart + ", displayEnd="
				+ displayEnd + ", placeName=" + placeName + ", placeLot=" + placeLot + ", placeStreet=" + placeStreet
				+ ", tel=" + tel + ", homepage=" + homepage + ", email=" + email + "]";
	}
	
	
	
	
	

}
