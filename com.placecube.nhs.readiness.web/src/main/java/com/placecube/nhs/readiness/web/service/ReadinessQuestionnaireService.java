package com.placecube.nhs.readiness.web.service;

import java.util.List;
import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;

@Component(immediate = true, service = ReadinessQuestionnaireService.class)
public class ReadinessQuestionnaireService {

	@Reference
	private ReadinessService readinessService;

	public List<ReadinessQuestion> getQuestions(ThemeDisplay themeDisplay) throws PortletException {
		try {
			return readinessService.getQuestions(themeDisplay.getUser());
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public Optional<ReadinessQuestion> getQuestionWithIndex(List<ReadinessQuestion> questions, int questionIndex) {
		return questions.stream().filter(question -> question.getIndex() == questionIndex).findFirst();
	}

	public void setWebContentAttributesInRequest(RenderRequest renderRequest, boolean intro) throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			JournalArticle article;
			Company company = themeDisplay.getCompany();
			if (intro) {
				article = readinessService.getQuestionnaireIntro(company);
			} else {
				renderRequest.setAttribute("closeURL", readinessService.getCloseURL(company.getCompanyId()));
				article = readinessService.getQuestionnaireCompleted(company);
			}
			renderRequest.setAttribute("webContentGroupId", article.getGroupId());
			renderRequest.setAttribute("webContentArticleId", article.getArticleId());
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

}
