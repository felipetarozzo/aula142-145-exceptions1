package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//static para que não seja instanciado um 
																			//novo SimpleDateFormat para cada objeto
																			//que a aplicação tiver
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
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
	
	//Não desejo que as datas sejam mudadas arbitrariamente, pois existe um método para isso
	//public void setCheckin(Date checkin) {
	//	this.checkin = checkin;
	//}
	
	public Date getCheckout() {
		return checkout;
	}
	
	//Não desejo que as datas sejam mudadas arbitrariamente, pois existe um método para isso
	//public void setCheckout(Date checkout) {
	//	this.checkout = checkout;
	//}
		
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();//O getTime(); pega as datas em milissegundos
		//Converter milissegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//converte o valo diff (milissegundos) para dias	
	}
	
	public String updatDates(Date checkin, Date checkout) {
		
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "Reservations dates must be future dates";
		}
		if (!checkout.after(checkin)) {
			return "Checkout date must be after chekin";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;//Critério para identificar que não houve nenhum erro na operação
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
