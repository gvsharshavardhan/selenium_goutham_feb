package selenium_end_to_end_feb;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void logintest() {
		loginToOrange();
		assertEquals(true, false);
	}
}
