package bbOffer;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PTopics {
@Test
public void printTopics() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	WebDriver	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bigbasket.com/");
	Thread.sleep(30000);

	driver.findElement(By.xpath("//button[text()='Login/ Sign Up']")).click();

	driver.findElement(By.xpath("//input[@placeholder='Enter Phone number/ Email Id']")).sendKeys("kirangouda65@gmail.com");

	driver.findElement(By.xpath("//button[text()='Continue']")).click();
	Thread.sleep(80000);

	driver.findElement(By.xpath("//button[text()='Got it']")).click();
	driver.findElement(By.id("headlessui-menu-button-:rc:")).click();
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Customer Service']")).click();
	List<WebElement> titles = driver.findElements(By.xpath("//h6[@class='ng-binding']"));
	int count=titles.size();
	boolean flag=false;
	if(count>=10)
	{
		flag=true;
	}
	SoftAssert a=new SoftAssert(); 
	a.assertTrue(flag);
	System.out.println("titles are greater than or equal to 10");
	a.assertFalse(flag);
	System.out.println("titles are less than 10");

	System.out.println("total topics"+count);
	for(WebElement we:titles)
	{
		String topics = we.getText();
		System.out.println(topics);
	}
	driver.findElement(By.xpath("//a[text()='My Orders'and@id='link-my-orders']")).click();
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	Random random = new Random();
	int ranInt = random.nextInt(4000);

	File dest = new File("./screenshots/screenshots"+ranInt+".png");
	try
	{
	FileUtils.copyFile(src, dest);
	}
	catch(Exception e)
	{
		
	}

	a.assertAll();

}
}
