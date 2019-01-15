package RestProject.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import RestProject.Test.utils.ReadFile;
import RestProject.Test.utils.RestAssuredAPI;

public class Executable {
ReadFile readfile=new ReadFile();
String file="D://Ankush_Data//Workspace//Test//resources//TestData.xlsx";

ExtentReports reports = new ExtentReports(System.getProperty("user.dir")+"\\resources\\reports.html");

ExtentTest test;
	@Test(priority=1)
	public void createNewUsers() throws Exception{
		test = reports.startTest("test start for create New Users");
		Boolean value=true;
		String url="https://reqres.in/api/users";
		String Body=readfile.ReadFile(file, "Sheet1", "Value");
		System.out.println(Body+": file");
		String resp=RestAssuredAPI.POST(url, Body);
		if(resp.contains("George")){
			test.log(LogStatus.PASS, "George is verified successfully");
			System.out.println("George is verified successfully");
			
		}else{
			test.log(LogStatus.FAIL, "     George is not present     ");

			Assert.fail("     George is not present     ");
					}
		reports.endTest(test);
	}
	@Test(priority=2)
	public void UpdateNewUsers() throws Exception{
		test = reports.startTest("test start for Update New Users");
		String url="https://reqres.in/api/users/2";
		String Body=readfile.ReadFile(file, "Sheet1", "Value");
		int statusCode=RestAssuredAPI.PUT(url, Body);
		int success=200;
		if(statusCode==success){
			test.log(LogStatus.PASS, "200 statusCode is verified successfully");
			System.out.println("200 statusCode is verified successfully");
			
		}else{
			test.log(LogStatus.FAIL, "     200 statusCode is not verified    ");
			Assert.fail("     200 statusCode is not verified     ");
			
		}
		reports.endTest(test);
	}
	@Test(priority=3)
	public void DeleteNewUsers() throws Exception{
		test = reports.startTest("test start for Delete New Users");
		test.log(LogStatus.PASS, " verified successfully without verification");
		String url="https://reqres.in/api/users/2";
		String Body=readfile.ReadFile(file, "Sheet1", "Value");
		RestAssuredAPI.Delete(url, Body);
		reports.endTest(test);
		reports.flush();
	}
}
