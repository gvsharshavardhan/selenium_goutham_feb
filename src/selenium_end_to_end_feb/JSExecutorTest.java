package selenium_end_to_end_feb;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorTest extends BaseTest {

	@Test
	public void scrollTest() {
		getDriver().get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		scrollintoviewJScript(getDriver().findElement(By.xpath("//a[contains(.,'virtualauthenticator')]")));
		sleep(5);
	}

	@Test
	public void elementHighlight() {
		getDriver().get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		WebElement e1 = getDriver().findElement(By.xpath("//a[contains(.,'org.openqa.selenium.concurrent')]"));
		int i = 0;
		while (i < 10) {
			((JavascriptExecutor) getDriver()).executeScript(
					"arguments[0].setAttribute('style', 'background: red; border: 5px solid black')", e1);
			sleep(1);
			((JavascriptExecutor) getDriver()).executeScript(
					"arguments[0].setAttribute('style', 'background: white; border: 5px solid black')", e1);
			sleep(1);
			i++;
		}
	}

	@Test
	public void jsscriptAlertTest() {
		String message = "hello Goutham!!";
		getDriver().get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		((JavascriptExecutor) getDriver()).executeScript("alert('" + message + "')");
		assertEquals(message,getDriver().switchTo().alert().getText(),"alert text is not as expected!!");
		sleep(2);
		getDriver().switchTo().alert().accept();
	}
	
	@Test
	public void scrollInsideAnElement() {
		getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");
		scrollintoviewJScript(getDriver().findElement(By.cssSelector(".tableFixHead")));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollTop = 500",
				getDriver().findElement(By.cssSelector(".tableFixHead")));
		sleep(2);
	}
	
	@Test
	public void getUrlUsingJs() {
		getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");
		String url = ((JavascriptExecutor) getDriver()).executeScript("return document.URL").toString();
		System.out.println(url);
	}
}
