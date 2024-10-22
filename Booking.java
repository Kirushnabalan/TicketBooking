package BusReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
    String PassengerName;
    int BusNo;
    Date Date;

    Booking(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the passager:");
        PassengerName = sc.nextLine();
        System.out.println("Enter the number of the bus:");
        BusNo = sc.nextInt();
        System.out.println("Enter the date of the booking(dd/MM/yyyy):");
        String BookingDate;
        BookingDate = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date=dateFormat.parse(BookingDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        for (Bus bus : buses) {
            if(bus.getBusNo() == BusNo){
                capacity = bus.getCapacity();
            }
        }
        int booked = 0;
        for(Booking b:bookings)
            if (b.BusNo == BusNo && b.Date.equals(Date))
                booked++;
        return booked<capacity?true:false;
    }
    }

