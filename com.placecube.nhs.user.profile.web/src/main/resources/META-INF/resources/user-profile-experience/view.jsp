<%@ include file="../init.jsp"%>


<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
	
		<portlet:renderURL var="addExperienceUrl" windowState="${windowStateMaximized}">
			<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.EXPERIENCE_EDIT%>"/>
		</portlet:renderURL>
		
		<div class="nhsuk-care-card nhsuk-care-card--non-urgent">
			<div class="nhsuk-care-card__heading-container">
				<h3 class="nhsuk-care-card__heading">
					<span role="text">
						<liferay-ui:message key="experience"/>
					</span>
					<span class="action-icon">
						<a href="${addExperienceUrl}">
							<aui:icon cssClass="icon-monospaced" image="plus" markupView="lexicon" />
						</a>
					</span>		
				</h3>
			</div>
			<div class="nhsuk-care-card__content">
				<c:choose>
					<c:when test="${not empty experiences}">
						<c:forEach items="${experiences}" var="experience" varStatus="loop">
							<div class="experience-entry">
								<h4 class="nhsuk-u-margin-0">
									${experience.role}
									
									<portlet:renderURL var="updateExperienceUrl" windowState="${windowStateMaximized}">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.EXPERIENCE_EDIT%>"/>
										<portlet:param name="experienceId" value="${experience.experienceId}"/>
									</portlet:renderURL>
									
									<span class="pull-right">
										<a href="${updateExperienceUrl}">
											<aui:icon cssClass="icon-monospaced" image="pencil" markupView="lexicon" />
										</a>
									</span>		
								</h4>
								
								<p class="nhsuk-u-margin-0">${experience.placeOfWork}</p>
								<p class="nhsuk-u-margin-0"><nhs-dates-ui:friendlyTimeFrame startDate="${experience.getFromDate()}"endDate="${experience.getToDate()}" /></p>
								<c:if test="${not loop.last}">
									<hr class="nhsuk-section-break nhsuk-section-break--visible nhsuk-u-margin-bottom-3 nhsuk-u-margin-top-3"/>
								</c:if>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<a href="${addExperienceUrl}">
							<aui:icon cssClass="icon-monospaced" image="plus" markupView="lexicon" />
							<span class="h5"><liferay-ui:message key="add-experience"/></span>
						</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="please-sign-in-to-access-this-application"/>
	</c:otherwise>
</c:choose>


