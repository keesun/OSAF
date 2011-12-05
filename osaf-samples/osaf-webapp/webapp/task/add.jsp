<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>
<%@ include file="/include/popupheader.jsp" %>

<o:popuppage title="작업등록">
	<o:formbuttons />

	<o:form>
		<o:formblock>
			<o:ftext label="이름" path="name" size="10" maxlength="15" />
		</o:formblock>
	</o:form>
</o:popuppage>

<%@ include file="/include/popupfooter.jsp" %>