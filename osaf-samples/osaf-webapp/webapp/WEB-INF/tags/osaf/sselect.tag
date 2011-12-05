<%@ tag pageEncoding="euc-kr" %>
<%@ tag import="org.apache.jasper.runtime.PageContextImpl" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ attribute name="path" required="true" %> 
<%@ attribute name="label" required="false" %>
<%@ attribute name="items" type="java.util.Collection" required="true" %>
<%@ attribute name="valuepath" required="false" %> <%-- value property name of elements of the list --%>
<%@ attribute name="textpath" required="false" %> <%-- text property name of elements of the list --%>
<%@ attribute name="desc" required="false" %>
<%@ attribute name="isCOV" required="false" %>

<%
valuepath = (valuepath != null) ? valuepath : "value";
textpath = (textpath != null) ? textpath : "descr";
%>

<label>${label} :</label>

<select id="${path}" name="${path}">
	<option value="0">All</option> 			
	<c:forEach var="row" items="${items}">
<c:choose>
	<c:when test="${isCOV == 'yes'}">
		<option value="${row}">${row}</option>
	</c:when>
	<c:otherwise>
		<%-- option loop --%>
		<option value=
<%
String listvalue = (String)PageContextImpl.proprietaryEvaluate("${row." + this.valuepath + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false);
out.print("\"" + listvalue + "\"");
%>
	> 
<%=PageContextImpl.proprietaryEvaluate("${row." + this.textpath + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false)%>
		</option>
	</c:otherwise>
</c:choose>
	</c:forEach>
</select>
${desc}
<jsp:doBody />