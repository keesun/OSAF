<%@ tag pageEncoding="euc-kr" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags/osaf" %>

<script>
	var excelHandler = function() {
		$("hiddenview").value = "excel";
		$("searchform").submit();	
		$("hiddenview").value = "grid";
	}
</script>

<o:button clickhandler="excelHandler" text="�����ٿ�ε�" id="excelbtn" styleclass="downbtn" />