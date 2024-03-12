package com.SC.QA.EndToEnd.TestCases;

import java.io.IOException;

import com.SC.QA.Page.HomePage;
import com.SC.QA.Page.JobApplicationPage;
import com.SC.QA.Page.LoginPage;
import com.SC.QA.Page.PostVacancyPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.SC.QA.Base.TestBase;
import com.SC.QA.Util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 *
 * @author Kazi Md Shimul Billah
 */

public class EndToEndTests extends TestBase {

	TestUtil testUtil;
	
	HomePage homePage;
	PostVacancyPage postVacancyPage;
	LoginPage loginPage;
	JobApplicationPage jobApplicationPage;
	String sheetName = "UserDetails";
	public ExtentReports extent;
	public ExtentTest extentTest;

	public EndToEndTests() {
		super();
	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		jobApplicationPage = new JobApplicationPage();
		jobApplicationPage = PageFactory.initElements(driver, JobApplicationPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		postVacancyPage = new PostVacancyPage();
		postVacancyPage = PageFactory.initElements(driver, PostVacancyPage.class);
	}
	
	@Test(priority = 1)
	public void verifySelectAnyJobCircular () throws InterruptedException {
		extentTest = extent.startTest("Job Circular Verification");
		homePage.getFirstCircularNo();
		Thread.sleep(500);
		switchWindow(1);
		Thread.sleep(500);
		postVacancyPage.verifyCircularNo();
		Thread.sleep(500);
		postVacancyPage.clickOnAction();
		Thread.sleep(500);
		postVacancyPage.verifyApplyNow();
		Thread.sleep(500);
		
	}
	
	@Test(priority = 2, dataProvider = "UserDetails")
	public void FillingApplication (String name,String firstname, String lastname, String nidNumber, String bDate) throws InterruptedException {
		extentTest = extent.startTest("Application form verification");
		homePage.getFirstCircularNo();
		Thread.sleep(500);
		switchWindow(1);
		Thread.sleep(500);
		postVacancyPage.clickOnAction();
		Thread.sleep(500);
		postVacancyPage.verifyApplyNow();
		Thread.sleep(500);
		postVacancyPage.clickOnApplyNowbtn();
		Thread.sleep(500);
		loginPage.clickOnContinueWithoutLoginBtn();
		Thread.sleep(500);
		jobApplicationPage.verifyJobApplicationTitle();
		Thread.sleep(500);
		jobApplicationPage.setNationalId(nidNumber);
		Thread.sleep(500);
		jobApplicationPage.setBirthDate(bDate);
		Thread.sleep(500);
		jobApplicationPage.clickOnVerifyNidBtn();
		Thread.sleep(1000);
	}


	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent report

			String screenshotPath = EndToEndTests.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest);

		driver.quit();
//
//		CloseWebDriver();
	}

	@DataProvider
	public Object[][] UserDetails() {
		Object[][] data = TestUtil.getTestData(sheetName);

		return data;
	}

}
