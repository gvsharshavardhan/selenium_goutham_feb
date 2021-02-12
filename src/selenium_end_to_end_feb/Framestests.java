package selenium_end_to_end_feb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Framestests extends BaseTest{
	
	@Test
	public void testJqueryFrames() {
		goTo("https://jqueryui.com/droppable/");		
		WebElement fframe = getDriver().findElement(By.xpath("//iframe"));		
		getDriver().switchTo().frame(0);		
		System.out.println(getTextFromElement(By.xpath("//div[@id='draggable']//p")));
		getDriver().switchTo().defaultContent();
		click(By.linkText("Sortable"));
	}

}
