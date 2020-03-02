package com.placecube.nhs.readiness.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.readiness.configuration.ReadinessInstanceConfiguration;
import com.placecube.nhs.readiness.model.ReadinessQuestion;
import com.placecube.nhs.readiness.model.impl.ModelFactoryBuilder;
import com.placecube.nhs.readiness.service.ReadinessService;

@Component(immediate = true, service = ReadinessService.class)
public class ReadinessServiceImpl implements ReadinessService {

	@Reference
	private ConfigurationProvider configurationProvider;

	@Reference
	private ExpandoColumnLocalService expandoColumnLocalService;

	@Reference
	private ExpandoValueLocalService expandoValueLocalService;

	@Reference
	private ModelFactoryBuilder modelFactoryBuilder;

	@Override
	public void deleteAnswer(long questionId, long userId) throws PortalException {
		ExpandoColumn expandoColumn = expandoColumnLocalService.getColumn(questionId);
		expandoValueLocalService.deleteValue(expandoColumn.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumn.getName(), userId);
	}

	@Override
	public ReadinessQuestion getQuestion(long questionId, User user) throws PortalException {
		try {
			List<ReadinessQuestion> questions = getQuestions(user);
			return questions.stream().filter(question -> questionId == question.getQuestionId()).findFirst().get();
		} catch (Exception e) {
			throw new PortalException(e);
		}
	}

	@Override
	public List<ReadinessQuestion> getQuestions(User user) throws PortalException {
		try {

			ReadinessInstanceConfiguration configuration = configurationProvider.getCompanyConfiguration(ReadinessInstanceConfiguration.class, user.getCompanyId());

			String[] questions = configuration.questions();
			if (ArrayUtil.isNotEmpty(questions) && Validator.isNotNull(questions[0])) {
				List<ReadinessQuestion> results = new LinkedList<>();
				for (int index = 0; index < questions.length; index++) {
					results.add(modelFactoryBuilder.getQuestion(user, index, questions[index]));
				}
				return results;
			} else {
				throw new PortalException("No questions configured");
			}
		} catch (Exception e) {
			throw new PortalException(e);
		}
	}

	@Override
	public void updateAnswer(long questionId, long userId, String value) throws PortalException {
		if (Validator.isNotNull(value)) {
			ExpandoColumn expandoColumn = expandoColumnLocalService.getColumn(questionId);
			String[] availableValues = expandoColumn.getDefaultData().split(StringPool.COMMA);
			if (ArrayUtil.contains(availableValues, value)) {
				expandoValueLocalService.addValue(expandoColumn.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumn.getName(), userId,
						new String[] { value });
			} else {
				throw new PortalException("Invalid value");
			}
		} else {
			deleteAnswer(questionId, userId);
		}
	}

}
