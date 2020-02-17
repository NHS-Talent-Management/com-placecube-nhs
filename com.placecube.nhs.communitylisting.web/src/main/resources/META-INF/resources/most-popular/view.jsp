<%@ include file="../init.jsp"%>


<div class="nhsuk-grid-row nhsuk-promo-group compact-mobile-view">

	<c:forEach items="${communities}" var="group">

		<div class="nhsuk-grid-column-one-third nhsuk-promo-group__item nhsuk-u-margin-bottom-3">
			<div class="nhsuk-promo">
				<a href="${group.getDisplayURL(themeDisplay)}" class="nhsuk-promo__link-wrapper">
					<div class="nhsuk-promo__content">
						<h3 class="nhsuk-promo__heading">
							${group.getName(locale)}
						</h3>
					</div>
				</a>
			</div>
		</div>

	</c:forEach>

</div>

