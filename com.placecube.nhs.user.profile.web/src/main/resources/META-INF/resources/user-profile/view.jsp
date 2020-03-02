<%@ include file="../init.jsp"%>

<portlet:renderURL var="editUrl" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandKeys.EDIT %>"/>
</portlet:renderURL>

<div class="row">
	<div class="col-md-12">
		<div class="pull-left">
			<h4 class="nhsuk-heading-l nhsuk-u-margin-bottom-2">
				${ userProfileContext.firstName } ${ userProfileContext.lastName }
			</h4>
		</div>
		<div class="pull-right">
			<a href="${ editUrl }"><aui:icon cssClass="icon-monospaced" image="pencil" markupView="lexicon" /></a>
		</div>
	</div>

	<div class="col-md-12">
		<c:if test="${ not empty userProfileContext.currentPosition}">
			<p class="nhsuk-u-font-weight-regular nhsuk-u-margin-bottom-1">
				${ userProfileContext.currentPosition }
			</p>
		</c:if>
	
		<c:if test="${ not empty userProfileContext.location}">
			<p class="nhsuk-u-font-weight-regular nhsuk-u-margin-bottom-1">
				${ userProfileContext.location }
			</p>
		</c:if>

		<c:if test="${ not empty userProfileContext.summary}">
			<hr class="nhsuk-section-break nhsuk-section-break--visible nhsuk-u-margin-bottom-1"/>
			<p class="nhsuk-u-font-weight-bold nhsuk-u-margin-bottom-1">
				Summary
			</p>
			<p class="nhsuk-u-font-weight-regular">
				${ userProfileContext.summary }
			</p>
		</c:if>
	</div>
</div>