package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.ListAllItemRemovePage;
import util.BrowserFactory;

public class ListAllItemRemoveTest {
	
	WebDriver driver;

	@Test
	public void validateAllItemRemove() {
		driver = BrowserFactory.init();
		ListAllItemRemovePage listAllItemRemovePage = PageFactory.initElements(driver, ListAllItemRemovePage.class);

		listAllItemRemovePage.addListItem();
		listAllItemRemovePage.clickToggleAll();
		listAllItemRemovePage.removeAll();
		listAllItemRemovePage.validateRemoveAll();

		BrowserFactory.tearDown();

	}

}
