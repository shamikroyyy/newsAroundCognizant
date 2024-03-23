package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.NewsPage;
import testBases.BaseClass;

public class TC_06_LikesAndViews extends BaseClass{
  @Test
  public void gettingLikesAndViews() throws InterruptedException {
	  System.out.println("Starting Test 6");
	  for(int i=1;i<=5;i++)
	  {
		  HomePage hp=new HomePage(driver,i);
		  NewsPage np=new NewsPage(driver);
		  try
		  {
			  Thread.sleep(2000);
			  hp.newsClick();
			  np.scrolling();
			  System.out.println("No of likes in news "+i+" :-- "+np.numOfLike()); 
			  System.out.println("No of views in news "+i+" :-- "+np.numOfViews()); 
		  }
		  catch(Exception e)
		  {
			  System.out.println("There are some issues in internet or site");
		  }
		  hp.navigatingBack();
	  }
	  System.out.println("Test 6 Ends");

  	}
}
