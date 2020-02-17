<%@ include file="../init.jsp"%>
<%@ taglib uri="http://placecube.com/tld/nhs-az-ui" prefix="nhs-az-ui" %>

<c:set var="noValuesFoundMessage">
	<liferay-ui:message key="no-entries-found"/>
</c:set>

<nhs-az-ui:azListing items="${articles}" noValuesFoundMessage="${noValuesFoundMessage}" portletNamespace="${portletNamespace}"/>

 
