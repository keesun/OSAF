<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>
<%@ include file="/include/popupheader.jsp" %>

<o:popuppage title="�۾�����">
	<o:updatebuttons />

	<o:form>
		<o:formblock>
			<o:ftext label="�̸�" path="name" size="50" maxlength="50" />
		</o:formblock>
	</o:form>
</o:popuppage>

<%@ include file="/include/popupfooter.jsp" %>