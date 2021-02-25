package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

//2ª solução: Ruim. Lógica dentro da classe Reservation
//É um tipo de solução usada em linguagens mais antigas, como a C
//A classe responsável pela lógica retorna um código que o programador deve recuperar
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

		//validação para criar um objeto ainda deve ser feita aqui, pois deveria estar no construtor 
		//e não existe meio de fazer o construtor retornar uma string
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

			String error = reservation.updatDates(checkin, checkout);

			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();
	}

}
