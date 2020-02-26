<div class="course-display">
	<h1>
	    ${.vars['reserved-article-title'].data}
	</h1>
	
	<div class="nhsuk-body-l">
	    ${.vars['reserved-article-description'].data}
	</div>
	
	<#if Description.getData()?has_content>
		<div class="nhsuk-body">
			${Description.getData()}
		</div>	
	</#if>
	
	<#assign Created_Data = getterUtil.getString(Created.getData())>
	<#if validator.isNotNull(Created_Data)>
		<#assign Created_DateObj = dateUtil.parseDate("yyyy-MM-dd", Created_Data, locale)>
		<p class="nhsuk-body">
			Created: ${dateUtil.getDate(Created_DateObj, "dd MMM yyyy", locale)}
		</p>
	</#if>
		
	 
	<#assign LastMajorUpdate_Data = getterUtil.getString(LastMajorUpdate.getData())>
	<#if validator.isNotNull(LastMajorUpdate_Data)>
		<#assign LastMajorUpdate_DateObj = dateUtil.parseDate("yyyy-MM-dd", LastMajorUpdate_Data, locale)>
		<p class="nhsuk-body">
			Last Major Update: ${dateUtil.getDate(LastMajorUpdate_DateObj, "dd MMM yyyy", locale)}
		</p>
	</#if>
	
	<#if Author.getData()?has_content>
		<p class="nhsuk-body">
			Author: ${Author.getData()}
		</p>	
	</#if>
	
	<#if Provider.getData()?has_content>
		<p class="nhsuk-body">
			Provider: ${Provider.getData()}
		</p>	
	</#if>

	<#assign tagNames = .vars['reserved-article-asset-tag-names'].data />
	<#if tagNames?has_content>
		<p class="nhsuk-body">
			Keywords: ${tagNames}
		</p>	
	</#if>
	
	<#if ProviderCourseURL.getData()?has_content>
	    <#if themeDisplay.isSignedIn()>
	        <a class="nhsuk-button" href="${ProviderCourseURL.getData()}" target="_blank">
              Join the course
            </a>
	    <#else>
	        <a class="nhsuk-button" href="${themeDisplay.getURLSignIn()}">
              Join to access the course
            </a>
	    </#if>
	</#if>

</div>