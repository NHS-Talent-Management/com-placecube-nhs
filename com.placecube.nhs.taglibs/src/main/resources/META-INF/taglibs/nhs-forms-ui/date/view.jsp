<%@ include file="../init.jsp"%>

<c:set var="hasError" value="${not empty errorMessage}"/>

<div class="nhsuk-form-group ${hasError ? 'nhsuk-form-group--error' : ''}" id="${portletNamespace}_field_${fieldName}">
	<fieldset class="nhsuk-fieldset" role="group">
		
		<%@ include file="../fieldLegendLabel.jspf" %>
		<%@ include file="../fieldHintMessage.jspf" %>
		<%@ include file="../fieldErrorMessage.jspf" %>
		
		<div class="nhsuk-date-input" id="${portletNamespace}_field_${fieldName}">
			
			<c:choose>
				<c:when test="${hideDay}">
					<input class="hide" id="${portletNamespace}${fieldName}_day" name="${portletNamespace}${fieldName}_day" type="hidden" value="1"/>
				</c:when>
				<c:otherwise>
					<div class="nhsuk-date-input__item">
						<div class="nhsuk-form-group">
							<label class="nhsuk-label nhsuk-date-input__label" for="${portletNamespace}${fieldName}_day">
								<liferay-ui:message key="day"/>
							</label>
							<input class="nhsuk-input nhsuk-date-input__input nhsuk-input--width-2 ${hasError ? 'nhsuk-input--error' : ''}" 
									id="${portletNamespace}${fieldName}_day" 
									name="${portletNamespace}${fieldName}_day" 
									type="number" pattern="[0-9]*"
									value="${dayValue}"/>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${hideMonth}">
					<input class="hide" id="${portletNamespace}${fieldName}_month" name="${portletNamespace}${fieldName}_month" type="hidden" value="1"/>
				</c:when>
				<c:otherwise>
					<div class="nhsuk-date-input__item">
						<div class="nhsuk-form-group">
							<label class="nhsuk-label nhsuk-date-input__label" for="${portletNamespace}${fieldName}_month">
								<liferay-ui:message key="month"/>
							</label>
							<input class="nhsuk-input nhsuk-date-input__input nhsuk-input--width-2 ${hasError ? 'nhsuk-input--error' : ''}" 
									id="${portletNamespace}${fieldName}_month" 
									name="${portletNamespace}${fieldName}_month" 
									type="number" 
									pattern="[0-9]*"
									value="${monthValue}"/>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			
			<div class="nhsuk-date-input__item">
				<div class="nhsuk-form-group">
					<label class="nhsuk-label nhsuk-date-input__label" for="${portletNamespace}${fieldName}_year">
						<liferay-ui:message key="year"/>
					</label>
					<input class="nhsuk-input nhsuk-date-input__input nhsuk-input--width-4 ${hasError ? 'nhsuk-input--error' : ''}" 
							id="${portletNamespace}${fieldName}_year" 
							name="${portletNamespace}${fieldName}_year" 
							type="number" 
							pattern="[0-9]*"
							value="${yearValue}"/>
				</div>
			</div>
		</div>
	</fieldset>
</div>