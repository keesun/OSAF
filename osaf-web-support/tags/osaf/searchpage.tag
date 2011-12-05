<%@ tag pageEncoding="euc-kr" %>
<%@ attribute name="title" required="true" %>

<div id="title">
	<h1>${title}</h1>
</div>
		
<jsp:doBody />
		
<div id="maingridbox" class="ifrmbox">
	<iframe id="maingrid" name="maingrid" src="" height="300" scrolling="auto" frameborder="0" class="ifrm">
	</iframe>
</div>