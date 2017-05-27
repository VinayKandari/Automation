package org.testcase.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Start {

	public static void main(String[] args) throws IOException {

		XmlSuite suite1 = new XmlSuite();
		suite1.setName("S1");
		
		XmlTest t1 = new XmlTest(suite1);
		t1.setName("T1");
		
		File f = new File("C:\\New folder\\KeywordDriven.xlsx");
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet s1 = wb.getSheet("Sheet1");
		int r = s1.getPhysicalNumberOfRows();
		ArrayList<XmlClass> Ac = new ArrayList<XmlClass>();
		for (int i=1; i<r; i++){
			
			XSSFRow r1 = s1.getRow(i);
			XSSFCell c1 = r1.getCell(4);
			
			if (c1.getStringCellValue().equalsIgnoreCase("Y")){
				
				XSSFCell cp = r1.getCell(2);
				XSSFCell cc = r1.getCell(3);
				XmlClass co = new XmlClass(cp.getStringCellValue() + "." + cc.getStringCellValue());
				Ac.add(co);
			}
		}
		
		wb.close();
		
		t1.setXmlClasses(Ac);
		
		ArrayList<XmlTest> At = new ArrayList<XmlTest>();
		At.add(t1);
		
		suite1.setTests(At);
		
		ArrayList<XmlSuite> As = new ArrayList<XmlSuite>();
		As.add(suite1);
		
		TestNG tng = new TestNG();
		tng.setXmlSuites(As);
		tng.run();

	}

}
