package com.techfios.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
    private XSSFWorkbook workBook;
	private XSSFSheet workSheet;
	
	
	public ReadExcel(FileInputStream fis) {
		try {
            workBook = new XSSFWorkbook(fis);
            workSheet = workBook.getSheetAt(0);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
	}
	
	public LinkedHashMap<Integer, String[]> returnAllDataInMapFormat(){
		
		Iterator<Row> rowIter = workSheet.rowIterator();
		int i = 0;
		int arrayIndex = 0;
		LinkedHashMap<Integer, String[]> dataMap = new LinkedHashMap<Integer, String[]>();
		
		while (rowIter.hasNext()) {
			
			Row r = rowIter.next();
			
			Iterator<Cell> cellIter = r.iterator();
			String[] cellArray = new String[2];
			
			while (cellIter.hasNext()) {
				
				Cell c = cellIter.next();
				cellArray[arrayIndex] = c.toString();
				arrayIndex++;

			}
			arrayIndex = 0;
			dataMap.put(i, cellArray);
//			System.out.println(i + " : " + cellArray[0] + " & " + cellArray[1]);
			i++;
			
		}
		
		return dataMap;
//		System.out.println(1 + " : " + dataMap.get(0)[0] + " & " + dataMap.get(0)[1]);
//		System.out.println(2 + " : " + dataMap.get(1)[0] + " & " + dataMap.get(1)[1]);
		
	}

}
