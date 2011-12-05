<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ attribute name="action" required="true" %>
<%@ attribute name="gridid" required="false" %>

<c:set var="grididDF" value="${gridid != null ? gridid : 'maingrid'}" />
<c:set var="actionDF" value="${action != null ? action : 'grid.do'}" />

<div id="searchformbox">
<form id="searchform" action="${actionDF}" target="${grididDF}" method="get">
	<input type="hidden" id="hiddenview" name="view" value="grid" />
	<jsp:doBody />
</form>
</div>