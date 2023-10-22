package bbOffer;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShowMore {
	@Test
public void searchShowMore() throws InterruptedException
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
	//driver.findElement(By.className("AddressCard___StyledDiv-sc-1udrslf-0 cSQMNB")).click();
	driver.findElement(By.xpath("//button[@class='MemberDropdown___StyledMenuButton-sc-ce95dd-1 ezacJo']")).click();
	
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Customer Service']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Search for Products..']")).sendKeys("lava");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='VIEW ALL PRODUCTS']")).click();
	List<WebElement> moreitems = driver.findElements(By.xpath("//div[@class='break-words h-10 w-full']"));
	int allcount=moreitems.size();
	System.out.println(allcount+"----totalitems");
	for(WebElement m:moreitems)
	{
		String title = m.getText();
		System.out.println(title);
	}
	
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	Random random = new Random();
	int ranInt = random.nextInt(4000);

	File dest = new File("./screenshots/screenshotshowmore"+ranInt+".png");
	try
	{
	FileUtils.copyFile(src, dest);
	}
	catch(Exception e)
	{
		
	}

	
}
}
