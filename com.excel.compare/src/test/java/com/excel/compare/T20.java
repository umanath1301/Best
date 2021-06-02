package com.excel.compare;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T20 {

	public void rank1() throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\VISWA SYSTEMS\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.icc-cricket.com/rankings/mens/team-rankings/odi");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='T20I']")).click();
		
		List<WebElement>row=driver.findElements(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr"));
		System.out.println("row  :"+row.size());
		File file=new File("E:\\New folder\\excel\\third.xlsx");
		XSSFWorkbook wbook=new XSSFWorkbook(file);
		XSSFSheet sheet=wbook.getSheet("Sheet1");
		List<String> l2=new ArrayList<String>();
		List<String>l=new ArrayList<String>();
		
		for(int i=1;i<=row.size();i++) {          
			String one=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[1]")).getText();
			String two=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[2]")).getText();
			String three=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[3]")).getText();
			String four=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[4]")).getText();
			String five=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[5]")).getText();
			l2.add(one);
			l2.add(two);
			l2.add(three);
			l2.add(four);
			l2.add(five);
			Row row1=sheet.getRow(i);
			String a=row1.getCell(0).getStringCellValue();
			String b=row1.getCell(1).getStringCellValue();
			String c=row1.getCell(2).getStringCellValue();
			String d=row1.getCell(3).getStringCellValue();
			String e=row1.getCell(4).getStringCellValue();
			l.add(a);
			l.add(b);
			l.add(c);
			l.add(d);
			l.add(e);
			if(l2.equals(l)) {
				System.out.println("pass");
				row1.createCell(5).setCellValue("matched");
			}else {
				System.out.println("fail");
				row1.createCell(5).setCellValue("mismatched");
			}
			l2.clear();
			l.clear();
		}
		ComparExcel.logger.info("3 case");
		driver.close();
		File file1=new File("E:\\New folder\\excel\\3dresu4g4weghlt.xlsx");
		FileOutputStream fos=new FileOutputStream(file1);
		wbook.write(fos);
		fos.close();
		
		
	}

}
