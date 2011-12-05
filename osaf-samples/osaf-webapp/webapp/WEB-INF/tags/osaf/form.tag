<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="formbox">
	<form:form id="form" method="post" commandName="model">
		<div class="formblock">
			<jsp:doBody />
		</div>
	</form:form>
</div>