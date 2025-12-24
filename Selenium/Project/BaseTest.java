package project;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	 // One ExtentReports per run
    private static ExtentReports extent;
 
    public static WebDriver driver;

    // Thread-safe ExtentTest (one per test method)
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void setupReport() {

        String reportPath = System.getProperty("user.dir") + "/test-output/extentReport.html";
        System.out.println("==== reportpath === "+ reportPath);

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        
        spark.config().setDocumentTitle("JOB Automation Project Report");
        spark.config().setReportName("Test Report");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setTimeStampFormat("MMM dd, yyyy hh:mm:ss a");

        extent = new ExtentReports();
        extent.attachReporter(spark);

    }
    
	@BeforeClass (alwaysRun = true)
	public void setUp() {

		driver = new FirefoxDriver();

	}

    @BeforeMethod(alwaysRun = true)
    public void createTest(Method method) {
        // Create one ExtentTest per test method
        String testName = method.getDeclaringClass().getSimpleName() + " : " + method.getName();
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    @AfterMethod(alwaysRun = true)
    public void updateResult(org.testng.ITestResult result) {
        ExtentTest extentTest = test.get();
        if (extentTest == null) return;

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                extentTest.pass("Test passed");
                break;
            case ITestResult.FAILURE:
                extentTest.fail(result.getThrowable());
                break;
            case ITestResult.SKIP:
                extentTest.skip(result.getThrowable());
                break;
            default:
                extentTest.info("Test finished with status: " + result.getStatus());
        }

        // Clear ThreadLocal to avoid leaks
        test.remove();
    }
    
	@AfterClass (alwaysRun = true)
	public void tearDown() {
		
		driver.quit();

	}

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
    	
        if (extent != null) {
            extent.flush();
        }

    }

    // Helper to get current ExtentTest in tests
    protected ExtentTest getTest() {
        return test.get();
    }
    
	protected void logInfo(String msg) {
		test.get().info(msg);
	}

}
