<%@ include file="../init.jsp"%>

<div class="row">
	<div class="col-md-12">
		<liferay-journal:journal-article 
			articleId="<%= WebContentArticles.READINESS_QUESTIONNAIRE_COMPLETED.getArticleId() %>" 
			groupId="${webContentGroupId}" 
			showTitle="false" />
	</div>
</div>
