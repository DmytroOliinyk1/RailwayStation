package com.epam.entity;

import java.util.Date;

public class BookedPlace extends Entity {

    private Long wagonNumber;
    private Long placeNumber;
    private Date departureDate;
    private Long trainId;

    public enum bookedPlaceSqlQuery {
        GET_BY_ID(SqlQuery.GET_BY_ID, "SELECT * FROM booked_places WHERE BookedPlaceID = ?;"),
        GET_BY_FIELD(SqlQuery.GET_BY_FIELD, "SELECT * FROM trains WHERE " +
                "TrainID = ? AND DepartureDate = '?' AND WagonNumber = ? AND PlaceNumber = ?;"),
        GET_ALL(SqlQuery.GET_ALL, "SELECT * FROM booked_places;"),
        INSERT(SqlQuery.INSERT, "INSERT INTO booked_places " +
                "(WagonNumber, PlaceNumber, DepartureDate, TrainID) VALUES (?, ?, ?, ?);"),
        DELETE_BY_ID(SqlQuery.DELETE_BY_ID, "DELETE FROM booked_places WHERE BookedPlaceID = ?;");



        private SqlQuery sqlQuery;
        private String query;

        bookedPlaceSqlQuery(SqlQuery sqlQuery, String query) {
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

    public BookedPlace() {
    }

    public BookedPlace(Long wagonNumber, Long placeNumber, Date departureDate, Long trainId) {
        this.wagonNumber = wagonNumber;
        this.placeNumber = placeNumber;
        this.departureDate = departureDate;
        this.trainId = trainId;
    }

    public BookedPlace(Long id, Long wagonNumber, Long placeNumber, Date departureDate, Long trainId) {
        super(id);
        this.wagonNumber = wagonNumber;
        this.placeNumber = placeNumber;
        this.departureDate = departureDate;
        this.trainId = trainId;
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
        if (!super.equals(o)) return false;

        BookedPlace that = (BookedPlace) o;

        if (wagonNumber != null ? !wagonNumber.equals(that.wagonNumber) : that.wagonNumber != null) return false;
        if (placeNumber != null ? !placeNumber.equals(that.placeNumber) : that.placeNumber != null) return false;
        if (departureDate != null ? !departureDate.equals(that.departureDate) : that.departureDate != null)
            return false;
        return trainId != null ? trainId.equals(that.trainId) : that.trainId == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wagonNumber != null ? wagonNumber.hashCode() : 0);
        result = 31 * result + (placeNumber != null ? placeNumber.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (trainId != null ? trainId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookedPlace{" +
                "wagonNumber=" + wagonNumber +
                ", placeNumber=" + placeNumber +
                ", departureDate=" + departureDate +
                ", trainId=" + trainId +
                '}';
    }
}