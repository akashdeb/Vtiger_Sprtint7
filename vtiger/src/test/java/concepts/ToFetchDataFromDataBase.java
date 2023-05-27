package concepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ToFetchDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from emp;");
		
		if(result.next()) {
			System.out.println("Name: "+result.getString(2)+" Job: "+result.getString(3));
		}
		
		connection.close();

	}

}
