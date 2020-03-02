<%@ include file="../init.jsp"%>

<portlet:actionURL name="<%=MVCCommandKeys.EDIT%>" var="userProfilEditURL" />

<portlet:renderURL var="viewUrl" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandKeys.VIEW %>"/>
</portlet:renderURL>



<aui:form action="${userProfilEditURL}" method="post" name="userProfilForm">
	<div class="row">
		<div class="col-md-12">
			<div class="pull-left">
				<div class="nhsuk-back-link">
					<a class="nhsuk-back-link__link" href="${ viewUrl }">
						<svg class="nhsuk-icon nhsuk-icon__chevron-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
							<path d="M8.5 12c0-.3.1-.5.3-.7l5-5c.4-.4 1-.4 1.4 0s.4 1 0 1.4L10.9 12l4.3 4.3c.4.4.4 1 0 1.4s-1 .4-1.4 0l-5-5c-.2-.2-.3-.4-.3-.7z"></path>
						</svg>
						<liferay-ui:message key="back-to-profile"/>
					</a>
				</div>
			</div>
			<div class="pull-right">
				<button class="nhsuk-button" type="submit">
					<liferay-ui:message key="save"/>
				</button> 
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12 text-center">
			<h2>
				<liferay-ui:message key="add-intro"/>
			</h2>
		</div>
	</div>

	<nhs-forms-ui:errorSummary portletNamespace="${portletNamespace}" errors="${userProfileContext.getErrors()}"/>

	<div class="row">
		<div class="col-md-12">

			<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
				fieldName="firstName"
				fieldLabel="first-name"
				fieldValue="${userProfileContext.getFirstName()}"
				errorMessage="${userProfileContext.getFieldError('firstName')}"
				showAsPassword="false"/>

			<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
				fieldName="lastName"
				fieldLabel="last-name"
				fieldValue="${userProfileContext.getLastName()}"
				errorMessage="${userProfileContext.getFieldError('lastName')}" 
				showAsPassword="false"/>

			<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
				fieldName="currentPosition"
				fieldLabel="current-position"
				fieldValue="${userProfileContext.getCurrentPosition()}"
				errorMessage="${userProfileContext.getFieldError('currentPosition')}" 
				showAsPassword="false"/>
						
			<nhs-forms-ui:inputText portletNamespace="${portletNamespace}" 
				fieldName="location"
				fieldLabel="location"
				fieldValue="${userProfileContext.getLocation()}"
				errorMessage="${userProfileContext.getFieldError('location')}" 
				showAsPassword="false"/>

			<nhs-forms-ui:textarea portletNamespace="${portletNamespace}" 
				fieldName="summary"
				fieldLabel="summary"
				fieldValue="${ userProfileContext.getSummary()}"
				errorMessage="${userProfileContext.getFieldError('summary')}"
				fieldRows="5"/>
		</div>
	</div>
</aui:form>