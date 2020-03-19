<%@ include file="init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.SEND_NUDGE%>" var="sendNudgeURL">
	<portlet:param name="totalResults" value="${nudgeNotification.totalResults}"/>
</portlet:actionURL>

<portlet:renderURL var="cancelURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.SAVE %>"/>
	<portlet:param name="keepFilters" value="true"/>
</portlet:renderURL>
 
<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${validationErrors}"/>

<aui:form action="${sendNudgeURL}" method="post" name="talentSearchForm">
	
	<span class="nhsuk-hint">
		<liferay-ui:message key="send-nudge-info"/>
	</span>
	<span class="nhsuk-hint">
		<strong><liferay-ui:message key="send-nudge-users" arguments="${nudgeNotification.totalResults}"/></strong>
	</span>
	
	
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
	
	<nhs-forms-ui:input-textarea portletNamespace="${portletNamespace}" 
		fieldName="emailBody" 
		fieldLabel="body"
		fieldValue="${nudgeNotification.emailBody}" 
		errorMessage="${validationErrors.get('emailBody')}" 
		fieldRows="10" />
	
	<aui:button-row cssClass="nhsuk-u-margin-top-8">	
		<aui:button type="cancel" href="${cancelURL}" cssClass="nhsuk-button nhsuk-button--secondary pull-left" value="cancel"/>
		<aui:button type="submit" cssClass="nhsuk-button pull-right" value="send-nudge"/>
	</aui:button-row>		
	
</aui:form>
