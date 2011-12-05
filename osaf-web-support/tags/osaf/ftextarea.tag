<%@ tag pageEncoding="euc-kr" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="cols" required="true" %>
<%@ attribute name="rows" required="true" %>

<p id="${path}row">
	<label>${label} :</label>
	<form:textarea path="${path}" cols="${cols}" rows="${rows}" />
	<form:errors path="${path}" />
</p>