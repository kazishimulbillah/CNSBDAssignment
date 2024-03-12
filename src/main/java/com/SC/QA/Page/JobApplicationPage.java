package com.SC.QA.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.SC.Helper.JavaScript.JavaScriptHelper;
import com.SC.QA.Base.TestBase;

public class JobApplicationPage extends TestBase {
	
	@FindBy(xpath = "//h4[contains(text(),'Job Application')]")
    WebElement jobApplicationTitle;
	
	@FindBy(id = "national_id")
    WebElement nationalIdField;
	
	@FindBy(id = "date_of_birth")
    WebElement dateOfBirthField;
	
	@FindBy(xpath = "//*[@id=\"nid_verification\"]")
    WebElement verifyNidBtn;
	
	@FindBy(xpath = "//input[@id='national_id_attachment']")
    WebElement nationalIdAttachmentField;
	
	JavaScriptHelper javaScript = new JavaScriptHelper(driver);
	
	public JobApplicationPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void verifyJobApplicationTitle() throws InterruptedException {
    	Thread.sleep(1000);
    	Assert.assertEquals(jobApplicationTitle.getText(), "Job Application");
    }
	
	public void setNationalId(String nidNumber) throws InterruptedException {
    	Thread.sleep(1000);
    	javaScript.clickElement(nationalIdField);
    	javaScript.SendElement(nationalIdField, nidNumber);
    }
	
	public void setBirthDate(String bDate) throws InterruptedException {
    	Thread.sleep(1000);
    	javaScript.clickElement(dateOfBirthField);
    	javaScript.SendElement(dateOfBirthField, bDate);
    }
	
	public void clickOnVerifyNidBtn() throws InterruptedException {
    	Thread.sleep(500);
    	javaScript.clickElement(verifyNidBtn);
    }

}
