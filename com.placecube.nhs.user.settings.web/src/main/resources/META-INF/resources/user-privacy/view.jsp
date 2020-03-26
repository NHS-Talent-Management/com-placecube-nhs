<%@ include file="../init.jsp"%>

<c:if test="${themeDisplay.isSignedIn()}">

	<c:set var="backToName" value="settings"/>
	<c:set var="showSaveButton" value="false"/>
	<c:set var="windowState" value="${windowStateMaximized}"/>
	<c:set var="mvcRenderCommandName" value="<%=MVCCommandKeys.VIEW_SETTINGS_OPTIONS%>"/>
	<%@ include file="../action-bar.jspf" %>

	<div class="nhsuk-care-card__content">

		<legend class="nhsuk-fieldset__legend nhsuk-fieldset__legend--l">
			<h1 class="nhsuk-fieldset__heading float-left">
				<liferay-ui:message key="privacy-sharing"></liferay-ui:message>
			</h1>
			<aui:icon cssClass="icon-monospaced float-right" image="cog" markupView="lexicon" />
		</legend>
				
		<ul class="list-options">
			<c:forEach items="${privacyPages}" var="userPrivacyPage">
				<li class="list-option-entry"> 
					<portlet:renderURL var="userPrivacyPageEditRenderUrl">
						<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandKeys.USER_PRIVACY_UPDATE %>"/>
						<portlet:param name="userPrivacyPage" value="${userPrivacyPage.name()}"/>
					</portlet:renderURL>
					<a href="${userPrivacyPageEditRenderUrl}">
						<span class="list-option-entry-text">
							<liferay-ui:message key="${userPrivacyPage.getFieldLabel()}"/>
						</span>
						<svg class="nhsuk-icon nhsuk-icon__chevron-right" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
							<path d="M15.5 12a1 1 0 0 1-.29.71l-5 5a1 1 0 0 1-1.42-1.42l4.3-4.29-4.3-4.29a1 1 0 0 1 1.42-1.42l5 5a1 1 0 0 1 .29.71z"></path>
						</svg>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</c:if>