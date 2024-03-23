package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.HomePage;
import testBases.BaseClass;

public class TC_01_UserInfoCapture extends BaseClass {


  @Test
  public void validatingInfo() throws InterruptedException, IOException {
	  System.out.println("Starting Test 1");
	  HomePage hp=new HomePage(driver,1);
	  try {
		  hp.infoCheck();
		  System.out.println("User information is captured");
	  }
	  catch(Exception e)
	  {
		  System.out.println("Can't find any user info due to internet or site issue");
	  }
	  screenshotMethod(1);
	  System.out.println("Test 1 Ends");
  }
}
