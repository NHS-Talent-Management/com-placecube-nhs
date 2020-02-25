<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.module.configuration.ConfigurationException"%>
<%@page import="com.placecube.nhs.communitylisting.constants.MVCCommandKeys"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<liferay-ui:error exception="<%=ConfigurationException.class %>" message="invalid-configuration"/>