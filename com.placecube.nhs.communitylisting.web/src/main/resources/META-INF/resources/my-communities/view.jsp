<%@ include file="../init.jsp"%>

<div class="nhsuk-care-card nhsuk-care-card--non-urgent">
	<div class="nhsuk-care-card__heading-container">
		<h3 class="nhsuk-care-card__heading">
			<span role="text">
				<liferay-ui:message key="${communityTypeLabel}"/>
			</span>
			<c:if test="${not empty viewAllURL}">
				<span class="action-icon">
					<a href="${viewAllURL}">
						<aui:icon cssClass="icon-monospaced" image="search" markupView="lexicon" />
					</a>
				</span>		
			</c:if>
		</h3>
	</div>
	<div class="nhsuk-care-card__content">
		<c:choose>
			<c:when test="${not empty communities}">
				<c:forEach items="${communities}" var="group" varStatus="loop">
					<div class="community-entry">
						<h4 class="nhsuk-u-margin-0">
							<a href="${group.getDisplayURL(themeDisplay)}">
								${group.getName(locale)}
							</a>
						</h4>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:if test="${not empty viewAllURL}">
					<a href="${viewAllURL}">
						<aui:icon cssClass="icon-monospaced" image="search" markupView="lexicon" />
						<span class="h5"><liferay-ui:message key="browse-communities"/></span>
					</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</div>

