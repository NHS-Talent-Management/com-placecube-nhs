<div class="course-display">
	<h1>
	    ${.vars['reserved-article-title'].data}
	</h1>
	
	
	<p class="nhsuk-body">
		Job Ref: ${JobReference.getData()}
	</p>

	<p class="nhsuk-body">
		Employer: ${Employer.getData()}
	</p>
	
	<p class="nhsuk-body">
		Department: ${Department.getData()}
	</p>
	
	<p class="nhsuk-body">
		Location: ${Location.getData()}
	</p>
	
	<p class="nhsuk-body">
		Salary: ${SalaryFrom.getData()} - ${SalaryTo.getData()}
	</p>
	 
	<#if Description.getData()?has_content>
		<div class="nhsuk-body">
			${Description.getData()}
		</div>	
	</#if>


    <#if themeDisplay.isSignedIn()>
        <a class="nhsuk-button" href="${ApplyURL.getData()}" target="_blank">
          Apply
        </a>
    <#else>
        <a class="nhsuk-button" href="${themeDisplay.getURLSignIn()}">
          Join to apply
        </a>
    </#if>

</div>