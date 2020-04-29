package com.epam.dto;

import java.util.Date;

public class BookedPlaceDto {
    private Long BookedPlaceId;
    private Long wagonNumber;
    private Long placeNumber;
    private Date departureDate;
    private Long trainId;

    public BookedPlaceDto() {
    }

    public BookedPlaceDto(Long wagonNumber, Long placeNumber, Date departureDate, Long trainId) {
        this.wagonNumber = wagonNumber;
        this.placeNumber = placeNumber;
        this.departureDate = departureDate;
        this.trainId = trainId;
    }

    public BookedPlaceDto(Long bookedPlaceId, Long wagonNumber, Long placeNumber, Date departureDate, Long trainId) {
        BookedPlaceId = bookedPlaceId;
        this.wagonNumber = wagonNumber;
        this.placeNumber = placeNumber;
        this.departureDate = departureDate;
        this.trainId = trainId;
    }

    public Long getBookedPlaceId() {
        return BookedPlaceId;
    }

    public void setBookedPlaceId(Long bookedPlaceId) {
        BookedPlaceId = bookedPlaceId;
    }

    public Long getWagonNumber() {
        return wagonNumber;
    }

    public void setWagonNumber(Long wagonNumber) {
        this.wagonNumber = wagonNumber;
    }

    public Long getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Long placeNumber) {
        this.placeNumber = placeNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookedPlaceDto that = (BookedPlaceDto) o;

        if (BookedPlaceId != null ? !BookedPlaceId.equals(that.BookedPlaceId) : that.BookedPlaceId != null)
            return false;
        if (wagonNumber != null ? !wagonNumber.equals(that.wagonNumber) : that.wagonNumber != null) return false;
        if (placeNumber != null ? !placeNumber.equals(that.placeNumber) : that.placeNumber != null) return false;
        if (departureDate != null ? !departureDate.equals(that.departureDate) : that.departureDate != null)
            return false;
        return trainId != null ? trainId.equals(that.trainId) : that.trainId == null;
    }

    @Override
    public int hashCode() {
        int result = BookedPlaceId != null ? BookedPlaceId.hashCode() : 0;
        result = 31 * result + (wagonNumber != null ? wagonNumber.hashCode() : 0);
        result = 31 * result + (placeNumber != null ? placeNumber.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (trainId != null ? trainId.hashCode() : 0);
        return result;
    }
}