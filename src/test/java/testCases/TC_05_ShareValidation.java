package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.NewsPage;
import testBases.BaseClass;

public class TC_05_ShareValidation extends BaseClass{
  @Test
  public void validatingShare() throws InterruptedException {
	  System.out.println("Starting Test 5");
	  for(int i=1;i<=5;i++)
	  {
		  HomePage hp=new HomePage(driver,i);
		  NewsPage np=new NewsPage(driver);
		  try
		  {
			  hp.newsClick();
			  Assert.assertEquals(np.shareDisplaying(), true);
			  System.out.println("Share option of news "+i+" is valid");
			  np.shareClicking();
			  System.out.println("Options are:--");
			  for(int j=0;j<np.shareList().size();j++)
			  {
				  System.out.println(np.shareOptions(j));
			  }
		  }
		  catch(Exception e)
		  {
			  System.out.println("There are some issues in the internet or site");
		  }
		  hp.navigatingBack();
	  }
	  System.out.println("Test 5 Ends");

  }
}
