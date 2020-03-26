<%@ include file="../init.jsp"%>

<c:if test="${themeDisplay.isSignedIn()}">
	
	<portlet:renderURL var="addProfessionalBodyUrl" windowState="${windowStateMaximized}">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.PROFESSIONAL_BODIES_EDIT%>"/>
	</portlet:renderURL>
	
	
	<div class="nhsuk-care-card nhsuk-care-card--non-urgent">
		<div class="nhsuk-care-card__heading-container">
			<h3 class="nhsuk-care-card__heading">
				<span role="text">
					<liferay-ui:message key="professional-bodies"/>
				</span>
				<span class="action-icon">
					<a href="${addProfessionalBodyUrl}">
						<aui:icon cssClass="icon-monospaced" image="plus" markupView="lexicon" />
						<span class="nhsuk-u-visually-hidden"><liferay-ui:message key="add-professional-body"/></span>
					</a>
				</span>		
			</h3>
		</div>
		<div class="nhsuk-care-card__content">
			<c:choose>
				<c:when test="${not empty professionalBodies}">
					<c:forEach items="${professionalBodies}" var="professionalBody" varStatus="loop">
						<div class="professionalBody-entry">
							<h4 class="nhsuk-u-margin-0">
								${professionalBody.title}
								
								<portlet:renderURL var="updateProfessionalBodyUrl" windowState="${windowStateMaximized}">
									<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.PROFESSIONAL_BODIES_EDIT%>"/>
									<portlet:param name="professionalBodyId" value="${professionalBody.professionalBodyId}"/>
								</portlet:renderURL>
								
								<span class="pull-right">
									<a href="${updateProfessionalBodyUrl}">
										<aui:icon cssClass="icon-monospaced" image="pencil" markupView="lexicon" />
									</a>
								</span>		
							</h4>
							
							<p class="nhsuk-u-margin-0"><liferay-ui:message key="location"/>:&nbsp;${professionalBody.location}</p>
							<p class="nhsuk-u-margin-0">
								<liferay-ui:message key="expiry-date"/>:&nbsp;
								<fmt:formatDate value="${professionalBody.getExpiryDate()}" pattern="dd/MM/yyyy" />
							</p>
							<c:if test="${not loop.last}">
								<hr class="nhsuk-section-break nhsuk-section-break--visible nhsuk-u-margin-bottom-3 nhsuk-u-margin-top-3"/>
							</c:if>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<a href="${addProfessionalBodyUrl}">
						<aui:icon cssClass="icon-monospaced" image="plus" markupView="lexicon" />
						<span class="h5"><liferay-ui:message key="add-professional-body"/></span>
					</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</c:if>