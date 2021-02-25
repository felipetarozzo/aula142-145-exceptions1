package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExcpetion;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//static para que n�o seja instanciado um 
																			//novo SimpleDateFormat para cada objeto
																			//que a aplica��o tiver
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainExcpetion {
		
		if (!checkout.after(checkin)) {
			//throw new IllegalArgumentException("Checkout date must be after chekin");
			//mesma l�gica da exce��o anterior, argumento errado se a data de checkout for anterior a data de checkin
			//Mesma l�gica para a exce��o personalizada
			throw new DomainExcpetion("Ceckout date must be after checkin");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getCheckin() {
		return checkin;
	}
	
	//N�o desejo que as datas sejam mudadas arbitrariamente, pois existe um m�todo para isso
	//public void setCheckin(Date checkin) {
	//	this.checkin = checkin;
	//}
	
	public Date getCheckout() {
		return checkout;
	}
	
	//N�o desejo que as datas sejam mudadas arbitrariamente, pois existe um m�todo para isso
	//public void setCheckout(Date checkout) {
	//	this.checkout = checkout;
	//}
		
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();//O getTime(); pega as datas em milissegundos
		//Converter milissegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//converte o valo diff (milissegundos) para dias	
	}
	
	public void updatDates(Date checkin, Date checkout) throws DomainExcpetion {//o throws � adicionado, pois quero que
																//o m�todo updateDates lance a exce��o
		Date now = new Date();									//e ela seja tratada no programa principal
		if (checkin.before(now) || checkout.before(now)) {
			//throw new IllegalArgumentException("Reservations dates must be future dates");
			//se der erro lan�a a excess�o de argumentos inv�lidos (caso os argumentos passados sejam errados)
			//pois o erro verificado � se as datas eram datas anteriores a data atual (argumentos inv�llidos 
			//passados ao m�todo)
			//EXE��O PERSONALIZADA
			throw new DomainExcpetion("Reservations dates must be future dates");
		}
		if (!checkout.after(checkin)) {
			//throw new IllegalArgumentException("Checkout date must be after chekin");
			//mesma l�gica da exce��o anterior, argumento errado se a data de checkout for anterior a data de checkin
			//Mesma l�gica para a exce��o personalizada
			throw new DomainExcpetion("Ceckout date must be after checkin");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkin)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
	}

}
