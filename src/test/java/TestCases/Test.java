package TestCases;


import Utilities.BaseClass;
import Utilities.DataParser;
import Utilities.DataReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static io.restassured.RestAssured.*;

public class Test extends BaseClass{
    String token;

    @org.testng.annotations.Test
    public void TokenGeneration() throws IOException {

         ExtentTest test =extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        RestAssured.baseURI = DataReader.ConfigFileReader().getProperty("endPoint1");
       String response=given().log().all().header("Content-Type","application/json").header("Host","mahauthorizationapi.azurewebsites.net").body("{\n" +
                       "    \"PlatformName\": \"WHATSAPP\",\n" +
                       "    \"GUID\": \"a4b6fc7f-2eea-4658-b193-70b7696f68f1\"\n" +
                       "}")
               .when().post(DataReader.ConfigFileReader().getProperty("resource1")).then().log().all().assertThat()
               .statusCode(200).extract().response().asString();
        var responseNode=test.createNode("Response Data");
        responseNode.info(response);

       JsonPath js= DataParser.JsonParsing(response);
       this.token=js.getString("Token");
       System.out.println(token);
    }

   @org.testng.annotations.Test
    public void LoginRequest() throws IOException {
       RestAssured.baseURI =DataReader.ConfigFileReader().getProperty("endPoint2");
       given().header("Content-Type","application/json")
               .header("Host","qa-api.dstvafrica.com")
               .header("Authorization","Bearer "+token)
               .queryParam("channel","mydstv")
               .queryParam("BusinessUnit","dstv")
               .body("{\n" +
               "  \"country\": \"malawi\",\n" +
               "  \"surname\": \"BANGURA\",\n" +
               "  \"mobileNumber\": \"\",\n" +
               "  \"smartCardNumber\": \"8061164508\"\n" +
               "}").when().post(DataReader.ConfigFileReader().getProperty("resource2")).then().log().all().assertThat().statusCode(200);
    }



}
