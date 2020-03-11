<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Company" %>

<liferay-util:buffer var="html">
    <liferay-util:include page="/login.portal.jsp" servletContext="<%= application %>" />
</liferay-util:buffer>

<%
	//Change register url to hardcoded page sign-up for fast login portlet, along with label
String regexForCreateAnonymousAccountLink = "<a [^>]*\\bhref\\s*=\\s*\"([^\"]*create_anonymous_account\\s*\")";
html = html.replaceAll(regexForCreateAnonymousAccountLink, "<a href=\"/sign-up\"");
		
String regexForCreateAnonymousAccountTarget = "<a [^>]*\\bhref\\s*=\\s*\"([^\"]*sign-up\\s*\")[^>]*\\btarget=\"(_self\")";
html = html.replaceAll(regexForCreateAnonymousAccountTarget, "<a href=\"/sign-up\" target=\"_top\"");		

String regexForCreateAnonymousAccountLabel = "<span class=\"taglib-text \">"+LanguageUtil.get(request,"guest")+"</span>";
html = html.replaceAll(regexForCreateAnonymousAccountLabel, "<span class=\"taglib-text \">"+LanguageUtil.get(request,"create-account")+"</span>");

//Change register url to hardcoded page sign-up
String regexForCreateAccountLink = "<a [^>]*\\bhref\\s*=\\s*\"([^\"]*create_account\\s*\")";
html = html.replaceAll(regexForCreateAccountLink, "<a href=\"/sign-up\"");
%>
<%= html %>

