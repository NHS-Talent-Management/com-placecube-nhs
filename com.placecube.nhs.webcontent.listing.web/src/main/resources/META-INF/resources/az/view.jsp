<%@ include file="../init.jsp"%>
<%@ taglib uri="http://placecube.com/tld/nhs-az-ui" prefix="nhs-az-ui" %>

<c:choose>
	<c:when test="${invalidConfiguration}">
		<div class="alert alert-warning">
			<liferay-ui:message key="the-default-preferences-are-invalid"/>
		</div>
	</c:when>
	<c:otherwise>
		<c:set var="noValuesFoundMessage">
			<liferay-ui:message key="no-entries-found"/>
		</c:set>
		
		<nhs-az-ui:azListing items="${articles}" noValuesFoundMessage="${noValuesFoundMessage}" portletNamespace="${portletNamespace}"/>
	</c:otherwise>
</c:choose>

 