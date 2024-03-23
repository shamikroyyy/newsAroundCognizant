package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.NewsPage;
import testBases.BaseClass;

public class TC_04_AssociateNameValidation extends BaseClass{
  @Test
  public void validatingAssociateName() throws InterruptedException {
	  System.out.println("Starting Test 4");
	  for(int i=1;i<=5;i++)
	  {
		  HomePage hp=new HomePage(driver,i);
		  NewsPage np=new NewsPage(driver);
		  try {
			  hp.newsClick();
			  String associate_name=np.associateTextReturn();
			  np.hovering();
			  String associate_pop=np.associatePopReturn();
			  Assert.assertEquals(associate_name, associate_pop);
			  System.out.println("The associate name "+associate_name+" is validated");
		  }
		  catch(Exception e)
		  {
			  if(i<=4)
				  System.out.println("Can't got the pop up due to some issue");
			  else
				  System.out.println("No associate's name found");
		  }
		  hp.navigatingBack();
	  }
	  System.out.println("Test 4 Ends");

  }
}
