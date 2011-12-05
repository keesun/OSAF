<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>

<%@ attribute name="action" required="true" %>	
<%@ attribute name="width" required="true" %>
<%@ attribute name="height" required="true" %>
<%@ attribute name="paramname" required="true" %>
<%@ attribute name="gridid" required="false" %>

<c:set var="grididNS" value="${gridid != null ? gridid : 'maingrid'}" />

<script>
var ${gridid}updateHandler = function() {
	var selectedId = getGridSelectedId('${grididNS}');
	if (selectedId == null) { alert("������ �׸��� ���� �������ּ���"); return; }
	
	if ("${action}".indexOf("?") >= 0) {
			popup("${action}&${paramname}=" + selectedId + "&gridid=${grididNS}", "${gridid}popup", ${width}, ${height}, "yes", "yes");
		}
		else {
			popup("${action}?${paramname}=" + selectedId + "&gridid=${grididNS}", "${gridid}popup", ${width}, ${height}, "yes", "yes");
		}		
}
</script>

<o:button clickhandler="${gridid}updateHandler" text="����" id="${gridid}updatebtn" styleclass="updatebtn" />