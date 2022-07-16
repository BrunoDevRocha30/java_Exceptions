package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import Model.Exception.DomainException;
import Model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		try {	
			System.out.print("Enter the room number: ");
			int number = sc.nextInt();
			System.out.print("Check-In date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println("");
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-In date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
			}
		catch(ParseException e) {
			System.out.println("Invalid date format.");			
		}
		catch(DomainException de) {
			System.out.println("Error in reservation"+ de.getMessage());
		}
		catch(RuntimeException re) {
			System.out.println("Unexpected error.");
		}
		sc.close();
		}	
	}
