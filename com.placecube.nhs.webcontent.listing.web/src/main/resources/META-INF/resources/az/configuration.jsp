<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ include file="../init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" cssClass="container-fluid-1280 mt-3" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<aui:input name="structureKey" type="text" value="${configuration.structureKey()}" required="true"/>
	
	<aui:input type="toggle-switch" name="matchingCategories" value="${configuration.matchingCategories()}"/>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>

</aui:form>
