package genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

import pomRepo.HomePage;
import pomRepo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public static WebDriver sDriver;
	public Connection connection;
	@BeforeSuite
	public void bsConfig() throws SQLException {
		
		Driver dataBaseDriver = new Driver();

		DriverManager.registerDriver(dataBaseDriver);

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		System.out.println("Data Connection is established");
	}

	@BeforeClass
	public void bcConfig() throws IOException {

		String url = fUtils.fetchDataFromPropertyFile("url");

		driver = new ChromeDriver();
		System.out.println("Chrome Browser has been launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		System.out.println("Navigated to the URL");
		sDriver = driver;
	}

	@BeforeMethod
	public void bmConfig() throws IOException {

		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("Login is successfull");
	}

	@AfterMethod
	public void amConfig() {
		HomePage home = new HomePage(driver);
		home.logoutAction();
	}

	@AfterClass
	public void acConfig() {
		driver.quit();
	}

	@AfterSuite
	public void asConfig() throws SQLException {
		connection.close();
		System.out.println("Data base has been closed");
	}

}
