<%@ include file="init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.SEARCH%>" var="searchTalentSearchURL">
	<portlet:param name="cmd" value="search"/>
</portlet:actionURL>

<portlet:actionURL name="<%=MVCCommandKeys.SEARCH%>" var="saveTalentSearchURL">
	<portlet:param name="cmd" value="save"/>
</portlet:actionURL>
 
<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

<aui:form action="" method="post" name="talentSearchForm" onSubmit='<%= "event.preventDefault(); "%>'>
	
	<%@ include file="campain-details.jspf" %>
	
	<div class="row">
		<div class="col-md-4">
			<%@ include file="campaign-filters.jspf" %>
		</div>
		
		<div class="col-md-8">
			<c:choose>
				<c:when test="${not talentSearchContext.isSearchExecuted()}">
					<liferay-ui:message key="select-filters-to-execute-search"/>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-md-12">
							<h2>
								<liferay-ui:message key="results-found" arguments="${searchContainer.getTotal()}"/>
							</h2>
						</div>
					</div>
					<%@ include file="view-entries.jspf" %>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
</aui:form>

<aui:script>
	function submitTalentSearchForm(formAction) {
		document.<portlet:namespace />talentSearchForm.action = formAction;
		submitForm(document.<portlet:namespace />talentSearchForm);
	}
</aui:script>
