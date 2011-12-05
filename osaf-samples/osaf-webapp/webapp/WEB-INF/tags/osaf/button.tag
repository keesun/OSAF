<%@ tag pageEncoding="euc-kr" %>
<%@ attribute name="id" required="true" %>	<%-- button id --%>
<%@ attribute name="text" required="true" %>	<%-- text displayed in the button --%>
<%@ attribute name="clickhandler" required="true" %>	<%-- if true, user's own click event handler --%>
<%@ attribute name="styleclass" required="true" %> <%-- TODO: default --%>

<%-- ===================================================================================== --%>
<%--                               Button Anchor                                           --%>
<%-- ===================================================================================== --%>
<a href="javascript:void(1)" id="${id}" class="${styleclass}">${text}</a>
	
<%-- ===================================================================================== --%>
<%--                            Click Event Handler                                        --%>
<%-- ===================================================================================== --%>
<script type="text/javascript"> 
	Event.observe("${id}", "click", ${clickhandler}, false);	
</script>