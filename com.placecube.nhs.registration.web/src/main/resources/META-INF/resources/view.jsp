<%@ include file="init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.REGISTER%>" var="personalDetailsURL" />

<div class="row">
	<div class="col-md-12">
		<liferay-journal:journal-article 
			articleId="<%= WebContentArticles.REGISTRATION_INTRO_TEXT.getArticleId() %>" 
			groupId="${webContentGroupId}" 
			showTitle="false" />
	</div>
</div>

<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${registrationContext.getErrors()}"/>

<aui:form action="${personalDetailsURL}" method="post" name="createAccountForm">
	
	<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
			fieldName="firstName" 
			fieldLabel="first-name"
			fieldValue="${registrationContext.getFirstName()}" 
			errorMessage="${registrationContext.getFieldError('firstName')}" 
			showAsPassword="false"/>
	
	<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
			fieldName="lastName" 
			fieldLabel="last-name" 
			fieldValue="${registrationContext.getLastName()}"
			errorMessage="${registrationContext.getFieldError('lastName')}" 
			showAsPassword="false"/>
	
	<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
			fieldName="emailAddress" 
			fieldLabel="email-address"
			fieldValue="${registrationContext.getEmailAddress()}"
			errorMessage="${registrationContext.getFieldError('emailAddress')}" 
			showAsPassword="false"/>
	
	<c:if test="${not empty passwordPolicyDescription}">
		<div class="row nhsuk-u-margin-top-5 nhsuk-u-margin-bottom-3">
			<div class="col-md-12">
				<c:out value="${passwordPolicyDescription}"/>
			</div>
		</div>
	</c:if>

	<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
		fieldName="password" 
		fieldLabel="password"
		fieldValue=""
		errorMessage="${registrationContext.getFieldError('password')}" 
		showAsPassword="true"/>

	<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
		fieldName="confirmPassword" 
		fieldLabel="confirm-password"
		fieldValue=""
		errorMessage="${registrationContext.getFieldError('confirmPassword')}" 
		showAsPassword="true"/>
	
	<c:if test="${captchaEnabled}">
		<div class="row" id="${portletNamespace}_error_captchaField">
			<div class="col-md-12 captcha">
				<p class="captcha-title"><liferay-ui:message key="prove-you-are-not-a-robot"/></p>
				<liferay-portlet:resourceURL copyCurrentRenderParameters="false" id="<%= MVCCommandKeys.DISPLAY_CAPTCHA %>" var="captchaURL" />
	
				<liferay-captcha:captcha url="${captchaURL}" />
			</div>
		</div>
	</c:if>

	<aui:button-row>
		<button type="submit" class="nhsuk-button"><liferay-ui:message key="continue"/></button>
	</aui:button-row>

</aui:form>

<%@ include file="sso.jspf"%>

<div class="row">
	<div class="col-md-12">
		<liferay-journal:journal-article 
			articleId="<%= WebContentArticles.REGISTRATION_BOTTOM_TEXT.getArticleId() %>" 
			groupId="${webContentGroupId}" 
			showTitle="false" />
	</div>
</div>
