package demopakage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class democlass {
	public static String url="https://demo.guru99.com/test/newtours/login.php";
	WebDriver driver;
	@BeforeTest
	public void b1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(3000);
	}
	@Test
	public void c1()
	{
		driver.findElement(By.name("userName")).sendKeys("user");
	
	
	}
}      