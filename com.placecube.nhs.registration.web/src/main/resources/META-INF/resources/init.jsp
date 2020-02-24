<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/journal" prefix="liferay-journal" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://placecube.com/tld/nhs-forms-ui" prefix="nhs-forms-ui" %>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.placecube.nhs.registration.constants.WebContentArticles"%>
<%@page import="com.placecube.nhs.registration.constants.MVCCommandKeys"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var="portletNamespace">
	<portlet:namespace/>
</c:set>
