<%@ include file="init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.SAVE%>" var="saveTalentSearchURL"/>
 
<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

<aui:form action="${saveTalentSearchURL}" method="post" name="talentSearchForm">
	
	<%@ include file="campain-details.jspf" %>
	
	<div class="row">
		<div class="col-md-4">
			<%@ include file="campaign-filters.jspf" %>
		</div>
		
		<div class="col-md-8">
			<c:choose>
				<c:when test="${not searchExecuted}">
					<liferay-ui:message key="select-filters-to-execute-search"/>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-md-12">
							<h2 class="nhsuk-heading-xs">
								<c:set var="messageKey" value="${searchContainer.getTotal() gt 1 ? 'x-results-found' : 'x-result-found'}"/>
								<liferay-ui:message key="${messageKey}" arguments="${searchContainer.getTotal()}"/>
							</h2>
							
							<portlet:actionURL name="<%=MVCCommandKeys.UPDATE_FILTER%>" var="removeFilterSearchURL">
								<portlet:param name="cmd" value="remove"/>
								<portlet:param name="fieldName" value="<%=SearchFilterConstants.PLACEHOLDER_FILTER_FIELD_NAME %>"/>
								<portlet:param name="fieldValue" value="<%=SearchFilterConstants.PLACEHOLDER_FILTER_FIELD_VALUE %>"/>
							</portlet:actionURL>
							<nhs-search-ui:active-filters portletNamespace="${portletNamespace}" updateFilterSearchURL="${removeFilterSearchURL}" filtersSelected="${selectedRemovableFilters}"/>
						</div>
					</div>
					<%@ include file="view-entries.jspf" %>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
</aui:form>
