package javaCasting;

public class InternetExp extends RemoteWebDriver{
	
	@Override
	public void findElement() {
		System.out.println("InternetExp find element impl");
		
	}

	@Override
	public void findElements() {
		System.out.println("InternetExp find elementss impl");		
	}

	@Override
	public void get() {
		System.out.println("InternetExp get impl");		
	}

	@Override
	public void close() {
		System.out.println("InternetExp close impl");		
	}


	public void internetSlow() {
		System.out.println("i'm bit slow");
	}

}
