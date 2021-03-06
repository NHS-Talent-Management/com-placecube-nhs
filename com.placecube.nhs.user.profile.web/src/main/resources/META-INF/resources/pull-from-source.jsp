<%@ include file="init.jsp"%>

<portlet:renderURL var="backURL" windowState="${windowStateMaximized}">
	<portlet:param name="mvcRenderCommandName" value="${backToCommand}"/>
</portlet:renderURL>


<div class="row">
	<div class="col-md-12">
		<div class="pull-left">
			<div class="nhsuk-back-link">
				<a class="nhsuk-back-link__link" href="${ backURL }">
					<svg class="nhsuk-icon nhsuk-icon__chevron-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
						<path d="M8.5 12c0-.3.1-.5.3-.7l5-5c.4-.4 1-.4 1.4 0s.4 1 0 1.4L10.9 12l4.3 4.3c.4.4.4 1 0 1.4s-1 .4-1.4 0l-5-5c-.2-.2-.3-.4-.3-.7z"></path>
					</svg>
					<liferay-ui:message key="${backToLabel}"/>
				</a>
			</div>
		</div>
	</div>
</div>
	


<div class="row">
	<div class="col-md-12">
		<liferay-journal:journal-article 
			articleId="${webcontentArticleId}" 
			groupId="${themeDisplay.getCompanyGroupId()}" 
			showTitle="false" />
	</div>
</div>


