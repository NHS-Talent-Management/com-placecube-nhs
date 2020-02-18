<#assign journalContentRendererService = serviceLocator.findService("com.pfiks.journal.content.service.JournalContentRendererService")/>
<#assign portalUtil = serviceLocator.findService("com.liferay.portal.kernel.util.PortalUtil")/>

<div class="nhsuk-grid-column-full nhsuk-promo-group__item">
	<div class="nhsuk-promo">

		<#assign articleViewURL = journalContentRendererService.getFriendlyURL(groupId, .vars['reserved-article-id'].data, "JOB") />
		<#assign currentPageURL = portalUtil.getLayoutFullURL(themeDisplay.getLayout(), themeDisplay) />
		
		<a class="nhsuk-promo__link-wrapper" href="${currentPageURL}${articleViewURL}">
		
			<div class="nhsuk-promo__content">
				<h2 class="nhsuk-promo__heading">
				    ${.vars['reserved-article-title'].data}
				</h2>
				
		        <div class="nhsuk-promo__description">
			       ${Department.getData()}
		        </div>
			    
			    <div class="nhsuk-promo__description">
			       ${Location.getData()}
		        </div>
		        
		        <div class="nhsuk-promo__description">
			        Salary : ${SalaryFrom.getData()} to ${SalaryTo.getData()}
		        </div>
		        
			</div>
			
		</a>
	</div>
</div>