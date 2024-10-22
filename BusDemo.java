package BusReservation;

import java.util.Scanner;
import java.util.ArrayList;

public class BusDemo {

    public static void main(String[] args) {
        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        buses.add(new Bus(1, true, 2));
        buses.add(new Bus(2, true, 3));
        buses.add(new Bus(3, true, 4));

        int userOpt = 1;
        Scanner input = new Scanner(System.in);

        // Display all bus information
        for (Bus bus : buses) {
            bus.displayBusInfo(); // Fixed the spelling here
        }

       while (userOpt == 1) {
                   System.out.println("Enter 1 to Book and 2 to exit:");
                   userOpt = input.nextInt();

                   // Using if-else instead of switch-case
                   if (userOpt == 1) {
                       Booking booking = new Booking();
                       if (booking.isAvailable(bookings, buses)) {  // Assuming method isAvailable exists
                           bookings.add(booking);
                           System.out.println("Booking successful");
                       } else {
                           System.out.println("Booking failed");
                       }
                   } else if (userOpt == 2) {
                       System.out.println("Exit");
                       userOpt = 0;  // Set userOpt to 0 to exit the loop
                   } else {
                       System.out.println("Invalid option");
                   }
               }

               input.close();  // Close the scanner after use
           }
}
