package testBases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	public static WebDriver driver;
	public Properties property;
	@BeforeTest
	public void setup() throws IOException
	{
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		property = new Properties();
		property.load(file);
		driver=new ChromeDriver();
		driver.get(property.getProperty("baseUrl"));
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	public void screenshotMethod(int i) throws IOException
	{
		TakesScreenshot shot1=(TakesScreenshot)driver;
		File src=shot1.getScreenshotAs(OutputType.FILE);
		File trg=new File(System.getProperty("user.dir")+".\\screenshots\\shot"+i+".png");
		FileUtils.copyFile(src, trg);
	}
	
}
