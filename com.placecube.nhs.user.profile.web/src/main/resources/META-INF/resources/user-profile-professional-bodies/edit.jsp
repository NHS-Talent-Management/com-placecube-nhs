<%@ include file="../init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.PROFESSIONAL_BODIES_EDIT%>" var="editProfessionalBodyURL">
	<portlet:param name="id" value="${extraInfoContext.getId()}"/>
</portlet:actionURL>


<aui:form action="${editProfessionalBodyURL}" method="post" name="editProfessionalBodyForm">

	
	<c:set var="backToProfileCommand" value="<%=MVCCommandKeys.PROFESSIONAL_BODIES_VIEW%>"/>
	<%@ include file="../back-to-profile.jspf" %>

	<c:if test="${extraInfoContext.getId() le 0}">
		<c:set var="pullFromSourceLabel" value="pull-professionalbody-from-source"/>
		<%@ include file="../pull-from-source-button.jspf" %>
	</c:if>
	
	<c:set var="titleMessageKey" value="${extraInfoContext.getId() gt 0 ? 'update-professional-body' : 'add-professional-body'}"/>
	<%@ include file="../edit-title.jspf" %>
	
	<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

	<div class="row">
		<div class="col-md-12">
			
			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="role"
				fieldLabel="professional-body-name"
				fieldValue="${extraInfoContext.getRole()}"
				errorMessage="${validationErrors.get('role')}" />

			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="place"
				fieldLabel="registration-number"
				fieldValue="${extraInfoContext.getPlace()}"
				errorMessage="${validationErrors.get('registrationNumber')}" />
			
			<nhs-forms-ui:input-date portletNamespace="${portletNamespace}" 
				fieldName="fromDate"
				fieldLabel="last-update-date"
				fieldValue="${extraInfoContext.getFromDate()}"
				errorMessage="${validationErrors.get('fromDate')}" />
			
			<nhs-forms-ui:input-date portletNamespace="${portletNamespace}" 
				fieldName="toDate"
				fieldLabel="revalidation-date"
				fieldValue="${extraInfoContext.getToDate()}"
				errorMessage="${validationErrors.get('toDate')}" />
				
		</div>
	</div>
</aui:form>