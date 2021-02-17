package javaCasting;

public class Demo {

	static WebDriver d;

	public static void main(String[] args) {

		char b = 'f';
		if (b == 'f') {
			d = new FireFoks();
		} else {
			d = new InternetExp();
		}

		d.findElement();
		d.close();
		d.get();
		
		WebDriver d2 = new InternetExp();
				
		((JavaScriptExe)d).execute();

//		if (d instanceof InternetExp) {
//			((InternetExp) d).internetSlow();
//		}else {
//			((FireFoks) d).security();
//		}
	}

}
