package org.opensprout.osaf.web.support;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.web.support.GridColumn;
import org.opensprout.osaf.web.support.GridColumn.Align;
import org.opensprout.osaf.web.support.GridColumn.Type;

/**
 * Unit test GridColumn class
 * @author Whiteship
 */
public class GridColumnTest {
	
	GridColumn gridColumn;
	
	@Before
	public void setup(){
		gridColumn = new GridColumn();
	}
	
	@Test
	public void align() throws Exception {
		assertNotNull(GridColumn.Align.CENTER);
		assertNotNull(GridColumn.Align.LEFT);
		assertNotNull(GridColumn.Align.RIGHT);
	}
	
	@Test
	public void type() throws Exception {
		assertNotNull(GridColumn.Type.DATE);
		assertNotNull(GridColumn.Type.TIMESTAMP);
		assertNotNull(GridColumn.Type.STRING);
		assertNotNull(GridColumn.Type.INTEGER);
		assertNotNull(GridColumn.Type.DOUBLE);
	}
	
	@Test
	public void properties() throws Exception {
		Align center = Align.CENTER;
		String format = "format";
		String header = "header";
		Type date = Type.DATE;
		String path = "path";

		gridColumn.setAlign(center);
		gridColumn.setFormat(format);
		gridColumn.setHeader(header);
		gridColumn.setType(date);
		gridColumn.setPath(path);
		
		assertThat(gridColumn.getAlign(), is(center));
		assertThat(gridColumn.getFormat(), is(format));
		assertThat(gridColumn.getHeader(), is(header));
		assertThat(gridColumn.getPath(), is(path));
		assertThat(gridColumn.getType(), is(date));
	}
	
	@Test
	@SuppressWarnings("static-access")
	public void findColType() throws Exception {
		assertThat(gridColumn.findColType("StRing"), is(Type.STRING));
		assertThat(gridColumn.findColType("daTe"), is(Type.DATE));
		assertThat(gridColumn.findColType("tiMestamp"), is(Type.TIMESTAMP));
		assertThat(gridColumn.findColType("Integer"), is(Type.INTEGER));
		assertThat(gridColumn.findColType("douBle"), is(Type.DOUBLE));
	}

}
