<%@ include file="../init.jsp"%>

<div class="row nhsuk-u-margin-bottom-3 nhsuk-u-margin-top-3">
	<div class="col-md-12">
	
		<c:choose>
	
			<c:when test="${isGuest}">
				<a href="${themeDisplay.getURLSignIn()}" class="nhsuk-button join-community-button">
					<liferay-ui:message key="log-in-to-join-this-community" />
				</a>
			</c:when>
			
			<c:when test="${isSiteMember}">
				<portlet:actionURL name="<%=MVCCommandKeys.UPDATE_MEMBERSHIP%>" var="leaveGroupURL">
					<portlet:param name="cmd" value="leave"/>
				</portlet:actionURL>
				
				<a href="${leaveGroupURL}" class="leave-community-button float-right">
					<svg class="nhsuk-icon nhsuk-icon__cross" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
						<path d="M17 18.5c-.4 0-.8-.1-1.1-.4l-10-10c-.6-.6-.6-1.6 0-2.1.6-.6 1.5-.6 2.1 0l10 10c.6.6.6 1.5 0 2.1-.3.3-.6.4-1 .4z"></path>
						<path d="M7 18.5c-.4 0-.8-.1-1.1-.4-.6-.6-.6-1.5 0-2.1l10-10c.6-.6 1.5-.6 2.1 0 .6.6.6 1.5 0 2.1l-10 10c-.3.3-.6.4-1 .4z"></path>
					</svg>
					<liferay-ui:message key="leave-this-community" />
				</a>
			</c:when>
			
			<c:otherwise>
				<portlet:actionURL name="<%=MVCCommandKeys.UPDATE_MEMBERSHIP%>" var="joinGroupURL" >
					<portlet:param name="cmd" value="join"/>
				</portlet:actionURL>
				
				<a href="${joinGroupURL}" class="nhsuk-button join-community-button">
					<liferay-ui:message key="join-this-community" />
				</a>
			</c:otherwise>
			
		</c:choose>

	</div>
</div>