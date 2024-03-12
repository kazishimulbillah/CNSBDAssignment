package com.SC.QA.Page;

import com.SC.Helper.JavaScript.JavaScriptHelper;
import com.SC.QA.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//*[@id=\"circularMst\"]/tbody/tr[1]/td[1]/a")
    WebElement firstCircularNo;


    JavaScriptHelper javaScript = new JavaScriptHelper(driver);
    
    public static String circularNo;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    
    
    public void getFirstCircularNo() throws InterruptedException {
    	Thread.sleep(1000);
    	circularNo = firstCircularNo.getText();
    	javaScript.clickElement(firstCircularNo);
    }
}
