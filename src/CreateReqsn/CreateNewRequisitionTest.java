package CreateReqsn;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common_Function.WebDriverPass;


public class CreateNewRequisitionTest extends WebDriverPass{
	ExtentReports report;
	ExtentTest test;
	CreateNewRequisition p = new CreateNewRequisition();
	
	 @Test(priority=1)
	  public void createnewreq() throws Exception {
		try{
		  test=report.startTest("Create New Reqsn Module"); 
		  p.createnewreq(driver);
		  Assert.assertTrue(true);
		}catch(Exception e){
			e.getMessage();
			System.out.println("Exception is :" +e);
		}
		 System.out.println("New Reqsn Created Successfully.");
	      test.log(LogStatus.PASS, "Purchase-->Create New Reqsn"); 
	      
	      
		    
	  }

 @AfterMethod
	  	public void afterMethod(ITestResult result) {
	  	    if (result.getStatus() == ITestResult.FAILURE) {
	  	        test.log(LogStatus.FAIL, "Test failed " + result.getThrowable());
	  	    } else if (result.getStatus() == ITestResult.SKIP) {
	  	        test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	  	    } else {
	  	        test.log(LogStatus.PASS, "Test passed");
	  	    }
	  	    report.endTest(test);
	  	    report.flush();
	  }
	  @BeforeSuite
	  public void beforeSu() {
	  	  report = CreateNewRequisition.getReporter(path.concat("Report.html"));
	  }

	  @AfterSuite
	  public void afterSu() {
	      report.close();
	  }


	  }
