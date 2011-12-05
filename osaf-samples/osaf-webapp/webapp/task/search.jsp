<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>
<%@ include file="/include/searchheader.jsp" %>

<o:searchpage title="작업관리">
	<o:searchbuttons popupheight="400" popupwidth="600" />

	<o:searchform action="grid.do">
		<o:searchrow>
			<o:stext label="이름" path="name" size="20" maxlength="30" />
		</o:searchrow>
	</o:searchform>
</o:searchpage>

<%@ include file="/include/searchfooter.jsp" %>