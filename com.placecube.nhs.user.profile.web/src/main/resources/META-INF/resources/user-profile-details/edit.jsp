<%@ include file="../init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.PROFILE_DETAILS_EDIT%>" var="userProfilEditURL" />

<aui:form action="${userProfilEditURL}" method="post" name="userProfilForm">
	<c:set var="backToProfileCommand" value="<%=MVCCommandKeys.PROFILE_DETAILS_VIEW%>"/>
	<%@ include file="../back-to-profile.jspf" %>
	
	<c:set var="pullFromSourceLabel" value="pull-profile-from-source"/>
	<%@ include file="../pull-from-source-button.jspf" %>
	
	<c:set var="titleMessageKey" value="add-intro"/>
	<%@ include file="../edit-title.jspf" %>

	<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

	<div class="row">
		<div class="col-md-12">

			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="firstName"
				fieldLabel="first-name"
				fieldValue="${userProfileContext.getFirstName()}"
				errorMessage="${validationErrors.get('firstName')}"/>

			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="lastName"
				fieldLabel="last-name"
				fieldValue="${userProfileContext.getLastName()}"
				errorMessage="${validationErrors.get('lastName')}"/>

			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="currentPosition"
				fieldLabel="current-position"
				fieldValue="${userProfileContext.getCurrentPosition()}"
				errorMessage="${validationErrors.get('currentPosition')}" />
						
			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="location"
				fieldLabel="location"
				fieldValue="${userProfileContext.getLocation()}"
				errorMessage="${validationErrors.get('location')}" />

			<nhs-forms-ui:input-textarea portletNamespace="${portletNamespace}" 
				fieldName="summary"
				fieldLabel="summary"
				fieldValue="${ userProfileContext.getSummary()}"
				errorMessage="${validationErrors.get('summary')}" 
				fieldRows="5"/>
		</div>
	</div>
</aui:form>