package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.DomainException;
import model.entities.Reservaion;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
		    Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reservaion reservation = new Reservaion(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy)");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy)");
			checkout = sdf.parse(sc.next());
			
			reservation.updateDate(checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
		}
		
		catch (ParseException e) {
			System.out.println("Ivalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		sc.close();

	}

}
