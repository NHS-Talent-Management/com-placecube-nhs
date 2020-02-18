<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ include file="../init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" cssClass="container-fluid-1280 mt-3" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<aui:select name="groupType" required="true">
		<c:forEach items="${availableGroupTypes}" var="availableGroupType">
			<aui:option value="${availableGroupType.getValue()}" selected="${configuration.groupType().equals(availableGroupType.getValue())}">
				<liferay-ui:message key="${availableGroupType.getValue()}"/>
			</aui:option>
		</c:forEach>
	</aui:select>
	
	<aui:input type="toggle-switch" name="compactDisplay" value="${configuration.compactDisplay()}"/>
	
	<aui:input name="maxItemsToDisplay" type="number" value="${configuration.maxItemsToDisplay()}"  >
		<aui:validator name="min">1</aui:validator>
	</aui:input>
	

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>

</aui:form>
