package com.qaclickacademy.utility;




import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	//identify testcases column by scanning the entire first row
	//scan whole column to find test case names
	//then find the testcase which we need i.e purchase
	//then grab row of that testcase i.e purchase----
	//pull all the data of that row and feed it into test
	public ArrayList<String> getdata(String testcasename) throws IOException
	{
		ArrayList<String> a=new ArrayList<String>();
		//to read excel file location
		FileInputStream file=new FileInputStream("C:\\Users\\hp\\Desktop\\demodata.xlsx");
		//object for access the excel file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//to move to the desired sheet like sheet1,sheet2 ...etc
		int sheets=workbook.getNumberOfSheets();//sheet count
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				//identify testcases column by scanning the entire first row
				Iterator<Row> r=sheet.iterator();
				Row firstrow=r.next();//we got first row
				Iterator<Cell> ce=firstrow.cellIterator();
				int k=0;
				int column = 0;
				while(ce.hasNext())//checking next column is present or not
				{
					//getting the string of that cell using getstringcellvalue 
					//and comparing with testcases name
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						column=k;//to get the index of the testcases column
					}
					k++;
				}
				System.out.println(column);
				//then find the testcase which we need i.e purchase
				//then grab row of that testcase i.e purchase----
				while(r.hasNext())
				{
					Row row=r.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						//after you grab the row =pull all the data of that row and feed it into test
						Iterator<Cell> cv=row.cellIterator();
						while(cv.hasNext())
						{
							//System.out.println(cv.next().getStringCellValue());
							//adding all the data of purchase into arraylist
							/* a.add(cv.next().getStringCellValue()); */
							
							 Cell c=cv.next();
							 if(c.getCellType()==CellType.STRING)
							  //check the datatype of data it is string or number like that 
							  {  
							  a.add((c.getStringCellValue())); 
							  } 
							  else 
							  {
							  a.add(NumberToTextConverter.toText(c.getNumericCellValue())); 
							  }
							 
						}
				    }
				
				}
			}
			
			
		}
		return a;
	
		
	}

	public static void main(String[] args) 
	{
	}

	

}
