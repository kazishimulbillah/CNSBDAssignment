package com.SC.QA.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.SC.Helper.JavaScript.JavaScriptHelper;
import com.SC.QA.Base.TestBase;

public class PostVacancyPage extends TestBase {
	
	
	@FindBy(xpath = "//*[@id=\"circularDtl\"]/tbody/tr/td[2]")
    WebElement circularNo;
	
	@FindBy(xpath = "//*[@id=\"circularDtl\"]/tbody/tr/td[7]/a")
    WebElement actionButton;
	
	
	
	JavaScriptHelper javaScript = new JavaScriptHelper(driver);
	
	public PostVacancyPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void verifyCircularNo() throws InterruptedException {
    	Thread.sleep(1000);
    	Assert.assertEquals(circularNo.getText(), HomePage.circularNo);
    }
	
	public void clickOnAction() throws InterruptedException {
    	Thread.sleep(500);
    	javaScript.clickElement(actionButton);
    }
	
	@FindBy(xpath = "//*[@id=\"circularDtlCard\"]/div[1]/div[1]/div/p[1]/a")
    WebElement applyNowBtn;
	
	public void clickOnApplyNowbtn() throws InterruptedException {
    	Thread.sleep(500);
    	javaScript.clickElement(applyNowBtn);
    }
	
	public void verifyApplyNow() throws InterruptedException {
    	Thread.sleep(500);
    	Assert.assertEquals(applyNowBtn.getText(), "Apply Now");
    }

}
