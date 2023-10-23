package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.TestListener;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.nio.file.FileSystems;

public class BaseClass {
    public ExtentReports extent;
    public ExtentTest test;
    @BeforeTest
    public void BeforeTestCase()
    {
        extent = new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter(FileSystems.getDefault().getPath("").toAbsolutePath() +"\\src\\test\\java\\Report\\index.html");
        extent.attachReporter(spark);
    }
    @AfterTest
    public void AfterTestCase()
    {
        try
        {
            extent.flush();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(Status.FAIL, result.getThrowable());

        }
        if(result.getStatus()==ITestResult.SUCCESS)
        {
            test.log(Status.PASS,"Test Passed");

        }
    }
}
