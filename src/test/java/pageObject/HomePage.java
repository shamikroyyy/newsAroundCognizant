package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver,int i)
	{
		super(driver,i);
	}

	By info_btn=By.id("O365_HeaderRightRegion");
	By news_img=By.xpath("//div[@role='listitem']["+i+"]//a[@id='news_text_title']");
	By info_img=By.cssSelector("div#mectrl_main_body");
	By searchbox_input=By.xpath("//input[@placeholder='Search across sites']");
	
	
	public void infoCheck() throws InterruptedException
	{
		super.waiting(searchbox_input);
		driver.findElement(info_btn).click();
		super.waiting(info_img);
	}
	
	public void newsClick() throws InterruptedException
	{
		driver.findElement(news_img).click();
	}
	
	public void hovering() throws InterruptedException
	{
		super.waiting(news_img);
		super.hovering(news_img);
		Thread.sleep(1000);
	}
	
	public String toolTipReturn()
	{
		return driver.findElement(news_img).getAttribute("title");
	}
	
	public String titleReturn()
	{
		super.waiting(news_img);
		return driver.findElement(news_img).getText();
	}
	
}
