package selenium_end_to_end_feb;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WindowHandlingTests extends BaseTest{
	
	@Test
	public void testWindowHandles() {
		String dummy = getDriver().getWindowHandle();
		System.out.println(dummy);
		getDriver().switchTo().window(dummy);
		
//		getDriver().get("http://the-internet.herokuapp.com/");
//		getDriver().findElement(By.xpath("//a[text()='Multiple Windows']")).click();
//		
//		
//		String parentWindowID = getDriver().getWindowHandle();
//		getDriver().findElement(By.xpath("//a[text()='Click Here']")).click();
//		Set<String> windowIds = getDriver().getWindowHandles();	
//		System.out.println(windowIds.size());
//		System.out.println(windowIds);
//		Iterator<String> itr = windowIds.iterator();	
//		System.out.println(itr.next().equals(parentWindowID));
//		String childWindowId = itr.next();
//		getDriver().switchTo().window(childWindowId);	
//		System.out.println(getDriver().findElement(By.xpath("//h3[text()='New Window']")).isDisplayed());	
	}

}

