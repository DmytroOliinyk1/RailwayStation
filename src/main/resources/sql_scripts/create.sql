create database if not exists railway_station;

use railway_station;

create table if not exists users
(
    UserID   int          not null auto_increment,
    Email    varchar(255) not null,
    Password varchar(255) not null,
    Name     varchar(255) not null,
    Surname  varchar(255) not null,
    primary key (UserID)
);

create table if not exists trains
(
    TrainID        int           not null auto_increment,
    TrainNumber    varchar(255)  not null,
    FromStation    varchar(255)  not null,
    ToStation      varchar(255)  not null,
    DepartureTime  time          not null,
    ArrivalTime    time          not null,
    WagonsQuantity int           not null,
    PlacesQuantity int           not null,
    Price         decimal(9, 2)  not null,
    primary key (TrainID)
);

create table if not exists history
(
    HistoryID     int            not null auto_increment,
    TrainNumber   varchar(255)   not null,
    FromStation   varchar(255)   not null,
    ToStation     varchar(255)   not null,
    DepartureTime time           not null,
    ArrivalTime   time           not null,
    DepartureDate date           not null,
    WagonNumber   int            not null,
    PlaceNumber   int            not null,
    Price         decimal(9, 2)  not null,
    UserID        int            not null,
    primary key (HistoryID),
    foreign key (UserID) references users (UserID)
);

create table if not exists booked_places
(
    BookedPlaceID int  not null auto_increment,
    WagonNumber   int  not null,
    PlaceNumber   int  not null,
    DepartureDate date not null,
    primary key (BookedPlaceID),
    TrainID       int  not null,
    foreign key (TrainID) references trains (TrainID)
);