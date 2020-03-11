package com.placecube.nhs.readiness.service;

import java.util.List;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.placecube.nhs.readiness.model.ReadinessQuestion;

public interface ReadinessService {

	void deleteAnswer(long questionId, long userId) throws PortalException;

	ReadinessQuestion getQuestion(long questionId, User user) throws PortalException;

	List<ReadinessQuestion> getQuestions(User user) throws PortalException;

	void updateAnswer(long questionId, long userId, String value) throws PortalException;

	List<ReadinessQuestion> getQuestionnaire(Company company) throws PortalException;

	JournalArticle getQuestionnaireIntro(Company company) throws PortalException;

	JournalArticle getQuestionnaireCompleted(Company company) throws PortalException;

	String getCloseURL(long companyId) throws PortalException;

}
