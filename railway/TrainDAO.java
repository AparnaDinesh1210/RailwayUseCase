package railway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TrainDAO {
	
	String driverClass ="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/traininfo?autoReconnect=true&useSSL=false";
	String userName="root";
	String password="rootpassword";


public Train findTrain(int trainNo)
{
	int id= trainNo;
	Train train = null;

try
{
	
Class.forName(driverClass);
System.out.println("Class found");

Connection con = DriverManager.getConnection(url, userName, password);
System.out.println("connected");

PreparedStatement ps = con.prepareStatement("select * from trains where trainno= ?");		
ps.setInt(1, id);

ResultSet rs = ps.executeQuery();
while(rs.next())
{
	
	train = new Train(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
	//System.out.println(rs.getInt(1) +" " + rs.getString(2) +" " +rs.getString(3)+ " "+rs.getInt(4));
}
con.close();
}
catch(Exception e)
{
System.out.println("Class not found");
}
return train;
}
}
