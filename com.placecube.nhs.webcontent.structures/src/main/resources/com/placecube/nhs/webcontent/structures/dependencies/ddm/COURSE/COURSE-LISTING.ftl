<#assign htmlUtil = serviceLocator.findService("com.liferay.portal.kernel.util.HtmlUtil")/>
<#assign journalContentRendererService = serviceLocator.findService("com.pfiks.journal.content.service.JournalContentRendererService")/>
<#assign urlService = serviceLocator.findService("com.placecube.nhs.template.utils.URLService")/>

<div class="nhsuk-grid-column-full nhsuk-promo-group__item">
	<div class="nhsuk-promo">

		<#assign articleViewURL = journalContentRendererService.getFriendlyURL(groupId, .vars['reserved-article-id'].data, "COURSE") />
		<#assign currentPageURL = urlService.getCurrentFullURL(themeDisplay) />
		
		<a class="nhsuk-promo__link-wrapper" href="${currentPageURL}${articleViewURL}">
		
			<div class="nhsuk-promo__content">
				<h2 class="nhsuk-promo__heading">
				    ${.vars['reserved-article-title'].data}
				</h2>
				

			    <#assign summaryText = .vars['reserved-article-description'].data />
			    <#if !summaryText?has_content>
			        <#assign summaryText = Description.getData() />
			    </#if>
			    
			    <#assign summaryText = htmlUtil.extractText(summaryText) />
                <#if summaryText?has_content>
			        
			        <div class="nhsuk-promo__description">
    			        <#if summaryText?length gt 200 >
    			            ${summaryText[0..*200]}...
                        <#else>
                            ${summaryText}
                        </#if>
			        </div>
			        
			    </#if>
			    
			</div>
			
		</a>
	</div>
</div>