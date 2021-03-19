package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilites.GetDriverf;
import Utilites.Utilities;
import page.Main1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class payonnerreg {

	private ExtentReports extent;
	private ExtentTest myTest;
	private static String reportPaht = System.getProperty("user.dir") + "\\test-output\\payonnerreg.html";
	private WebDriver driver;
	private String baseurl;
	private Actions actions;
	private Main1 main;

	private static final Logger logger = LogManager.getLogger(payonnerreg.class);

	@BeforeClass

	public void beforeClass() {

		extent = new ExtentReports(reportPaht);
		extent.loadConfig((new File(System.getProperty("user.dir") + "\\resource\\payonner-extent-config.xml")));
		// myTest=extent.startTest("");

		baseurl = "https://www.payoneer.com/";
		driver = GetDriverf.getDriver("chrome", baseurl);

		main = new Main1(driver);
	}

	@Test(priority = 1, enabled = true, description = "open register page")
	public void goregister(Method method) throws InterruptedException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
		logger.debug("debug it");
		main.goregister();
	}

	@Test(priority = 2, enabled = true, description = "open register page")
	public void choosesupplier(Method method) throws InterruptedException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
		logger.debug("debug it");
		main.choosesupllier();
		 
	}
	@Test(priority = 3, enabled = true, description = "open register page")
	public void register(Method method) throws InterruptedException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
		main.register();
		 
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			myTest.log(LogStatus.FAIL, "Test failed: " + result.getName());
			myTest.log(LogStatus.FAIL, "Test failed reason: " + result.getThrowable());
			myTest.log(LogStatus.FAIL, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));
		} else {
			myTest.log(LogStatus.PASS, "the producte  was sort by popularety");
			myTest.log(LogStatus.PASS, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));
		}
		myTest.log(LogStatus.INFO, "Finish test", "Finish test ");

		extent.endTest(myTest);
		// driver.get(baseurl);

	}

	@AfterClass
	public void afterClass() {

		extent.flush();
		// driver.quit();
		extent.close();
	}

}
