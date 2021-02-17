package javaCasting;

public class RemoteWebDriver implements WebDriver, JavaScriptExe{

	@Override
	public void findElement() {
		System.out.println("remote webdriver find element impl");
		
	}

	@Override
	public void findElements() {
		System.out.println("remote webdriver find elementss impl");		
	}

	@Override
	public void get() {
		System.out.println("remote webdriver get impl");		
	}

	@Override
	public void close() {
		System.out.println("remote webdriver close impl");		
	}

	@Override
	public void execute() {
		System.out.println("RemoteWebDriver execute impl");
		
	}
}
