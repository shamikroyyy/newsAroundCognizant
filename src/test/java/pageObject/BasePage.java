package pageObject;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {
	public WebDriver driver;
	public int i;
	public FluentWait<WebDriver> wait;

	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public BasePage(WebDriver driver,int i)
	{
		this.driver=driver;
		this.i=i;
	}
	
	public void hovering(By locator)
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(locator)).perform();
	}
	public void waiting(By locator)
	{
		wait = new FluentWait<WebDriver> (driver);
		wait.withTimeout(Duration.ofSeconds(25));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public void navigatingBack() throws InterruptedException
	{
		new BasePage(driver).waiting(new NewsPage(driver).news_title);		
		driver.navigate().back();
		new BasePage(driver).waiting(new HomePage(driver,i).news_img);
	}
	
}
