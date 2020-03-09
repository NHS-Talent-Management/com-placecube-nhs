<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
		<div class="row nhsuk-u-margin-bottom-4">
			<div class="col-md-12">
				<c:set var="questionEntryDetails" value="${question.getIndex()},${totalQuestions}"/>
				<liferay-ui:message key="question-entry" arguments="${fn:split(questionEntryDetails,',')}"/>
			</div>
		</div>
		
		<liferay-portlet:actionURL name="<%=MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER%>" windowState="<%=WindowState.MAXIMIZED.toString() %>" var="saveAndContinueURL">
			<liferay-portlet:param name="currentQuestionIndex" value="${question.getIndex()}"/>
			<liferay-portlet:param name="currentQuestionId" value="${question.getQuestionId()}"/>
		</liferay-portlet:actionURL>
		
		<liferay-portlet:renderURL  windowState="<%=WindowState.MAXIMIZED.toString() %>" var="previousQuestionURL">
			<liferay-portlet:param name="mvcRenderCommandName" value="<%=MVCCommandKeys.QUESTIONNAIRE_EDIT_ANSWER %>"/>
			<liferay-portlet:param name="currentQuestionIndex" value="${question.getIndex()}"/>
			<liferay-portlet:param name="<%=Constants.CMD %>" value="previous"/>
		</liferay-portlet:renderURL>
		
		<aui:form action="${saveAndContinueURL}" method="post" name="saveAndContinueForm">
		
			<div class="nhsuk-form-group">
			
				<fieldset class="nhsuk-fieldset">
					<legend class="nhsuk-fieldset__legend nhsuk-fieldset__legend--l">
						<h1 class="nhsuk-fieldset__heading">
							${question.getQuestionTitle()}
						</h1>
					</legend>
					
					<div class="nhsuk-radios">
						<c:forEach items="${question.getAvailableAnswers()}" var="answer" varStatus="loop">
							<div class="nhsuk-radios__item">
								<input class="nhsuk-radios__input" 
										id="<portlet:namespace/>userAnswer-${loop.index}" 
										name="<portlet:namespace/>userAnswer" 
										type="radio" 
										value="${answer}"
										${answer.equals(question.getUserAnswer()) ? 'checked' : ''}>
								<label class="nhsuk-label nhsuk-radios__label" for="<portlet:namespace/>userAnswer-${loop.index}">
									${answer}
								</label>
							</div>
						</c:forEach>
					</div>
				</fieldset>
			
			</div>
				
			
			<aui:button-row cssClass="nhsuk-u-margin-top-8">	
				<aui:button type="submit" cssClass="nhsuk-button" value="save-and-continue"/>
				<c:if test="${question.getIndex() gt 1}">
					<aui:button type="cancel" href="${previousQuestionURL}" cssClass="nhsuk-button nhsuk-button--secondary" value="change-my-previous-answer"/>
				</c:if>
			</aui:button-row>		
			
		</aui:form>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="please-sign-in-to-access-this-application"/>
		</div>
	</c:otherwise>
</c:choose>

	