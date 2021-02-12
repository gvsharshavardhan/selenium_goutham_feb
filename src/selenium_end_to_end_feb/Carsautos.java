package selenium_end_to_end_feb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class Carsautos extends BaseTest{
	
	@Test
	public void testCarsAuto() {
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getDriver().get("https://www.autoscout24.de/");
		getDriver().manage().addCookie(new Cookie("toguru", "ugact-298-as24-home-reverse-proxy=false"));
		getDriver().manage().addCookie(new Cookie("disable-cmp", "true"));
		getDriver().navigate().refresh();
		click(By.xpath("(//input[@data-role='user-query' and @class='react-autocomplete__input  '])[1]"));
		click(By.xpath("//span[contains(text(),'Audi')]/.."));
		click(By.cssSelector("[data-test='search']"));
		sleep(5);
		click(By.cssSelector("[data-test='tag-make-model-0']  .sc-tag__close"));
		sleep(5);
		click(By.cssSelector("[data-test='tag-make-47']"));
		click(By.cssSelector("[data-test='resetAllFilterLink']"));
	}

}
