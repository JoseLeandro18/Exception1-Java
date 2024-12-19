package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("ROOM NUMBER: ");
        Integer roomNumber = sc.nextInt();
        System.out.print("CHECK-IN DATE (dd/MM/yyyy): ");
        Date checkInDate = sdf.parse(sc.next());
        System.out.print("CHECK-OUT DATE (dd/MM/yyyy): ");
        Date checkOutDate = sdf.parse(sc.next());

        if (!checkOutDate.after(checkInDate)) {
            System.out.println("ERROR IN RESERVATION: CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE ");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
            System.out.println("RESERVATION: " + reservation);

            System.out.println();
            System.out.println("ENTER DATA TO UPDATE THE RESERVATION: ");
            System.out.print("CHECK-IN DATE (dd/MM/yyyy): ");
            checkInDate = sdf.parse(sc.next());
            System.out.print("CHECK-OUT DATE (dd/MM/yyyy): ");
            checkOutDate = sdf.parse(sc.next());

            Date now = new Date();
            if (checkInDate.before(now) || checkOutDate.before(now)) {
                System.out.println("ERROR IN RESERVATION: RESERVATION DATES FOR UPDATE MUST BE FUTURE DATES");
            } else if (!checkOutDate.after(checkInDate)) {
                System.out.println("ERROR IN RESERVATION: CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE ");
            } else {
                reservation.updateDates(checkInDate, checkOutDate);
                System.out.println("RESERVATION: " + reservation);
            }
        }



        sc.close();
    }
}
