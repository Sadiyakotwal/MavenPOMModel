package com.Scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageFactory.BootstrapAlertPage;
import com.PageFactory.CheckBoxDemoPage;
import com.PageFactory.SEDemoHomePage;
import com.PageFactory.SimpleFormDemoPage;
import com.generic.BaseTest;

public class SimpleFormTest extends BaseTest
{
	/**
	 * Description: Creating global references
	 */
	private SEDemoHomePage objSEDemoHomePage;
	private SimpleFormDemoPage objSimpleFormDemoPage;
	private BootstrapAlertPage objBootstrapAlertPage;
	private CheckBoxDemoPage objCheckBoxDemoPage;
	/**
	 *Description:Creating object through reference 
	 */
	public void initializePageObjectModel() 
	{
		objSEDemoHomePage = new SEDemoHomePage(this);
		objSimpleFormDemoPage =new SimpleFormDemoPage(this);
		objBootstrapAlertPage = new BootstrapAlertPage(this);
		objCheckBoxDemoPage = new CheckBoxDemoPage(this);
	}
	/**
	 *Description: To call the method of basetest class of initializing the
	 *WebEnvironment.
	 */
	@BeforeClass
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();	
		objSEDemoHomePage.managePopUP();
	}
	
	@Test(priority=1,description = "Checking simple form demo page")
	public void TC_ID_100_VerifySimpleFormDemoPageIsDisplayed() 
	{
		objSEDemoHomePage.selectMenuBarOptionAndDropDown(objConfigProperties.getProperty("strMenuBar"),objConfigProperties.getProperty("strDropDownValue"));
		objSimpleFormDemoPage.verifySimpleFormDemoPageIsDisplayed();
	}
	@Test(priority=2,description = "Checking single input message")
	public void TC_ID_101_VerifySingleInputFieldSectionMsgIsDisplayed() 
	{
		objSimpleFormDemoPage.verifySingleInputFieldHeader();
		objSimpleFormDemoPage.setSingleInputFieldMessage(objConfigProperties.getProperty("strMessage"));
		objSimpleFormDemoPage.clickShowMessageButton();
		objSimpleFormDemoPage.verifyMessageEnteredInSingleInputField();
	}
		
	@Test(priority=3,description = "Checking Bootstrap Alerts Page Header")
	public void TC_ID_102_verifyBootstrapAlertPageIsDisplayed() 
	{
		objSEDemoHomePage.selectMenuBarOptionAndDropDown(objConfigProperties.getProperty("strMenuBarAlerts"),objConfigProperties.getProperty("strDropDownValueBootstrapAlerts"));
		objBootstrapAlertPage.verifyBootstrapAlertPageIsDisplayed();
	}
	@Test(priority=4)
	public void TC_ID_103_VerifyAutocloseableSuccessMsgIsDisplayed() 
	{
		objBootstrapAlertPage.verifyAutocloseableSuccessMsgButtonIsDisplayed();
		objBootstrapAlertPage.clickBootstrapAlertButtonsOption(objConfigProperties.getProperty("strAutocloseableSuccessButton"));
		objBootstrapAlertPage.verifyAutocloseableSuccessMsgIsDisplayed();
	}
	
	@Test(priority=5)
	public void TC_ID_104_VerifyNormalSuccessMsgIsDisplayed() 
	{
		objBootstrapAlertPage.clickBootstrapAlertButtonsOption(objConfigProperties.getProperty("strNormalSuccessButton"));
		objBootstrapAlertPage.verifyNormalSuccessMessageIsDisplayed();
	}
	@Test(priority=6)
	public void TC_ID_105_verifyAutocloseableWarningMessageIsDisplayed() 
	{
		objBootstrapAlertPage.clickBootstrapAlertButtonsOption(objConfigProperties.getProperty("strAutocloseableWarningButton"));
		objBootstrapAlertPage.verifyAutocloseableWarningMessageIsDisplayedOrNot(objConfigProperties.getProperty("strExpAutocloseableWarningMsg"));
	}
	@Test(priority=7)
	public void TC_ID_106_verifyCheckBoxDemoPageIsDisplayed() 
	{
		objSEDemoHomePage.selectMenuBarOptionAndDropDown(objConfigProperties.getProperty("strMenuBar"),objConfigProperties.getProperty("strDropDownValueCheckBox"));
		objCheckBoxDemoPage.verifyCheckBoxDemoPageIsDisplayedOrNot();
	}
	@Test(priority=8)
	public void TC_ID_108_VerifySingleCheckBoxIsSelected() 
	{
		objCheckBoxDemoPage.verifySingleCheckBoxDemoSectionHeaderIsDisplayedOrNot();
		objCheckBoxDemoPage.selectSingleCheckBox();
	}
	
	/**
	 *Description: To close the web environment 
	 */
	@AfterClass
	public void tearDownWebEnvironment()
	{
		tearDown();
	}
}
