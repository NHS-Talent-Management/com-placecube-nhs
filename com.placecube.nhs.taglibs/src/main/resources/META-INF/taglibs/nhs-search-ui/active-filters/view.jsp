<%@ include file="../init.jsp"%>

<c:if test="${not empty filtersSelected and showActiveFilters}">
	<div class="search-filter search-active-filters-container facet-tags__container">
		<div class="facet-tags">
			<c:forEach items="${filtersSelected}" var="selectedFilter">
				<c:if test="${selectedFilter.isActive()}">
					<div class="facet-tags__group ">
						<c:forEach items="${selectedFilter.getFieldSelectedValuesList()}" var="selectedFilterValue" varStatus="loopValues">
							<div class="facet-tags__wrapper">
								<p class="facet-tags__preposition">
									<c:choose>
										<c:when test="${loopValues.first}">
											<liferay-ui:message key="${selectedFilter.getFieldLabel()}"/>
										</c:when>
										<c:otherwise>
											<liferay-ui:message key="or"/>
										</c:otherwise>
									</c:choose>
								</p>
								
								<div class="facet-tag">
									<c:set var="removeValueLabel"><liferay-ui:message key="remove"/>&nbsp;<liferay-ui:message key="${selectedFilterValue}"/></c:set>
									<p class="facet-tag__text"><liferay-ui:message key="${selectedFilterValue}"/></p>
									<button type="button" class="facet-tag__remove" aria-label="${removeValueLabel}" searchablename="${selectedFilter.getSearchableFieldName()}" filtervalue="${selectedFilterValue}">x</button>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:if>
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