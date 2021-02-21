package railway;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class Ticket 
{
	
	private static int counter=100;
	private String pnr;
	private LocalDate travelDate;
	private Train train;
	private TreeMap<Passenger,Integer> passengers;
	

	public Ticket(LocalDate travelDate, Train train) {
		super();
		travelDate = travelDate;
		this.train = train;
	}

public Ticket(String travelDate2, Train train2) {
		// TODO Auto-generated constructor stub
	}

public int getCounter() {
		return counter;
	}


public static void setCounter(int counter) {
		Ticket.counter = counter;
	}


public String getPnr() {
		return pnr;
	}

public void setPnr(String pnr) {
		this.pnr = pnr;
	}

public LocalDate getTravelDate() {
		return travelDate;
	}

public void setTravelDate(LocalDate travelDate) {
		travelDate = travelDate;
	}

public Train getTrain() {
		return train;
	}

public void setTrain(Train train) {
		this.train = train;
	}

public TreeMap<Passenger, Integer> getPassengers() {
		return passengers;
	}

public void setPassengers(TreeMap<Passenger, Integer> passengers) {
		this.passengers = passengers;
	}
	
	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", travelDate=" + travelDate + ", train=" + train + ", passengers=" + passengers
				+ "]";
	}

    public String generatePNR()
	{
	String src = String.valueOf(train.getSource().charAt(0));
	String dest = String.valueOf(train.getDestination().charAt(0));
	
	String d = travelDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	String pnr = src+dest+ "_"+ d + "_" + counter++;

    if(travelDate.isAfter(LocalDate.now()))
    return pnr;
    else
    	return "Please enter a valid date";
    	
    }
	
	
	
     double calcPassengerFare(Passenger Passenger)
	{
		if(Passenger.getAge()<=12)
		  return (0.5)*(train.getTicketPrice());
		else if(Passenger.getAge()>=60)
			return (0.6)*(train.getTicketPrice());
		else if(Passenger.getGender()=='F')
			return (0.25)*(train.getTicketPrice());
		else
		return train.getTicketPrice();
		
	}
	
	public void addPassenger(String name, int age, char gender) throws NullPointerException
	{
		passengers = new TreeMap<Passenger, Integer>();
		Integer fare=(int) calcPassengerFare(new Passenger(name,age,gender));
		System.out.println(fare);
		passengers.put(new Passenger(name,age,gender),fare);
	}
	
double calculateTotalTicketPrice()
	{
		int totalTicketPrice=0;
		Collection<Integer>price=passengers.values();
		for(Integer values:price)
		{
			totalTicketPrice=totalTicketPrice+values;
		}
		return (double) totalTicketPrice;
	}
	
	StringBuilder generateTicket()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("PNR : "+generatePNR()).append("\n").append("Travel Date : "+travelDate).append("\n").append("TrainNo : "+train.getTrainNo()).append("\n").append("Train name : "+train.getTrainName()).append("\n").append("Source station : "+train.getSource()).append("\n").append("Destination station : "+train.getDestination());
		return sb;
	}
	
	
	
	public void writeTicket() throws IOException 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter details : ");
		String pnr = s.next();
		FileWriter fw = new FileWriter("pnr");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.flush();
		bw.close();
	}
}
