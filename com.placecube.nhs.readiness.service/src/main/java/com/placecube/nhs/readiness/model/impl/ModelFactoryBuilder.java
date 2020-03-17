package com.placecube.nhs.readiness.model.impl;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

@Component(immediate = true, service = ModelFactoryBuilder.class)
public class ModelFactoryBuilder {

	@Reference
	private ExpandoColumnLocalService expandoColumnLocalService;

	@Reference
	private ExpandoValueLocalService expandoValueLocalService;

	public ReadinessQuestion getQuestion(Company company, int index, String questionConfig) throws PortalException {
		return getPopulatedQuestion(company.getCompanyId(), -1, company.getLocale(), index, questionConfig);
	}

	public ReadinessQuestion getQuestion(User user, int index, String questionConfig) {
		return getPopulatedQuestion(user.getCompanyId(), user.getUserId(), user.getLocale(), index, questionConfig);
	}

	private ReadinessQuestion getPopulatedQuestion(long companyId, long userId, Locale locale, int index, String questionConfig) {
		String[] questionDetails = questionConfig.split(StringPool.EQUAL);
		String expandoColumnName = questionDetails[0];
		String questionTitle = questionDetails[1];

		ExpandoColumn expandoColumn = expandoColumnLocalService.getColumn(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumnName);

		ExpandoValue expandoValue = userId > 0 ? expandoValueLocalService.getValue(expandoColumn.getTableId(), expandoColumn.getColumnId(), userId) : null;
		String userAnswer = Validator.isNotNull(expandoValue) ? expandoValue.getData() : StringPool.BLANK;

		return ReadinessQuestionImpl.init(expandoColumn, locale, questionTitle, index + 1, userAnswer);
	}

}
