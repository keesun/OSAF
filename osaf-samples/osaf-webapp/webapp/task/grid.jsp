<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>
<%@ include file="/include/gridheader.jsp" %>

<o:gridpage popupheight="400" popupwidth="600">
	<c:set var="startNumValue" value="${startNum}" />

	<d:table name="list" class="maingrid" id="maingrid">
		<d:column title="No">
			<a href="javascript:sendToUpdate(<c:out value="${maingrid.id}" />)">
				${startNumValue}
			</a>
			<c:set var="startNumValue" value="${startNumValue + 1}" />
		</d:column>
		<d:column property="name" title="ÀÌ¸§" />
	</d:table>
</o:gridpage>
	
<%@ include file="/include/gridfooter.jsp" %>
