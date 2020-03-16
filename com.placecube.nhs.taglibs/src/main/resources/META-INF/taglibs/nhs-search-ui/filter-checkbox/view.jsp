<%@ include file="../init.jsp"%>

<details class="nhsuk-details search-filter search-filter-checkbox" ${fieldSelectedValues.isEmpty() ? '' : 'open'}>
	<summary class="nhsuk-details__summary">
		<span class="nhsuk-details__summary-text">
			<liferay-ui:message key="${fieldLabel}"/>
		</span>
	</summary>
	<div class="nhsuk-details__text">
		<div class="nhsuk-checkboxes">
			<c:forEach items="${fieldOptions}" var="availableOption" varStatus="loop">
				<div class="nhsuk-checkboxes__item">
					<input class="nhsuk-checkboxes__input" id="${portletNamespace}${fieldName}-${loop.index}" name="${portletNamespace}${fieldName}" searchablename="${fieldName}" type="checkbox" value="${availableOption.key}"
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

<c:if test="${not empty updateFilterSearchURL}">
	<aui:script use="aui-tree-view">
		$('.search-filter.search-filter-checkbox input.nhsuk-checkboxes__input').on('change', function(){
			var fieldName = $(this).attr('searchablename');
			var fieldValue = $(this).val();
			var cmdValue = '';
			if(this.checked){
				cmdValue = 'add';
			} else {
				cmdValue = 'remove';
			}
			document.location = "${updateFilterSearchURL}".replace("FILTER_FIELD_NAME",fieldName).replace("FILTER_FIELD_VALUE",fieldValue).replace("FILTER_ACTION",cmdValue);
		});
	</aui:script>
</c:if>