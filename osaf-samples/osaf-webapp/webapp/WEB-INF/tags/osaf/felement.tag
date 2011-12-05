<%@ tag pageEncoding="euc-kr" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="size" required="true" %>
<%@ attribute name="maxlength" required="true" %>
<%@ attribute name="desc" required="false" %>
<%@ attribute name="type" required="true" %>

<p id="${path}row">
	<label>${label} :</label>
	<c:choose>
		<c:when test="${type =='text'}">
			<form:input path="${path}" size="${size}" maxlength="${maxlength}" />
		</c:when>
		<c:when test="${type =='password'}">
			<form:password path="${path}" size="${size}" maxlength="${maxlength}" showPassword="true" />
		</c:when>
	</c:choose>
	&nbsp;${desc}
	<form:errors path="${path}" cssClass="error" />
</p>