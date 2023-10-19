package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    static ExtentTest test;
    static ExtentReports extent;
    @BeforeClass
    public void Setup(){

        extent = new ExtentReports();
    }
}
