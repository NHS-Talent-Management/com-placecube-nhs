package com.placecube.nhs.readiness.service.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.placecube.journal.service.JournalArticleCreationService;
import com.placecube.nhs.readiness.constants.WebContentArticles;

@Component(immediate = true, service = ReadinessWebContentService.class)
public class ReadinessWebContentService {

	@Reference
	private JournalArticleCreationService journalArticleCreationService;

	@Reference
	private JournalArticleLocalService journalArticleLocalService;

	public void addArticle(WebContentArticles webContent, JournalFolder journalFolder, ServiceContext serviceContext) throws PortalException {
		try {
			String articleContent = StringUtil.read(getClass().getClassLoader(), "com/placecube/nhs/readiness/dependencies/webcontent/" + webContent.getArticleId() + ".xml");
			journalArticleCreationService.getOrCreateBasicWebContentArticle(webContent.getArticleId(), webContent.getArticleTitle(), articleContent, journalFolder, serviceContext);
		} catch (Exception e) {
			throw new PortalException(e);
		}
	}

	public JournalFolder addFolder(ServiceContext serviceContext) throws PortalException {
		return journalArticleCreationService.getOrCreateJournalFolder("Readiness Questionnaire", serviceContext);
	}

	public JournalArticle getArticle(Company company, WebContentArticles webContentArticle) throws PortalException {
		return journalArticleLocalService.getLatestArticle(company.getGroupId(), webContentArticle.getArticleId());
	}

	public ServiceContext getServiceContext(Group globalGroup) {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(globalGroup.getGroupId());
		serviceContext.setCompanyId(globalGroup.getCompanyId());
		serviceContext.setUserId(globalGroup.getCreatorUserId());
		serviceContext.setLanguageId(globalGroup.getDefaultLanguageId());
		return serviceContext;
	}

}
