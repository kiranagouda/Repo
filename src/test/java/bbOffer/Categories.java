package bbOffer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Categories {
@Test
public void categoriesBB() throws InterruptedException
{

	WebDriverManager.chromedriver().setup();
	WebDriver	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bigbasket.com/");
	Thread.sleep(13000);
	driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bclm:']")).click();
	Thread.sleep(13000);
	WebElement bvrgs = driver.findElement(By.xpath("//div[@class='CategoryMenu___StyledMenuItems-sc-d3svbp-4 cAslOa']/descendant::a[text()='Beverages']"));
	Thread.sleep(3000);

RemoteWebDriver rw=(RemoteWebDriver) driver;
rw.executeScript("arguments[0].click()", bvrgs);
	Thread.sleep(60000);
	WebElement y = driver.findElement(By.xpath("//h2[text()='Beverages']"));
JavascriptExecutor js=(JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true)",y);

	//js.executeScript("window.scrollBy(0,"+y+")");
	

	driver.findElement(By.xpath("//div[@class='p-2.5 pt-0 flex flex-col bg-white border border-silverSurfer-200 shadow-3 rounded-2xs h-full']/button[text()='Show more +']")).click();
	List<WebElement> bevarages = driver.findElements(By.xpath("//a[@class='FilterByCategory___StyledLink3-sc-c0pkxv-4 bqthFs']"));
int countbvr = bevarages.size();
System.out.println(countbvr);
	for(WebElement bvr:bevarages)
{
	String bvritems=bvr.getText();
	System.out.println(bvritems);
}
	driver.findElement(By.xpath("//a[@class='FilterByCategory___StyledLink3-sc-c0pkxv-4 bqthFs' and text()='Coffee']")).click();
	Thread.sleep(30000);

	driver.findElement(By.xpath("//div[@class='p-2.5 pt-0 flex flex-col bg-white border border-silverSurfer-200 shadow-3 rounded-2xs h-full']/descendant::a[text()='Ground Coffee']")).click();
	Thread.sleep(30000);
	WebElement y2 = driver.findElement(By.xpath("//span[text()='Shop by Category']"));
	 js.executeScript("arguments[0].scrollIntoView(true)",y2);
		Thread.sleep(8000);

	driver.findElement(By.xpath("//h3[text()='Coffee - Powder, Speciality Blend Of Coffee & Chicory Powder']/ancestor::h3[@class='flex flex-col xl:gap-1 lg:gap-0.5']/descendant::span[text()='2x500 g - Multipack']/ancestor::div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP']/descendant::button[text()='Add']")).click();
	 
	
	String exactrate = driver.findElement(By.xpath("//h3[text()='Coffee - Powder, Speciality Blend Of Coffee & Chicory Powder']/ancestor::h3[@class='flex flex-col xl:gap-1 lg:gap-0.5']/descendant::span[text()='2x500 g - Multipack']/ancestor::div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP']/descendant::span[@class='Label-sc-15v1nk5-0 Pricing___StyledLabel-sc-pldi2d-1 gJxZPQ AypOi']")).getText();
	String mrp = driver.findElement(By.xpath("//h3[text()='Coffee - Powder, Speciality Blend Of Coffee & Chicory Powder']/ancestor::h3[@class='flex flex-col xl:gap-1 lg:gap-0.5']/descendant::span[text()='2x500 g - Multipack']/ancestor::div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP']/descendant::span[@class='Label-sc-15v1nk5-0 Pricing___StyledLabel2-sc-pldi2d-2 gJxZPQ hsCgvu']")).getText();


exactrate=exactrate.replace("₹","");
mrp=mrp.replace("₹","");
System.out.println(exactrate);
System.out.println(mrp);
int exctrate=Integer.parseInt(exactrate);
int mrprate=Integer.parseInt(mrp);
int diffrnce=mrprate-exctrate;
System.out.println(diffrnce);
boolean flag=false;
if(exctrate==mrprate)
{
flag=true;
}
Assert.assertFalse(flag);
System.out.println(diffrnce+"is the diffrnce btwn exact and mrprate");



}
}
