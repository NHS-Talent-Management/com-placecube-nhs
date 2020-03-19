<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">

		<c:set var="backToName" value="privacy-sharing"/>
		<c:set var="windowState" value="${windowStateMaximized}"/>
		<c:set var="mvcRenderCommandName" value="<%= MVCCommandKeys.USER_PRIVACY_SHARING_VIEW %>"/>
		<%@ include file="../back.jspf" %>

		<portlet:actionURL var="saveForm" name="<%= MVCCommandKeys.USER_PRIVACY_SHARING_EDIT %>"></portlet:actionURL>

		<aui:form action="${saveForm}" method="post" name="saveForm">
			<aui:input name="fieldName" value="${userPrivacyPage.name()}" type="hidden"></aui:input>
			<div class="nhsuk-form-group">
			
				<fieldset class="nhsuk-fieldset">
					<legend class="nhsuk-fieldset__legend nhsuk-fieldset__legend--l">
						<h1 class="nhsuk-fieldset__heading">
							<liferay-ui:message key="${userPrivacyPage.getFieldLabel(locale)}"></liferay-ui:message>
						</h1>
					</legend>
					<div class="nhsuk-radios">
						<c:forEach items="${userPrivacyContextRoles}" var="userPrivacyContextRole" varStatus="loop">
							<div class="nhsuk-radios__item">
								<input class="nhsuk-radios__input" 
										id="<portlet:namespace/>privacyRoleId-${loop.index}" 
										name="<portlet:namespace/>privacyRoleId" 
										type="radio" 
										value="${userPrivacyContextRole.roleId}"
										${roleIdsSelected.contains(userPrivacyContextRole.roleId) ? 'checked' : ''}
										>
								<label class="nhsuk-label nhsuk-radios__label" for="<portlet:namespace/>privacyRoleId-${loop.index}">
									${userPrivacyContextRole.getDisplayName(locale)}
								</label>
							</div>
						</c:forEach>
					</div>
				</fieldset>
			</div>

			<aui:button-row cssClass="nhsuk-u-margin-top-8">	
				<aui:button type="submit" cssClass="nhsuk-button" value="save"/>
			</aui:button-row>		

		</aui:form>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="please-sign-in-to-access-this-application"/>
		</div>
	</c:otherwise>
</c:choose>