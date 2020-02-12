<%@ include file="../init.jsp"%>

<nav class="nhsuk-nav-a-z" id="communities-nhsuk-nav-a-z" role="navigation" aria-label="A to Z Navigation">
	<ol class="nhsuk-nav-a-z__list" role="list">
		<c:forEach items="${azCommunities}" var="azCommunity">
			<li class="nhsuk-nav-a-z__item">
				<a class="${not empty azCommunity.value ? 'nhsuk-nav-a-z__link' : 'nhsuk-nav-a-z__link--disabled'}" href="#${azCommunity.key}">${azCommunity.key}</a>
			</li>
		</c:forEach>
	</ol>
</nav>

<c:forEach items="${azCommunities}" var="azCommunity">
	<div class="nhsuk-list-panel">
		
		<h2 class="nhsuk-list-panel__label" id="${azCommunity.key}">
			${azCommunity.key}
		</h2>
		
		<c:choose>
			<c:when test="${not empty azCommunity.value}">
				<ul class="nhsuk-list-panel__list nhsuk-list-panel__list--with-label">
					<c:forEach items="${azCommunity.value}" var="community">
						<li class="nhsuk-list-panel__item">
							<a class="nhsuk-list-panel__link" href="${community.getViewURL(themeDisplay)}">${community.getName()}</a>
						</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<div class="nhsuk-list-panel__box nhsuk-list-panel__box--with-label">
					<p class="nhsuk-list-panel--results-items__no-results">
						<liferay-ui:message key="no-communities-found"/>
					</p>
				</div>
			</c:otherwise>
		</c:choose>
		
		<div class="nhsuk-back-to-top">
			<a class="nhsuk-back-to-top__link" href="#communities-nhsuk-nav-a-z">
				<svg class="nhsuk-icon nhsuk-icon__arrow-right" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
					<path d="M19.6 11.66l-2.73-3A.51.51 0 0 0 16 9v2H5a1 1 0 0 0 0 2h11v2a.5.5 0 0 0 .32.46.39.39 0 0 0 .18 0 .52.52 0 0 0 .37-.16l2.73-3a.5.5 0 0 0 0-.64z"></path>
				</svg>
				<liferay-ui:message key="back-to-top"/>
			</a>
		</div>
	</div>

</c:forEach>

 
