<%@ tag pageEncoding="euc-kr" %>

<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="labelwidth" required="false" %>
<%@ attribute name="size" required="true" %>
<%@ attribute name="maxlength" required="true" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="desc" required="false" %>

<label>${label} :</label>
<input id="${path}" name="${path}" type="text" size="${size}" maxlength="${maxlength}" value="${value}" /> ${desc}