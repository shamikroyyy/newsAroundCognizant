package pageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage extends BasePage {
	public NewsPage(WebDriver driver)
	{
		super(driver);
	}
	
	By news_title=By.cssSelector("div#title_text");
	By news_text=By.cssSelector("div.q_e_50a7110f");
	By associate_text=By.xpath("//div[@class='jb_x_9f38462c']");
	By associate_popup=By.xpath("//div[@role='presentation']//h1");
	By share_option=By.name("Share");
	By share_list=By.xpath("//span[contains(@class,'ms-ContextualMenu-itemText')]");
	By scrollable_element=By.cssSelector("div.f_a_ada2ac09");
	By likes_num=By.xpath("//span[contains(text(),'liked this')]");
	By views_num=By.xpath("//aside//span[contains(text(),'Views')]");
	By links=By.xpath("//div[contains(@class,'a_b_50')]//a");
	
	
	public String newsReturn()
	{
		super.waiting(news_title);
		return driver.findElement(news_text).getText();
	}
	
	public String associateTextReturn() throws InterruptedException
	{
		super.waiting(associate_text);
		return driver.findElement(associate_text).getText();
	}
	
	public void hovering() throws InterruptedException
	{
		super.hovering(associate_text);

	}
	public String associatePopReturn() throws InterruptedException
	{
		super.waiting(associate_popup);
		return driver.findElement(associate_popup).getText();
	}
	
	public boolean shareDisplaying() throws InterruptedException
	{
		super.waiting(share_option);
		return driver.findElement(share_option).isDisplayed();
	}
	public void shareClicking() throws InterruptedException
	{
		driver.findElement(share_option).click();
		Thread.sleep(4000);
	}
	public List<WebElement> shareList() throws InterruptedException
	{
		return driver.findElements(share_list);
	}
	public String shareOptions(int i) throws InterruptedException
	{
		return shareList().get(i).getText();
	}
	public void scrolling() throws InterruptedException
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(4000);		
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(scrollable_element));
		Thread.sleep(4000);
	}
	public String numOfLike()
	{
		String str=driver.findElement(likes_num).getText();
		String[]arr_like=str.split(" ");
		return arr_like[0];
	}
	public String numOfViews()
	{
		String str=driver.findElement(views_num).getText();
		String[]arr_like=str.split(" ");
		return arr_like[0];
	}
	public boolean linkStatusReturn() throws IOException
	{
		super.waiting(links);
		URL url=new URL(driver.findElement(links).getAttribute("href"));
		URLConnection connection=url.openConnection();
		HttpURLConnection httpConnection=(HttpURLConnection)connection;
		httpConnection.connect();
		if(httpConnection.getResponseCode()>=400)
			return false;
		else
			return true;
	}
}
