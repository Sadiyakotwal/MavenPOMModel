package com.PageFactory;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import com.generic.BaseTest;

public class SEDemoHomePage 
{
	private BaseTest objBaseTest;
	public boolean blnFlag = false;

	/**
	 * Description:Created constructor and passed BaseTest class so that we can access all 
	 * webElement variable
	 * @param :baseTest
	 */
	public SEDemoHomePage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	/**
	 *Description:A PopUp occurs and it is handled by this method 
	 *with Implicit Wait and it is converted to int as configFile has all string values
	 */
	public void managePopUP() 
	{
		objBaseTest.getObjWrapperFunctions().setImplicitlyWait(Integer.parseInt(objBaseTest.objConfigProperties.getProperty("ImplicitWait")));
		objBaseTest.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
	}
	
	public void selectMenuBarElement(String strMenuBar) 
	{
		By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strMenuBar+"')]");
		System.out.println("Menu Bar Selected : "+strMenuBar);
		objBaseTest.getDriver().findElement(MenuList).click();	
		
	}
	
	public void selectParticularDropDown(String strDropDownValue)
	{
		//Dynamic xpath
		By Drop_Down_Option = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='"+strDropDownValue+"']");
		System.out.println("Drop Down Selected : "+strDropDownValue);
		objBaseTest.getDriver().findElement(Drop_Down_Option).click();	
	}
	
	/**
	 * Description: To select option of MenuBar and DropDown from that menubar
	 * @param :strMenu 
	 * @param :strDropDownValue
	 */
	public void selectMenuBarOptionAndDropDown(String strMenu,String strDropDownValue) 
	{
		this.selectMenuBarElement(strMenu);
		this.selectParticularDropDown(strDropDownValue);
		
	}
	

}
