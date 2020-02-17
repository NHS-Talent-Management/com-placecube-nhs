<%@ include file="../init.jsp"%>

<c:if test="${not empty journalArticleDisplays}">

	<div class="nhsuk-grid-row nhsuk-promo-group">

		<c:forEach items="${journalArticleDisplays}" var="journalArticleDisplay">

			${journalArticleDisplay.getContent()}

		</c:forEach>

	</div>

</c:if>