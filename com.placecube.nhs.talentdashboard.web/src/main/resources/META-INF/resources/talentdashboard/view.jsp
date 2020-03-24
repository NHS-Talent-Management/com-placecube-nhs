<%@ include file="init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.SAVE%>" var="saveTalentSearchURL">
	<portlet:param name="cmd" value="save"/>
</portlet:actionURL>

<portlet:actionURL name="<%=MVCCommandKeys.SAVE%>" var="updateFiltersURL"/>
 
<portlet:renderURL var="sendNudgeURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.SEND_NUDGE %>"/>
	<portlet:param name="totalResults" value="${searchContainer.getTotal()}"/>
</portlet:renderURL>

<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

<aui:form method="post" name="talentSearchForm" onSubmit='<%= "event.preventDefault(); "%>'>
	<div class="row">
		<div class="col-md-12">
			<liferay-journal:journal-article 
				articleId="<%= WebContentArticles.TALENT_DASHBOARD_INTRO_TEXT.getArticleId() %>" 
				groupId="${webContentGroupId}" 
				showTitle="false" />
		</div>
	</div>
	
	<%@ include file="campain-details.jspf" %>
	
	<div class="row">
		<div class="col-md-12">
			<liferay-journal:journal-article 
				articleId="<%= WebContentArticles.TALENT_DASHBOARD_FILTERS_TEXT.getArticleId() %>" 
				groupId="${webContentGroupId}" 
				showTitle="false" />
		</div>
	</div>
	
	<%@ include file="campaign-filters.jspf" %>
		
	<div class="row">
		<div class="col-md-12">
			<c:choose>
				<c:when test="${not searchExecuted}">
					<liferay-ui:message key="select-filters-to-execute-search"/>
				</c:when>
				<c:otherwise>
				
					<div class="search-results-header">
						<h2 class="nhsuk-heading-xs">
							<c:set var="messageKey" value="${searchContainer.getTotal() gt 1 ? 'x-results-found' : 'x-result-found'}"/>
							<liferay-ui:message key="${messageKey}" arguments="${searchContainer.getTotal()}"/>
						</h2>
						
						<portlet:actionURL name="<%=MVCCommandKeys.UPDATE_FILTER%>" var="removeFilterSearchURL">
							<portlet:param name="cmd" value="remove"/>
							<portlet:param name="fieldName" value="<%=SearchFilterConstants.PLACEHOLDER_FILTER_FIELD_NAME %>"/>
							<portlet:param name="fieldValue" value="<%=SearchFilterConstants.PLACEHOLDER_FILTER_FIELD_VALUE %>"/>
						</portlet:actionURL>
						<nhs-search-ui:active-filters portletNamespace="${portletNamespace}" updateFilterSearchURL="${removeFilterSearchURL}" filtersSelected="${availableFilters}"/>
					</div>
					
					<%@ include file="view-entries.jspf" %>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<c:if test="${searchExecuted and searchContainer.getTotal() gt 0}">
		<aui:button-row cssClass="pull-right">
			<a class="nhsuk-button nhsuk-button--secondary" href="${sendNudgeURL}">
				<liferay-ui:message key="notify-these-people"/>
			</a>
		</aui:button-row>
	</c:if>
	
</aui:form>


<aui:script>
	function submitTalentSearchForm(formAction) {
		document.<portlet:namespace />talentSearchForm.action = formAction;
		submitForm(document.<portlet:namespace />talentSearchForm);
	}
</aui:script>
