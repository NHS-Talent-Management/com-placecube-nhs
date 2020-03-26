<%@ include file="init.jsp"%>
<%@page import="com.placecube.nhs.user.settings.constants.UserSettingsPage"%>

<c:if test="${themeDisplay.isSignedIn()}">

	<c:set var="backToName" value="profile"/>
	<c:set var="showSaveButton" value="false"/>
	<c:set var="windowState" value="${windowStateNormal}"/>
	<c:set var="mvcRenderCommandName" value="/"/>
	<%@ include file="action-bar.jspf" %>

	<div class="nhsuk-care-card__content">
	
		<legend class="nhsuk-fieldset__legend nhsuk-fieldset__legend--l">
			<h1 class="nhsuk-fieldset__heading float-left">
				<liferay-ui:message key="settings"/>
			</h1>
			<aui:icon cssClass="icon-monospaced float-right" image="cog" markupView="lexicon" />
		</legend>

		<ul class="list-options">
			<c:forEach items="<%= UserSettingsPage.values() %>" var="userSettingsPage">
				<li class="list-option-entry"> 
					<portlet:renderURL var="userSettingsPageRenderUrl">
						<portlet:param name="mvcRenderCommandName" value="${userSettingsPage.getMvcCommandName()}"/>
					</portlet:renderURL>
					<a href="${userSettingsPageRenderUrl}">
						<span class="list-option-entry-text">
							<liferay-ui:message key="${userSettingsPage.getFieldLabel()}"/>
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