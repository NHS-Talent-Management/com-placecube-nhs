<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Company" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>

<liferay-util:buffer var="html">
    <liferay-util:include page="/login_redirect.portal.jsp" servletContext="<%= application %>" />
</liferay-util:buffer>

<%= html %>

<%
Company companyForLoginRedirect = PortalUtil.getCompany(request);
User userForLoginRedirect  = PortalUtil.getUser(request);

boolean liferayAnonymousAndStrangers = ParamUtil.getBoolean(request, "anonymousUser") && companyForLoginRedirect.isStrangers();
boolean liferayNotStrangerAndNullUser = !companyForLoginRedirect.isStrangers() && (userForLoginRedirect == null);
%>

<c:if test="<%= !liferayAnonymousAndStrangers && !liferayNotStrangerAndNullUser%>">
	<aui:script use="aui-modal,liferay-util-window,aui-base,aui-dialog,aui-dialog-iframe">
		$(function() {
			setTimeout(function() {
				Liferay.Util.getOpener().close();
			}, 3000);
		});
	</aui:script>
</c:if>
 