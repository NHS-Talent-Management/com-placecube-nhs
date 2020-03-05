<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://placecube.com/tld/nhs-forms-ui" prefix="nhs-forms-ui" %>
<%@ taglib uri="http://placecube.com/tld/nhs-dates-ui" prefix="nhs-dates-ui" %>

<%@page import="com.placecube.nhs.user.profile.constants.MVCCommandKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var="portletNamespace">
	<portlet:namespace/>
</c:set>

<c:set var="windowStateNormal" value="<%= LiferayWindowState.NORMAL.toString() %>" />
<c:set var="windowStateMaximized" value="<%= LiferayWindowState.MAXIMIZED.toString() %>" />