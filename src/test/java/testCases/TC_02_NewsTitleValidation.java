package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import testBases.BaseClass;

public class TC_02_NewsTitleValidation extends BaseClass{
  @Test
  public void validatingTitle() throws InterruptedException {
	  System.out.println("Starting Test 2");
	  for(int i=1;i<=5;i++)
	  {
		  
		  try {
			  HomePage hp=new HomePage(driver,i);
			  hp.hovering();
			  String toolTip=hp.toolTipReturn();
			  String title=hp.titleReturn();
			  Assert.assertEquals(toolTip,title);
			  System.out.println("Title of news "+i+" :- "+title+" is matching");
		  }
		  catch(Exception e)
		  {
			  System.out.println("There are some issues in internet or the site");
		  }
	  }
	  System.out.println("Test 2 Ends");
  }
}

