package selenium_end_to_end_feb;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Selenium_alerts extends BaseTest{
	
	@Test
	public void testAlarts() {
		getDriver().get("https://demoqa.com/alerts");		
		click(By.xpath("//*[@id='alertButton']"));
		sleep(2);
		System.out.println(getDriver().switchTo().alert().getText());
		getDriver().switchTo().alert().accept();
		sleep(2);
	}
}
