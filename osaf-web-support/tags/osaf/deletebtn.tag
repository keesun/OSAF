<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>

<%@ attribute name="action" required="false" %>	

<%
	if (action == null) {
		jspContext.setAttribute("action", "delete.do?id=" + request.getParameter("id"));
	}
%>

<script>
var deleteHandler = function() {
	var res = confirm("정말로 삭제하시겠습니까?");
	if (res == false) return;
	document.location.href = "${action}";
}
</script>

<o:button clickhandler="deleteHandler" text="삭제" id="deletebtn" styleclass="deletebtn" />