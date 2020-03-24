<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/journal" prefix="liferay-journal" %>
<%@ taglib uri="http://placecube.com/tld/nhs-forms-ui" prefix="nhs-forms-ui" %>
<%@ taglib uri="http://placecube.com/tld/nhs-search-ui" prefix="nhs-search-ui" %>
<%@ taglib uri="http://placecube.com/tld/nhs-user-ui" prefix="nhs-user-ui" %>

<%@page import="com.placecube.nhs.talentdashboard.web.constants.MVCCommandKeys"%>
<%@page import="com.placecube.nhs.talentdashboard.web.constants.WebContentArticles"%>
<%@page import="com.placecube.nhs.taglibs.constants.SearchFilterConstants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var="portletNamespace">
	<portlet:namespace/>
</c:set>

<c:set var="windowStateNormal" value="<%= LiferayWindowState.NORMAL.toString() %>" />
<c:set var="windowStateMaximized" value="<%= LiferayWindowState.MAXIMIZED.toString() %>" />