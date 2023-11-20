package mavendemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertdemo {
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
		driver.findElement(By.id("confirm button")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		@SuppressWarnings("unused")
		Alert popAlert3=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		popAlert3.accept();	
		Thread.sleep(3000);
	}
	
	@Test(enabled=true,priority=0)
	public void al3() throws InterruptedException, IOException {
	    JavascriptExecutor scroll=(JavascriptExecutor)driver;
	    //{0,100} this is for going or scrolling.
	    scroll.executeScript("window.scrollBy(0,100)");
	    driver.findElement(By.xpath("(//*[@type='button'])[5]")).click();
	    Alert alt=driver.switchTo().alert();
	    alt.sendKeys("welcome");
	    alt.accept();
	    scroll.executeScript("window.scrollBy(0,-100)");
	    scroll.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    
	    
	    TakesScreenshot ss = (TakesScreenshot)driver;
	    File fl = ss.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(fl, new File("/Users/sagars/Documents/Selenium ss/alerts.png"));
	}

}
