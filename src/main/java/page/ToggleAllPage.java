package page;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ToggleAllPage extends BasePage {
	
	WebDriver driver;

	public ToggleAllPage(WebDriver driver) {
		this.driver = driver;

	}

	// list item data
//	String item1="asma";
//	String item2="kadir";
//	String item3="karim";
	// Define WebElements
	@FindBy(how = How.NAME, using = "allbox")
	WebElement TOGGLEALL_ELEMENT;
	@FindBy(how = How.NAME, using = "data")
	WebElement LIST_ITEM_ELEMENT;
	@FindBy(how = How.NAME, using = "todo[0]")
	WebElement FIRST_LIST_ITEM_BOX_ELEMENT;
	@FindBy(how = How.NAME, using = "todo[1]")
	WebElement SECOND_LIST_ITEM_BOX_ELEMENT;
	@FindBy(how = How.NAME, using = "todo[2]")
	WebElement THIRD_LIST_ITEM_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/input[2]")
	WebElement ADD_LIST_ITEM_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/input[1]")
	WebElement REMOVE_BUTTON_ELEMENT;

	public boolean addListItem() {
//		LIST_ITEM_ELEMENT.sendKeys(item1);
//		ADD_LIST_ITEM_ELEMENT.click();
//		
//		LIST_ITEM_ELEMENT.sendKeys(item2);
//		ADD_LIST_ITEM_ELEMENT.click();
//		LIST_ITEM_ELEMENT.sendKeys(item3);
//		ADD_LIST_ITEM_ELEMENT.click();

		try {

			Scanner sc = new Scanner(new File("InsertAddListItem.txt"));
			while (sc.hasNextLine()) {

				String listItem = sc.nextLine();
				enterlistItem(listItem);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		List<WebElement> listofItemsAdded = driver.findElements(By.name("todo"));
		if (listofItemsAdded.isEmpty() == true) {
			// boolean itemsremoved = true;
			return true;
		} else {

			for (WebElement element : listofItemsAdded) {
				element.isSelected();
				System.out.println(element.getText());
			}
			return false;

		}
	}

	public void checkSingleItemAndRemove() {
		FIRST_LIST_ITEM_BOX_ELEMENT.click();
		REMOVE_BUTTON_ELEMENT.click();
	}
	
	public void enterlistItem(String listItems) {
		LIST_ITEM_ELEMENT.sendKeys(listItems);
		ADD_LIST_ITEM_ELEMENT.click();
	}

	public void validateListItemChecked() {
		if (TOGGLEALL_ELEMENT.isSelected()) {
//			Assert.assertTrue(FIRST_LIST_ITEM_BOX_ELEMENT.isSelected());
//			Assert.assertTrue(SECOND_LIST_ITEM_BOX_ELEMENT.isSelected());
//			Assert.assertTrue(THIRD_LIST_ITEM_BOX_ELEMENT.isSelected());
			Assert.assertEquals(ADD_LIST_ITEM_ELEMENT.isSelected(),false);
		}

	}
//
//	public void validateSingleItemRemoved() {
//		Assert.assertFalse(driver.getPageSource().contains(item1));
//
//	}

//	public void validateRemoveAll() {
//		Assert.assertFalse(driver.getPageSource().contains(item2));
//		Assert.assertFalse(driver.getPageSource().contains(item3));
//
//	}

	public void clickToggleAll() {
		TOGGLEALL_ELEMENT.click();
	}

	public void removeAll() {
		REMOVE_BUTTON_ELEMENT.click();
	}

}
