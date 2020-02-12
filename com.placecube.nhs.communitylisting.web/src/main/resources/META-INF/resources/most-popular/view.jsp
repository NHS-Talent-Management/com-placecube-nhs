<%@ include file="../init.jsp"%>

<c:if test="${not empty communities}">

	<div class="row">
		<div class="col">
			<span class="nhsuk-hint"> 
				<liferay-ui:message key="top-trending-communities" />
			</span>
		</div>
	</div>

	<div class="nhsuk-grid-row nhsuk-promo-group compact-mobile-view">

		<c:forEach items="${communities}" var="community">

			<div class="nhsuk-grid-column-one-third nhsuk-promo-group__item nhsuk-u-margin-bottom-3">
				<div class="nhsuk-promo">
					<a href="${community.getViewURL(themeDisplay)}" class="nhsuk-promo__link-wrapper">
						<div class="nhsuk-promo__content">
							<h3 class="nhsuk-promo__heading">
								${community.getName()}
							</h3>
						</div>
					</a>
				</div>
			</div>

		</c:forEach>

	</div>

	<c:if test="${not empty browseAllURL}">
		<div class="nhsuk-action-link">
			<a class="nhsuk-action-link__link" href="${browseAllURL}"> 
				<svg class="nhsuk-icon nhsuk-icon__arrow-right-circle" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
					<path d="M0 0h24v24H0z" fill="none"></path>
					<path d="M12 2a10 10 0 0 0-9.95 9h11.64L9.74 7.05a1 1 0 0 1 1.41-1.41l5.66 5.65a1 1 0 0 1 0 1.42l-5.66 5.65a1 1 0 0 1-1.41 0 1 1 0 0 1 0-1.41L13.69 13H2.05A10 10 0 1 0 12 2z"></path>
				</svg>
				<span class="nhsuk-action-link__text">
					<liferay-ui:message key="browse-all-communities" />
				</span>
			</a>
		</div>
	</c:if>
</c:if>