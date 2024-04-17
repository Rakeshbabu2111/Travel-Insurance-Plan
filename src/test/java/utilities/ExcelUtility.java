package utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import pageObjects.CarInsurancePOM;
import pageObjects.HomePagePOM;
import pageObjects.TravelInsurancePOM;



public class ExcelUtility {
	WebDriver driver;
	TravelInsurancePOM travelInsurance=new TravelInsurancePOM(BaseClass.getDriver());
	
	public void captureInsuranceDetails() throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "TravelInsurance-" + timeStamp + ".xlsx";
		FileOutputStream file=new FileOutputStream(".\\ExcelData\\"+repName);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet st=wb.createSheet();
		XSSFRow row1=st.createRow(0);
		row1.createCell(0).setCellValue("Travel Insurance Company");
		row1.createCell(1).setCellValue("Total Premium Amount");
		
		for(int r=1;r<4;r++) {
			XSSFRow currentRow=st.createRow(r);
			String companyName=travelInsurance.InsuranceCompanyNames_txt.get(r-1).getText();
			String Amount=travelInsurance.InsuranceCompanyPrice_txt.get(r-1).getText();
			for(int c=0;c<2;c++) {
				if(c==0) {
					currentRow.createCell(c).setCellValue(companyName);
				}
				if(c==1) {
					currentRow.createCell(c).setCellValue(Amount);
					
				}
			}
		}
		wb.write(file);
		wb.close();
		
	}
	
	public void captureHealthInsuranceMenuItems() throws IOException {
		HomePagePOM homepagepom=new HomePagePOM(BaseClass.getDriver());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "HealthInsuranceMenuItems-" + timeStamp + ".xlsx";
		FileOutputStream file=new FileOutputStream(".\\ExcelData\\"+repName);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet st=wb.createSheet();
		XSSFRow row1=st.createRow(0);
		row1.createCell(0).setCellValue("Health Insurance Menu Items");
		for(int r=1;r<homepagepom.listOfMenuItems_txt.size();r++) {
			XSSFRow currentRow=st.createRow(r);
			currentRow.createCell(0).setCellValue(homepagepom.listOfMenuItems_txt.get(r).getText());
		}
		wb.write(file);
		wb.close();
	}
	
	
	public String getCellDataContactDetails(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		
		FileInputStream file=new FileInputStream(xlfile);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet st=wb.getSheet(xlsheet);
		XSSFRow row=st.getRow(rownum);
		XSSFCell cell=row.getCell(colnum);
		String data;
		try 
		{
			//data=cell.toString();
			DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            wb.close();
            return data;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		file.close();
		return data;
	}
	
	public static void setCellData() throws IOException
	{
		CarInsurancePOM ci=new CarInsurancePOM(BaseClass.getDriver());
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "ErrorMessages-" + timeStamp + ".xlsx";
		FileOutputStream file=new FileOutputStream(".\\ExcelData\\"+repName);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet st=wb.createSheet();
		XSSFRow row1=st.createRow(0);
		row1.createCell(0).setCellValue(ci.emailErrorMsg_txt.getText());
		row1.createCell(1).setCellValue(ci.MobileNoErrorMsg_txt.getText());
		wb.write(file);
		wb.close();
		
	}
	
	


}
