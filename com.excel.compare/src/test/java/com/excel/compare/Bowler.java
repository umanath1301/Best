package com.excel.compare;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bowler {

	public void rank() throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\VISWA SYSTEMS\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.icc-cricket.com/rankings/mens/team-rankings/odi");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Test']")).click();
		List<WebElement>row=driver.findElements(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr"));
		int r=row.size();
		System.out.println("row  : "+r);
		File file=new File("E:\\New folder\\excel\\second.xlsx");
		XSSFWorkbook wbook=new XSSFWorkbook(file);
		XSSFSheet sheet=wbook.getSheet("Sheet1");
		int row2=sheet.getLastRowNum();
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		System.out.println("bowler ranking comparison");
		System.out.println("------------------------");
		for(int i=1;i<=r;i++) {
			Row row1=sheet.getRow(i);
			String one=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[1]")).getText();
			String two=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[2]")).getText();
			String three=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[3]")).getText();
			String four=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[4]")).getText();
			String five=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/section/div[3]/table/tbody/tr["+i+"]/td[5]")).getText();
				lhm.put(1, one);
				lhm.put(2, two);
				lhm.put(3, three);
				lhm.put(4, four);
				lhm.put(5, five);
				String a=row1.getCell(0).getStringCellValue();
				String b=row1.getCell(1).getStringCellValue();
				String c=row1.getCell(2).getStringCellValue();
				String d=row1.getCell(3).getStringCellValue();
				String e=row1.getCell(4).getStringCellValue();
				map.put(1, a);
				map.put(2, b);
				map.put(3, c);
				map.put(4, d);
				map.put(5, e);
				if(lhm.equals(map)) {
					System.out.println("true");
					row1.createCell(5).setCellValue("matched");
				}else {
					row1.createCell(5).setCellValue("mismatched");
				}
				lhm.clear();
				map.clear();
		}
		ComparExcel.logger.info("2 case");
		driver.close();
		File file1=new File("E:\\New folder\\excel\\22dgwtw4tgd.xlsx");
		FileOutputStream fos=new FileOutputStream(file1);
		wbook.write(fos);
		fos.close();
		
		}
		
	}


