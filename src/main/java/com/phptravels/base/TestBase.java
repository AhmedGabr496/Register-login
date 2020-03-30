package com.phptravels.base;

import atu.testrecorder.ATUTestRecorder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public  class TestBase {

    public static WebDriver driver;
    public static Properties pro;
    public static ATUTestRecorder recorder;
    public static int AssertionResult = 0;

    public  static ExtentReports extent; // create report
    public  static ExtentTest logger;   // create test cases added to report

    public TestBase() throws IOException {
        pro = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/phptravels/config/config.properties");
        pro.load(fis);
    }

    public void intialize(String browser)
    {
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/com/phptravels/resources/chrome/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.firefox.driver", "src/main/java/com/phptravels/resources/firefox/geckodriver.exe");
            driver = new ChromeDriver();
        }
        driver.get(pro.getProperty("URL"));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


}
