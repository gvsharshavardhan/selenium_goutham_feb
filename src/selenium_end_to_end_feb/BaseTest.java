package selenium_end_to_end_feb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() {
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
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
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");;
		driver.findElement(By.name("Submit")).click();
	}
	
	public void sleep(int seconds) {
		
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
