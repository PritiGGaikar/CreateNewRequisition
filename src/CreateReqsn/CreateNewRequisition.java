package CreateReqsn;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;


import common_Function.RW;

public class CreateNewRequisition extends RW{
	
		
	

	private static ExtentReports report;
	public synchronized static ExtentReports getReporter(String filePath) { //allow only one thread to access the shared resource,To prevent thread interference.
	    if (report == null) {
	    	report = new ExtentReports(path.concat("Report\\Purchase_Admin_Report.html"));
	        
	        report
	            .addSystemInfo("Host Name", "Priti") //Environment Setup For Report
	            .addSystemInfo("Environment", "QA");
	    }
	    
	    return report;
	}



	
	
	public void createnewreq(WebDriver driver1) throws Exception {

	
	 	
		WebDriver driver = driver1;

		for(k=0;k<=350;k++){
			
	     ArrayList<Row> row= OR_Purchase_m.searchSheet("CreateNewReqsn",0,9);
	    ArrayList<Row> row1=input_purc_m.searchSheet("CreateNewReqsn", 0,0);
	 	
		String input_purc_URL =url.concat(input_purc_m.getData(0, 0, 2));
	 	driver1.get(input_purc_URL);
	    
	 	 
	    		    
	    
	    
			for(int i=0;i<row.size();i++)
			{
				String strValue=""; 
				String LocatingType=row.get(i).getCell(1).getStringCellValue();
				String strControl=row.get(i).getCell(2).getStringCellValue();
				 for(int j=0;j<row1.size();j++)
				 {
					 if(row.get(i).getCell(0)!=null)
						{
						
						 	if(row1.get(j).getCell(1)!=null)
							{
							  if(row.get(i).getCell(0).toString().compareTo(row1.get(j).getCell(1).toString())==0)
							  {
								  strValue=row1.get(j).getCell(2).toString();
								  
								  switch(row1.get(j).getCell(2).getCellTypeEnum()){
								     
								     case NUMERIC: 
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getNumericCellValue());
								    	 break;
								     case STRING:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     case BOOLEAN:
								    	 strValue=String.valueOf(row1.get(j).getCell(2).getBooleanCellValue());
								    	 break;
								     default:
								    	 strValue=row1.get(j).getCell(2).getStringCellValue();
								    	 break;
								     }
								     
							  }
							}
						}
				 
				 }
				 
				
					
					if(row.get(i).getCell(10)!=null)
					{
							
						
						String strControlTypeKey=row.get(i).getCell(10).toString();

						if (strControlTypeKey.compareTo("Value_Ctrl") != 0) {
							if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
								click_element(driver, LocatingType, strControl); 
								Thread.sleep(k);
								Thread.sleep(5000);
							}

							if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
							
								dropdown(driver, LocatingType, strControl, strValue);
								Thread.sleep(k);
							
								
							}

							if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
								sendkeys(driver, LocatingType, strControl, strValue); 
								Thread.sleep(k);
							}

							if (strControlTypeKey.compareTo("Alert_accept") == 0) {
								click_element(driver, LocatingType, strControl); 
								Alert(driver);
								Thread.sleep(k);
							}
							if (strControlTypeKey.compareTo("Url_Ctrl") == 0) {
								driver.get(strValue); 
								Thread.sleep(k);

							}

							
							if (strControlTypeKey.compareTo("WindowSwitch_Ctrl") == 0) {
								Thread.sleep(k);
								Thread.sleep(k);
								click_element(driver, LocatingType, strControl);
								Thread.sleep(k);
							 WindowSwitchto(driver);
							 Thread.sleep(k);
							}

							
							if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
								clear_element(driver, LocatingType, strControl); 																										
								Thread.sleep(k);
							}

							if (strControlTypeKey.compareTo("Gettext_Ctrl") == 0) {
								 gettext(driver, LocatingType, strControl, row.get(i + 1).getCell(2).getStringCellValue());
			                      Thread.sleep(k);
								}
							if (strControlTypeKey.compareTo("DropdownCheckBox_Ctrl") == 0) {

								dropdownCheckbox(driver, LocatingType, strControl,strControl,strControl);
			                      Thread.sleep(k);
							}
							if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

							 frameSwitchto(driver, LocatingType, strControl);
			                      Thread.sleep(k);
							
					}
							if (strControlTypeKey.compareTo("Upload_Ctrl") == 0) {
							uploadFile(driver,LocatingType, strControl, strControl,strValue, strControl, strControl);
							   Thread.sleep(k);
								
							}
							
							if (strControlTypeKey.compareTo("GetAttribute_Ctrl") == 0) {

								 getAttribute(driver, LocatingType, strValue, row.get(i + 1).getCell(2).getStringCellValue());
			                      Thread.sleep(k);
								}
							if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {

								frameSwitchBack(driver);
				                      Thread.sleep(k);
				                      click_element(driver, LocatingType, strControl);
				                      Thread.sleep(k);
								
						}
							
												}
			}
			}}}}