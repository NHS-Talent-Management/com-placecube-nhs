<%@ include file="../init.jsp"%>

<c:if test="${not empty errors}">

	<div class="nhsuk-error-summary" aria-labelledby="error-summary-title" role="alert" tabindex="-1">
		
		<h2 class="nhsuk-error-summary__title" id="${portletNamespace}error-summary-title">
			<liferay-ui:message key="there-is-a-problem" />
		</h2>
		
		<div class="nhsuk-error-summary__body">
			<ul class="nhsuk-list nhsuk-error-summary__list">
				<c:forEach items="${errors}" var="error">
					<li>
					  <a href="#${portletNamespace}_error_${error.key}">${error.value}</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		
	</div>

</c:if>
