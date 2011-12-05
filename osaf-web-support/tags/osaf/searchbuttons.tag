<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>

<%@ attribute name="popupwidth" required="true" %>
<%@ attribute name="popupheight" required="true" %>

<o:buttons>
	<o:searchbtn />
	<o:addbtn action="add.do" height="${popupheight}" width="${popupwidth}" />
	<jsp:doBody />
</o:buttons>