<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
		<div class="row">
			<div class="col-md-12">
				<liferay-journal:journal-article 
					articleId="<%= WebContentArticles.CAREER_READINESS.getArticleId() %>" 
					groupId="${webContentGroupId}" 
					showTitle="false" />
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				
				<liferay-portlet:renderURL  windowState="<%=WindowState.MAXIMIZED.toString() %>" var="startQuestionnaireURL">
					<liferay-portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER %>"/>
					<liferay-portlet:param name="cmd" value="next"/>
				</liferay-portlet:renderURL>
				
				<a href="${startQuestionnaireURL}" class="nhsuk-button">
					<liferay-ui:message key="continue"/>
				</a>
				
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="please-sign-in-to-access-this-application"/>
	</c:otherwise>
</c:choose>

	