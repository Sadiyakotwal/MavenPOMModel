package com.PageFactory;
import static org.testng.Assert.assertNotNull;
import com.generic.*;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.generic.BaseTest;
public class BootstrapAlertPage 
{
	public BaseTest objBaseTest;
	public boolean blnFlag = false;

	public BootstrapAlertPage(BaseTest BaseTest) 
	{
		this.objBaseTest = BaseTest;
	}
	/**
	 * Description: Locators of BootStrap Alert page Header and Mesaage Box
	 */
	By loc_BootstrapAlertPageHeader = By.xpath("//h2[text()='Bootstrap Alert messages']");
	By loc_AutocloseableSuccessMsgButtonIsDisplayed = By.xpath("//button[@id='autoclosable-btn-success']");
	By loc_AutocloseableSuccessMessage = By.xpath("//div[contains(text(),' an autocloseable success  message. I will hide in 5 seconds.')]");
	By loc_getNormalSuccessMsg = By.xpath("//div[@class='alert alert-success alert-normal-success']");
	/**
	 *  Description: Verify the header of bootstrap alert page 
	 */
	public void verifyBootstrapAlertPageIsDisplayed() 
	{
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(loc_BootstrapAlertPageHeader));
	}
	/**
	 *  Description: Created dynamic xpath for all buttons
	 * @param strButtonsOption
	 * Passing a parameter which contains the information of every bootstrap alert button
	 */
	public void clickBootstrapAlertButtonsOption(String strButtonsOption) 
	{
		objBaseTest.getDriver().findElement(By.xpath("//button[@id='"+strButtonsOption+"']")).click();
	}
	/**
	 * Description: Button 1 
	 * Also Checking if element is visible or not 
	 * Verify with assert if button is dispalyed
	 */
	public void verifyAutocloseableSuccessMsgButtonIsDisplayed() 
	{
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(loc_AutocloseableSuccessMsgButtonIsDisplayed));
	}
	
	/**
	 * Description: verify the autocloseable succes msg is displayed 
	 * @param strExpAutocloseableSuccessMsg
	 */
	public void verifyAutocloseableSuccessMsgIsDisplayed() 
	{
		String strActualMessage = "I'm an autocloseable success  message. I will hide in 5 seconds.";
		List<WebElement> AutocloseableSuccessMessage = objBaseTest.getDriver().findElements(loc_AutocloseableSuccessMessage);
		Assert.assertTrue(AutocloseableSuccessMessage.size()!=0);
		Assert.assertTrue(objBaseTest.getDriver().getPageSource().contains(strActualMessage));
	}	
	/**
	 *Description:Button 2
	 *Also Checking if element is visible or not 
	 *Verify if message is displayed 
	 */
	public void verifyNormalSuccessMessageIsDisplayed() 
	{
		Assert.assertTrue(objBaseTest.getObjWrapperFunctions().checkIfElementIsDisplayed(loc_getNormalSuccessMsg));
	}
	/**
	 *Description:Button 3
	 *Toi get Text  
	 */
	public String getAutocloseableWarningMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-warning alert-autocloseable-warning']")).getText();
	}
	/**
	 *Description: Verify the text message with actual and expected string 
	 */
	public void verifyAutocloseableWarningMessageIsDisplayedOrNot(String strExpAutocloseableWarningMsg) 
	{
			String strActualMessage = this.getAutocloseableWarningMsg();
			Assert.assertEquals(strActualMessage, strExpAutocloseableWarningMsg);
	}
	
	
	

	
}


