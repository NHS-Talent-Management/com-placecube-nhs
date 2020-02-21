<%@ include file="../init.jsp"%>

<c:set var="hasError" value="${not empty errorMessage}"/>

<div class="nhsuk-form-group ${hasError ? 'nhsuk-form-group--error' : ''}" id="${portletNamespace}_field_${fieldName}">
	<label class="nhsuk-label" for="${portletNamespace}${fieldName}">
		<liferay-ui:message key="${fieldLabel}"/>
	</label>
	
	<c:if test="${hasError}">
		<span class="nhsuk-error-message" id="${portletNamespace}_error_${fieldName}">
			<span class="nhsuk-u-visually-hidden"><liferay-ui:message key="error"/></span> <liferay-ui:message key="${errorMessage}"/>
		</span>
	</c:if>
	<input class="nhsuk-input ${hasError ? 'nhsuk-input--error' : ''}" id="${portletNamespace}${fieldName}" name="${portletNamespace}${fieldName}" type="${showAsPassword ? 'password' : 'text' }" value="${fieldValue}">
</div>

 
