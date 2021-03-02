package selenium_end_to_end_feb;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenLinks extends BaseTest {

	@Test
	public void testBrokenLinks() {
		getDriver().get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = getDriver().findElements(By.tagName("a"));
		for (WebElement ele : links) {
			String url = ele.getAttribute("href");
			if (url != null && !url.isEmpty() && url!="#") {
				try {
					URL u = new URL(url);
					HttpURLConnection hcu = ((HttpURLConnection) u.openConnection());
					hcu.setRequestMethod("HEAD");
					hcu.connect();
					int res = hcu.getResponseCode();
					System.out.println(res+" : "+url);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testBrokenImages() {
		getDriver().get("file:///C:/Users/Harsha/Pictures/selenium/demopage.html");
		sleep(10);
		List<WebElement> imges = getDriver().findElements(By.tagName("img"));
		for(WebElement we : imges) {
		JavascriptExecutor hse = ((JavascriptExecutor)getDriver());
		boolean flag = (boolean)hse.executeScript("return (typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0);", we);
		System.out.println(flag);
		}
	}
}
