<#if !entries?has_content>
	
	<#if !themeDisplay.isSignedIn()>
		${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
	</#if>

	<div class="alert alert-info">
		<@liferay_ui["message"] key="there-are-no-results" />
	</div>

<#else>
	<#assign userLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService") />
	<#assign blogsEntryLocalService = serviceLocator.findService("com.liferay.blogs.service.BlogsEntryLocalService")/>
	<#assign commentManager = serviceLocator.findService("com.liferay.portal.kernel.comment.CommentManager")/>
	<#assign htmlUtil = serviceLocator.findService("com.liferay.portal.kernel.util.HtmlUtil")/>
    
    <div class="row widget-mode-card">
	
    	<#list entries as entry>
    		<#assign assetRenderer = entry.getAssetRenderer() />
    
    		<#assign curBlogEntry = blogsEntryLocalService.getBlogsEntry(entry.getClassPK()) />
    		
    		<#assign viewURLAssetEntry = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, assetRenderer, entry, !stringUtil.equals(assetLinkBehavior, "showFullContent"))	/>
    	    <#assign viewURL = "/c/blogs/find_entry?p_l_id=" + themeDisplay.getPlid() +"&entryId="+ entry.getClassPK() +"&noSuchEntryRedirect="+viewURLAssetEntry />
    		
    		 <#if curBlogEntry.getCoverImageURL(themeDisplay)??>
    			<#assign cardImage = true />
    		<#else>
    			<#assign cardImage = false />
    		</#if>
    	
    		<div class="col-lg-4">
    			<div class="card">
    				<#if cardImage>
    					<div class="card-header">
    						<div class="aspect-ratio aspect-ratio-8-to-3">
    							<img alt="thumbnail" class="aspect-ratio-item-center-middle aspect-ratio-item-fluid" src="${curBlogEntry.getCoverImageURL(themeDisplay)}">
    						</div>
    					</div>
    				</#if>
    	
    				<div class="card-body widget-topbar">
    					<div class="autofit-row card-title">
    						<div class="autofit-col autofit-col-expand">
    							<h3 class="title">
    								<a class="title-link" href="${viewURL}">
    									${htmlUtil.escape(assetRenderer.getTitle(locale))}
    								</a>
    							</h3>
    						</div>
    					</div>
    	
    					<div class="autofit-row widget-metadata">
    						<div class="autofit-col inline-item-before">
								<@liferay_ui["user-portrait"]
									size="lg"
									userId=curBlogEntry.userId
									userName=curBlogEntry.userName
								/>
							</div>
							
							<#assign entryUser = userLocalService.fetchUser(curBlogEntry.getUserId()) />
    						<div class="autofit-col autofit-col-expand">
    							<div class="autofit-row">
    								<div class="autofit-col autofit-col-expand nhsuk-u-margin-bottom-3">
    									<div class="text-truncate-inline">
											<span class="text-truncate username">${curBlogEntry.getUserName()}</span>
										</div>
    									<div>
    										${dateUtil.getDate(curBlogEntry.getStatusDate(), "dd MMMM yyyy", locale)}
    									</div>
    								</div>
    							</div>
    						</div>
    					</div>
    	
    					<#if validator.isNotNull(curBlogEntry.getDescription())>
    						<#assign content = curBlogEntry.getDescription() />
    					<#else>
    						<#assign content = curBlogEntry.getContent() />
    					</#if>
    	
    					<#if cardImage>
    						<p class="widget-resume">${stringUtil.shorten(htmlUtil.stripHtml(content), 150)}</p>
    					<#else>
    						<p class="widget-resume">${stringUtil.shorten(htmlUtil.stripHtml(content), 400)}</p>
    					</#if>
    				</div>
    	
    				<div class="card-footer">
    					<div class="card-row">
    						<div class="autofit-float autofit-row autofit-row-center widget-toolbar">
    							<div class="autofit-col">
    
    								<span class="btn-sm rating-off" >
    									<span class="inline-item inline-item-before">
    										<@clay["icon"] symbol="comments" />
    									</span> ${commentManager.getCommentsCount("com.liferay.blogs.model.BlogsEntry", curBlogEntry.getEntryId())}
    								</span>
    							</div>
    	
    							<div class="autofit-col">
    								<@liferay_ui["ratings"]
    									className="com.liferay.blogs.model.BlogsEntry"
    									classPK=curBlogEntry.getEntryId()
    								/>
    							</div>
    	
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</#list>
    </div>
</#if>
