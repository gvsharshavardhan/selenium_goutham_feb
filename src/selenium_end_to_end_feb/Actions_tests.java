package selenium_end_to_end_feb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Actions_tests extends BaseTest{
	
	@Test
	public void testCaps() {
		goTo("https://www.google.com/");
		WebElement searchbox = getElementByCss("[name='q']");
		Actions act = new Actions(getDriver());
//		act.keyDown(searchbox, Keys.SHIFT);
//		act.sendKeys(searchbox, "apple mac book pro");
//		act.keyUp(searchbox, Keys.SHIFT);
//		Action a = act.build();
//		sleep(5);
//		a.perform();	
		act.keyDown(searchbox, Keys.SHIFT).sendKeys("hello world").keyUp(searchbox, Keys.SHIFT).perform();
		sleep(2);
	}
	
	@Test
	public void dragAndDrop() {
		goTo("https://jqueryui.com/droppable/");
		getDriver().switchTo().frame(0);
		WebElement drag = getElementByCss("div#draggable");
		WebElement drop = getElementByCss("div#droppable");
		Actions act = new Actions(getDriver());
		act.dragAndDrop(drag, drop).perform();
		sleep(3);
	}
	
	@Test
	public void HorizontalsliderTest() {
		goTo("https://rangeslider.js.org/");
		WebElement drag = getDriver()
				.findElement(By.xpath("//div[@id='js-rangeslider-0']/div[@class='rangeslider__handle']"));	
		System.out.println(getTextFromElement(By.id("js-output")));
		Actions act = new Actions(getDriver());
		act.dragAndDropBy(drag, -100, 0).perform();
		sleep(3);
		System.out.println(getTextFromElement(By.id("js-output")));
	}
	
	@Test
	public void verticalSliderTest() {
		goTo("https://get.foundation/sites/docs-v5/components/range_slider.html");
		WebElement drag = getDriver()
				.findElement(By.cssSelector(".medium-2.columns span.range-slider-handle"));	
		System.out.println(getTextFromElement(By.cssSelector("span#sliderOutput2")));
		Actions act = new Actions(getDriver());
		act.dragAndDropBy(drag, 0, 100).perform();
		sleep(3);
		System.out.println(getTextFromElement(By.cssSelector("span#sliderOutput2")));
	}
	
	@Test
	public void mouseHoverTest() {
		goTo("https://www.amazon.in/");	
		WebElement signinele = getDriver().findElement(By.cssSelector("div.nav-signin-tt.nav-flyout"));
		WebDriverWait w = new WebDriverWait(getDriver(),10);
		w.until(ExpectedConditions.invisibilityOf(signinele));
	
		WebElement acclist = getDriver()
				.findElement(By.cssSelector("[data-nav-ref='nav_ya_signin']"));	
		Actions act = new Actions(getDriver());
		act.moveToElement(acclist).perform();
		sleep(2);
		click(By.xpath("//span[text()='Your Wish List']/parent::a"));
		System.out.println(getDriver().getTitle());
	}
	
	@Test
	public void dbclickTest() {
		goTo("https://api.jquery.com/dblclick/");
		WebElement box = getDriver().findElement(By.cssSelector(".demo.code-demo"));
		scrollintoviewJSScript(box);	
		getDriver().switchTo().frame(0);
		WebElement box1 = getDriver().findElement(By.cssSelector("body > div"));
		sleep(2);
		Actions act = new Actions(getDriver());
		act.doubleClick(box1).perform();
		sleep(2);
	}

}
