package PageClass_BH;


	/*
	* Copyright (c) 2014 MedImpact Healthcare Systems, Inc.
	* All Rights Reserved.
	*
	* History
	*
	*
	*/
	 
	package com.medimpact.itqa.benefithighlights.pageclass;
	 
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.apache.log4j.Logger;
	import org.testng.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.TimeoutException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import com.medimpact.itqa.benefithighlights.seleniumtools.WebPage;
	 
	/**
	*
	 * <p>
	* Class to implement Benefit HighLights Login Page functionalities
	*
	 * @author Smrutiranjan Mohapatra
	*/
	 
	public class BenefitHighLightsLoginPage implements WebPage {
	 
	                static Logger logger;
	                protected WebDriver _driver;
	                protected WebDriverWait _driverWait;
	                protected String benefitHighLightURL;
	                protected String headerText;
	                protected String header;
	                protected String HQTextbox;
	                protected String memberNoTxtbox;
	                protected String famPosTxtbox;
	                protected String yesRadioBtn;
	                protected String noRadioBtn;
	                protected String brandCodeTextbox;
	                protected String benefitHighLightsLink;
	                protected Properties prop;
	 
	                /**
	                * <p>
	                * This constructor method Loads the all page locators required for
	                * BenefitHighLights login Page from test.property file
	                *
	                 * @author Smrutiranjan Mohapatra
	                * @param driver
	                *            a WebDriver Object
	                * @param timeout
	                *            an int that is used to set the default timeout for the page
	                *
	                 */
	 
	                public BenefitHighLightsLoginPage(WebDriver driver, int timeout) {
	                                _driver = driver;
	                                logger = Logger.getLogger(this.getClass().getName());
	                                try {
	                                                prop = new Properties();
	                                                prop.load(BenefitHighLightsLoginPage.class.getClassLoader()
	                                                                                .getResourceAsStream(
	                                                                                                                "BenefitHighLightsLoginPage.properties"));
	                                                benefitHighLightURL = prop.getProperty("benefit_highlights_url");
	                                                Assert.assertNotNull(benefitHighLightURL);
	 
	                                                header = prop.getProperty("header");
	                                                Assert.assertNotNull(header);
	 
	                                                headerText = prop.getProperty("header_text");
	                                                Assert.assertNotNull(headerText);
	 
	                                                HQTextbox = prop.getProperty("hq_txtbox");
	                                                Assert.assertNotNull(HQTextbox);
	 
	                                                memberNoTxtbox = prop.getProperty("member_no_txtbox");
	                                                Assert.assertNotNull(memberNoTxtbox);
	 
	                                                famPosTxtbox = prop.getProperty("fp_txtbox");
	                                                Assert.assertNotNull(famPosTxtbox);
	 
	                                                yesRadioBtn = prop.getProperty("yes_radiobutton");
	                                                Assert.assertNotNull(yesRadioBtn);
	 
	                                                noRadioBtn = prop.getProperty("no_radiobutton");
	                                                Assert.assertNotNull(noRadioBtn);
	 
	                                                brandCodeTextbox = prop.getProperty("brand_code_textbox");
	                                                Assert.assertNotNull(brandCodeTextbox);
	 
	                                                benefitHighLightsLink = prop.getProperty("submit");
	                                                Assert.assertNotNull(benefitHighLightsLink);
	 
	                                                int weight = Integer.parseInt(prop
	                                                                                .getProperty("bh_login_page_weight"));
	                                                Assert.assertNotNull(weight);
	 
	                                                _driver.manage().timeouts()
	                                                                                .implicitlyWait(weight * timeout, TimeUnit.SECONDS);
	                                                _driverWait = new WebDriverWait(_driver, weight * timeout, weight);
	 
	                                } catch (IOException e) {
	                                                logger.error("Could not find property file");
	                                                logger.error(e.getMessage());
	                                }
	 
	                }
	 
	                /**
	                * This method returns the driver associated with BenefitHighLights login
	                * Page
	                *
	                 * @author Smrutiranjan Mohapatra
	                * @return the Webdriver used to access BenefitHighLights login Page
	                */
	                public WebDriver getDriver() {
	                                return _driver;
	                }
	 
	                /**
	                * This Method asserts the title of the BenefitHighLights login Page
	                *
	                 * @author Smrutiranjan Mohapatra
	                * @return return "PASS"
	                *
	                 */
	                public String getTitle() {
	                                String theHeader = _driver.findElement(By.xpath(header)).getText()
	                                                                .trim();
	                                Assert.assertEquals(theHeader, headerText, "page header not found");
	                                logger.info(theHeader);
	                                return "PASS";
	                }
	 
	                /**
	                * <p>
	                * Method to validate BenefitHighLights login Page
	                *
	                 * @author Smrutiranjan Mohapatra
	                * @return PASS if validation success else FAIL
	                *
	                 */
	                public String validatePage() {
	 
	                                logger.info("verify BenefitHighLights Login Page ");
	                                try {
	                                                if (_driver.findElement(By.xpath(benefitHighLightsLink))
	                                                                                .isDisplayed())
	                                                                logger.info("BenefitHighLights page is validated");
	 
	                                } catch (NoSuchElementException e) {
	                                                logger.error("Could not validate benefitHighLights page...");
	                                                return "FAIL";
	                                }
	 
	                                return "PASS";
	                }
	 
	                /**
	                * <p>
	                * Method that access the URL to get benefitHighLights Login page and
	                * returns WebDriver Object
	                *
	                 * @author Smrutiranjan Mohapatra
	                * @return _driver the WebDriver object
	                */
	                public WebDriver getBenefitHighLightsLoginPage() {
	 
	                                logger.info(" Open benefit HighLights Login  Page");
	                                try {
	                                                _driver.get(benefitHighLightURL);
	                                } catch (StaleElementReferenceException se) {
	                                                logger.info(" Stale Element ref exception occured retrying after 5 seconds");
	                                                _driverWait.withTimeout(5, TimeUnit.SECONDS);
	                                                _driver.get(benefitHighLightURL);
	                                }
	 
	                                // to handle certification error on IE
	                                if (_driver.getTitle().equals("Certificate Error: Navigation Blocked"))
	                                                _driver.get("javascript:document.getElementById('overridelink').click();");
	                                //_driver.manage().window().maximize();
	                                return _driver;
	                }
	 
	                /**
	                * <p>
	                * Method that invoke benefitHighLights login page
	                *
	                 * @author smmohapatra
	                * @return returns string "PASS" on successful invocation,"FAIL" otherwise.
	                *
	                 */
	                public String enterMemberLoginDetails(String hqCode, String memberNo,
	                                                String famPos, String brandCode) {
	                                logger.info("Enter Member login details");
	                                try {
	                                                _driverWait.until(ExpectedConditions.presenceOfElementLocated(By
	                                                                                .xpath(HQTextbox)));
	                                                _driver.findElement(By.xpath(HQTextbox)).clear();
	                                                _driver.findElement(By.xpath(HQTextbox)).sendKeys(hqCode);
	 
	                                                _driver.findElement(By.xpath(memberNoTxtbox)).clear();
	                                                _driver.findElement(By.xpath(memberNoTxtbox)).sendKeys(memberNo);
	 
	                                                _driver.findElement(By.xpath(famPosTxtbox)).clear();
	                                                _driver.findElement(By.xpath(famPosTxtbox)).sendKeys(famPos);
	 
	                                                _driver.findElement(By.xpath(yesRadioBtn)).click();
	 
	                                                _driver.findElement(By.xpath(brandCodeTextbox)).clear();
	                                                _driver.findElement(By.xpath(brandCodeTextbox)).sendKeys(brandCode);
	 
	                                                logger.info("Below login details entered ");
	                                                logger.info("\n HQ_Code: "
	                                                                                + ((hqCode.trim().isEmpty()) ? "<blank>" : hqCode)
	                                                                                + "\n Member_no: "
	                                                                                + ((memberNo.trim().isEmpty()) ? "<blank>" : memberNo)
	                                                                                + "\n Family_position: "
	                                                                                + ((famPos.trim().isEmpty()) ? "<blank>" : famPos)
	                                                                                + "\n brand_code: "
	                                                                                + ((brandCode.trim().isEmpty()) ? "<blank>" : brandCode));
	 
	                                } catch (NoSuchElementException e) {
	                                                logger.info(" Error : Member login fields not found");
	                                                logger.error(e.getMessage());
	                                                return "FAIL";
	                                } catch (TimeoutException te) {
	                                                logger.info("TimeOut Execption Occurred :" + te.getMessage());
	                                                return "FAIL";
	                                }
	                                return "PASS";
	                }
	 
	                /**
	                * <p>
	                * Method that initiate login
	                *
	                 * @author Smrutiranjan Mohapatra
	                * @return Return PASS if login initiated else, return FAIL
	                */
	                public String signIn() {
	                                logger.info("Click On  benefit highlights Link");
	                                try {
	                                                _driver.findElement(By.xpath(benefitHighLightsLink)).click();
	                                                logger.info("Clicked on benefit highlights link  ");
	                                } catch (NoSuchElementException e) {
	                                                logger.info("benefit highlights link is  not found" + e);
	                                                return "FAIL";
	                                }
	                                return "PASS";
	                }
	 
	}