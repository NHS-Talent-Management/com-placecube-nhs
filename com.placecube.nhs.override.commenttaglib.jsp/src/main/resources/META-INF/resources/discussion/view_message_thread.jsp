<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<liferay-util:buffer var="html">
    <liferay-util:include page="/discussion/view_message_thread.portal.jsp" servletContext="<%= application %>" />
</liferay-util:buffer>

<%
String valueToReplace = "<span class=\"lfr-btn-label\">Reply as...<\\/span>";
String updatedValue = "<span class=\"lfr-btn-label\">Join to comment...<\\/span>";
html = html.replaceFirst(valueToReplace, updatedValue);
%>

<%= html %>