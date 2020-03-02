package com.placecube.nhs.readiness.web.lifefycle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.journal.model.JournalFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.placecube.digitalplace.journal.service.JournalArticleCreationService;
import com.placecube.nhs.readiness.web.constants.WebContentArticles;

@Component(immediate = true, service = ReadinessSetupService.class)
public class ReadinessSetupService {

	@Reference
	private JournalArticleCreationService journalArticleCreationService;

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

	public ServiceContext getServiceContext(Group group) {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(group.getGroupId());
		serviceContext.setCompanyId(group.getCompanyId());
		serviceContext.setUserId(group.getCreatorUserId());
		serviceContext.setLanguageId(group.getDefaultLanguageId());
		return serviceContext;
	}

}
