package Final_Assessment2;

import org.testng.annotations.Test;

import FinalAssessment2.BaseClass;

public class TestCase1Implementation extends BaseClass {	
	@Test
	public void testCase1Test() throws InterruptedException
	{
		homePage.clickBuzz();
		Thread.sleep(1000);
		buzzPage.getTf(info);
		Thread.sleep(1000);
		buzzPage.getPostButton();
		Thread.sleep(1000);
		buzzPage.verify(info);
		Thread.sleep(2000);
	}

}
