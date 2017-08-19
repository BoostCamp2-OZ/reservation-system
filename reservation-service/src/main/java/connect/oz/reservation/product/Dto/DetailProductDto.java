package connect.oz.reservation.product.dto;

import connect.oz.reservation.product.domain.Image;
import connect.oz.reservation.product.domain.Price;

import java.sql.Timestamp;
import java.util.List;

public class DetailProductDto {

    private Long id;
    private String name;
    private String description;
    private String event;
    private Timestamp salesStart;
    private Timestamp salesEnd;
    private Timestamp displayStart;
    private Timestamp displayEnd;
    private int salesFlag;
    private String content;
    private String observationTime;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;

    private List<Image> files;
    private List<Price> prices;

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

    public List<Image> getFiles() {
        return files;
    }

    public void setFiles(List<Image> files) {
        this.files = files;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
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

    @Override
    public String toString() {
        return "DetailProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", event='" + event + '\'' +
                ", salesStart=" + salesStart +
                ", salesEnd=" + salesEnd +
                ", displayStart=" + displayStart +
                ", displayEnd=" + displayEnd +
                ", salesFlag=" + salesFlag +
                ", content='" + content + '\'' +
                ", observationTime='" + observationTime + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeLot='" + placeLot + '\'' +
                ", placeStreet='" + placeStreet + '\'' +
                ", tel='" + tel + '\'' +
                ", homepage='" + homepage + '\'' +
                ", email='" + email + '\'' +
                ", files=" + files +
                ", prices=" + prices +
                '}';
    }
}
