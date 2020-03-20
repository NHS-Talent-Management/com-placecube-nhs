<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
		<portlet:actionURL var="saveFormURL" name="<%= MVCCommandKeys.USER_PRIVACY_UPDATE %>">
			<portlet:param name="userPrivacyPage" value="${userPrivacyPage.name()}"/>
		</portlet:actionURL>

		<aui:form action="${saveFormURL}" method="post" name="userPrivacyForm">

			<c:set var="backToName" value="privacy-sharing"/>
			<c:set var="showSaveButton" value="true"/>
			<c:set var="windowState" value="${windowStateMaximized}"/>
			<c:set var="mvcRenderCommandName" value="<%=MVCCommandKeys.USER_PRIVACY_OPTIONS%>"/>
			<%@ include file="../action-bar.jspf" %>
			
			<nhs-forms-ui:input-radio
				fieldLabel="${userPrivacyPage.getFieldLabel()}" 
				fieldOptions="${privacyOptions}"
				fieldValue="${privacySelectedValue}"  
				portletNamespace="${portletNamespace}"
				fieldName="userPrivacy" />

		</aui:form>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="please-sign-in-to-access-this-application"/>
		</div>
	</c:otherwise>
</c:choose>