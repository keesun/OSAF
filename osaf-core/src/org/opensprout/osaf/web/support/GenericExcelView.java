/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.web.support;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.mvel.MVEL;
import org.opensprout.osaf.util.ExcelUtils;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * GenericExcelView class
 * @author Toby
 */
public class GenericExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map model, HSSFWorkbook book,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		List list = (List) model.get("list");
		List<GridColumn> columns = (List<GridColumn>) model.get("columns");
		String modelName = (String) model.get("modelName");

		// header
		res.setHeader("Content-Disposition", "attachment; filename=" + modelName + ".xls");
		
		// create sheet
        HSSFSheet sheet = book.createSheet(modelName);
		
		setHeaders(sheet.createRow(0), columns);
		makeColumnsRow(sheet, columns, list);
		
	}

	private void setHeaders(HSSFRow row, List<GridColumn> columns) {
        short idx = 0;
        for(GridColumn column : columns) {
        	ExcelUtils.addCell(row, idx++, column.getHeader());
        }
	}

	@SuppressWarnings("unchecked")
	private void makeColumnsRow(HSSFSheet sheet, List<GridColumn> columns, List list) {
		int rowidx = 1;
		for(Object entity : list) {
			HSSFRow row = sheet.createRow(rowidx++);
			int colidx = 0;
			for(GridColumn column : columns) {
				if (column.getType() == GridColumn.Type.DOUBLE) {				
					ExcelUtils.addCell(row, colidx++, MVEL.eval(column.getPath(), entity, Double.class));
				}
				else if (column.getType() == GridColumn.Type.INTEGER) {
					ExcelUtils.addCell(row, colidx++, MVEL.eval(column.getPath(), entity, Integer.class));
				}
				else if (column.getType() == GridColumn.Type.DATE) {
					ExcelUtils.addCell(row, colidx++, MVEL.eval(column.getPath(), entity, Date.class));
				}
				else {
					ExcelUtils.addCell(row, colidx++, MVEL.eval(column.getPath(), entity, String.class));
				}
				
			}
		}
	}

}
