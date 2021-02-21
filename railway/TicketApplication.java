package railway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TicketApplication {

	public static void main(String[] args) {
		
		System.out.println("======Railway Ticket Reservation Application=====");
		
    	TrainDAO trainDao = new TrainDAO();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd="
				+ "");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter train id : ");
		trainDao.findTrain(sc.nextInt()); 
		
    	Train train = trainDao.findTrain(sc.nextInt());
		System.out.println("Price is : "+train.getTicketPrice()); 
		
		System.out.println("Enter the travel date: ");
		String travelDate=sc.next();
		LocalDate date = LocalDate.parse(travelDate,df);
		
		System.out.println("travel date: " +date);
		String userInput=sc.next();
		
		System.out.println("after format: " +date.format(df));
		
		System.out.println("Enter number of passengers : ");
		int numberOfPassengers=sc.nextInt(); 
		
		
		Train train=new Train(trainNo,trainName,"Mumbai","Bangalore",1600);
		Ticket ticket=new Ticket(travelDate,train);
		sc.nextLine();
		
		for(int i=1;i<=numberOfPassengers;i++)
		{
			System.out.println("Enter the name of passenger : ");
			String name=sc.next();
			sc.nextLine();
			
			System.out.println("Enter age : ");
			int age=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter gender(F/M) : ");
			String gender=sc.next();
			char c=gender.charAt(0);
			
			
			ticket.addPassenger(name, age, c);
		}
		
		System.out.println("Ticket booked with the PNR: "+ticket.generatePNR());
		ticket.writeTicket();
		
		
		
}

}
