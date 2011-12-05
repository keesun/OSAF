<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>
<%@ include file="/include/popupheader.jsp" %>

<o:popuppage title="�������">
	<o:updatebuttons />
	
	<o:form>
		<o:ftext label="�̸�" path="name" size="10" maxlength="20" />
		<o:ftext label="���̵�" path="loginId" size="15" maxlength="20" desc="�ִ� 20�ڸ����� �Է� �� �� �ֽ��ϴ�." />
		<o:fpassword label="�н�����" path="password" size="10" maxlength="16" desc="�ִ� 16�ڸ����� �Է� �� �� �ֽ��ϴ�." />
		<o:fradiobuttons label="����" path="sex" items="${ref.sexType}" />
		<o:fcheckboxes label="���" path="hobbies" items="${ref.hobbyType}" />
		<o:fselect label="����" path="location" items="${ref.locations}" isCOV="yes" />
		<o:ftextarea label="�޸�" path="memo" rows="3" cols="50" />
	</o:form>
</o:popuppage>

<%@ include file="/include/popupfooter.jsp" %>