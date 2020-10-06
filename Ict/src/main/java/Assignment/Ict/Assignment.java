
package Assignment.Ict;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
public class Assignment{
	WebDriver driver;
	String actualdata="Fantasy Island";
	ExtentHtmlReporter extenthtmlReport;
	ExtentReports extentReports;
	ExtentTest extentTest; 
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		
		String path=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GNARESH\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("useAutomationExtension", false);
		
		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://in.bookmyshow.com/bengaluru");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extenthtmlReport=new ExtentHtmlReporter("\\reports\\extentreport.html");
		extenthtmlReport.config().setDocumentTitle("Automation Report");
		extenthtmlReport.config().setReportName("Book My Show Search Report");
	
		extentReports.attachReporter(extenthtmlReport);
		
		extentReports.setSystemInfo("hostname", "DELL-PC");  
		extentReports.setSystemInfo("OS", "Windows");
	}
	
	@Test(priority = 0)
	public void BookMyShowTitle() throws IOException {
		extentTest=extentReports.createTest("Book My Show Title");
		extentTest.log(Status.INFO, "Book My Show Page Opened");
		System.out.println(driver.getTitle());
		
       Assert.assertEquals(driver.getTitle(), "Movie Tickets, Plays, Sports, Events & Cinemas near Bengaluru - BookMyShow");
	
		
	}
	@AfterTest
		public void QuitProgram() throws IOException {
		driver.close();
	}
}


