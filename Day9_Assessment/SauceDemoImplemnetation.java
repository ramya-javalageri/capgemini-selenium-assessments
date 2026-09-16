package SauceDemoKeywordFrameworkImplementation;

import SauceDemoKeyword.KeywordExecutor;

public class keywords {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		KeywordExecutor e = new KeywordExecutor();
		
		e.executor("LAUNCH_BROWSER");
		Thread.sleep(2000);
		e.executor("OPEN_URL");
		Thread.sleep(2000);
		e.executor("USERNAME_TF");
		Thread.sleep(2000);
		e.executor("PASSWORD_TF");
		Thread.sleep(2000);
		e.executor("LOGIN_BUTTON");
		Thread.sleep(2000);
		e.executor("CLOSE_BROWSER");
	}

}
