<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
		<div class="row">
			<div class="col-md-12">
				<liferay-journal:journal-article 
					articleId="<%= WebContentArticles.READINESS_QUESTIONNAIRE_COMPLETED.getArticleId() %>" 
					groupId="${webContentGroupId}" 
					showTitle="false" />
			</div>
		</div>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="please-sign-in-to-access-this-application"/>
		</div>
	</c:otherwise>
</c:choose>

	