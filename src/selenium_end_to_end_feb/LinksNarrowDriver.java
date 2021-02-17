package selenium_end_to_end_feb;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LinksNarrowDriver extends BaseTest {

	@Test
	public void getLinksCount() {
		goTo("https://rahulshettyacademy.com/AutomationPractice/");
		String parentWindowId = getDriver().getWindowHandle();
		System.out.println(getDriver().findElements(By.tagName("a")).size());
		WebElement footer = getDriver().findElement(By.xpath("//div[@id='gf-BIG']"));
		List<WebElement> coupons = footer.findElements(By.xpath("//table//td[1]//a"));
		Actions acct = new Actions(getDriver());
		for (int i = 1; i < coupons.size(); i++) {
			acct.keyDown(Keys.CONTROL).click(coupons.get(i)).keyUp(Keys.CONTROL).build().perform();
		}
		Set<String> WindowIds = getDriver().getWindowHandles();
		for(String id : WindowIds ) {
			if(!id.equals(parentWindowId)){
				getDriver().switchTo().window(id);
				System.out.println(getDriver().getTitle());
			}
		}	
	}
}
