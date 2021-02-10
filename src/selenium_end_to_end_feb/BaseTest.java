package selenium_end_to_end_feb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

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
}
