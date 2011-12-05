/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.opensprout.osaf.exception.ExcelUploadException;

/**
 * Util class for Excel POI
 * @author Toby
 * @author Whiteship
 */
public class ExcelUtils {

	public static HSSFCell addCell(HSSFRow row, int colIndex, String value) {
		if( value == null ) value = "";
		HSSFCell c = row.createCell((short)colIndex);
		c.setEncoding(HSSFCell.ENCODING_UTF_16);
		c.setCellValue((String)value);		
		return c;
	}
    
	public static HSSFCell addCell(HSSFRow row, int colIndex, Double value) {
		HSSFCell c = row.createCell((short)colIndex);
		if (value != null)
			c.setCellValue(value);
		else 
			c.setCellValue("");
		
		return c;
	}
	
	public static HSSFCell addCell(HSSFRow row, int colIndex, Integer value) {
		HSSFCell c = row.createCell((short)colIndex);
		if (value != null)
			c.setCellValue(value);
		else 
			c.setCellValue("");
		
		return c;
	}  
	
	public static HSSFCell addCell(HSSFRow row, int colIndex, Date value) {
		HSSFCell c = row.createCell((short)colIndex);
		if (value != null)
			c.setCellValue(value);
		else 
			c.setCellValue("");
		
		return c;
	}    	
	
	public static HSSFCell addCell(HSSFRow row, int colIndex, String value, HSSFCellStyle style) {
		HSSFCell cell = addCell(row, colIndex, value);
		cell.setCellStyle(style);		
		return cell;
	}
    
	public static HSSFCell addCell(HSSFRow row, int colIndex, Double value, HSSFCellStyle style) {
		HSSFCell cell = addCell(row, colIndex, value);
		cell.setCellStyle(style);		
		return cell;
	}
	
	public static HSSFCell addCell(HSSFRow row, int colIndex, Integer value, HSSFCellStyle style) {
		HSSFCell cell = addCell(row, colIndex, value);
		cell.setCellStyle(style);		
		return cell;
	}
	
	public static HSSFCell addCell(HSSFRow row, int colIndex, Date value, HSSFCellStyle style) {
		HSSFCell cell = addCell(row, colIndex, value);
		cell.setCellStyle(style);		
		return cell;
	}	
	
	public static HSSFCellStyle getTitleCellStyle(HSSFWorkbook wb) {
		HSSFCellStyle titleStyle = wb.createCellStyle();
        HSSFFont titleFont = wb.createFont();
//        titleFont.setFontHeight((short)50);
        titleStyle.setFont(titleFont);
        return titleStyle;
	}	
	
	public static int getIntegerValue(HSSFRow row, int i) {
		HSSFCell c = row.getCell((short) i);
		if (c == null)
			return 0;
		return (int) c.getNumericCellValue();
	}
	
	public static String getStringValue(HSSFRow row, int i) {
		HSSFCell c = row.getCell((short)i);
		if (c == null) return "";
		return c.getStringCellValue();
	}

	public static Date getDateValue(HSSFRow row, int i) {
		HSSFCell c = row.getCell((short) i);
		if (c == null)
			return new Date();
		return c.getDateCellValue();
	}
	
	public static boolean confirmCellValue(HSSFCell cell, String value) {
//		if (row == null)
//			return false;
//		HSSFCell c1 = row.getCell((short) index);
		if (cell == null)
			return false;
		return value.equals(cell.getStringCellValue());
	}

	/**
	 * Read uploaded exel file and make entity object.
	 * @param excelFile uploaded excel file.
	 * @param startRow first row number to map entity.
	 * @param values additional infomations to map entity.
	 * @param callback validate and mapping template.
	 */
	public static void processExcelFile(String excelFile, int startRow, Map<String, Object> values, ExcelUploadTemplate callback) {
		POIFSFileSystem fs = null;
		HSSFWorkbook wb = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(excelFile);
			fs = new POIFSFileSystem(fileInputStream);
			wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);

			if (sheet.getLastRowNum() < 1)
				throw new ExcelUploadException("Invalid Excel File - empty rows");
			if (!callback.checkColumnHeader(sheet.getRow(0)))
				throw new ExcelUploadException("Invalid Excel File - Invalid Column Header.");

			for (int i = startRow; i <= sheet.getLastRowNum() ; i++) {
				HSSFRow row = sheet.getRow(i);
				callback.makeEntity(row, values);
			}
		} catch (Exception e) {
			throw new ExcelUploadException(e);
		} finally {
			try {
				if(fileInputStream != null){
					fileInputStream.close();
					fileInputStream = null;
				}
			} catch (IOException e) {
				throw new ExcelUploadException(e);
			}
		}
	}
	
	/**
	 * default start row number is 1(this is second row of excel sheet.) 
	 * no additional inforamtion.
	 * @param excelFile uploaded excel file.
	 * @param callback validate and mapping template.
	 */
	public static void processExcelFile(String excelFile, ExcelUploadTemplate callback) {
		processExcelFile(excelFile, 1, null, callback);
	}

	/**
	 * no additional information.
	 * @param excelFile uploaded excel file.
	 * @param startRow first row number to map entity.
	 * @param callback validate and mapping template.
	 */
	public static void processExcelFile(String excelFile, int startRow, ExcelUploadTemplate callback) {
		processExcelFile(excelFile, startRow, null, callback);
	}
	
	public static HSSFWorkbook getHSSFWorkbook(String file) {
		POIFSFileSystem fs = null;
		HSSFWorkbook formwb = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			fs = new POIFSFileSystem(fileInputStream);
			formwb = new HSSFWorkbook(fs);
		} catch (Exception e) {
			throw new ExcelUploadException(e);
		} finally {
			try {
				if(fileInputStream != null){
					fileInputStream.close();
					fileInputStream = null;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return formwb;
	}
	
	/**
	 * Copy sheet to sheet, from start row to end row.
	 * @param from from Sheet
	 * @param to to Sheet
	 * @param fromRowCnt start row number
	 * @param toRowCnt length of copying rows
	 */
	@SuppressWarnings("unchecked")
	public static void copySheet(HSSFSheet from, HSSFSheet to, int fromRowCnt, int toRowCnt) {
		HSSFRow fromRow = null;
		HSSFRow toRow = null;
		
		for(int i = fromRowCnt ; i <= toRowCnt ; i++){
			fromRow = from.getRow(i);
			toRow = to.createRow(i);
			Iterator<HSSFCell> iterator = fromRow.cellIterator();
			short col = 0;
			while(iterator.hasNext()){
				HSSFCell cell = iterator.next();
				addCell(toRow, col++, cell.getStringCellValue(), cell.getCellStyle());
			}
		}
	}
}
