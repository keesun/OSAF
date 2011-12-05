<%@ tag pageEncoding="euc-kr" %>
<%@ tag import="java.util.*, java.text.*, org.apache.jasper.runtime.PageContextImpl" %>
<%@ tag import="org.opensprout.osaf.web.support.PageNavigation" %>
<%@ tag import="org.opensprout.osaf.data.support.OrderPage" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ variable name-given="startNum" %>
<%@ attribute name="popupheight" required="true" %>
<%@ attribute name="popupwidth" required="true" %>
 
<script>
var windowresize = function() {
	var iframe = parent.$('maingrid');
 
 	// 참고 frm.contentWindow.document.documentElement.scrollHeight;
    iframe.height = document.documentElement.scrollHeight + 20;
}
</script>
<%PageNavigation pn = new PageNavigation((OrderPage)request.getAttribute("orderPage"), request, null); %>
<div class="navibar">
	<span class="navicount">
		 [ ${orderPage.startRowno}/${orderPage.rowcount} ]
	</span>
	<span class="pagesize">
		페이지당 목록수 <select 
			onchange="document.location.href='<%=pn.getUriWithoutPageSize()%>&pagesize=' + this.options[this.selectedIndex].value">
			<c:forEach var="ps" items="${orderPage.pageSizes}">
				<option value="${ps.value}"
				<c:if test="${ps.value==orderPage.pagesize}">selected="selected"</c:if>
				>${ps.descr}</option>
			</c:forEach>
		</select>
	</span>
	<span class="pagenavi">
		<%out.println(pn.getNavigationBar());%>
	</span>
</div>

<c:set var="startNum" value="${orderPage.startRowno}" scope="request" />
<%
int count = (Integer)request.getAttribute("startNum"); 
jspContext.setAttribute("startNum", count);
%>

<div class="clear">

<jsp:doBody  />

</div>

<script type="text/javascript"> 
function sendToUpdate(selectedId) { 
	popup("update.do?id=" + selectedId + "&gridid=maingrid", "maingridpopup", ${popupwidth}, ${popupheight}, "yes", "yes");
}
</script> 