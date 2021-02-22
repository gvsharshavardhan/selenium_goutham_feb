package kartExample;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import selenium_end_to_end_feb.BaseTest;

public class KartTest extends BaseTest {

	public String VEGGIES_QUANTITY_XPATH = "//div[@class='product']//h4[contains(.,'$veg$')]"
			+ "/following-sibling::div/input";
	public String VEGGIES_PRICE_XPATH = "//div[@class='product']//h4[contains(.,'$veg$')]" + "/following-sibling::p";
	public String VEGGIES_INCREMENT_BUTTON_XPATH = "//div[@class='product']//h4[contains(.,'$veg$')]"
			+ "/following-sibling::div/a[@class='increment']";
	public String VEGGIES_ADD_TO_CART_BUTTON_XPATH = "//div[@class='product']//h4[contains(.,'$veg$')]"
			+ "/following-sibling::div/button";
	public String CART_ICON_BUTTON_CSS_SELECTOR = "a.cart-icon";
	public String PROCEED_TO_CHECKOUT_BUTTON_XPATH = "//button[.='PROCEED TO CHECKOUT']";
	public String PROMO_CODE_INPUT_XPATH = "//*[@class='promoCode']";
	public String PROMO_CODE_APPLY_BUTTON_CSS = ".promoBtn";
	public String PROMO_CODE_MESSAGE_CSS = ".promoInfo";
	public String PLACE_ORDER_BUTTON_XPATH = "//button[.='Place Order']";
	public String CHOOSE_COUNTRY_LABEL = "//label";
	Map<String, Integer> veggies_price = new HashMap<String, Integer>();

	@Test
	public void testKart() {
		goTo("https://rahulshettyacademy.com/seleniumPractise/#/");
		Map<String, Integer> veggies = getVeggies();
		Set<Entry<String, Integer>> entr = veggies.entrySet();
		for (Entry<String, Integer> e : entr) {
			String veg = e.getKey();
			int quantity = e.getValue();
			veggies_price.put(veg, getPriceOfVeggie(veg));
			selectQuantity(veg, quantity);
			addToKart(veg);
		}
		sleep(2);
		System.out.println(veggies_price);
		click(By.cssSelector(CART_ICON_BUTTON_CSS_SELECTOR));
		click(By.xpath(PROCEED_TO_CHECKOUT_BUTTON_XPATH));
		System.out.println(getDriver().getTitle());
		enterPromoCode(getPromoCode());
		click(By.cssSelector(PROMO_CODE_APPLY_BUTTON_CSS));
		waitUntillElementDisplayed(By.cssSelector(PROMO_CODE_MESSAGE_CSS));
		System.out.println(getDriver().findElement(By.cssSelector(PROMO_CODE_MESSAGE_CSS)).getText());
		click(By.xpath(PLACE_ORDER_BUTTON_XPATH));		
		assertTrue(isElementDisplayed(By.xpath(CHOOSE_COUNTRY_LABEL))
				, "Expected element is not displayed!");
	}
	
	public void enterPromoCode(String promoCode) {
		getDriver().findElement(By.xpath(PROMO_CODE_INPUT_XPATH)).sendKeys(promoCode);
	}
	
	public String getPromoCode() {
		return getDriver().getCurrentUrl().split(".com")[0].split("//")[1];
	}

	public void addToKart(String veg) {
		clickUsingJS(By.xpath(VEGGIES_ADD_TO_CART_BUTTON_XPATH.replace("$veg$", veg)));
	}

	public void selectQuantity(String veg, int quantity) {
		for (int i = 0; i < quantity; i++) {
			scrollintoviewJScript(
					getDriver().findElement(By.xpath(VEGGIES_INCREMENT_BUTTON_XPATH.replace("$veg$", veg))));
			clickUsingJS(By.xpath(VEGGIES_INCREMENT_BUTTON_XPATH.replace("$veg$", veg)));
		}
	}

	public Integer getPriceOfVeggie(String veg) {
		return Integer.parseInt(getDriver().findElement(By.xpath(VEGGIES_PRICE_XPATH.replace("$veg$", veg))).getText());
	}

	public Map<String, Integer> getVeggies() {
		Map<String, Integer> veggies = new HashMap<String, Integer>();
		veggies.put("Potato", 3);
		veggies.put("Cucumber", 2);
		return veggies;
	}
}
