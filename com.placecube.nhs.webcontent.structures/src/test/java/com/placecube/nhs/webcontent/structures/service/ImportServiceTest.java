package com.placecube.nhs.webcontent.structures.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.util.DefaultDDMStructureHelper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.placecube.nhs.webcontent.structures.constants.WebContentStructure;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StringUtil.class })
public class ImportServiceTest extends PowerMockito {

	private static final String LANGUAGE_ID = "langId";
	private static final Long USER_ID = 1l;
	private static final Long GROUP_ID = 2l;
	private static final Long COMPANY_ID = 3l;
	private static final Long ARTICLE_CLASS_NAME_ID = 4l;
	private static final Long STRUCTURE_CLASS_NAME_ID = 5l;

	@InjectMocks
	private ImportService importService;

	@Mock
	private DDMStructureLocalService mockDDMStructureLocalService;

	@Mock
	private DefaultDDMStructureHelper mockDefaultDDMStructureHelper;

	@Mock
	private ImportUtil mockImportUtil;

	@Mock
	private Portal mockPortal;

	@Mock
	private DDMStructure mockDDMStructure;

	@Mock
	private ServiceContext mockServiceContext;

	@Mock
	private Group mockGroup;

	@Before
	public void setUp() {
		mockStatic(StringUtil.class);
	}

	@Test
	public void getServiceContext_WhenNoError_ThenReturnsConfiguredServiceContext() {
		when(mockGroup.getCreatorUserId()).thenReturn(USER_ID);
		when(mockGroup.getGroupId()).thenReturn(GROUP_ID);
		when(mockGroup.getCompanyId()).thenReturn(COMPANY_ID);
		when(mockGroup.getDefaultLanguageId()).thenReturn(LANGUAGE_ID);

		ServiceContext serviceContext = importService.getServiceContext(mockGroup);

		assertThat(serviceContext.isAddGuestPermissions(), equalTo(true));
		assertThat(serviceContext.isAddGroupPermissions(), equalTo(true));
		assertThat(serviceContext.getCompanyId(), equalTo(COMPANY_ID));
		assertThat(serviceContext.getLanguageId(), equalTo(LANGUAGE_ID));
		assertThat(serviceContext.getScopeGroupId(), equalTo(GROUP_ID));
		assertThat(serviceContext.getUserId(), equalTo(USER_ID));
	}

	@Test
	public void addStructureAndTemplates_WhenNoError_ThenCreatesTheStructureAndTheTemplates() throws Exception {
		WebContentStructure webContentStructure = WebContentStructure.COURSE;
		when(mockPortal.getClassNameId(JournalArticle.class)).thenReturn(ARTICLE_CLASS_NAME_ID);
		when(mockPortal.getClassNameId(DDMStructure.class.getName())).thenReturn(STRUCTURE_CLASS_NAME_ID);
		when(mockServiceContext.getUserId()).thenReturn(USER_ID);
		when(mockServiceContext.getScopeGroupId()).thenReturn(GROUP_ID);
		when(mockDDMStructureLocalService.getStructure(GROUP_ID, ARTICLE_CLASS_NAME_ID, webContentStructure.getStructureKey())).thenReturn(mockDDMStructure);

		importService.addStructureAndTemplates(mockServiceContext, webContentStructure);

		InOrder inOrder = Mockito.inOrder(mockDefaultDDMStructureHelper, mockImportUtil);
		inOrder.verify(mockDefaultDDMStructureHelper, times(1)).addDDMStructures(USER_ID, GROUP_ID, ARTICLE_CLASS_NAME_ID, ImportService.class.getClassLoader(),
				"com/placecube/nhs/webcontent/structures/dependencies/ddm/" + webContentStructure.getStructureKey() + "/" + webContentStructure.getStructureKey() + ".xml", mockServiceContext);
		inOrder.verify(mockImportUtil, times(1)).createTemplate(mockServiceContext, webContentStructure.getStructureKey(), webContentStructure.getFullDisplayTemplateKey(), ARTICLE_CLASS_NAME_ID,
				mockDDMStructure);
		inOrder.verify(mockImportUtil, times(1)).createTemplate(mockServiceContext, webContentStructure.getStructureKey(), webContentStructure.getListingTemplateKey(), ARTICLE_CLASS_NAME_ID,
				mockDDMStructure);
	}

}
