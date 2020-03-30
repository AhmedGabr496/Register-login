package com.phptravels.testcases;

//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.phptravels.base.TestBase;
import com.phptravels.util.TestUtils;
import com.phptravels.base.valdiatedData;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RegisterPageTest extends TestBase {
    public static Object[][] loginData;
    public static int i=0 ,r=0;
    public RegisterPageTest() throws IOException {
        super();
        Object temp[][]= testData();
        int rowsize=temp.length;
        loginData = new Object[rowsize][2];
    }

    @Parameters({"browser"})
    @BeforeMethod()
    public void setUp(String browser,Method method) /*throws ATUTestRecorderException*/ {
        logger = extent.startTest(method.getName());
        intialize(browser);
        //recorder = new ATUTestRecorder("videoRecords\\",method.getName(),false);
        //recorder.start();

    }

    @DataProvider
    public Object[][] testData() throws IOException
    {
        //Object registerdata[][]= TestUtils.getDataFromExcel("RegistrationData");
        Object registerdata[][]= valdiatedData.validData();
        return registerdata;
    }

    //Annotaion --> indicates a testcase
    @Test(priority = 1)
    public void urlCheck() throws IOException {
        //Test Steps
        String actualResult = driver.getCurrentUrl();
        String expectedResult = pro.getProperty("URL");
        Assert.assertEquals(actualResult,expectedResult);
        AssertionResult = 1;
    }


    @Test(priority = 2 ,dataProvider = "testData")
    public void validateRegisteration(String firstN , String lastN ,String phone ,String email ,String pass,String cofirmpass ) throws IOException {
        //Test steps
        Assert.assertEquals(AssertionResult,1,"Wrong URL");
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        WebElement emailAddress = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passFirst = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement passSecond = driver.findElement(By.xpath("//input[@name='confirmpassword']"));
        WebElement signUpButton=driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        firstName.sendKeys(firstN);
        lastName.sendKeys(lastN);
        phoneNumber.sendKeys(phone);
        emailAddress.sendKeys(email);
        passFirst.sendKeys(pass);
        passSecond.sendKeys(cofirmpass);
        signUpButton.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='img-responsive go-right img-thumbnail']")));
        Assert.assertTrue(true);
        loginData[i][0]=email;
        loginData[i][1]=pass;
        i++;
    }
    public Object[][] getLoginData()
    {
        return loginData;
    }
    @AfterMethod
    public void exitAll(Method method,ITestResult result) throws /*ATUTestRecorderException,*/ IOException {
        // closes all windows after test is done
        TestUtils.takeSnapShot(method.getName());
        if (result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(LogStatus.PASS,"Test Passed");
            logger.log(LogStatus.PASS,"<a href = '"+result.getName()+".png"+"'><span class='lable info'>Download SnapShot</span></a>");
        }
        else if (result.getStatus()==ITestResult.FAILURE)
        {
            logger.log(LogStatus.FAIL,"Test Failed"+result.getThrowable());
            logger.log(LogStatus.PASS,"<a href = '"+result.getName()+".png"+"'><span class='lable info'>Download SnapShot</span></a>");

        }
        else {
            logger.log(LogStatus.SKIP,"Test Skipped"+result.getThrowable());
        }
        driver.quit();
        //recorder.stop();

    }
}
