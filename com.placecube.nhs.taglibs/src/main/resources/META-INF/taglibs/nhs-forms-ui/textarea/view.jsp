<%@ include file="../init.jsp"%>

<c:set var="hasError" value="${not empty errorMessage}"/>

<div class="nhsuk-form-group ${hasError ? 'nhsuk-form-group--error' : ''}" id="${portletNamespace}_field_${fieldName}">
	<label class="nhsuk-label" for="${portletNamespace}${fieldName}">
		<liferay-ui:message key="${fieldLabel}"/>
	</label>
	
	<%@ include file="../fieldErrorMessage.jspf" %>
	
	<textarea class="nhsuk-textarea ${hasError ? 'nhsuk-textarea--error' : ''}" rows="${fieldRows}" id="${portletNamespace}${fieldName}" name="${portletNamespace}${fieldName}">${fieldValue}</textarea>
</div>
