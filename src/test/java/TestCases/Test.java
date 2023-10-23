package TestCases;


import TestData.DataCoditioning;
import TestData.TestDataProvider;
import Utilities.BaseClass;
import Utilities.DataParser;
import Utilities.DataReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static io.restassured.RestAssured.*;

public class Test extends BaseClass{
    String token;
    ExtentTest test;
    @org.testng.annotations.Test
    public void TokenGeneration() throws IOException {
         test =extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());

        RestAssured.baseURI = DataReader.ConfigFileReader().getProperty("endPoint1");
       String response=given().log().all().header("Content-Type","application/json").header("Host","mahauthorizationapi.azurewebsites.net")
               .body(DataCoditioning.PayLoadForTokenGeneration("a4b6fc7f-2eea-4658-b193-70b7696f68f1","WHATSAPP"))
               .when().post(DataReader.ConfigFileReader().getProperty("resource1")).then().log().all().assertThat()
               .statusCode(200).extract().response().asString();
        var responseNode=test.createNode("Response Data");
        responseNode.info(response);

       JsonPath js= DataParser.JsonParsing(response);
       this.token=js.getString("Token");
       System.out.println(token);
    }

   @org.testng.annotations.Test(dependsOnMethods = "TokenGeneration", dataProvider = "data-provider", dataProviderClass = TestDataProvider.class)
    public void LoginRequest(String country, String surname, String mobileNo, String smartCardNo) throws IOException {
       test =extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());

       RestAssured.baseURI =DataReader.ConfigFileReader().getProperty("endPoint2");
       String response=given().log().all().header("Content-Type","application/json")
               .header("Host","qa-api.dstvafrica.com")
               .header("Authorization","Bearer "+token)
               .queryParam("channel","mydstv")
               .queryParam("BusinessUnit","dstv")
               .body(DataCoditioning.PayloadForLoginRequest(country, surname, mobileNo, smartCardNo))
               .when().post(DataReader.ConfigFileReader().getProperty("resource2"))
               .then().log().all().assertThat().statusCode(200).extract().response().asString();
       var responseNode=test.createNode("Response Data");
       responseNode.info(response);
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
