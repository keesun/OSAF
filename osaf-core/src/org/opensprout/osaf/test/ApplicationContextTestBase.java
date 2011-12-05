/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.test;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

/**
 * Extend this class when you need to integration test.
 * This class uses DBUnit and Spring's AbstractTransactionalJUnit4SpringContextTests
 * @author Toby
 * @author Whiteship
 * @see org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
 */
@ContextConfiguration(locations = { "/test-datasource.xml", "/test-applicationContext.xml" })
@Transactional
public abstract class ApplicationContextTestBase extends AbstractTransactionalJUnit4SpringContextTests {
	enum DataType {EXCEL, FLATXML}

	protected SimpleJdbcTemplate jdbcTemplate;
	
	protected DataSource dataSource;

	protected HttpServletRequest req = new MockHttpServletRequest();
	protected HttpServletResponse res = new MockHttpServletResponse();
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	protected void cleanInsertFlatXmlData(String fileSource) throws Exception {
		insertData(fileSource, DataType.FLATXML, DatabaseOperation.CLEAN_INSERT);
	}	
	protected void cleanInsertXlsData(String fileSource) throws Exception {
		insertData(fileSource, DataType.EXCEL, DatabaseOperation.CLEAN_INSERT);
	}
	
	private void insertData(String fileSource, DataType type, DatabaseOperation operation) throws Exception {
		InputStream sourceStream = new ClassPathResource(fileSource, getClass()).getInputStream();
		
		IDataSet dataset = null;
		if (type == DataType.EXCEL) {
			dataset = new XlsDataSet(sourceStream);
		}
		else if (type == DataType.FLATXML) {
			dataset = new FlatXmlDataSet(sourceStream);
		}
		
		operation.execute(
				new DatabaseConnection(DataSourceUtils.getConnection(dataSource)), dataset);
	}
	
	protected void insertFlatXmlData(String fileSource) throws Exception {
		insertData(fileSource, DataType.FLATXML, DatabaseOperation.INSERT);
	}
	
	protected void insertXlsData(String fileSource) throws Exception {
		insertData(fileSource, DataType.EXCEL, DatabaseOperation.INSERT);
	}
}