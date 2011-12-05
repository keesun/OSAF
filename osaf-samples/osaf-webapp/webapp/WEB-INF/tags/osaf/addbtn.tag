<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>

<%@ attribute name="action" required="true" %>	
<%@ attribute name="gridid" required="false" %>	
<%@ attribute name="width" required="true" %>
<%@ attribute name="height" required="true" %>

<c:set var="grididNS" value="${gridid != null ? gridid : 'maingrid'}" />

<script>
var ${gridid}addHandler = function() {
	if ("${action}".indexOf("?") >= 0) {
		popup("${action}&gridid=${grididNS}", "${gridid}popup", ${width}, ${height}, "yes", "yes");
	}
	else {
		popup("${action}?gridid=${grididNS}", "${gridid}popup", ${width}, ${height}, "yes", "yes");
	}
}
</script>

<o:button clickhandler="${gridid}addHandler" text="Ãß°¡" id="${gridid}addbtn" styleclass="addbtn" />