package kr.or.connect.reservation.dto;

import java.sql.Timestamp;
import java.util.List;

public class DetailProductDto {
	private String name;
	private String description;
	private String event;
	private Timestamp salesEnd; 	// 판매 종료 날짜 (비교를 위해서 TimeStamp)
	private int salesFlag; 			// 매진 flag ?
	private String content;
	private String observationTime;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String homepage;
	private String email;
	private List<ImageDto> files;

	public DetailProductDto() {

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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Timestamp getSalesEnd() {
		return salesEnd;
	}

	public void setSalesEnd(Timestamp salesEnd) {
		this.salesEnd = salesEnd;
	}

	public int getSalesFlag() {
		return salesFlag;
	}

	public void setSalesFlag(int salesFlag) {
		this.salesFlag = salesFlag;
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

	public List<ImageDto> getFiles() {
		return files;
	}

	public void setFiles(List<ImageDto> files) {
		this.files = files;
	}

}
