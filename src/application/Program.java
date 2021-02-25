package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

//1ª solução: Muito ruim. Lógica dentro do programa principal
public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Chekin date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Chekout date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Checkout date must be after chekin");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update reservation:");
			System.out.print("Chekin date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Chekout date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());

			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservations dates must be future dates");
			} else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: Checkout date must be after chekin");
			} else {
				reservation.updatDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}

		}

		sc.close();
	}

}
