package com.placecube.nhs.readiness.model.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

@Component(immediate = true, service = ModelFactoryBuilder.class)
public class ModelFactoryBuilder {

	@Reference
	private ExpandoColumnLocalService expandoColumnLocalService;

	@Reference
	private ExpandoValueLocalService expandoValueLocalService;

	public ReadinessQuestion getQuestion(User user, int index, String questionConfig) {
		String[] questionValues = questionConfig.split(StringPool.EQUAL);
		String expandoColumnName = questionValues[0];

		ExpandoColumn expandoColumn = expandoColumnLocalService.getColumn(user.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumnName);
		ExpandoValue expandoValue = expandoValueLocalService.getValue(expandoColumn.getTableId(), expandoColumn.getColumnId(), user.getUserId());

		String userAnswer = Validator.isNotNull(expandoValue) ? expandoValue.getData() : StringPool.BLANK;
		String questionName = LanguageUtil.get(user.getLocale(), expandoColumnName);
		String questionTitle = questionValues[1];
		String[] availableValues = expandoColumn.getDefaultData().split(StringPool.COMMA);

		return new ReadinessQuestionImpl(expandoColumn.getColumnId(), questionName, questionTitle, availableValues, index + 1, userAnswer);
	}

}
