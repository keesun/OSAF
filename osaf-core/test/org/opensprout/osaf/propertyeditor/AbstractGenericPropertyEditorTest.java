package org.opensprout.osaf.propertyeditor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.opensprout.osaf.model.Member;
import org.opensprout.osaf.model.MemberDao;
import org.opensprout.osaf.model.MemberGenericService;
import org.opensprout.osaf.model.support.MemberPropertyEditor;
import org.opensprout.osaf.propertyeditor.AbstractGenericPropertyEditor;
import org.opensprout.osaf.test.ApplicationContextTestBase;
import org.opensprout.osaf.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Integration test AbstractGenericPropertyEditor class.
 * @author Whiteship
 */
public class AbstractGenericPropertyEditorTest extends ApplicationContextTestBase{

	@Autowired
	MemberGenericService service;
	
	private AbstractGenericPropertyEditor<Member, MemberDao> editor;

	@Before
	public void setUp(){
		editor = new MemberPropertyEditor(applicationContext);
	}
	
	@Test
	public void create() throws Exception {
		assertNotNull(editor);
		assertNotNull(ReflectionUtils.getValue(MemberPropertyEditor.class, editor, "dao", true));
	}
	
	@Test
	public void getAsText() throws Exception {
		Member member = new Member();
		int id = 10;
		member.setId(id);
		editor.setValue(member);
		
		assertEquals(String.valueOf(id), editor.getAsText());
		
		editor.setValue(null);
		
		assertEquals("", editor.getAsText());
	}
	
	@Test
	public void setAsText() throws Exception {
		editor.setAsText("");
		assertEquals(null, editor.getValue());
		
		editor.setAsText(null);
		assertEquals(null, editor.getValue());
		
		Member member = new Member();
		int id = 10;
		member.setId(id);
	}
}
