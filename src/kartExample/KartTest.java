package kartExample;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import selenium_end_to_end_feb.BaseTest;

public class KartTest extends BaseTest {

	private String VEGGIES_QUANTITY_XPATH = "//div[@class='product']//h4[contains(.,'$veg$')]"
			+ "/following-sibling::div/input";
	private String VEGGIES_PRICE_XPATH = "//div[@class='product']//h4[contains(.,'$veg$')]" + "/following-sibling::p";
	private String VEGGIES_INCREMENT_BUTTON_XPATH = "//div[@class='product']//h4[contains(.,'$veg$')]"
			+ "/following-sibling::div/a[@class='increment']";
	private String VEGGIES_ADD_TO_CART_BUTTON_XPATH = "//div[@class='product']//h4[contains(.,'$veg$')]"
			+ "/following-sibling::div/button";
	private String CART_ICON_BUTTON_CSS_SELECTOR = "a.cart-icon";
	private String PROCEED_TO_CHECKOUT_BUTTON_XPATH = "//button[.='PROCEED TO CHECKOUT']";
	private String PROMO_CODE_INPUT_XPATH = "//*[@class='promoCode']";
	private String PROMO_CODE_APPLY_BUTTON_CSS = ".promoBtn";
	private String PROMO_CODE_MESSAGE_CSS = ".promoInfo";
	private String PLACE_ORDER_BUTTON_XPATH = "//button[.='Place Order']";
	private String CHOOSE_COUNTRY_LABEL = "//label";
	private String COUNTRY_DROP_DOWN_XPATH = "//select";
	private String TERMS_CONDITIONS_CHECKBOX_XPATH = "//*[@class='chkAgree']";
	private String COUNTRY_PAGE_PROCEED_BUTTON_XPATH = "//button[.='Proceed']";
	private String VEGGIE_PRICE_FROM_KART_XAPTH = "//header//p[@class='product-name' and contains(.,'$veggie$')]/ancestor::li//p[@class='amount']";
	private String VEGGIE_PRICE_FROM_TABLE_XAPTH = "(//td//p[@class='product-name' and contains(.,'$veggie$')]/ancestor::tr//p[@class='amount'])[last()]";
	Map<String, Integer> veggies_price = new HashMap<String, Integer>();
	Map<String, Integer> veggies_kart_price = new HashMap<String, Integer>();
	Random rand = new Random();

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

		verifyKartElementsPrice();

		click(By.xpath(PROCEED_TO_CHECKOUT_BUTTON_XPATH));
		System.out.println(getDriver().getTitle());

		verifyVeggieTable();

		enterPromoCode(getPromoCode());
		click(By.cssSelector(PROMO_CODE_APPLY_BUTTON_CSS));
		waitUntillElementDisplayed(By.cssSelector(PROMO_CODE_MESSAGE_CSS));

		verifyPromocode("Code applied ..!");

		System.out.println();
		click(By.xpath(PLACE_ORDER_BUTTON_XPATH));
		assertTrue(isElementDisplayed(By.xpath(CHOOSE_COUNTRY_LABEL)), "Expected element is not displayed!");
		selectACountryAndVerify();
		acceptTermsAndConditions();
		clickOnProceedToSuccesfulPage();

		verifySuccessMessage("Thank you, your order has been placed successfully");
	}

	private void verifyVeggieTable() {
		for (Entry<String, Integer> e : veggies_kart_price.entrySet()) {
			Integer price_table = Integer.parseInt(getDriver()
					.findElement(By.xpath(VEGGIE_PRICE_FROM_TABLE_XAPTH.replace("$veggie$", e.getKey()))).getText());
			assertEquals(price_table, e.getValue(), "invlaid promo code message!");
		}
	}

	private void verifyPromocode(String code) {
		String promoCodeSuccMessage = getDriver().findElement(By.cssSelector(PROMO_CODE_MESSAGE_CSS)).getText();
		assertEquals(code, promoCodeSuccMessage, "invlaid promo code message!");
	}

	private void verifyKartElementsPrice() {
		for (Entry<String, Integer> e : getVeggies().entrySet()) {
			int price = veggies_price.get(e.getKey());
			int total = price * e.getValue();
			veggies_kart_price.put(e.getKey(), total);
			int priceFromKart = Integer.parseInt(getDriver()
					.findElement(By.xpath(VEGGIE_PRICE_FROM_KART_XAPTH.replace("$veggie$", e.getKey()))).getText());
			assertEquals(priceFromKart, total, "price in kart is not as expected!!");
		}
	}

	private void verifySuccessMessage(String string) {
		boolean isTextDisplyed = getDriver().findElement(By.xpath("//*[contains(.,'" + string + "')]")).isDisplayed();
		assertTrue(isTextDisplyed, "expected text is not displayed!!");
	}

	private void clickOnProceedToSuccesfulPage() {
		click(By.xpath(COUNTRY_PAGE_PROCEED_BUTTON_XPATH));
	}

	private void acceptTermsAndConditions() {
		click(By.xpath(TERMS_CONDITIONS_CHECKBOX_XPATH));
	}

	private void selectACountryAndVerify() {
		By DropDownLocator = By.xpath(COUNTRY_DROP_DOWN_XPATH);
		click(DropDownLocator);
		WebElement dropDown = getDriver().findElement(DropDownLocator);
		Select s = new Select(dropDown);
		String country = getRandomOptionFromDropDown(s);
		s.selectByVisibleText(country);
		assertEquals(country, s.getFirstSelectedOption().getText(), "Country drop down is not working!!");
	}

	private String getRandomOptionFromDropDown(Select s) {
		s.getOptions().remove(0);
		List<WebElement> options = s.getOptions();
		List<String> optionsLabels = options.stream().map((e) -> e.getText()).collect(Collectors.toList());
		return optionsLabels.get(rand.nextInt(optionsLabels.size()));
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
		for (int i = 0; i < quantity - 1; i++) {
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
