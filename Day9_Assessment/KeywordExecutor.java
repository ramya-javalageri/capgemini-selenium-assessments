package SauceDemoKeyword;

public class KeywordExecutor {
	KeywordImplementation k = new KeywordImplementation();
	public void executor(String value)
	{
		if(value.equals("LAUNCH_BROWSER"))
			k.launchBrowser();
		else if(value.equals("OPEN_URL"))
			k.openUrl();
		else if(value.equals("USERNAME_TF"))
			k.usernameTf();
		else if(value.equals("PASSWORD_TF"))
			k.pwdTf();
		else if(value.equals("LOGIN_BUTTON"))
			k.loginButton();
		else if(value.equals("CLOSE_BROWSER"))
			k.closeBrowser();
	}
}
