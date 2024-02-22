import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Karting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.chromedriver","/Users/thulasiramkakarla/Downloads/chromedriver" );
		WebDriver driver  = new ChromeDriver(); // Invokes the Chrome Broswer from the erbDriver Interface
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicitly wait 5 seconds to read the pages before doingb every step  
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.saucedemo.com/"); 
		Thread.sleep(250);
		driver.navigate().back();
		Thread.sleep(250);
		driver.navigate().forward();
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();
Thread.sleep(1000);

driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
driver.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-bolt-t-shirt'])[1]")).click();
driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(2) > button:nth-child(2)")).click();
System.out.println(driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).getText());
WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
Select dropdown = new Select(staticDropdown);
dropdown.selectByIndex(2);
//dropdown.selectByValue("hilo");

driver.findElement(By.xpath("(//a[@class='shopping_cart_link'])[1]")).click();
driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
driver.findElement(By.name("checkout")).click();
driver.findElement(By.cssSelector("#continue")).click();


driver.findElement(By.id("first-name")).sendKeys("Alex");
driver.findElement(By.cssSelector("#last-name")).sendKeys("Wyatt");
driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("3000");

driver.findElement(By.cssSelector("#continue")).click();
driver.findElement(By.xpath("//button[@id='finish']")).click();
	}

}
