<%@ tag pageEncoding="euc-kr" %>
<%@ tag import="org.apache.jasper.runtime.PageContextImpl" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="items" type="java.util.Collection" required="true" %>
<%@ attribute name="desc" required="false" %>
<%@ attribute name="valuepath" required="false" %> <%-- value property name of elements of the list --%>
<%@ attribute name="textpath" required="false" %> <%-- text property name of elements of the list --%>
<%@ attribute name="isCOV" required="false" %> <%-- isCollectionOfValueType --%>

<p id="${path}row">
	<label>${label} :</label>
	<c:choose>
		<c:when test="${isCOV == 'yes'}">
			<form:select path="${path}" items="${items}" />
		</c:when>
		<c:otherwise>
			<select name="${status.expression}" id="${status.expression}">		
				<option value="0">--Select--</option>	
<%
valuepath = (valuepath != null) ? valuepath : "value";
textpath = (textpath != null) ? textpath : "descr";
String statusValue = (String)PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)this.getJspContext(), null, false);
%>		
				<%-- option loop --%>
				<c:forEach var="row" items="${items}">
					<option value=
<%
String listvalue = (String)PageContextImpl.proprietaryEvaluate("${row." + this.valuepath + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false);
out.print("\"" + listvalue + "\"");
if (listvalue.equals(statusValue)) out.print(" selected=\"selected\"");
%>
					> 
<%=PageContextImpl.proprietaryEvaluate("${row." + this.textpath + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false)%>
					</option>
				</c:forEach>
			</select>
		</c:otherwise>
	</c:choose>
	&nbsp;${desc}
	<form:errors path="${path}" cssClass="error" />
</p>