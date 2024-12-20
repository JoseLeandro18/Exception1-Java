package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    // days calculated method
    public Long duration(){
        Long diference = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diference, TimeUnit.MILLISECONDS);
    }

    // update date method
    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "ROOM: " +
                roomNumber +
                ", CHECK-IN: " +
                sdf.format(checkIn) +
                ", CHECK-OUT: " +
                sdf.format(checkOut) +
                ", DURATION: " +
                duration() +
                " NIGHTS";
    }



}
