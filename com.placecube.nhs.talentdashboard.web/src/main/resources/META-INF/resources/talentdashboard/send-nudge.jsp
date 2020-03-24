<%@ include file="init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.SEND_NUDGE%>" var="sendNudgeURL">
	<portlet:param name="totalResults" value="${nudgeNotification.totalResults}"/>
</portlet:actionURL>

<portlet:renderURL var="cancelURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.SAVE %>"/>
	<portlet:param name="keepFilters" value="true"/>
</portlet:renderURL>
 
<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

<aui:form action="${sendNudgeURL}" method="post" name="talentSearchForm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveEntry();" %>'>
	
	<div class="row">
		<div class="col-md-12">
			<liferay-journal:journal-article 
				articleId="<%= WebContentArticles.TALENT_DASHBOARD_NUDGE_TEXT.getArticleId() %>" 
				groupId="${webContentGroupId}" 
				showTitle="false" />
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<span class="nhsuk-hint">
				<strong><liferay-ui:message key="send-nudge-users" arguments="${nudgeNotification.totalResults}"/></strong>
			</span>
		</div>
	</div>
	
	<dl class="nhsuk-summary-list nhsuk-summary-list--no-border selected-filters">
		<c:forEach items="${availableFilters}" var="availableFilter">
			<c:if test="${availableFilter.isActive()}">
				<div class="nhsuk-summary-list__row">
					<dt class="nhsuk-summary-list__key">
						<liferay-ui:message key="${availableFilter.getFieldLabel()}"/>
					</dt>
					<dd class="nhsuk-summary-list__value">
						<c:forEach items="${availableFilter.getFieldSelectedValuesList()}" var="selectedValue" varStatus="loop">
							<liferay-ui:message key="${selectedValue}"/>${loop.last ? '' : ',&nbsp;'}
						</c:forEach>
					</dd>
				</div>
			</c:if>
		</c:forEach>
	</dl>
	
	<nhs-forms-ui:input-text portletNamespace="${portletNamespace}" 
			fieldName="emailSubject" 
			fieldLabel="subject"
			fieldValue="${nudgeNotification.emailSubject}" 
			errorMessage="${validationErrors.get('emailSubject')}" 
			showAsPassword="false" />
	

	<c:set var="hasError" value="${not empty validationErrors.get('emailBody')}"/>
	<div class="nhsuk-form-group ${hasError ? 'nhsuk-form-group--error' : ''}" id="${portletNamespace}_field_emailBody">
		<label class="nhsuk-label" for="${portletNamespace}emailBody">
			<liferay-ui:message key="body"/>
		</label>
		
		<c:if test="${hasError}">
			<span class="nhsuk-error-message" id="${portletNamespace}_error_emailBody">
				<span class="nhsuk-u-visually-hidden"><liferay-ui:message key="error"/></span> <liferay-ui:message key="${validationErrors.get('emailBody')}"/>
			</span>
		</c:if>
		
		<liferay-ui:input-editor contents="${nudgeNotification.emailBody}" editorName="alloyeditor" name="contentEditor" cssClass="nhsuk-textarea ${hasError ? 'nhsuk-textarea--error' : ''}"  />

		<aui:input name="emailBody" type="hidden" />
	</div>
	
	<aui:button-row cssClass="nhsuk-u-margin-top-8">	
		<aui:button type="cancel" href="${cancelURL}" cssClass="nhsuk-button nhsuk-button--secondary pull-left" value="cancel"/>
		<aui:button type="submit" cssClass="nhsuk-button pull-right" value="send-nudge"/>
	</aui:button-row>		
	
</aui:form>


<aui:script>
	function <portlet:namespace />getDescription() {
		return window.<portlet:namespace />contentEditor.getHTML();
	}

	function <portlet:namespace />saveEntry() {
		document.<portlet:namespace />talentSearchForm.<portlet:namespace />emailBody.value = <portlet:namespace />getDescription();
		submitForm(document.<portlet:namespace />talentSearchForm);
	}
</aui:script>
