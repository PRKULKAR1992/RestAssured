package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.nio.file.FileSystems;

public class BaseClass {
    public ExtentReports extent;
    @BeforeTest
    public void BeforeTestCase(){
        extent = new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter(FileSystems.getDefault().getPath("").toAbsolutePath() +"\\src\\test\\java\\Report\\index.html");
        extent.attachReporter(spark);
    }
    @AfterTest
    public void AfterTestCase(){
        extent.flush();
    }
}
