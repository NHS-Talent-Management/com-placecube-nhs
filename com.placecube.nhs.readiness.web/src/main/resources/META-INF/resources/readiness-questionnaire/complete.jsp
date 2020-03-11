<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
		<div class="row">
			<div class="col-md-12">
				<liferay-journal:journal-article 
					articleId="${webContentArticleId}" 
					groupId="${webContentGroupId}" 
					showTitle="false" />
			</div>
		</div>
		<c:if test="${not empty closeURL}">
			<div class="row">
				<div class="col-md-12">
					<a href="${closeURL}" class="nhsuk-button">
						<liferay-ui:message key="go-to-my-profile"/>
					</a>
				</div>
			</div>
		</c:if>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="please-sign-in-to-access-this-application"/>
		</div>
	</c:otherwise>
</c:choose>

	