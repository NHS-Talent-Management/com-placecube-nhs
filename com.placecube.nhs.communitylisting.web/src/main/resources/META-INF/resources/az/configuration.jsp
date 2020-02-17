<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ include file="../init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" cssClass="container-fluid-1280 mt-3" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />
	
	<c:forEach items="${availableGroupTypes}" var="availableGroupType">
		<aui:input name="groupTypes" type="checkbox" label="${availableGroupType.getValue()}" value="${availableGroupType.getValue()}" checked="${configuredGroupTypes.contains(availableGroupType.getValue())}"/>
	</c:forEach>
	
	<aui:input type="toggle-switch" name="matchingCategories" value="${matchingCategories}"/>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>

</aui:form>
