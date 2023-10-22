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

public class AutoSugg {
	@Test
public void autoSuggests() throws InterruptedException
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
		driver.findElement(By.xpath("//input[@placeholder='Search for Products..']")).sendKeys("lava");
		Thread.sleep(3000);
		List<WebElement> autosug = driver.findElements(By.xpath("//ul[@id='uiv2-autosearch-list']/descendant::a[@class='uiv2-img-product-name']/span"));
		int count=autosug.size();
		System.out.println(count);
		
		for(WebElement as:autosug)
		{
			String sugg = as.getText();
			System.out.println(sugg);
		}
		 WebElement secondautosug = driver.findElement(By.xpath("(//ul[@id='uiv2-autosearch-list']/descendant::a[@class='uiv2-img-product-name']/span)[2]"));
secondautosug.click();


TakesScreenshot ts=(TakesScreenshot)driver;
File src = ts.getScreenshotAs(OutputType.FILE);
Random random = new Random();
int ranInt = random.nextInt(4000);

File dest = new File("./screenshots/screenshotsautosugg"+ranInt+".png");
try
{
FileUtils.copyFile(src, dest);
}
catch(Exception e)
{
	
}




}
}
