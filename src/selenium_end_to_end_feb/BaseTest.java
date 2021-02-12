package selenium_end_to_end_feb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	private WebDriver driver;
	String browser = "c";

	@BeforeTest
	public void setUp() {
//		ChromeOptions chromeOptions = new ChromeOptions();
////		WebDriverManager.chromedriver().arch64().setup();
//		WebDriverManager.chromedriver().setup();
////		WebDriverManager.firefoxdriver().setup();

		if (browser.equals("c")) {
			driver = new ChromeDriver();
		} else if (browser.equals("f")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void loginToOrange() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void click(By by) {
		getDriver().findElement(by).click();
	}
	
	public String getTextFromElement(By by) {
		return getDriver().findElement(by).getText().trim();
	}
	
	public String getAlertText() {
		return getDriver().switchTo().alert().getText();
	}
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
}
