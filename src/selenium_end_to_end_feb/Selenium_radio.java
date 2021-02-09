package selenium_end_to_end_feb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Selenium_radio extends BaseTest{
	

	@Test
	public void testRadioButtons() {
		String radiotext = "Round Trip";
		List<WebElement> radioButtons = new ArrayList<WebElement>();	
		getDriver().get("https://rahulshettyacademy.com/dropdownsPractise/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		radioButtons = getDriver().findElements(By.xpath("//table[@class='tblTrip']//input"));
		for(WebElement button : radioButtons) {
			if(button.isSelected()) {
				System.out.println(button.getAttribute("value"));
			}
		}
		
		getDriver().findElement(By.xpath("//label[text()='"+radiotext+"']/preceding-sibling::input")).click();
		for(WebElement button : radioButtons) {
			if(button.isSelected()) {
				System.out.println(button.getAttribute("value"));
			}
		}
		
	}

}
