package com.phptravels.util;

//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.phptravels.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtils extends TestBase {
    public TestUtils() throws IOException
    {
        super();
    }
    public static void takeSnapShot(String name) throws IOException
    {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("Reports\\"+name+".png"));
    }


    public static Object[][] getDataFromExcel(String SheetName) throws IOException
    {
        File testData= new File("src/main/java/com/phptravels/testdata/testData.xlsx");
        FileInputStream fis = new FileInputStream(testData); // load the excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet1 = workbook.getSheet(SheetName);
        int rows = sheet1.getLastRowNum();
        int columns = sheet1.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows][columns] ;


        for (int i =0;i<rows;i++)
        {
            for(int j =0;j<columns;j++)
            {
                data[i][j]=sheet1.getRow(i+1).getCell(j).toString();
            }
        }
        workbook.close();
        return data;
    }
}
