<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>

<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="size" required="true" %>
<%@ attribute name="maxlength" required="true" %>
<%@ attribute name="desc" required="false" %>

<o:felement type="password" label="${label}" path="${path}" maxlength="${maxlength}" size="${size}" desc="${desc}" />