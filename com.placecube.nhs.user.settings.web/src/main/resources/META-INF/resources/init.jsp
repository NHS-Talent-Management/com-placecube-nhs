<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.placecube.nhs.user.settings.constants.MVCCommandKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var="portletNamespace">
	<portlet:namespace/>
</c:set>

<c:set var="windowStateNormal" value="<%= LiferayWindowState.NORMAL.toString() %>" />
<c:set var="windowStateMaximized" value="<%= LiferayWindowState.MAXIMIZED.toString() %>" />