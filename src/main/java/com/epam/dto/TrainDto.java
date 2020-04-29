package com.epam.dto;

import java.math.BigDecimal;
import java.sql.Time;

public class TrainDto {
    private Long TrainId;
    private String trainNumber;
    private String fromStation;
    private String toStation;
    private Time departureTime;
    private Time arrivalTime;
    private Long wagonsQuantity;
    private Long placesQuantity;
    private BigDecimal price;

    public TrainDto() {
    }

    public TrainDto(String trainNumber, String fromStation, String toStation, Time departureTime,
                    Time arrivalTime, Long wagonsQuantity, Long placesQuantity, BigDecimal price) {
        this.trainNumber = trainNumber;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.wagonsQuantity = wagonsQuantity;
        this.placesQuantity = placesQuantity;
        this.price = price;
    }

    public TrainDto(Long trainId, String trainNumber, String fromStation, String toStation, Time departureTime,
                    Time arrivalTime, Long wagonsQuantity, Long placesQuantity, BigDecimal price) {
        TrainId = trainId;
        this.trainNumber = trainNumber;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.wagonsQuantity = wagonsQuantity;
        this.placesQuantity = placesQuantity;
        this.price = price;
    }

    public Long getTrainId() {
        return TrainId;
    }

    public void setTrainId(Long trainId) {
        TrainId = trainId;
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

    public Long getWagonsQuantity() {
        return wagonsQuantity;
    }

    public void setWagonsQuantity(Long wagonsQuantity) {
        this.wagonsQuantity = wagonsQuantity;
    }

    public Long getPlacesQuantity() {
        return placesQuantity;
    }

    public void setPlacesQuantity(Long placesQuantity) {
        this.placesQuantity = placesQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainDto trainDto = (TrainDto) o;

        if (TrainId != null ? !TrainId.equals(trainDto.TrainId) : trainDto.TrainId != null) return false;
        if (trainNumber != null ? !trainNumber.equals(trainDto.trainNumber) : trainDto.trainNumber != null)
            return false;
        if (fromStation != null ? !fromStation.equals(trainDto.fromStation) : trainDto.fromStation != null)
            return false;
        if (toStation != null ? !toStation.equals(trainDto.toStation) : trainDto.toStation != null) return false;
        if (departureTime != null ? !departureTime.equals(trainDto.departureTime) : trainDto.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(trainDto.arrivalTime) : trainDto.arrivalTime != null)
            return false;
        if (wagonsQuantity != null ? !wagonsQuantity.equals(trainDto.wagonsQuantity) : trainDto.wagonsQuantity != null)
            return false;
        if (placesQuantity != null ? !placesQuantity.equals(trainDto.placesQuantity) : trainDto.placesQuantity != null)
            return false;
        return price != null ? price.equals(trainDto.price) : trainDto.price == null;
    }

    @Override
    public int hashCode() {
        int result = TrainId != null ? TrainId.hashCode() : 0;
        result = 31 * result + (trainNumber != null ? trainNumber.hashCode() : 0);
        result = 31 * result + (fromStation != null ? fromStation.hashCode() : 0);
        result = 31 * result + (toStation != null ? toStation.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (wagonsQuantity != null ? wagonsQuantity.hashCode() : 0);
        result = 31 * result + (placesQuantity != null ? placesQuantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}