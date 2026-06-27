package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public String updateDates(LocalDate checkIn, LocalDate checkOut) {

        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            return ("Error in reservation: Reservation dates for update must be future dates.");

        }
        if (!checkOut.isAfter(checkIn)) {
            //Aqui deu um erro, pois no curso utilizei a data 2019, igual foi instruído lá.
            //Mas, como utilizei o LocalDate.now(), necessariamente preciso colocar a data posterior ao ano que estou, no caso, 2026.
            return ("Error in reservation: Check-out date must be after check-in date.");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

        @Override
        public String toString () {
            return "Room "
                    + roomNumber
                    + ", check-in: "
                    + checkIn.format(DTF)
                    + ", check-out: "
                    + checkOut.format(DTF)
                    + ", "
                    + duration()
                    + " nights";
        }

    }
