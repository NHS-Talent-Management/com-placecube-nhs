<%@ include file="../init.jsp"%>

<c:if test="${themeDisplay.isSignedIn()}">
	
	<portlet:renderURL var="editProfileUrl" windowState="${windowStateMaximized}">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.PROFILE_DETAILS_EDIT%>"/>
	</portlet:renderURL>
	
	<div class="nhsuk-care-card nhsuk-care-card--non-urgent white-card">
	
		<div class="nhsuk-care-card__heading-container">
			<h3 class="nhsuk-care-card__heading">
				<span role="text">
					${ userProfileContext.firstName } ${ userProfileContext.lastName }
				</span>
				<span class="action-icon">
					<a href="${editProfileUrl}">
						<aui:icon cssClass="icon-monospaced" image="pencil" markupView="lexicon" />
						<span class="nhsuk-u-visually-hidden"><liferay-ui:message key="edit-your-profile-details"/></span>
					</a>
				</span>		
			</h3>
		</div>
		
		<div class="nhsuk-care-card__content">
			<c:choose>
				<c:when test="${ not empty userProfileContext.currentPosition || not empty userProfileContext.location || not empty userProfileContext.summary}">
					
						<c:if test="${not empty userProfileContext.currentPosition}">
							<p class="nhsuk-u-font-weight-regular nhsuk-u-margin-bottom-1">
								${ userProfileContext.currentPosition }
							</p>
						</c:if>
					
						<c:if test="${not empty userProfileContext.location}">
							<p class="nhsuk-u-font-weight-regular nhsuk-u-margin-bottom-1">
								${userProfileContext.location}
							</p>
						</c:if>
				
						<c:if test="${not empty userProfileContext.summary}">
							<hr class="nhsuk-section-break nhsuk-section-break--visible nhsuk-u-margin-bottom-1"/>
							<p class="nhsuk-u-font-weight-bold nhsuk-u-margin-bottom-1">
								Summary
							</p>
							<p class="nhsuk-u-font-weight-regular">
								${userProfileContext.summary}
							</p>
						</c:if>
				</c:when>
				<c:otherwise>
					<a href="${editProfileUrl}">
						<aui:icon cssClass="icon-monospaced" image="plus" markupView="lexicon" />
						<span class="h5"><liferay-ui:message key="add-profile-details"/></span>
					</a>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>
</c:if>

	