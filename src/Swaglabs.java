import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Swaglabs {
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		// pathing the webdriver from the local machine for the better synchroniztion
		System.setProperty("webdriver.chrome.chromedriver","/Users/thulasiramkakarla/Downloads/chromedriver" ); 
		WebDriver driver  = new ChromeDriver(); // Invokes the Chrome Broswer from the erbDriver Interface
	
		driver.manage().window().maximize(); // maximizes the tab 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicitly wait 5 seconds to read the pages before doingb every step  
		driver.get("https://www.google.com/"); // for entering the search engine in the browser
		driver.navigate().to("https://www.saucedemo.com/"); // navigating into the website
		driver.navigate().back();
		Thread.sleep(250); // pausing to check whether the back button is clicked
		driver.navigate().forward(); // navigating forward
		String username = getUserName(driver); 
		String password = getPassword(driver);
		driver.findElement(By.cssSelector("#user-name")).sendKeys(username);// sending userename to login
driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);// sendinbg password to login
driver.findElement(By.id("login-button")).click();
System.out.println(username); // displaying the username and password  for assertion in Testng
System.out.println(password);

Thread.sleep(1000);


driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click(); // cssSelector with the tagname

driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click(); // regular xpath function
driver.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-bolt-t-shirt'])[1]")).click(); // xpath selector with the help of index
driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(2) > button:nth-child(2)")).click();
System.out.println(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText());
WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
Select dropdown = new Select(staticDropdown); // checking the dropdown function for its functionality
dropdown.selectByIndex(2); // selecting option from the index 
//dropdown.selectByValue("hilo"); selecting from the value 

driver.findElement(By.xpath("(//a[@class='shopping_cart_link'])[1]")).click();
driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
driver.findElement(By.name("checkout")).click(); // name selector 
driver.findElement(By.cssSelector("#continue")).click();


driver.findElement(By.id("first-name")).sendKeys("Alex"); // unique id selctor
driver.findElement(By.cssSelector("#last-name")).sendKeys("Wyatt");
driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("3000");

driver.findElement(By.cssSelector("#continue")).click();
driver.findElement(By.xpath("//button[@id='finish']")).click();




		
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
