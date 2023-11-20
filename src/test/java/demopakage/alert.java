package demopakage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alert {
	public static String url = "https://demoqa.com/alerts";
	WebDriver driver;
	@BeforeTest
	public void openurl()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test (enabled = false)
	public void alert1() throws InterruptedException
	{
		//System.out.println("alert");
		driver.findElement(By.id("alertbutton")).click();
		System.out.println("click me button was clicked");
		Alert popAlert=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		popAlert.accept();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}
	
	@Test (enabled = true)
	public void alert2() throws InterruptedException
	{
		driver.findElement(By.id("time alert button")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Alert popAlert2=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		popAlert2.accept();	
		Thread.sleep(3000);
	}
	
	@Test
	public void alert3() throws InterruptedException
	{
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,100");
		driver.findElement(By.id("time alert button")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Alert popAlert3=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		popAlert3.accept();	
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void winclose()
	{
		driver.close();
	}
}


