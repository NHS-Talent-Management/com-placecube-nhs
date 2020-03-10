<#if entries?has_content>
	<nav class="nhsuk-header__navigation" id="header-navigation" role="navigation" aria-labelledby="label-navigation">
		<div class="nhsuk-width-container">
			<p class="nhsuk-header__navigation-title">
				<span id="label-navigation">Menu</span>
				<button class="nhsuk-header__navigation-close" id="close-menu">
					<svg class="nhsuk-icon nhsuk-icon__close" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true" focusable="false">
						<path d="M13.41 12l5.3-5.29a1 1 0 1 0-1.42-1.42L12 10.59l-5.29-5.3a1 1 0 0 0-1.42 1.42l5.3 5.29-5.3 5.29a1 1 0 0 0 0 1.42 1 1 0 0 0 1.42 0l5.29-5.3 5.29 5.3a1 1 0 0 0 1.42 0 1 1 0 0 0 0-1.42z"></path>
					</svg>
					<span class="nhsuk-u-visually-hidden">Close menu</span>
				</button>
			</p>
 
			<ul class="nhsuk-header__navigation-list">
				<#list entries as navigationEntry>
					<li class="nhsuk-header__navigation-item">
						<a class="nhsuk-header__navigation-link" href="${navigationEntry.getRegularURL()}">
							${navigationEntry.getName()}
							<svg class="nhsuk-icon nhsuk-icon__chevron-right" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
								<path d="M15.5 12a1 1 0 0 1-.29.71l-5 5a1 1 0 0 1-1.42-1.42l4.3-4.29-4.3-4.29a1 1 0 0 1 1.42-1.42l5 5a1 1 0 0 1 .29.71z"></path>
							</svg>
						</a>
					</li>
				</#list>
				
				<#if themeDisplay.isSignedIn()>
				    <li class="nhsuk-header__navigation-item">
						<a class="nhsuk-header__navigation-link" href="${themeDisplay.getURLSignOut()}">
							Sign out
							<svg class="nhsuk-icon nhsuk-icon__chevron-right" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true">
								<path d="M15.5 12a1 1 0 0 1-.29.71l-5 5a1 1 0 0 1-1.42-1.42l4.3-4.29-4.3-4.29a1 1 0 0 1 1.42-1.42l5 5a1 1 0 0 1 .29.71z"></path>
							</svg>
						</a>
					</li>
				</#if>
				
			</ul>
		</div>
	</nav>
</#if>