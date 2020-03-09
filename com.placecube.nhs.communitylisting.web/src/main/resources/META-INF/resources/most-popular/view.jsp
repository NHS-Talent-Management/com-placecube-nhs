<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${invalidConfiguration}">
		<div class="alert alert-warning">
			<liferay-ui:message key="the-default-preferences-are-invalid"/>
		</div>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${compactDisplay}">
		
				<div class="nhsuk-grid-row nhsuk-promo-group compact-mobile-view">
				
					<c:forEach items="${communities}" var="group">
				
						<div class="nhsuk-grid-column-one-third nhsuk-promo-group__item nhsuk-u-margin-bottom-3">
							<div class="nhsuk-promo">
								<a href="${group.getDisplayURL(themeDisplay)}" class="nhsuk-promo__link-wrapper">
									<div class="nhsuk-promo__content">
										<h3 class="nhsuk-promo__heading">
											${group.getName(locale)}
										</h3>
									</div>
								</a>
							</div>
						</div>
				
					</c:forEach>
				
				</div>
			
			</c:when>
			
			<c:otherwise>
				<div class="community-listing-icon-view">
					<div class="nhsuk-grid-row nhsuk-promo-group">
					
						<c:forEach items="${communities}" var="group">
						
							<div class="nhsuk-grid-column-full nhsuk-promo-group__item nhsuk-u-margin-bottom-3">
								<div class="nhsuk-promo">
									<a href="${group.getDisplayURL(themeDisplay)}" class="nhsuk-promo__link-wrapper">
										<c:set var="logoURL" value="${group.getLogoURL(themeDisplay, false)}"/>
										<c:if test="${empty logoURL}">
											<c:set var="logoURL" value="${renderRequest.contextPath}/images/icon-community.png"/>	
										</c:if>
										
										<div class="nhsuk-promo__content">
											<img class="community-listing-logo" src="${logoURL}" alt="logo">
											<div class="col-md-9">
												<h3 class="nhsuk-promo__heading">
													${group.getName(locale)}
												</h3>
												<div class="nhsuk-promo__description">
													${group.getDescription(locale)}
												</div>
											</div>
										</div>
									</a>
								</div>
							</div>
						
						</c:forEach>
					
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
