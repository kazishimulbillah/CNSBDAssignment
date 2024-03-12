package com.SC.QA.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SC.Helper.JavaScript.JavaScriptHelper;
import com.SC.QA.Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[2]/a")
    WebElement continueWithoutLoginBtn;
	
	JavaScriptHelper javaScript = new JavaScriptHelper(driver);
	
	public LoginPage() {
        PageFactory.initElements(driver, this);
    }
	
	public void clickOnContinueWithoutLoginBtn() throws InterruptedException {
    	Thread.sleep(500);
    	javaScript.clickElement(continueWithoutLoginBtn);
    }

}
