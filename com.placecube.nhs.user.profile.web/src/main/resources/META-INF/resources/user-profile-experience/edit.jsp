<%@ include file="../init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.EXPERIENCE_EDIT%>" var="editExperienceURL">
	<portlet:param name="id" value="${extraInfoContext.getId()}"/>
</portlet:actionURL>

<aui:form action="${editExperienceURL}" method="post" name="editExperienceForm">
	
	<c:set var="backToProfileCommand" value="<%=MVCCommandKeys.EXPERIENCE_VIEW%>"/>
	<%@ include file="../back-to-profile.jspf" %>
	
	<c:set var="titleMessageKey" value="${extraInfoContext.getId() gt 0 ? 'update-experience' : 'add-experience'}"/>
	<%@ include file="../edit-title.jspf" %>
	
	<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

	<div class="row">
		<div class="col-md-12">
			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="placeOfWork"
				fieldLabel="place-of-work"
				fieldValue="${extraInfoContext.getPlace()}"
				errorMessage="${validationErrors.get('placeOfWork')}" />
			
			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="role"
				fieldLabel="role"
				fieldValue="${extraInfoContext.getRole()}"
				errorMessage="${validationErrors.get('role')}" />
			
			<nhs-forms-ui:input-checkbox portletNamespace="${portletNamespace}" 
				fieldName="current"
				fieldLabel="time-period"
				fieldOptions="${timePeriodOptions}"
				fieldValue="${extraInfoContext.isCurrent()}"
				errorMessage="${validationErrors.get('current')}" />
			
			<nhs-forms-ui:input-date portletNamespace="${portletNamespace}" 
				fieldName="fromDate"
				fieldLabel="from"
				fieldValue="${extraInfoContext.getFromDate()}"
				errorMessage="${validationErrors.get('fromDate')}"
				hideDay="true" />
			
			<nhs-forms-ui:input-date portletNamespace="${portletNamespace}" 
				fieldName="toDate"
				fieldLabel="to"
				fieldValue="${extraInfoContext.getToDate()}"
				errorMessage="${validationErrors.get('toDate')}"
				hideDay="true" />
				
		</div>
	</div>
</aui:form>