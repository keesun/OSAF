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

import static org.mockito.Mockito.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.junit.Test;

/**
 * Unit test ExcelUtil class
 * @author Whiteship
 */
public class ExcelUtilsTest {

	@Test
	public void addCellHSSFRowIntString() {
		HSSFRow row = mock(HSSFRow.class);
		HSSFCell cell = mock(HSSFCell.class);
		int colIndex = 1;
		String value = "name";
		
		stub(row.createCell((short)colIndex)).toReturn(cell);
		
		ExcelUtils.addCell(row, colIndex, value);
		verify(cell).setEncoding(HSSFCell.ENCODING_UTF_16);
		verify(cell).setCellValue((String)value);
	}

	@Test
	public void addCellHSSFRowIntStringWithNull() {
		HSSFRow row = mock(HSSFRow.class);
		HSSFCell cell = mock(HSSFCell.class);
		int colIndex = 1;
		String value = null;
		
		stub(row.createCell((short)colIndex)).toReturn(cell);
		
		ExcelUtils.addCell(row, colIndex, value);
		verify(cell).setEncoding(HSSFCell.ENCODING_UTF_16);
		verify(cell).setCellValue("");
	}

//	@Test
//	public void addCellHSSFRowIntDouble() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddCellHSSFRowIntInteger() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddCellHSSFRowIntDate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddCellHSSFRowIntStringHSSFCellStyle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddCellHSSFRowIntDoubleHSSFCellStyle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddCellHSSFRowIntIntegerHSSFCellStyle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddCellHSSFRowIntDateHSSFCellStyle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetTitleCellStyle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetIntegerValue() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetStringValue() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetDateValue() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testConfirmCellValue() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testProcessExcelFileStringIntMapOfStringObjectExcelUploadTemplate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testProcessExcelFileStringExcelUploadTemplate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testProcessExcelFileStringIntExcelUploadTemplate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetHSSFWorkbook() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCopySheet() {
//		fail("Not yet implemented");
//	}

}
