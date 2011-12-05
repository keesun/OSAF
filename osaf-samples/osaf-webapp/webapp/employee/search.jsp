<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>
<%@ include file="/include/searchheader.jsp" %>

<o:searchpage title="�������">
	<o:searchbuttons popupheight="400" popupwidth="700" />

	<o:searchform action="grid.do">
		<o:searchrow>
			<o:stext path="name" label="�̸�" size="20" maxlength="30" />
			<o:sselect path="location" label="����" items="${ref.locations}" isCOV="yes" />
			<o:sdate path="birthday" label="����" />
		</o:searchrow>
		<o:searchrow>
			<o:sradiobuttons path="sex" label="����" items="${ref.sexType}" />
		</o:searchrow>
		<o:searchrow>
			<o:scheckboxes path="hobbies" label="���" items="${ref.hobbyType}" />
		</o:searchrow>
	</o:searchform>
</o:searchpage>

<%@ include file="/include/searchfooter.jsp" %>