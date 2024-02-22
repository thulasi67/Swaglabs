import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Compediumdev {
public static void main(String[] args) throws InterruptedException{		
	
	System.setProperty("webdriver.chrome.chromedriver","/Users/thulasiramkakarla/Downloads/chromedriver" );
	/* The above property is completely optional, even if we don't set the property, SelenIum
	manager will take care of invoking the browser, Installing the ChromeDriver in the local machine 
	decreases latency  */
	
	WebDriver driver  = new ChromeDriver(); // Invokes the Chrome Broswer from the erbDriver Interface
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicitly wait 5 seconds to read the pages before doingb every step  
	//String username = getUserName(driver);
	driver.get("https://www.saucedemo.com/");       // Targeted website 
System.out.println(driver.getTitle());      // Page title check
System.out.println(driver.getCurrentUrl()); // Verifying page title with the Current Url


//Web element using "id " locator

driver.findElement(By.id("user-name")).sendKeys("get_it_done"); 

//Web element using "name " locator

driver.findElement(By.name("password")).sendKeys("Standard@554");
driver.findElement(By.id("login-button")).click();
// web element using cssSelector
System.out.println(driver.findElement(By.cssSelector("h3[data-test='error']")).getText());

// 
System.out.println(driver.findElement(By.cssSelector("div.error-message-container")).getText());  

// web element using class
Thread.sleep(1000);

driver.findElement(By.className("error-button")).click();
// clearing the data for new input 
driver.findElement(By.id("user-name")).clear();
driver.findElement(By.name("password")).clear();

System.out.println(driver.findElement(By.xpath("//div[@class='login_password']")).getText());
//driver.findElement(By.id("user-name")).sendKeys(username); 

//String userName= driver.findElement(By.xpath("(//div[@id='login_credentials'])[1]")).getText();
//System.out.println(userName);


//driver.close();
//driver.quit();
}
/*public static String getUserName(WebDriver driver) throws InterruptedException {
	driver.get("https://www.saucedemo.com/");   
	String userName= driver.findElement(By.xpath("(//div[@id='login_credentials'])[1]")).getText();
	String[] userNameArray = userName.split(":");
	String username = userNameArray[1].split("l")[0];
return username;
}*/
}