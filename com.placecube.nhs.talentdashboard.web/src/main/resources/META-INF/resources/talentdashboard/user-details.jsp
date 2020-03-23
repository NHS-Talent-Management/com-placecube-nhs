<%@ include file="init.jsp"%>

<portlet:renderURL var="backURL"  windowState="${windowStateNormal}">
	<portlet:param name="mvcRenderCommandName" value="/"/>
	<portlet:param name="keepFilters" value="true"/>
</portlet:renderURL>

<div class="row">
	<div class="col-md-12">
		<div class="nhsuk-back-link pull-left">
			<a class="nhsuk-back-link__link" href="${ backURL }">
				<svg class="nhsuk-icon nhsuk-icon__chevron-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
					<path d="M8.5 12c0-.3.1-.5.3-.7l5-5c.4-.4 1-.4 1.4 0s.4 1 0 1.4L10.9 12l4.3 4.3c.4.4.4 1 0 1.4s-1 .4-1.4 0l-5-5c-.2-.2-.3-.4-.3-.7z"></path>
				</svg>
				<liferay-ui:message key="back-to-search-results"/>
			</a>
		</div>
	</div>
</div>
	
<div class="nhsuk-care-card nhsuk-care-card--non-urgent white-card">
	<div class="nhsuk-care-card__heading-container">
		<h1 class="nhsuk-care-card__heading">
			${userResult.getFullName()}
		</h1>
	</div>
	
	<div class="nhsuk-care-card__content">
		<dl class="nhsuk-summary-list">
			<c:forEach items="${availableFilters}" var="availableFilter">
				<nhs-user-ui:view-expando expandoFieldName="${availableFilter.getFieldName()}" expandoFieldLabel="${availableFilter.getFieldLabel()}" user="${userResult}"/>
			</c:forEach>
		</dl>
	</div>
</div>
