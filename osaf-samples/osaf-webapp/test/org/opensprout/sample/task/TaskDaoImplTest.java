package org.opensprout.sample.task;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.opensprout.osaf.data.support.OrderPage;
import org.opensprout.osaf.test.ApplicationContextTestBase;
import org.opensprout.sample.task.support.TaskParams;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskDaoImplTest extends ApplicationContextTestBase {

	@Autowired
	TaskDaoImpl taskDao;
	
	@Test
	public void di() {
		assertNotNull(taskDao);
	}
	
	@Test
	public void find() throws Exception {
		insertFlatXmlData("testdata.xml");
		assertThat(taskDao.getAll().size(), is(1));
		
		TaskParams params = new TaskParams();
		params.setName("te");
		assertThat(taskDao.search(params, new OrderPage()).size(), is(1));

		params.setName("asd");
		assertThat(taskDao.search(params, new OrderPage()).size(), is(0));
	}
	
}
