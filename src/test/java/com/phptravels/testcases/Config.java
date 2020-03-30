package com.phptravels.testcases;

import com.relevantcodes.extentreports.ExtentReports;
import com.phptravels.base.TestBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Config extends TestBase {
    public Config() throws IOException {
        super();
    }
    @BeforeSuite
    public void start()
    {
        //True , delete old report
    extent = new ExtentReports("Reports\\Report.HTML",true);
    extent.addSystemInfo("Pixelogic","SDET");
    extent.addSystemInfo("TesterName","Ahmed Gabr");
    extent.addSystemInfo("Programming Language","JAVA");
    extent.addSystemInfo("Frame Work","Maven & TestNG");
    extent.addSystemInfo("OS","Windows");

    }

    @AfterSuite
    public void end()
    {
        extent.flush();
    }



}
