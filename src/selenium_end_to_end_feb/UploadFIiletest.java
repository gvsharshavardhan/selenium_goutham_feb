package selenium_end_to_end_feb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadFIiletest extends BaseTest{
	
	@Test
	public void upoloadfiletest() {
		goTo("http://omayo.blogspot.com/");
		WebElement upload = getDriver().findElement(By.cssSelector("#uploadfile"));
		scrollintoviewJScript(upload);
		upload.sendKeys("C:\\Users\\Harsha\\Pictures\\selenium\\selenium_logo.jpg");
		sleep(5);
	}
}
