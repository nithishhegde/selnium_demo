package com.salesforce;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import com.salesforce.base.ExcelReader;
import com.salesforce.base.Keywords;

public class CreateTrialAccount {
	
	@Test
	public void createTrialAccountTest() {
		//open open open
		ArrayList data = ExcelReader.getData("D:/salesforcetest/CreateTrialAccountTestSuite.xlsx");
		Keywords key = new Keywords();
		for (int i = 0; i < data.size(); i++) {
			if(data.get(i).equals("open")) {
				key.open();
			}
			if(data.get(i).equals("url")) {
				String httpUrl = data.get(i+1).toString();
				key.url(httpUrl);
			}
			if(data.get(i).equals("input")) {
				String testData = data.get(i+1).toString();
				String objectName = data.get(i+2).toString();
				key.input(testData, objectName);
			}
			if(data.get(i).equals("click")) {
				String objectName = data.get(i+2).toString();
				key.click(objectName);
			}
			if(data.get(i).equals("closebrowser")) {
				key.closebrowser();
			}
			if(data.get(i).equals("inputbyname")) {
				String testData = data.get(i+1).toString();
				String objectName = data.get(i+2).toString();
				key.inputbyname(testData, objectName);
			}
		}
	}

}
