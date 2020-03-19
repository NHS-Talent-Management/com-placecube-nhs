<%@ include file="init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
		<div class="col-md-4 float-right">
			<div class="nhsuk-care-card__content">
				<portlet:renderURL var="settingsUrl" windowState="${windowStateMaximized}">
					<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandKeys.USER_PRIVACY_SETTINGS_VIEW %>"/>
				</portlet:renderURL>
				
				<a href="${settingsUrl}">
					<legend class="nhsuk-fieldset__legend nhsuk-fieldset__legend--l">
						<h1 class="nhsuk-fieldset__heading float-left">
							<liferay-ui:message key="settings"/>
						</h1>
						<aui:icon cssClass="icon-monospaced float-right" image="cog" markupView="lexicon" />
					</legend>
					<span class="nhsuk-u-visually-hidden"><liferay-ui:message key="settings"/></span>
				</a>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="please-sign-in-to-access-this-application"/>
		</div>
	</c:otherwise>
</c:choose>