package com.epam.entity;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;

public class History extends Entity {

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

    public enum historySqlQuery {
        GET_BY_ID(SqlQuery.GET_BY_ID, "SELECT * FROM history WHERE HistoryID = ?;"),
        GET_BY_FIELD(SqlQuery.GET_BY_FIELD, "SELECT * FROM history WHERE UserID = ?;"),
        GET_ALL(SqlQuery.GET_ALL, "SELECT * FROM history"),
        DELETE_BY_FIELD(SqlQuery.DELETE_BY_FIELD, "DELETE FROM history WHERE UserID = ?"),
        INSERT(SqlQuery.INSERT, "INSERT INTO history (TrainNumber, FromStation, ToStation, " +
                "DepartureTime, ArrivalTime, DepartureDate, WagonNumber, PlaceNumber, Price, UserID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        private SqlQuery sqlQuery;
        private String query;

        historySqlQuery(SqlQuery sqlQuery, String query) {
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

    public History() {
    }

    public History(String trainNumber, String fromStation, String toStation, Time departureTime,
                   Time arrivalTime, Date departureDate, Long wagonNumber, Long placeNumber,
                   BigDecimal price, Long userId) {
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

    public History(Long id, String trainNumber, String fromStation, String toStation, Time departureTime,
                   Time arrivalTime, Date departureDate, Long wagonNumber,
                   Long placeNumber, BigDecimal price, Long userId) {
        super(id);
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
        if (!super.equals(o)) return false;

        History history = (History) o;

        if (trainNumber != null ? !trainNumber.equals(history.trainNumber) : history.trainNumber != null) return false;
        if (fromStation != null ? !fromStation.equals(history.fromStation) : history.fromStation != null) return false;
        if (toStation != null ? !toStation.equals(history.toStation) : history.toStation != null) return false;
        if (departureTime != null ? !departureTime.equals(history.departureTime) : history.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(history.arrivalTime) : history.arrivalTime != null) return false;
        if (departureDate != null ? !departureDate.equals(history.departureDate) : history.departureDate != null)
            return false;
        if (wagonNumber != null ? !wagonNumber.equals(history.wagonNumber) : history.wagonNumber != null) return false;
        if (placeNumber != null ? !placeNumber.equals(history.placeNumber) : history.placeNumber != null) return false;
        if (price != null ? !price.equals(history.price) : history.price != null) return false;
        return userId != null ? userId.equals(history.userId) : history.userId == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
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

    @Override
    public String toString() {
        return "History{" +
                "trainNumber='" + trainNumber + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureDate=" + departureDate +
                ", wagonNumber=" + wagonNumber +
                ", placeNumber=" + placeNumber +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }
}