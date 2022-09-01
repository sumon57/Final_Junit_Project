package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.ToggleAllPage;
import util.BrowserFactory;

public class ToggleAllTest {
	
	WebDriver driver;

	@Test
	public void checkToggleAll() {
		driver = BrowserFactory.init();
		ToggleAllPage toggleAllPage = PageFactory.initElements(driver, ToggleAllPage.class);

		toggleAllPage.addListItem();
		toggleAllPage.clickToggleAll();
		toggleAllPage.validateListItemChecked();

		BrowserFactory.tearDown();

	}

}
