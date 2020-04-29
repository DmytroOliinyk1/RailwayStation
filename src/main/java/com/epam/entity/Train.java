package com.epam.entity;

import java.math.BigDecimal;
import java.sql.Time;

public class Train extends Entity {

    private String trainNumber;
    private String fromStation;
    private String toStation;
    private Time departureTime;
    private Time arrivalTime;
    private Long wagonsQuantity;
    private Long placesQuantity;
    private BigDecimal price;

    public enum trainSqlQuery {
        GET_BY_ID(SqlQuery.GET_BY_ID, "SELECT * FROM trains WHERE TrainID = ?;"),
        GET_BY_FIELD(SqlQuery.GET_BY_FIELD, "SELECT * FROM trains WHERE FromStation = '?' AND ToStation = '?';"),
        GET_ALL(SqlQuery.GET_ALL, "SELECT * FROM trains"),
        INSERT(SqlQuery.INSERT, "INSERT INTO trains (TrainNumber, FromStation, ToStation, " +
                "DepartureTime, ArrivalTime, WagonsQuantity, PlacesQuantity, Price) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

        private SqlQuery sqlQuery;
        private String query;

        trainSqlQuery(SqlQuery sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQuery getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    public Train() {
    }

    public Train(String trainNumber, String fromStation, String toStation, Time departureTime,
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

    public Train(Long id, String trainNumber, String fromStation, String toStation, Time departureTime,
                 Time arrivalTime, Long wagonsQuantity, Long placesQuantity, BigDecimal price) {
        super(id);
        this.trainNumber = trainNumber;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.wagonsQuantity = wagonsQuantity;
        this.placesQuantity = placesQuantity;
        this.price = price;
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
        if (!super.equals(o)) return false;

        Train train = (Train) o;

        if (trainNumber != null ? !trainNumber.equals(train.trainNumber) : train.trainNumber != null) return false;
        if (fromStation != null ? !fromStation.equals(train.fromStation) : train.fromStation != null) return false;
        if (toStation != null ? !toStation.equals(train.toStation) : train.toStation != null) return false;
        if (departureTime != null ? !departureTime.equals(train.departureTime) : train.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(train.arrivalTime) : train.arrivalTime != null) return false;
        if (wagonsQuantity != null ? !wagonsQuantity.equals(train.wagonsQuantity) : train.wagonsQuantity != null)
            return false;
        if (placesQuantity != null ? !placesQuantity.equals(train.placesQuantity) : train.placesQuantity != null)
            return false;
        return price != null ? price.equals(train.price) : train.price == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
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

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber='" + trainNumber + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", wagonsQuantity=" + wagonsQuantity +
                ", placesQuantity=" + placesQuantity +
                ", price=" + price +
                '}';
    }
}