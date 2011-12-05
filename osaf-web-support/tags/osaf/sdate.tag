<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="desc" required="false" %>
<%@ attribute name="format"required="false" %>

<c:set var="formatNS" value="${format != null ? format : '%Y/%m/%d'}" />

<label>${label} :</label>
<input id="${path}" name="${path}" type="text" size="10" maxlength="10" value="${value}" /> ${desc}
<a href="javascript:void(0)" id="${path}calbtn"><img src="/images/calendar.gif"  border="0" style="vertical-align: bottom"/></a> 
<script type="text/javascript">
    Calendar.setup({
        inputField     :    "${path}",      // id of the input field
        ifFormat       :    "${formatNS}",       // format of the input field
        showsTime      :    false,            // will display a time selector
        button         :    "${path}calbtn",   // trigger for the calendar (button ID)
        singleClick    :    false,           // double-click mode
        step           :    1                // show all years in drop-down boxes (instead of every other year as default)
    });
</script>