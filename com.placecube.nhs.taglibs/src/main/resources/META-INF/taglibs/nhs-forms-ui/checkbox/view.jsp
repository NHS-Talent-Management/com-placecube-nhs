<%@ include file="../init.jsp"%>

<c:set var="hasError" value="${not empty errorMessage}"/>

<div class="nhsuk-form-group ${hasError ? 'nhsuk-form-group--error' : ''}" id="${portletNamespace}_field_${fieldName}">
	<fieldset class="nhsuk-fieldset">
		
		<%@ include file="../fieldLegendLabel.jspf" %>
		<%@ include file="../fieldHintMessage.jspf" %>
		<%@ include file="../fieldErrorMessage.jspf" %>
		
		<div class="nhsuk-checkboxes">
			<c:forEach items="${fieldOptions}" var="availableOption" varStatus="loop">
				<div class="nhsuk-checkboxes__item">
					<input class="nhsuk-checkboxes__input" id="${portletNamespace}${fieldName}-${loop.index}" name="${portletNamespace}${fieldName}" type="checkbox" value="${availableOption.key}"
						${availableOption.key.equals(fieldValue) ? 'checked' : ''}
					/>
					<label class="nhsuk-label nhsuk-checkboxes__label" for="${portletNamespace}${fieldName}-${loop.index}">
						<liferay-ui:message key="${availableOption.value}"/>
					</label>
				</div>
			</c:forEach>
		</div>
	</fieldset>
</div>