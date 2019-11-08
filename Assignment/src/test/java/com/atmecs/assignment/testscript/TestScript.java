package com.atmecs.assignment.testscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.assignment.base.Base;
import com.atmecs.assignment.config.Constant;
import com.atmecs.assignment.helper.Helper;
import com.atmecs.assignment.helper.Waits;
import com.atmecs.assignment.report.Reports;

public class TestScript extends Base {
	public Helper helper = new Helper();
	public Waits waits = new Waits();
	public Reports report = new Reports();

	@BeforeClass
	public void browserLaunch() {
		getBrowser();
		report.logInfo("user sucessfully landed");
		getUrl();
	}
	
	 /**
	  * product add into cart and validating the product(name,size,colour,price,total price)
	  *  
	  * @throws Exception
	  */
	  @Test
	  public void merchandiseMenu( ) throws Exception {
		  waits.implicitlyWait(driver);
		  
		
		  helper.moveOver(driver, utils.propertyRead(Constant.merchandiseMenu_file, "loc_merchandise"));
		  report.logInfo("clicked merchandise menu");

		  helper.clickOnWebElement(driver, utils.propertyRead(Constant.merchandiseMenu_file,"loc_men"));
		  report.logInfo("selected men in drop down list");
		  
		  helper.elementIsDisplayed(driver, utils.propertyRead(Constant.merchandiseMenu_file,"loc_viewing"));
		  report.logInfo("viewing mens is displayed");
		  
		  helper.clickOnWebElement(driver, utils.propertyRead(Constant.merchandiseMenu_file, "loc_buynow"));
		  helper.clickOnWebElement(driver, utils.propertyRead(Constant.merchandiseMenu_file, "loc_colour"));
		  report.logInfo("selected red colour");
		  
		  helper.clickOnWebElement(driver,utils.propertyRead(Constant.merchandiseMenu_file, "loc_size"));
		  report.logInfo("selected middle size");
		  
		  helper.inputValuesToTheWebelement(driver, utils.propertyRead(Constant.merchandiseMenu_file,"loc_name"),"ranjitha");
		  report.logInfo("entered user name");
		  helper.clickOnWebElement(driver,utils.propertyRead(Constant.merchandiseMenu_file,"loc_popup_buynow"));
		  
		 
		  helper.clickOnWebElement(driver,utils.propertyRead(Constant.merchandiseMenu_file,"loc_cart"));
		  report.logInfo("navigated to cart");
		  
		  //actual data from website
		  String actualItemName = helper.getText(driver,utils.propertyRead(Constant.merchandiseMenu_file,"loc_productname"));
		  String actualSize = helper.getText(driver,utils.propertyRead(Constant.merchandiseMenu_file,"loc_productsize"));
		  String actualColour = helper.getText(driver,utils.propertyRead(Constant.merchandiseMenu_file,"loc_productcolour"));
		  String actualUserName = helper.getText(driver,utils.propertyRead(Constant.merchandiseMenu_file,"loc_personalizedname"));
		  String actualPrice = helper.getText(driver,utils.propertyRead(Constant.merchandiseMenu_file,"loc_price"));
		  String actualTotalPrice = helper.getText(driver,utils.propertyRead(Constant.merchandiseMenu_file,"loc_totalprice"));
		  report.logInfo("verified product");
		  
          helper.clickOnWebElement(driver,utils.propertyRead(Constant.merchandiseMenu_file, "loc_quantity"));
          report.logInfo("increased quantity");
          
          helper.clickOnWebElement(driver,utils.propertyRead(Constant.merchandiseMenu_file, "loc_update"));
          report.logInfo("updated increased quantity");
          String actualUpdatedTotalPrice = helper.getText(driver, utils.propertyRead(Constant.merchandiseMenu_file, "loc_totalprice"));
		  
		  
		  
		  //reading expected data from property file
           String expectedItemName = utils.propertyRead(Constant.cartProductData_file,"productname");
           String expectedActualSize = utils.propertyRead(Constant.cartProductData_file,"productsize");
           String expectedColour = utils.propertyRead(Constant.cartProductData_file,"productcolour");
           String expectedUserName = utils.propertyRead(Constant.cartProductData_file,"username");
           String expectedPrice = utils.propertyRead(Constant.cartProductData_file,"productprice");
           String expectedTotalPrice = utils.propertyRead(Constant.cartProductData_file,"producttotalprice");
           String expectedUpadedtotalprice = utils.propertyRead(Constant.cartProductData_file, "updatedtotalprice");
           
           
		//validating product by comparing expected and actual data
           helper.pageValidation(actualItemName, expectedItemName);
           helper.pageValidation(actualSize,expectedActualSize);
           helper.pageValidation(actualColour, expectedColour);
           helper.pageValidation(actualUserName, expectedUserName);
           helper.pageValidation(actualPrice, expectedPrice);
           helper.pageValidation(actualTotalPrice, expectedTotalPrice);
           helper.pageValidation(actualUpdatedTotalPrice, expectedUpadedtotalprice);
		

	}
	  
	  /**
	   * verify user redirected to respective pages
	   * 
	   */

		@Test
		public void PageRedirection()
		{
			helper.clickOnWebElement(driver, utils.propertyRead(Constant.homePage_file, "loc_home"));
			report.logInfo("clicked home menu");
			helper.clickOnWebElement(driver, utils.propertyRead(Constant.homePage_file, "loc_hotsauces"));
			report.logInfo("clicked hotsauces menu");
			helper.clickOnWebElement(driver, utils.propertyRead(Constant.homePage_file, "loc_merchandise"));
			report.logInfo("clicked merchandise menu");
			helper.clickOnWebElement(driver, utils.propertyRead(Constant.homePage_file, "loc_clearence"));
			report.logInfo("clicked clearence menu");
			helper.clickOnWebElement(driver, utils.propertyRead(Constant.homePage_file, "loc_newtohotsauces"));
			report.logInfo("clicked newtohotsauces menu");
			helper.clickOnWebElement(driver, utils.propertyRead(Constant.homePage_file, "loc_faq"));
			report.logInfo("clicked faq menu");
		}
		
		

	@AfterClass
	public void browserClose() {

		driverClose();
		report.logInfo("driver closed");
	}

	

}
