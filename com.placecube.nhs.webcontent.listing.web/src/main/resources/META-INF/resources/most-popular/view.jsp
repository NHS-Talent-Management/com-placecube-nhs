<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${invalidConfiguration}">
		<div class="alert alert-warning">
			<liferay-ui:message key="the-default-preferences-are-invalid"/>
		</div>
	</c:when>
	<c:otherwise>
		<c:if test="${not empty journalArticleDisplays}">
		
			<div class="nhsuk-grid-row nhsuk-promo-group">
		
				<c:forEach items="${journalArticleDisplays}" var="journalArticleDisplay">
		
					${journalArticleDisplay.getContent()}
		
				</c:forEach>
		
			</div>
		
		</c:if>
	</c:otherwise>
</c:choose>

