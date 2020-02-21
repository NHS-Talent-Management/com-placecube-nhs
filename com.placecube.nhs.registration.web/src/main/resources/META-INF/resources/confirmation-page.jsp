<%@ include file="init.jsp"%>

<div class="row">
	<div class="col-md-12">
		<liferay-journal:journal-article 
			articleId="<%= WebContentArticles.REGISTRATION_CONFIRMATION_PAGE.getArticleId() %>" 
			groupId="${webContentGroupId}" 
			showTitle="false" />
	</div>
</div>