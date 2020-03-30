<div class="row widget-mode-card">
	<#if entries?has_content>
		<#list entries as curBlogEntry>
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
								<#assign viewEntryPortletURL = renderResponse.createRenderURL() />

								${viewEntryPortletURL.setParameter("mvcRenderCommandName", "/blogs/view_entry")}

								<#if validator.isNotNull(curBlogEntry.getUrlTitle())>
									${viewEntryPortletURL.setParameter("urlTitle", curBlogEntry.getUrlTitle())}
								<#else>
									${viewEntryPortletURL.setParameter("entryId", curBlogEntry.getEntryId()?string)}
								</#if>

								<h3 class="title">
									<a class="title-link" href="${viewEntryPortletURL.toString()}">
									${htmlUtil.escape(blogsEntryUtil.getDisplayTitle(resourceBundle, curBlogEntry))}</a>
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

							<div class="autofit-col autofit-col-expand">
								<div class="autofit-row">
									<div class="autofit-col autofit-col-expand nhsuk-u-margin-bottom-3">
										<#if serviceLocator??>
											<#assign
												userLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService")

												entryUser = userLocalService.fetchUser(curBlogEntry.getUserId())
											/>

											<#if entryUser?? && !entryUser.isDefaultUser()>
												<#assign entryUserURL = entryUser.getDisplayURL(themeDisplay) />
											</#if>
										</#if>

										<div class="text-truncate-inline">
											<span class="text-truncate username">${curBlogEntry.getUserName()}</span>
										</div>

										<div>
											${dateUtil.getDate(curBlogEntry.getStatusDate(), "dd MMMM yyyy", locale)}

											<#if serviceLocator??>
												<#assign
													assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService")

													assetEntry = assetEntryLocalService.getEntry("com.liferay.blogs.model.BlogsEntry", curBlogEntry.getEntryId())
												/>

												<#if blogsPortletInstanceConfiguration.enableViewCount()>
													- <@liferay_ui["message"] arguments=assetEntry.getViewCount() key=(assetEntry.getViewCount()==0)?then("x-view", "x-views") />
												</#if>
											</#if>
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
								<#if blogsPortletInstanceConfiguration.enableComments()>
									<div class="autofit-col">
										<#assign viewCommentsPortletURL = renderResponse.createRenderURL() />

										${viewCommentsPortletURL.setParameter("mvcRenderCommandName", "/blogs/view_entry")}
										${viewCommentsPortletURL.setParameter("scroll", renderResponse.getNamespace() + "discussionContainer")}

										<#if validator.isNotNull(curBlogEntry.getUrlTitle())>
											${viewCommentsPortletURL.setParameter("urlTitle", curBlogEntry.getUrlTitle())}
										<#else>
											${viewCommentsPortletURL.setParameter("entryId", curBlogEntry.getEntryId()?string)}
										</#if>

										<a class="btn btn-outline-borderless btn-outline-secondary btn-sm" href="${viewCommentsPortletURL.toString()}" title="${language.get(locale, "comments")}">
											<span class="inline-item inline-item-before">
												<@clay["icon"] symbol="comments" />
											</span> ${commentManager.getCommentsCount("com.liferay.blogs.model.BlogsEntry", curBlogEntry.getEntryId())}
										</a>
									</div>
								</#if>

								<#if blogsPortletInstanceConfiguration.enableRatings()>
									<div class="autofit-col">
										<@liferay_ui["ratings"]
											className="com.liferay.blogs.model.BlogsEntry"
											classPK=curBlogEntry.getEntryId()
										/>
									</div>
								</#if>

							</div>
						</div>
					</div>
				</div>
			</div>
		</#list>
	</#if>
</div>
