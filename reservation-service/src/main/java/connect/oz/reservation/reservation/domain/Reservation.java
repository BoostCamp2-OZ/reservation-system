package connect.oz.reservation.reservation.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class Reservation {
    private long id;
    @NotNull
    private long productId;
    @NotNull
    private long userId;

    @JsonProperty("general_ticket_count")
    @Min(value = 0)
    private int generalTicketCount;

    @JsonProperty("youth_ticket_count")
    @Min(value = 0)
    private int youthTicketCount;
    @JsonProperty("child_ticket_count")
    @Min(value = 0)
    private int childTicketCount;

    @JsonProperty("name")
    @NotNull
    private String reservationName;
    @JsonProperty("tel")
    @NotNull
    private String reservationTel;
    @JsonProperty("email")
    private String reservationEmail;

    private Timestamp reservationDate;
    private long reservationType;
    private Timestamp createDate;
    private Timestamp modifyDate;

    public Reservation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTel() {
        return reservationTel;
    }

    public void setReservationTel(String reservationTel) {
        this.reservationTel = reservationTel;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public Timestamp getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate;
    }

    public long getReservationType() {
        return reservationType;
    }

    public void setReservationType(long reservationType) {
        this.reservationType = reservationType;
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
        return "Reservation [productId=" + productId + ", userId=" + userId + ", generalTicketCount="
                + generalTicketCount + ", youthTicketCount=" + youthTicketCount + ", childTicketCount="
                + childTicketCount + ", reservationName=" + reservationName + ", reservationTel=" + reservationTel
                + ", reservationEmail=" + reservationEmail + ", reservationDate=" + reservationDate
                + ", reservationType=" + reservationType + ", createDate=" + createDate + ", modifyDate=" + modifyDate
                + "]";
    }

}


