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
	var res = confirm("������ �����Ͻðڽ��ϱ�?");
	if (res == false) return;
	document.location.href = "${action}";
}
</script>

<o:button clickhandler="deleteHandler" text="����" id="deletebtn" styleclass="deletebtn" />