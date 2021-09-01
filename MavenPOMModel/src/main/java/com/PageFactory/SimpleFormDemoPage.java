package com.PageFactory;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.generic.BaseTest;

public class SimpleFormDemoPage 
{
	private BaseTest objBaseTest;
	public boolean blnFlag = false;
	/**
	 * Description:Created constructor and passed BaseTest class reference so that we can access all 
	 * methods of basetest
	 * @param :baseTest
	 */
	public SimpleFormDemoPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	
	/**
	 * Description: Locators of Simple form Demo page Headers
	 */
	By loc_SimpleFormDemoPageHeader = By.xpath("//h3[text()='This would be your first example to start with Selenium.']");
	By loc_SingleInputFieldHeader = By.xpath("//div[text()='Single Input Field']");
	By singleInputFieldText = By.xpath("//div//label[text()='Your Message: ']/following-sibling::span[@id='display']");

	/**
	 * Description: To check if simple form demo page header is visible after selecting 
	 * the menu Input forms and drop down Simple from Demo
	 */
	public void verifySimpleFormDemoPageIsDisplayed() 
	{
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(loc_SimpleFormDemoPageHeader));
	}
	/**
	 * Description: To verify the header of Single Input field Section
	 */
	public void verifySingleInputFieldHeader() 
	{
		Assert.assertEquals((objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(loc_SingleInputFieldHeader)),true);
	}
	/**
	 *Description: To verify if the textbox field is empty or not
	 * @return: strValue
	 * 	This method returns the string value from the page of textbox field
	 */
	public String verifySingleInputEnterMsgFieldIsEmptyOrNOt() 
	{
		WebElement inputField = objBaseTest.getDriver().findElement(By.xpath("//input[@type='text']"));
	    String strValue =inputField.getAttribute("value");
	    return strValue;
	}
	/**
	 * Description: With the help of assert verify if returned value from textbox field is
	 * empty or not and if assert is true then send a text message in field
	 * @param strMessage
	 * 	To set a message in the textbox field
	 */
	public void setSingleInputFieldMessage(String strMessage) 
	{
		Assert.assertTrue(verifySingleInputEnterMsgFieldIsEmptyOrNOt().isEmpty());
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='user-message']")).sendKeys(strMessage);
	}
	/**
	 *Description: Click the button witth show message
	 */
	public void clickShowMessageButton() 
	{
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Show Message']")).click();
	}
	/**
	 *Description: Verify if message is displayed after the button click 
	 */
	public void verifyMessageEnteredInSingleInputField() 
	{
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(singleInputFieldText));
	}
	
}
