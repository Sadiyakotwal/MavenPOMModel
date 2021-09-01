package com.PageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.BaseTest;

public class CheckBoxDemoPage 
{
	private BaseTest objBaseTest;
	public boolean blnFlag = false;

	/**
	 * Description:Created constructor and passed BaseTest class so that we can access all 
	 * webElement variable
	 * @param :baseTest
	 */
	public CheckBoxDemoPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	/**
	 * Description: Locators of CheckBox Demo page Header
	 */
	By loc_CheckBoxDemoPageHeader = By.xpath("//h3[text()='This would be a basic example to start with checkboxes using selenium.']");
	By loc_SingleCheckBoxHeader = By.xpath("//div[text()='Single Checkbox Demo']");
	By loc_SelectSingleCheckBox = By.xpath("//input[@id='isAgeSelected']");
	/**
	 * Description: Verify header of checkbox demo page 
	 */
	public void verifyCheckBoxDemoPageIsDisplayedOrNot() 
	{
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(loc_CheckBoxDemoPageHeader));
	}
	/**
	 * Description:verify Single check box section header 
	 */
	public void verifySingleCheckBoxDemoSectionHeaderIsDisplayedOrNot() 
	{
		Assert.assertEquals(objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(loc_SingleCheckBoxHeader), true);	
	}
	/**
	 *  Description: Verify if checkbox is selected or not
	 * @return: boolean value either true or false
	 */
	public boolean verifySingleCheckBoxIsSectedOrNot() 
	{
        blnFlag = objBaseTest.getDriver().findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
        return blnFlag;
    }
	/**
	 *Description: Verify if selected or not and
	 *Select check box if not selected 
	 */
	public void selectSingleCheckBox() 
	{
		Assert.assertFalse(verifySingleCheckBoxIsSectedOrNot());
		objBaseTest.getObjWrapperFunctions().setFluentWait(loc_SelectSingleCheckBox);
		objBaseTest.getDriver().findElement(loc_SelectSingleCheckBox).click();
	}
}
