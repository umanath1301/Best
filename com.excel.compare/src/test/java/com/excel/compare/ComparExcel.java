package com.excel.compare;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class ComparExcel {
//	public static ExtentTest test;
//	public static ExtentReports report;
	public static final Logger logger=LogManager.getLogger(ComparExcel.class);
@BeforeTest
public static void before() throws FileNotFoundException, IOException {
	File file=new File("C:\\Users\\VISWA SYSTEMS\\eclipse\\Excelcomparison\\logger.log");
	file.delete();
	Properties props=new Properties();
	props.load(new FileInputStream("log4j.properties"));
	PropertyConfigurator.configure(props);
//	report= new ExtentReports(System.getProperty("user.div")+"\\ExtentReportsResult.html");
//	report.assignProject("comparing excel and webelement");
	
}
@Test
public static void testcase1() throws InvalidFormatException, IOException {
	Batsmen bat=new Batsmen();
	bat.rank();
logger.info("firstcase started");

	
}
@Test
public static void testcase2() throws InvalidFormatException, IOException {
	Bowler bowl =new Bowler();
	bowl.rank();
	
	logger.info("second testcase started ");
	
}
@Test
public static void testcase3() throws InvalidFormatException, IOException {
	logger.info("third testcase started");
	
	T20 t=new T20();
	t.rank1();
	
}
@AfterTest
public static void end() {
	System.out.println("finished");
	
}

}
