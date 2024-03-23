package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.NewsPage;
import testBases.BaseClass;
import utilities.DocumentUtils;

public class TC_03_NewsPrinting extends BaseClass{
  @Test
  public void newsPrint() throws IOException, InterruptedException {
	  System.out.println("Starting Test 3");
	  for(int i=1;i<=5;i++)
	  {
		  HomePage hp=new HomePage(driver,i);
		  NewsPage np=new NewsPage(driver);
		  try {
		  hp.hovering();
		  hp.newsClick();
		  DocumentUtils du=new DocumentUtils(System.getProperty("user.dir")+".//screenshots//News"+i+".docx");
		  du.printingLine(np.newsReturn());
		  du.closingDocument();
		  System.out.println("The body of news "+i+" has been printed as a document");
		  }
		  catch(Exception e)
		  {
			  System.out.println("There are some issuess in internet or site");
		  }
		  hp.navigatingBack();

	  }
	  System.out.println("Test 3 Ends");
  }
}
