package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.NewsPage;
import testBases.BaseClass;

public class TC_07_LinksValidation extends BaseClass {
  @Test
  public void validateLink() throws InterruptedException {
	  for(int i=1;i<=5;i++)
	  {
		  HomePage hp=new HomePage(driver,i);
		  NewsPage np=new NewsPage(driver);
		  try {
			  hp.newsClick();
			  Assert.assertEquals(np.linkStatusReturn(), true);
			  System.out.println("The first link of news "+i+" is valid");
		  }
		  catch(Exception e)
		  {
			  System.out.println("The first link of news "+i+" is invalid");
		  }
		  hp.navigatingBack();
	  }
  }
}
