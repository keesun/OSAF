<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>
<%@ include file="/include/popupheader.jsp" %>

<o:popuppage title="사원수정">
	<o:updatebuttons />
	
	<o:form>
		<o:ftext label="이름" path="name" size="10" maxlength="20" />
		<o:ftext label="아이디" path="loginId" size="15" maxlength="20" desc="최대 20자리까지 입력 할 수 있습니다." />
		<o:fpassword label="패스워드" path="password" size="10" maxlength="16" desc="최대 16자리까지 입력 할 수 있습니다." />
		<o:fradiobuttons label="성별" path="sex" items="${ref.sexType}" />
		<o:fcheckboxes label="취미" path="hobbies" items="${ref.hobbyType}" />
		<o:fselect label="국적" path="location" items="${ref.locations}" isCOV="yes" />
		<o:ftextarea label="메모" path="memo" rows="3" cols="50" />
	</o:form>
</o:popuppage>

<%@ include file="/include/popupfooter.jsp" %>