<%@ include file="../init.jsp"%>

<c:if test="${not empty filtersSelected}">
	<div class="search-filter search-active-filters-container facet-tags__container">
		<div class="facet-tags">
			<c:forEach items="${filtersSelected}" var="selectedFilter">
				<div class="facet-tags__group ">
					<c:forEach items="${selectedFilter.value}" var="selectedFilterValue" varStatus="loopValues">
						<div class="facet-tags__wrapper">
							<c:if test="${!loopValues.first}">
								<p class="facet-tags__preposition"><liferay-ui:message key="or"/></p>
							</c:if>
							<div class="facet-tag">
								<c:set var="removeValueLabel"><liferay-ui:message key="remove"/>&nbsp;<liferay-ui:message key="${selectedFilterValue}"/></c:set>
								<p class="facet-tag__text"><liferay-ui:message key="${selectedFilterValue}"/></p>
								<button type="button" class="facet-tag__remove" aria-label="${removeValueLabel}" searchablename="${selectedFilter.key}" filtervalue="${selectedFilterValue}">x</button>
							</div>
						</div>
					</c:forEach>
				</div>
				
			</c:forEach>
		</div>
	</div>

	<aui:script>
		$('button.facet-tag__remove').on('click', function(){
			var fieldName = $(this).attr('searchablename');
			var fieldValue = encodeURIComponent($(this).attr('filtervalue'));
			var cmdValue = 'remove';
			var updatedURL = "${updateFilterSearchURL}".replace("FILTER_FIELD_NAME",fieldName).replace("FILTER_FIELD_VALUE",fieldValue).replace("FILTER_ACTION",cmdValue);
			document.location = updatedURL;
		});
	</aui:script>
</c:if>