<%@ include file="init.jsp"%>

<div class="row">
	<div class="col-md-12">
		<liferay-journal:journal-article 
			articleId="${webcontentArticleId}" 
			groupId="${themeDisplay.getCompanyGroupId()}" 
			showTitle="false" />
	</div>
</div>


