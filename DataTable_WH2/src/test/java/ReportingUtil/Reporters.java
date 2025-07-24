package ReportingUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporters {
	
	
	ExtentReports extent;

	String ReportName="";
	
	public void CreateHTMLReport(String ReportTitle)
	{
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		 
		// ReportName ="TC01_Skills"+"_"+strDate;
		 
		 ReportName =ReportTitle+"_"+strDate;
		 
		String htmlFile="target"+"//"+ReportName+"//"+ReportName+".html";
		
		extent= new ExtentReports();
		//ExtentSparkReporter spark = new ExtentSparkReporter("target/Sparks.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(htmlFile);
		extent.attachReporter(spark);

	}
	
	public void logger(WebDriver driver,String logger1,String logger2) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		String str=capture(driver,ReportName);
		extent.createTest(logger1)
	    .log(Status.PASS, logger2)
	    .addScreenCaptureFromPath(str)
	   .pass(MediaEntityBuilder.createScreenCaptureFromPath
			   (str).build());
	}
	
	public void closeReport()
	{
		extent.flush();
	}

	
	public static  String capture(WebDriver driver,String ReportName) throws IOException
    {
				
		 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
		 Date now = new Date();
		 String strDate = sdfDate.format(now);
		
		
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        
		String userDirectory = System.getProperty("user.dir");
		userDirectory=userDirectory+"\\"+"target";
		System.out.println(userDirectory);
        
        
        String dest = userDirectory+"\\"+ReportName+"\\"+ReportName+"_"+strDate+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }

}
