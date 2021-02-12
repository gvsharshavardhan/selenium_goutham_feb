package selenium_end_to_end_feb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Waits extends BaseTest {

	@Test
	public void pageLoadTimeOutTest() {
//		getDriver().manage().timeouts().pageLoadTimeout(2,);
		getDriver().get("https://demoqa.com/alerts");
		click(By.cssSelector("#timerAlertButton"));
		System.out.println(getDriver().switchTo().alert().getText());
//		assertEquals(getTextFromElement(By.cssSelector("#finish h4")),
//				"Hello World!","text is not as expected!!");  

	}

	@Test
	public void pageExplicitTimeOut() {
		getDriver().get("http://the-internet.herokuapp.com/dynamic_loading");
		click(By.partialLinkText("Example 1:"));
		click(By.cssSelector("div#start button"));
		WebElement helloText = getDriver().findElement(By.cssSelector("#finish h4"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(helloText));
		System.out.println(helloText.getText());
	}

	@Test
	public void pageExplicitTimeOutToolsQA() {
		getDriver().get("https://demoqa.com/alerts");
//		click(By.partialLinkText("Example 1:"));
		click(By.cssSelector("#timerAlertButton"));
//		WebElement helloText = getDriver().findElement(By.cssSelector("#finish h4"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 2);
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(getAlertText());
	}

	@Test
	public void pageFluentTimeOutToolsQA() {
		getDriver().get("http://the-internet.herokuapp.com/dynamic_loading");
		click(By.partialLinkText("Example 1:"));
		click(By.cssSelector("div#start button"));
//		click(By.partialLinkText("Example 1:"));
//		click(By.cssSelector("#timerAlertButton"));
//		WebElement helloText = getDriver().findElement(By.cssSelector("#finish h4"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver());
				((FluentWait<WebDriver>) wait).withTimeout(5, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

//			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//			     public WebElement apply(WebDriver driver) {
//			    	 System.out.println("say hi");
//			       return driver.findElement(By.cssSelector("#finish h4"));
//			     }
//			   });
		WebElement helloText = getDriver().findElement(By.cssSelector("#finish h4"));
		wait.until(ExpectedConditions.visibilityOf(helloText));
	}
}
