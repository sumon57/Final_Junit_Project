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

public class SingleListItemPage extends BasePage {
	
	WebDriver driver;
	String listItem;
	
	
	
	
	public SingleListItemPage(WebDriver driver) {
		this.driver=driver;
	}
	//data for List item
	String item1="Sum";
	
//	@FindBy(how = How.NAME,using="data") WebElement LIST_ITEM_ELEMENT;
//	@FindBy(how = How.NAME,using="todo[0]") WebElement FIRST_LIST_ITEM_BOX_ELEMENT;
//	@FindBy(how = How.XPATH,using="/html/body/div[4]/input[2]") WebElement ADD_LIST_ITEM_ELEMENT;
//	@FindBy(how = How.XPATH,using="/html/body/div[3]/input[1]") WebElement REMOVE_BUTTON_ELEMENT;
//	
	
	@FindBy(how = How.NAME,using="allbox") WebElement TOGGLEALL_ELEMENT;
	@FindBy(how = How.NAME,using="data") WebElement LIST_ITEM_ELEMENT;
	@FindBy(how = How.XPATH,using="/html/body/div[4]/input[2]") WebElement ADD_LIST_ITEM_ELEMENT;
	@FindBy(how = How.XPATH,using="/html/body/div[3]/input[1]") WebElement REMOVE_BUTTON_ELEMENT;
	
	public boolean addListItem() {
//		LIST_ITEM_ELEMENT.sendKeys(item1);
//		ADD_LIST_ITEM_ELEMENT.click();
//		
//		LIST_ITEM_ELEMENT.sendKeys(item2);
//		ADD_LIST_ITEM_ELEMENT.click();
//		LIST_ITEM_ELEMENT.sendKeys(item3);
//		ADD_LIST_ITEM_ELEMENT.click();

		try {

			Scanner sc = new Scanner(new File("InsertSingleItemData.txt"));
			while (sc.hasNextLine()) {

			 listItem = sc.nextLine();
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

	public void enterlistItem(String listItem) {
		clearData();
		LIST_ITEM_ELEMENT.sendKeys(listItem);
		ADD_LIST_ITEM_ELEMENT.click();
	}
//	public void addListItem() {
//		LIST_ITEM_ELEMENT.sendKeys(li);
//		ADD_LIST_ITEM_ELEMENT.click();
//	
//	}
	public void checkSingleItemAndRemove() {
		
		clearData();
	
	}
	public void validateSingleItemRemoved() {
		Assert.assertEquals(ADD_LIST_ITEM_ELEMENT.isDisplayed(),true);
		
	}
	public void clearData() {
		TOGGLEALL_ELEMENT.click();
		REMOVE_BUTTON_ELEMENT.click();
	}

	
}
