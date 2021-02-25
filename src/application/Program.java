package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExcpetion;

//3ª solução: com tratamento de exceções
public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Chekin date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Chekout date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update reservation:");
			System.out.print("Chekin date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Chekout date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());

			reservation.updatDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		} catch (ParseException parseException) {
			System.err.println("Invalid date format.");
		}catch(DomainExcpetion domainException) {//catch (IllegalArgumentException illegalArgumentException) {
			System.err.println("Error in reservation: " + domainException.getMessage());//illegalArgumentException.getMessage());
		}catch(RuntimeException runtimeException) {
			System.err.println("Unexpected error");
		}//protege o programa de exceções que não eram esperadas
		sc.close();
	}

}
