/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Toby
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-datasource.xml", "/test-applicationContext.xml"})
public class TestDataSourceTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	public void connection() throws SQLException {
		Connection c = dataSource.getConnection();
		assertNotNull(c);
		assertTrue(((ComboPooledDataSource)dataSource).getJdbcUrl().indexOf("jdbc:derby:target/testdb") >= 0);
		c.close();
	}
}
