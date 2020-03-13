<%@ include file="../init.jsp"%>

<c:set var="hasError" value="${not empty errorMessage}"/>

<div class="nhsuk-form-group ${hasError ? 'nhsuk-form-group--error' : ''}" id="${portletNamespace}_field_${fieldName}">
		
	<%@ include file="../fieldErrorMessage.jspf" %>
	
	<label class="nhsuk-label" for="${portletNamespace}${fieldName}">
		<liferay-ui:message key="${fieldLabel}"/>
	</label>
	
	<select class="nhsuk-select" id="${portletNamespace}${fieldName}" name="${portletNamespace}${fieldName}">
		<c:forEach items="${fieldOptions}" var="availableOption">
			<option value="${availableOption.key}" ${availableOption.key.equals(fieldValue) ? 'selected' : ''}>
				<liferay-ui:message key="${availableOption.value}"/>
			</option>
		</c:forEach>
	</select>
</div>
