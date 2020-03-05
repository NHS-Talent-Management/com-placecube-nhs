<%@ include file="../init.jsp"%>

<portlet:renderURL var="addQualificationUrl" windowState="${windowStateMaximized}">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.LEARNING_SKILLS_EDIT%>"/>
</portlet:renderURL>


<div class="nhsuk-care-card nhsuk-care-card--non-urgent">
	<div class="nhsuk-care-card__heading-container">
		<h3 class="nhsuk-care-card__heading">
			<span role="text">
				<liferay-ui:message key="learning-and-skills"/>
			</span>
			<span class="action-icon">
				<a href="${addQualificationUrl}">
					<aui:icon cssClass="icon-monospaced" image="plus" markupView="lexicon" />
				</a>
			</span>		
		</h3>
	</div>
	<div class="nhsuk-care-card__content">
		<c:choose>
			<c:when test="${not empty qualifications}">
				<c:forEach items="${qualifications}" var="qualification" varStatus="loop">
					<div class="qualification-entry">
						<h4 class="nhsuk-u-margin-0">
							${qualification.place}
							
							<portlet:renderURL var="updateQualificationUrl" windowState="${windowStateMaximized}">
								<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.LEARNING_SKILLS_EDIT%>"/>
								<portlet:param name="qualificationId" value="${qualification.qualificationId}"/>
							</portlet:renderURL>
							
							<span class="pull-right">
								<a href="${updateQualificationUrl}">
									<aui:icon cssClass="icon-monospaced" image="pencil" markupView="lexicon" />
								</a>
							</span>		
						</h4>
						
						<p class="nhsuk-u-margin-0">${qualification.qualification}</p>
						<p class="nhsuk-u-margin-0"><nhs-dates-ui:simpleTimeFrame startDate="${qualification.getFromDate()}"endDate="${qualification.getToDate()}" /></p>
						<c:if test="${not loop.last}">
							<hr class="nhsuk-section-break nhsuk-section-break--visible nhsuk-u-margin-bottom-3 nhsuk-u-margin-top-3"/>
						</c:if>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<a href="${addQualificationUrl}">
					<aui:icon cssClass="icon-monospaced" image="plus" markupView="lexicon" />
					<span class="h5"><liferay-ui:message key="add-learning-skills"/></span>
				</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>

