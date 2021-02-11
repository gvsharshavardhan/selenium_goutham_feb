package selenium_end_to_end_feb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo {
	private static WebDriver driver;
	
	public static void main(String[] args) {	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.cssSelector("#timerAlertButton")).click();
		System.out.println(driver.switchTo().alert().getText());
		
	}

}
