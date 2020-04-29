package com.epam.dto;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class HistoryDto {
    private Long HistoryId;
    private String trainNumber;
    private String fromStation;
    private String toStation;
    private Time departureTime;
    private Time arrivalTime;
    private Date departureDate;
    private Long wagonNumber;
    private Long placeNumber;
    private BigDecimal price;
    private Long userId;

    public HistoryDto() {
    }

    public HistoryDto(String trainNumber, String fromStation, String toStation, Time departureTime, Time arrivalTime,
                      Date departureDate, Long wagonNumber, Long placeNumber, BigDecimal price, Long userId) {
        this.trainNumber = trainNumber;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.wagonNumber = wagonNumber;
        this.placeNumber = placeNumber;
        this.price = price;
        this.userId = userId;
    }

    public HistoryDto(Long historyId, String trainNumber, String fromStation, String toStation,
                      Time departureTime, Time arrivalTime, Date departureDate,
                      Long wagonNumber, Long placeNumber, BigDecimal price, Long userId) {
        HistoryId = historyId;
        this.trainNumber = trainNumber;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.wagonNumber = wagonNumber;
        this.placeNumber = placeNumber;
        this.price = price;
        this.userId = userId;
    }

    public Long getHistoryId() {
        return HistoryId;
    }

    public void setHistoryId(Long historyId) {
        HistoryId = historyId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryDto that = (HistoryDto) o;

        if (HistoryId != null ? !HistoryId.equals(that.HistoryId) : that.HistoryId != null) return false;
        if (trainNumber != null ? !trainNumber.equals(that.trainNumber) : that.trainNumber != null) return false;
        if (fromStation != null ? !fromStation.equals(that.fromStation) : that.fromStation != null) return false;
        if (toStation != null ? !toStation.equals(that.toStation) : that.toStation != null) return false;
        if (departureTime != null ? !departureTime.equals(that.departureTime) : that.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(that.arrivalTime) : that.arrivalTime != null) return false;
        if (departureDate != null ? !departureDate.equals(that.departureDate) : that.departureDate != null)
            return false;
        if (wagonNumber != null ? !wagonNumber.equals(that.wagonNumber) : that.wagonNumber != null) return false;
        if (placeNumber != null ? !placeNumber.equals(that.placeNumber) : that.placeNumber != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        int result = HistoryId != null ? HistoryId.hashCode() : 0;
        result = 31 * result + (trainNumber != null ? trainNumber.hashCode() : 0);
        result = 31 * result + (fromStation != null ? fromStation.hashCode() : 0);
        result = 31 * result + (toStation != null ? toStation.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (wagonNumber != null ? wagonNumber.hashCode() : 0);
        result = 31 * result + (placeNumber != null ? placeNumber.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}