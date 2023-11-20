package demopakage;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
    public static String url="https://www.makemytrip.com/";
    WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
    JavascriptExecutor j;
    
    @BeforeTest
    public void openBrowser() {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	driver.get(url);
    	/*htmlReporter=new ExtentHtmlReporter();
    	extent=new ExtentReports();
    	extent.attachReporter(htmlReporter);
    	extent.attachReporter(htmlReporter);*/
    	extent = new ExtentReports();
    	htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);
    	driver.manage().window().maximize(); 	
    }
    
    @Test(enabled=true, priority = 1)
    public void handlePopups() {
    	test=extent.createTest("My first test");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebElement framepath = driver.findElement(By.xpath("//iframe[@class='webklipper-publisher-widget-container-notification-frame']"));
    	driver.switchTo().frame(framepath);
        driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
        test.pass("Closed Suhana Safari Sale popup");
    	driver.findElement(By.xpath("//*[@class='commonModal__close']")).click();
    	test.pass("Closed Signup or Login popup");
    	//driver.switchTo().defaultContent(); 	
    	extent.flush();
    }
    
    @Test(enabled=true, priority = 2)
    public void selectPlaces() {
    	test=extent.createTest("My second test");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//*[@class='menu_Holidays removeItemMargin']")).click();
    	test.pass("Clicked on Holiday packages");
    	driver.findElement(By.xpath("//*[@class='primaryBtnWhite border-btn font16 latoBold']")).click(); //nearest airport recommendation
    	test.pass("Closed nearest airport recommendation popup");
    	driver.findElement(By.xpath("//*[@for='fromCity']")).click();
    	driver.findElement(By.className("citypicker_input")).clear();
    	driver.findElement(By.className("citypicker_input")).sendKeys("Bangalore");
    	test.pass("Entered Bangalore in From textbox");
    	driver.findElement(By.xpath("//*[@class='appendLeft8 blackText']")).click(); //select bangalore from suggestions
    	driver.findElement(By.xpath("//*[@class='lbl_input latoBold makeFlex column']")).click();
    	driver.findElement(By.className("dest-search-input")).sendKeys("Dubai");
    	test.pass("Entered Dubai in To textbox");
    	driver.findElement(By.xpath("(//[@class='dest-city-name'])[5]")).click(); //(//[@class='dest-city-name'])[1],(//[@class='dest-city-packages'])[1],(//[@class='dest-city-container'])[1]	
    	driver.findElement(By.xpath("//*[@aria-label='Sat Nov 25 2023']")).click(); //departure date
    	test.pass("Selected departure date");
    	driver.findElement(By.className("applyBtn")).click(); //rooms and guests
    	test.pass("Clicked on Apply button of number of guests");
    	driver.findElement(By.xpath("//*[text()='APPLY']")).click(); //filters
    	test.pass("Clicked on Apply button of filters");
    	driver.findElement(By.xpath("//*[@class='primaryBtn font24 latoBlack widgetSearchBtn lineHeight29']")).click(); //search button
    	test.pass("Clicked on Search button");
    	driver.findElement(By.className("skipBtn")).click(); //modify your search popup (clicking on skip)
    	test.pass("Skipped modify search popup");
    	driver.findElement(By.id("searchBtn")).click();
    	test.pass("Clicked on Search button");
    	extent.flush();
    }
    
    @Test(enabled=true, priority = 3)
    public void selectPackage() throws InterruptedException {
    	test=extent.createTest("My third test");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(15000);
    	driver.findElement(By.xpath("//*[@class='close closeIcon']")).click(); //Need assistance popup
    	test.pass("Closed on Need assistance popup");
        driver.findElement(By.xpath("(//*[@class='imageCardWrapper'])[1]")).click(); //2
        //driver.findElement(By.xpath("(//*[@class='sliderCardShadow'])[3]")).click(); //3
        test.pass("Selected a package");
        Thread.sleep(5000);
        Set<String> wh = driver.getWindowHandles();
        String[] arr = wh.toArray(new String[wh.size()]);
		String child=arr[1];
		driver.switchTo().window(child);
		test.pass("Switched to child window");
		driver.findElement(By.xpath("//*[@class='skipBtn']")).click(); //Edit your travel date and number of travelers from here : popup
		test.pass("Skipped Edit your travel date and number of travelers popup");
		extent.flush();
    }
    
    @Test(enabled=true, priority = 4)
    public void changeHotel() throws InterruptedException {
    	test=extent.createTest("My fourth test");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   	
    	j=(JavascriptExecutor)driver;
        j.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("(//*[@id='change'])[3]")).click(); //change hotel
        test.pass("Clicked on change hotel");
        Thread.sleep(15000);
        driver.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[1]")).click(); //select new hotel
        test.pass("Selected new hotel");
        driver.findElement(By.xpath("//*[@class='updatePackageBtnText font10']")).click();
        test.pass("Clicked on Update package");
        /*String ename= "Long Beach Resort & Spa - Holidays Selections";
        String aname = driver.findElement(By.xpath("(//*[@class='hotel-row-details-title'])[1]")).getText();
        Assert.assertEquals(aname, ename);*/
        extent.flush();
        
    }
    
    @Test(enabled=true, priority = 5)
    public void addActivity() {
    	test=extent.createTest("My fifth test");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
    	j=(JavascriptExecutor)driver;
    	j.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("(//*[@id='chooseAndAddBtn'])[1]")).click(); //add activity button
        test.pass("Clicked on add activity");
        driver.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[1]")).click(); //select a activity
        test.pass("Selected a activity");
        driver.findElement(By.xpath("//*[@class='updatePackageBtnText font10 btn btn-primary btn-sm']")).click();
        test.pass("Clicked on Update package");
        extent.flush();
    }
    
    @Test(enabled=true, priority = 6)
    public void validateAll() throws InterruptedException {
    	test=extent.createTest("My sixth test");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("(//*[text()='Flights'])[2]")).click();
    	test.pass("Clicked on Flights");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("(//*[text()='Hotel'])[1]")).click();
    	test.pass("Clicked on Hotels");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[text()='Transfers']")).click();
    	test.pass("Clicked on transfers");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[text()='Activities']")).click();
    	test.pass("Clicked on Activities");
    	Thread.sleep(3000);
    	extent.flush();
    }
    @AfterTest
    public void closeBrowser() {
    	driver.quit();
    }
    
}