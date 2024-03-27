package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class  ExtentReporter {
public static ExtentReports getExtentReport() {
	String extentReportFilepath = System.clearProperty("user.dir")+"\\reports\\extentreport.html";
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFilepath);
	sparkReporter.config().setReportName("ninja Automation Results");
	sparkReporter.config().setDocumentTitle("ninja Automation Results");
	ExtentReports extentreports = new ExtentReports();
	extentreports.attachReporter(sparkReporter);
	extentreports.setSystemInfo("Selenium","4.4.0");
	extentreports.setSystemInfo("Operating system", "windows11");
	extentreports.setSystemInfo("Executed By","shankar");
	return extentreports;
	
}
}
