package com.phptravels.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.phptravels.base.TestBase;
import com.phptravels.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class LoginPageTest extends TestBase {

    public LoginPageTest() throws IOException
    {
        super();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser ,Method method) throws ATUTestRecorderException
    {
        logger = extent.startTest(method.getName());
        intialize(browser);
        recorder = new ATUTestRecorder("Reports\\",method.getName(),false);
        recorder.start();
    }

    @DataProvider
    public Object[][] testData() throws IOException
    {
        Object data[][]=RegisterPageTest.loginData;
        return data;
    }

    @Test(priority = 1 , dataProvider = "testData")
    public void valdiateLogin(String email , String pass) throws IOException
    {
        driver.findElement(By.xpath("(//a[@id='dropdownCurrency'])[2]")).click();
        driver.findElement(By.xpath("//a[@class='dropdown-item active tr']")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement emailField = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        WebElement passField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        loginButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='img-responsive go-right img-thumbnail']")));

    }

    // itresult get the restult of testcase
    @AfterMethod
    public void exitAll(Method method,ITestResult result) throws IOException, ATUTestRecorderException
    {
        // closes all windows after test is done
        TestUtils.takeSnapShot(method.getName());
        if (result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(LogStatus.PASS,"Test Passed");
            logger.log(LogStatus.PASS,"<a href = '"+result.getName()+".png"+"'><span class='lable info'>Download SnapShot</span></a>");
            logger.log(LogStatus.PASS,"<a href = '"+result.getName()+".mov"+"'><span class='lable info'>Download Video</span></a>");

        }
        else if (result.getStatus()==ITestResult.FAILURE)
        {
            logger.log(LogStatus.FAIL,"Test Failed"+result.getThrowable());
            logger.log(LogStatus.PASS,"<a href = '"+result.getName()+".png"+"'><span class='lable info'>Download SnapShot</span></a>");
            logger.log(LogStatus.PASS,"<a href = '"+result.getName()+".mov"+"'><span class='lable info'>Download Video</span></a>");

        }
        else {
            logger.log(LogStatus.SKIP,"Test Skipped"+result.getThrowable());
        }
        recorder.stop();
        driver.quit();




    }

}
