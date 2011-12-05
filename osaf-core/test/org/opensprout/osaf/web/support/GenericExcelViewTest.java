package org.opensprout.osaf.web.support;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.util.ExcelUtils;
import org.opensprout.osaf.web.support.GenericExcelView;
import org.opensprout.osaf.web.support.GridColumn;
import org.opensprout.osaf.web.support.GridColumn.Align;
import org.opensprout.osaf.web.support.GridColumn.Type;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ModelMap;

/**
 * Unit test GenericExcelView class
 * @author Whiteship
 */
public class GenericExcelViewTest {

	GenericExcelView excelView;
	
	@Before
	public void setup(){
		excelView = new GenericExcelView();
	}
	
	@Test
	public void create() throws Exception {
		assertNotNull(excelView);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void buildExcelDocument() throws Exception {
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();
		List<GridColumn> columns = makeStubGridColumnList();
		List list = makeStubList();
		ModelMap map = makeStubMap(columns, list);
		HSSFWorkbook book = new HSSFWorkbook();
		
		excelView.buildExcelDocument(map, book, req, res);

		assertThat((String)res.getHeader("Content-Disposition"), is("attachment; filename=member.xls"));
		HSSFSheet sheet = book.getSheet("member");
		assertThat(ExcelUtils.getStringValue(sheet.getRow(0), 0), is("NAME"));
		assertThat(ExcelUtils.getStringValue(sheet.getRow(1), 0), is("keesun"));
	}

	@SuppressWarnings("unchecked")
	private ModelMap makeStubMap(List<GridColumn> columns, List list) {
		ModelMap map = new ModelMap();
		map.put("list", list);
		map.put("columns", columns);
		map.put("modelName", "member");
		return map;
	}

	@SuppressWarnings("unchecked")
	private List makeStubList() {
		List<Member> list = new ArrayList<Member>();
		
		Member member = new Member();
		member.setName("keesun");
		list.add(member);
		
		return list;
	}

	private List<GridColumn> makeStubGridColumnList() {
		List<GridColumn> columns = new ArrayList<GridColumn>();
		
		GridColumn column = new GridColumn();
		column.setAlign(Align.CENTER);
		column.setFormat("string");
		column.setHeader("NAME");
		column.setPath("name");
		column.setType(Type.STRING);
		columns.add(column);

		return columns;
	}
	
}
