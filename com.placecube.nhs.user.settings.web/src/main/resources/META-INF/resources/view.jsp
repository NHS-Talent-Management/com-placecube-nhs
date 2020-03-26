<%@ include file="init.jsp"%>

<c:if test="${themeDisplay.isSignedIn()}">
	<div class="nhsuk-care-card white-card float-right">
		<div class="nhsuk-care-card__heading-container">
			<portlet:renderURL var="settingsUrl" windowState="${windowStateMaximized}">
				<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.VIEW_SETTINGS_OPTIONS %>"/>
			</portlet:renderURL>
			
			<h3 class="nhsuk-care-card__heading">
				<a href="${settingsUrl}" >
					<span class="text">
						<liferay-ui:message key="settings"/>
					</span>
					<span class="action-icon">
						<aui:icon cssClass="icon-monospaced nhsuk-u-padding-left-3" image="cog" markupView="lexicon" />
					</span>
					<span class="nhsuk-u-visually-hidden"><liferay-ui:message key="update"/>&nbsp;<liferay-ui:message key="settings"/></span>
				</a>
			</h3>
		</div>
	</div>
</c:if>