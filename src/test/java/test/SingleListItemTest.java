package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.SingleListItemPage;
import util.BrowserFactory;

public class SingleListItemTest {
	
	WebDriver driver;

	@Test
	public void validateSingleItemCheckedAndRemoved() {
		driver = BrowserFactory.init();
		SingleListItemPage singleListItemPage = PageFactory.initElements(driver, SingleListItemPage.class);

		singleListItemPage.addListItem();
		singleListItemPage.checkSingleItemAndRemove();
		singleListItemPage.validateSingleItemRemoved();

		BrowserFactory.tearDown();

	}

}
