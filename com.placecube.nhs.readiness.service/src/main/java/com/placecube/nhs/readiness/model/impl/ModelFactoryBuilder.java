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
import com.liferay.portal.kernel.language.LanguageUtil;
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
		String[] questionValues = questionConfig.split(StringPool.EQUAL);
		String expandoColumnName = questionValues[0];

		ExpandoColumn expandoColumn = expandoColumnLocalService.getColumn(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumnName);
		ExpandoValue expandoValue = userId > 0 ? expandoValueLocalService.getValue(expandoColumn.getTableId(), expandoColumn.getColumnId(), userId) : null;

		String userAnswer = Validator.isNotNull(expandoValue) ? expandoValue.getData() : StringPool.BLANK;
		String questionName = LanguageUtil.get(locale, expandoColumnName);
		String questionTitle = questionValues[1];
		String[] availableValues = expandoColumn.getDefaultData().split(StringPool.COMMA);

		return new ReadinessQuestionImpl(expandoColumn, questionName, questionTitle, availableValues, index + 1, userAnswer);
	}

}
