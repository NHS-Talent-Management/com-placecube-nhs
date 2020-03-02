package com.placecube.nhs.readiness.web.service;

import java.util.List;
import java.util.Optional;

import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.service.ReadinessService;

@Component(immediate = true, service = ReadinessQuestionnaireService.class)
public class ReadinessQuestionnaireService {

	@Reference
	private GroupLocalService groupLocalService;

	@Reference
	private ReadinessService readinessService;

	public long getWebContentGroupId(ThemeDisplay themeDisplay) throws PortletException {
		try {
			return groupLocalService.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId();
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

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

}
