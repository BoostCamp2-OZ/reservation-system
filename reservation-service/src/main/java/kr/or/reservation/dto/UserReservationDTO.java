package kr.or.reservation.dto;

import java.sql.Timestamp;

public class UserReservationDTO {
	private Long id; // product id
	private String name; // product name
	private Timestamp displayStart;
	private Timestamp displayEnd;
	private int generalTicketCount;
	private int youthTicketCount;
	private int childTicketCount;
	
	public UserReservationDTO() {
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public int getGeneralTicketCount() {
		return generalTicketCount;
	}


	public void setGeneralTicketCount(int generalTicketCount) {
		this.generalTicketCount = generalTicketCount;
	}


	public int getYouthTicketCount() {
		return youthTicketCount;
	}


	public void setYouthTicketCount(int youthTicketCount) {
		this.youthTicketCount = youthTicketCount;
	}


	public int getChildTicketCount() {
		return childTicketCount;
	}


	public void setChildTicketCount(int childTicketCount) {
		this.childTicketCount = childTicketCount;
	}


	@Override
	public String toString() {
		return "id : \"" + id + "\", name : \"" + name + "\", displayStart : \"" + displayStart + "\", displayEnd : \""
				+ displayEnd + "\", generalTicketCount : \"" + generalTicketCount + "\", youthTicketCount : \""
				+ youthTicketCount + "\", childTicketCount : \"" + childTicketCount;
	}
	
	
	
	
	
}
