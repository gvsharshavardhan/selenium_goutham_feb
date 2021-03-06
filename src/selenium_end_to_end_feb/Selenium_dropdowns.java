package selenium_end_to_end_feb;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selenium_dropdowns extends BaseTest {

	@Test
	public void testDropDowns() {
		loginToOrange();
		getDriver().navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList/reset/1");
//		WebElement continentDropDown = getDriver().findElement(By.cssSelector("select[name='continents']"));
		WebElement JobTitle = getDriver().findElement(By.cssSelector("#empsearch_job_title"));
		Select s = new Select(JobTitle);
		List<WebElement> optionsElements = s.getOptions();
		List<String> optionsText = new ArrayList<String>();
		for (WebElement o : optionsElements) {
			optionsText.add(o.getText());
		}
		Random rand = new Random();
		int a = rand.nextInt(optionsText.size());
		System.out.println(optionsText.get(a));
		s.selectByVisibleText(optionsText.get(a));
		System.out.println("selected option: " + s.getFirstSelectedOption().getText());
		sleep(10);

		WebElement termination = getDriver().findElement(By.id("empsearch_termination"));
		Select s2 = new Select(termination);
		s2.selectByValue("2");
		sleep(10);
		System.out.println("selected option: " + s2.getFirstSelectedOption().getText());

	}

	@Test
	public void testMultipleDropDown() {
		getDriver().get("http://omayo.blogspot.com/");
		String co = getDriver().findElement(By.className("dropbtn")).getCssValue("background-color");
		System.out.println(co);
		
//		WebElement multipleSelectBox = getDriver().findElement(By.cssSelector("#multiselect1"));
//		Select se = new Select(multipleSelectBox);
//		List<String> multipleboxText = se.getOptions().stream().map((e) -> e.getText().trim())
//				.collect(Collectors.toList());
//		System.out.println(multipleboxText);
//
//		for (String s : multipleboxText) {
//			if (s.contains("Swift") || s.contains("Audi")) {
//				System.out.println(s);
//				se.selectByVisibleText(s);
//			}
//		}
//		System.out.println(se.getAllSelectedOptions().stream().map((e) -> e.getText()).collect(Collectors.toList()));
	}

	@Test
	public void testAutoSuggestiveDropDown() {

		String countryNeeded = "india";
		getDriver().get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement inputField = getDriver().findElement(By.cssSelector("input#autosuggest"));
		System.out.println(inputField.getCssValue("color"));
		inputField.sendKeys("ind");
		sleep(2);
		List<WebElement> countryElements = getDriver().findElements(By.xpath("//ul[contains(@id,'ui-id-1')]//a"));
		for (WebElement country : countryElements) {
			if (country.getText().trim().equalsIgnoreCase(countryNeeded)) {
				country.click();
				break;
			}
		}
		sleep(5);
//		assertTrue(inputField.getAttribute("value").equalsIgnoreCase("usa"),
//				"after selecting from drop down, country name is not as expected!!");
		assertEquals(inputField.getAttribute("value"), "usa",
				"after selecting from drop down, country name is not as expected!!");
	}

}
