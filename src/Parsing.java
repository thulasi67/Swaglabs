import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parsing {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.chromedriver","/Users/thulasiramkakarla/Downloads/chromedriver" );
		WebDriver driver  = new ChromeDriver(); // Invokes the Chrome Broswer from the erbDriver Interface
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicitly wait 5 seconds to read the pages before doingb every step  
		String username = getUserName(driver);
		String password = getPassword(driver);
		driver.get("https://www.saucedemo.com/"); 
		driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
driver.findElement(By.id("login-button")).click();




		
	}
	public static String getUserName(WebDriver driver) throws InterruptedException {
		driver.get("https://www.saucedemo.com/");   
		String userName= driver.findElement(By.xpath("(//div[@id='login_credentials'])[1]")).getText();
		String[] userNameArray = userName.split(":");
		String username = userNameArray[1].split("l")[0];
	return username;
}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://www.saucedemo.com/");   
		String passWord= driver.findElement(By.cssSelector(".login_password")).getText();
		String[] passWordArray = passWord.split(":");
		String password=passWordArray[1];
		
	return password;
}
}
