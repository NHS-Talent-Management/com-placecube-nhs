<%@ include file="../init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.LEARNING_SKILLS_EDIT%>" var="editQualificationURL">
	<portlet:param name="id" value="${extraInfoContext.getId()}"/>
</portlet:actionURL>

<aui:form action="${editQualificationURL}" method="post" name="editQualificationForm">
	
	<c:set var="backToProfileCommand" value="<%=MVCCommandKeys.LEARNING_SKILLS_VIEW%>"/>
	<%@ include file="../back-to-profile.jspf" %>
	
	<c:set var="titleMessageKey" value="${extraInfoContext.getId() gt 0 ? 'update-learning-skills' : 'add-learning-skills'}"/>
	<%@ include file="../edit-title.jspf" %>
	
	<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

	<div class="row">
		<div class="col-md-12">
			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="place"
				fieldLabel="institution-university"
				fieldValue="${extraInfoContext.getPlace()}"
				errorMessage="${validationErrors.get('place')}" />
			
			<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
				fieldName="role"
				fieldLabel="qualification"
				fieldValue="${extraInfoContext.getRole()}"
				errorMessage="${validationErrors.get('role')}" />
			
			<nhs-forms-ui:input-date portletNamespace="${portletNamespace}" 
				fieldName="fromDate"
				fieldLabel="from"
				fieldValue="${extraInfoContext.getFromDate()}"
				errorMessage="${validationErrors.get('fromDate')}"
				hideDay="true"
				hideMonth="true" />
			
			<nhs-forms-ui:input-date portletNamespace="${portletNamespace}" 
				fieldName="toDate"
				fieldLabel="to"
				fieldValue="${extraInfoContext.getToDate()}"
				errorMessage="${validationErrors.get('toDate')}"
				hideDay="true"
				hideMonth="true" />
				
		</div>
	</div>
</aui:form>