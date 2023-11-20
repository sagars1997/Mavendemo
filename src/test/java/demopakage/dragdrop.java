package demopakage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragdrop {
	public static String url = "https://jqueryui.com/droppable/";
	WebDriver driver;
	
	@BeforeTest
	public void openurl()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void dgdp1()
	{
		int nframes=driver.findElements(By.tagName("iframe")).size();
        List<WebElement> frame=driver.findElements(By.tagName("iframe"));
        frame.get(0).getText();
        System.out.println("frame: "+frame);
        System.out.println("number of frames: "+nframes);
        WebElement frametext=driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(frametext);
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Actions mact=new Actions(driver);
        mact.dragAndDrop(drag, drop).build().perform();
    }
}
