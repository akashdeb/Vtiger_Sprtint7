package concepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ToUpdateDataInDataBase {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate("insert into emp values(345,'Dheeraj', 'Tester');");
		
		if(result==1) {
			System.out.println("Data base has been updated");
		}
		
		else
			System.out.println("Data base has not been updated");

		connection.close();
	}

}
