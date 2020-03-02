<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<liferay-util:buffer var="html">
    <liferay-util:include page="/dynamic_include/com.liferay.login.web/navigation/facebook.portal.jsp" servletContext="<%= application %>" />
</liferay-util:buffer>


<%
String regexForLabel = "(<span class=\"taglib-text)(\\s)*(\">Facebook<\\/span>)";
String iconToAdd = "<span class=\"facebook-icon\"><\\/span>";
String valueToReplace = "<span class=\"taglib-text\">Connect with Facebook<\\/span>";
html = html.replaceFirst(regexForLabel, iconToAdd+valueToReplace);

html = html.replaceFirst("class=\" lfr-icon-item taglib-icon\"", "class=\" lfr-icon-item taglib-icon facebook-sso\"");
%>

<%= html %>
