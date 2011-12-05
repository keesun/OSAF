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
	<label>${label} : </label>
	<c:choose>
		<c:when test="${isCOV == 'yes'}">
			<form:checkboxes path="${path}" items="${items}" />
		</c:when>
		<c:otherwise>
<%
valuepath = (valuepath != null) ? valuepath : "value";
textpath = (textpath != null) ? textpath : "descr";
String propertyValues = (String)PageContextImpl.proprietaryEvaluate("${model." + path + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false);
%>	
			<c:forEach items="${items}" varStatus="varStatus" var="row">
			<span>
				<input id="${path}${varStatus.count}" name="${path}" type="checkbox" value=
<%
String listvalue = (String)PageContextImpl.proprietaryEvaluate("${row." + this.valuepath + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false);
out.print("\"" + listvalue + "\"");
if (propertyValues.contains(listvalue)) out.print(" checked=\"yes\"");
%>
				/>
				<label>
<%
String textvalue = (String)PageContextImpl.proprietaryEvaluate("${row." + this.textpath + "}", java.lang.String.class, (PageContext)this.getJspContext(), null, false);
out.print(textvalue);
%>		
				</label>
			</span>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	&nbsp;${desc}
	<form:errors path="${path}" cssClass="error" />
</p>