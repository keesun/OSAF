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
<c:forEach var="row" items="${items}">
<c:choose>
	<c:when test="${isCOV == 'yes'}">
		<input id="${path}${varStatus.count}" name="${path}" type="checkbox" value="${row}" />
	</c:when>
	<c:otherwise>
		<input id="${path}${varStatus.count}" name="${path}" type="checkbox" value=
<%
String listvalue = (String)PageContextImpl.proprietaryEvaluate("${row." + this.valuepath + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false);
out.print("\"" + listvalue + "\"");
%>
	/>
	<label>
<%=PageContextImpl.proprietaryEvaluate("${row." + this.textpath + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false)%>
	</label>
	</c:otherwise>
</c:choose>
</c:forEach>
</select>
${desc}
<jsp:doBody />