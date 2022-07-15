package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Enter the room number: ");
		int number = sc.nextInt();
		System.out.print("Check-In date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation! Check-Out date must be after Check-In date.");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println("");
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-In date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Reservation dates for update must be future dates");
			}else if(!checkOut.after(checkIn)){
				System.out.println("Error in reservation! Check-Out date must be after Check-In date.");
			}else {			
			reservation.updateDates(checkIn, checkOut);
			}
		}
		
		sc.close();

	}

}
