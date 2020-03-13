<%@ include file="../init.jsp"%>

<details class="nhsuk-details" ${fieldSelectedValues.isEmpty() ? '' : 'open'}>
	<summary class="nhsuk-details__summary">
		<span class="nhsuk-details__summary-text">
			<liferay-ui:message key="${fieldLabel}"/>
		</span>
	</summary>
	<div class="nhsuk-details__text">
		<div class="nhsuk-checkboxes">
			<c:forEach items="${fieldOptions}" var="availableOption" varStatus="loop">
				<div class="nhsuk-checkboxes__item">
					<input class="nhsuk-checkboxes__input" id="${portletNamespace}${fieldName}-${loop.index}" name="${portletNamespace}${fieldName}" type="checkbox" value="${availableOption.key}"
						${fieldSelectedValues.contains(availableOption.key) ? 'checked' : ''}
					/>
					<label class="nhsuk-label nhsuk-checkboxes__label" for="${portletNamespace}${fieldName}-${loop.index}">
						<liferay-ui:message key="${availableOption.value}"/>
					</label>
				</div>
			</c:forEach>
		</div>
	</div>
</details>

