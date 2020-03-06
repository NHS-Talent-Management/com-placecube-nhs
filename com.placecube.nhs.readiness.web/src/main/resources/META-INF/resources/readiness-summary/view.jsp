<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
		<c:if test="${not empty questions}">
		
			<div class="nhsuk-care-card nhsuk-care-card--non-urgent">
				<div class="nhsuk-care-card__heading-container">
					<liferay-portlet:renderURL portletName="<%=PortletKeys.READINESS_QUESTIONNAIRE %>" windowState="<%=WindowState.MAXIMIZED.toString() %>" var="startQuestionnaireURL">
						<liferay-portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.QUESTIONNAIRE_VIEW %>"/>
					</liferay-portlet:renderURL>
			
					<h3 class="nhsuk-care-card__heading">
						<span role="text">
							<liferay-ui:message key="career-readiness"/>
						</span>
						<span class="action-icon">
							<a href="${startQuestionnaireURL}">
								<aui:icon cssClass="icon-monospaced" image="pencil" markupView="lexicon" />
							</a>
						</span>		
					</h3>
					
				</div>
				
				<div class="nhsuk-care-card__content">
					<dl class="nhsuk-summary-list">
					
						<c:forEach items="${questions}" var="question">
							
							<div class="nhsuk-summary-list__row">
								<dt class="nhsuk-summary-list__key">
									${question.getQuestionName()}
								</dt>
								
								<dd class="nhsuk-summary-list__value">
									${question.getUserAnswer()}
								</dd>
								
								<dd class="nhsuk-summary-list__actions">
									<liferay-portlet:renderURL portletName="<%=PortletKeys.READINESS_QUESTIONNAIRE %>" windowState="<%=WindowState.MAXIMIZED.toString() %>" var="editQuestionURL">
										<liferay-portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER %>"/>
										<liferay-portlet:param name="currentQuestionIndex" value="${question.getIndex()}"/>
									</liferay-portlet:renderURL>
									
									<a href="${editQuestionURL}">
										<liferay-ui:message key="change"/><span class="nhsuk-u-visually-hidden"> ${question.getQuestionName()}</span>
									</a>
								</dd>
							</div>
							
						</c:forEach>
					
					</dl>
				</div>
			</div>
		
		</c:if>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="please-sign-in-to-access-this-application"/>
	</c:otherwise>
</c:choose>

	