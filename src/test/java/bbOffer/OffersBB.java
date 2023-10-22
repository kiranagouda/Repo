package bbOffer;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OffersBB {

 
@Test
public void offersBblist() throws InterruptedException, IOException
{
	WebDriverManager.chromedriver().setup();
	WebDriver	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bigbasket.com/");
	
	driver.findElement(By.xpath("//img[@src='http://www.bigbasket.com/media/uploads/banner_images/hp_cmc_m_offer_28_220921_all.png']")).click();
	List<WebElement> items=driver.findElements(By.xpath("//h2[text()='Best Sellers']/ancestor::section[@class='row custom-component carousel-section ng-scope']/descendant::div[@class='col-sm-12 col-xs-7 prod-name']/a"));
int count=items.size();
System.out.println(count+"items are present in banner1");


for(int j=0;j<count;j++)
{
	String title=items.get(j).getText();
	System.out.println(title);
	if((j+1)%5==0 && j<count-1)
	{
		driver.findElement(By.xpath("(//div[@class='owl-stage-outer'])[1]/following-sibling::div[@class='owl-nav']/child::div[@class='owl-next']")).click();	
		Thread.sleep(1000);

	}
		
	}

	

	
	List<WebElement> items2=driver.findElements(By.xpath("//h2[text()='Har Din Sasta Min 6%']/ancestor::section[@class='row custom-component carousel-section ng-scope']/descendant::div[@class='col-sm-12 col-xs-7 prod-name']/a"));
	int count2=items2.size();
	System.out.println(count2+"items are present in banner2");
	JavascriptExecutor je=(JavascriptExecutor)driver;
	je.executeScript("window.scrollBy(0,130)");
	Thread.sleep(1000);
	for(int j=0;j<count2;j++)
	{
		String title2=items2.get(j).getText();
		System.out.println(title2);
		if((j+1)%5==0 && j<count2-1)
		{
			driver.findElement(By.xpath("(//div[@class='owl-stage-outer'])[2]/following-sibling::div[@class='owl-nav']/child::div[@class='owl-next']")).click();	
			Thread.sleep(1000);

		}
			
		}
	
	je.executeScript("window.scrollTo(0,0)");
	Thread.sleep(1000);
	List<WebElement> allitems = driver.findElements(By.xpath("//section[@class='row custom-component carousel-section ng-scope']/descendant::div[@class='col-sm-12 col-xs-7 prod-name']/a"));
int allcount=allitems.size();
System.out.println(allcount);


//for(WebElement we:allitems)
//{
//	System.out.println(we.getText());
//}
for(int j=0;j<count;j++)
{
	String title3=allitems.get(j).getText();
	System.out.println(title3);	
	if((j+1)%5==0 && j<count-1)
	{
		driver.findElement(By.xpath("(//div[@class='owl-stage-outer'])[1]/following-sibling::div[@class='owl-nav']/child::div[@class='owl-next']")).click();
		Thread.sleep(1000);

	}
	
	}
je.executeScript("window.scrollBy(0,130)");
Thread.sleep(1000);

for(int j=count+1;j<count2;j++)
{
	String title4=allitems.get(j).getText();
	System.out.println(title4);	
	if((j+1)%5==0 && j<count2-1)
	{
		driver.findElement(By.xpath("(//div[@class='owl-stage-outer'])[2]/following-sibling::div[@class='owl-nav']/child::div[@class='owl-next']")).click();
		Thread.sleep(1000);

	}
	
	}

je.executeScript("window.scrollBy(0,130)");
Thread.sleep(1000);

for(int j=count2+1;j<allcount;j++)
{
	String title5=allitems.get(j).getText();
	System.out.println(title5);	
	if((j+1)%5==0 && j<allcount-1)
	{
		driver.findElement(By.xpath("(//div[@class='owl-stage-outer'])[3]/following-sibling::div[@class='owl-nav']/child::div[@class='owl-next']")).click();
		Thread.sleep(1000);

	}
	
	}


String titlename = driver.getTitle();
	System.out.println(titlename);
	
	WebElement secondelement = driver.findElement(By.xpath("(//section[@class='row custom-component carousel-section ng-scope']/descendant::div[@class='col-sm-12 col-xs-7 prod-name']/a)[2]"));
	File src = secondelement.getScreenshotAs(OutputType.FILE);
	Random random = new Random();
	int ranInt = random.nextInt(4000);

	File dest = new File("./screenshots/screenshot"+ranInt+".png");
	try
	{
	FileUtils.copyFile(src, dest);
	}
	catch(Exception e)
	{
		
	}
	
driver.close();	
}
}
