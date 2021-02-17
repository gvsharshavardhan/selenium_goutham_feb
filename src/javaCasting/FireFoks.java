package javaCasting;

public class FireFoks extends RemoteWebDriver{
	
	@Override
	public void findElement() {
		System.out.println("FireFoks find element impl");
		
	}

	@Override
	public void findElements() {
		System.out.println("FireFoks find elementss impl");		
	}

	@Override
	public void get() {
		System.out.println("FireFoksr get impl");		
	}

	@Override
	public void close() {
		System.out.println("FireFoks close impl");		
	}

	
	public void security() {
		System.out.println("i'm secure");
	}

}
