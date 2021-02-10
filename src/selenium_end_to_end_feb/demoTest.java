package selenium_end_to_end_feb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoTest {

	public static void main(String[] args) {
//		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/selenium-webdriver/webdrivermanager/");
	}

}
