<%@ include file="init.jsp"%>
<%@page import="com.placecube.nhs.user.settings.constants.UserSettingsPage"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">

		<c:set var="backToName" value="profile"/>
		<c:set var="windowState" value="${windowStateNormal}"/>
		<c:set var="mvcRenderCommandName" value="/"/>
		<%@ include file="back.jspf" %>

		<div class="nhsuk-care-card__content">
		
			<legend class="nhsuk-fieldset__legend nhsuk-fieldset__legend--l">
				<h1 class="nhsuk-fieldset__heading float-left">
					<liferay-ui:message key="settings"></liferay-ui:message>
				</h1>
				<aui:icon cssClass="icon-monospaced float-right" image="cog" markupView="lexicon" />
			</legend>

			<dl class="nhsuk-summary-list">
				<c:forEach items="<%= UserSettingsPage.values() %>" var="userSettingsPage">
					<div class="nhsuk-summary-list__row"> 
						<dt class="nhsuk-summary-list__key">
							${userSettingsPage.getFieldLabel(locale)}
						</dt>
						<dd class="nhsuk-summary-list__actions">
							<portlet:renderURL var="userSettingsPageRenderUrl">
								<portlet:param name="mvcRenderCommandName" value="${userSettingsPage.getMvcCommandName()}"/>
							</portlet:renderURL>
							<a href="${userSettingsPageRenderUrl}">
								<svg class="nhsuk-icon nhsuk-icon__chevron-right" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
									<path d="M15.5 12a1 1 0 0 1-.29.71l-5 5a1 1 0 0 1-1.42-1.42l4.3-4.29-4.3-4.29a1 1 0 0 1 1.42-1.42l5 5a1 1 0 0 1 .29.71z"></path>
								</svg>
								<span class="nhsuk-u-visually-hidden">${userSettingsPage.getFieldLabel(locale)}</span>
							</a>
						</dd>
					</div>
				</c:forEach>
			</dl>
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="please-sign-in-to-access-this-application"/>
		</div>
	</c:otherwise>
</c:choose>