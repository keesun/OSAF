<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>
<%@ include file="/include/gridheader.jsp" %>

<o:gridpage popupheight="400" popupwidth="700" >
<c:set var="startNumValue" value="${startNum}" />

	<d:table name="list" class="maingrid" id="maingrid">
		<d:column title="No">
			<a href="javascript:sendToUpdate(<c:out value="${maingrid.id}" />)">
				${startNumValue}
			</a>
<c:set var="startNumValue" value="${startNumValue + 1}" />
		</d:column>
		<d:column property="name" title="이름" />
		<d:column property="loginId" title="아이디" />
		<d:column property="sex" title="성별" decorator="org.opensprout.sample.model.enumeration.SexType" />
		<d:column property="location" title="사는곳" />
		<d:column property="birthday" title="생일" />
		<d:column property="hobbies" title="취미" />
	</d:table>
</o:gridpage>

<%@ include file="/include/gridfooter.jsp" %>