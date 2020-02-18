package com.placecube.nhs.webcontent.structures.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.dynamic.data.mapping.util.DefaultDDMStructureHelper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.placecube.nhs.webcontent.structures.constants.WebContentStructure;

@Ignore
@RunWith(PowerMockRunner.class)
@PrepareForTest({ StringUtil.class })
public class ImportServiceTest extends PowerMockito {

	private static final String LANGUAGE_ID = "langId";
	private static final Long USER_ID = 1l;
	private static final Long GROUP_ID = 2l;
	private static final Long COMPANY_ID = 3l;
	private static final Long ARTICLE_CLASS_NAME_ID = 4l;
	private static final Long STRUCTURE_CLASS_NAME_ID = 5l;
	private static final Long STRUCTURE_ID = 6l;
	private static final String STRUCTURE_NAME = "structureNameVal";
	private static final Locale LOCALE = Locale.CANADA_FRENCH;

	@InjectMocks
	private ImportService importService;

	@Mock
	private DDMStructureLocalService mockDDMStructureLocalService;

	@Mock
	private DefaultDDMStructureHelper mockDefaultDDMStructureHelper;

	@Mock
	private DDMTemplateLocalService mockDDMTemplateLocalService;

	@Mock
	private Portal mockPortal;

	@Mock
	private DDMStructure mockDDMStructure;

	@Mock
	private ServiceContext mockServiceContext;

	@Mock
	private DDMTemplate mockDDMTemplate;

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
	public void addStructureAndTemplates_WhenTemplateFound_ThenCreatesTheStructureButDoesNotCreateTemplate() throws Exception {
		WebContentStructure webContentStructure = WebContentStructure.COURSE;
		when(mockPortal.getClassNameId(JournalArticle.class)).thenReturn(ARTICLE_CLASS_NAME_ID);
		when(mockPortal.getClassNameId(DDMStructure.class.getName())).thenReturn(STRUCTURE_CLASS_NAME_ID);
		when(mockServiceContext.getUserId()).thenReturn(USER_ID);
		when(mockServiceContext.getScopeGroupId()).thenReturn(GROUP_ID);
		when(mockDDMStructureLocalService.getStructure(GROUP_ID, ARTICLE_CLASS_NAME_ID, webContentStructure.getStructureKey())).thenReturn(mockDDMStructure);
		when(mockDDMTemplateLocalService.fetchTemplate(GROUP_ID, STRUCTURE_CLASS_NAME_ID, webContentStructure.getListingTemplateKey())).thenReturn(mockDDMTemplate);

		importService.addStructureAndTemplates(mockServiceContext, webContentStructure);

		verify(mockDefaultDDMStructureHelper, times(1)).addDDMStructures(USER_ID, GROUP_ID, ARTICLE_CLASS_NAME_ID, ImportService.class.getClassLoader(),
				"com/placecube/nhs/webcontent/structures/dependencies/ddm/" + webContentStructure.getStructureKey() + "/" + webContentStructure.getStructureKey() + ".xml", mockServiceContext);
		verify(mockDDMTemplateLocalService, never()).addTemplate(anyLong(), anyLong(), anyLong(), anyLong(), anyLong(), anyString(), any(), any(), anyString(), any(), anyString(), anyString(),
				anyBoolean(), anyBoolean(), anyString(), any(), any(ServiceContext.class));
	}

	@Test
	public void addStructureAndTemplates_WhenTemplateNotFound_ThenCreateTheStructureAndTheTemplate() throws Exception {
		WebContentStructure webContentStructure = WebContentStructure.COURSE;
		when(mockPortal.getClassNameId(JournalArticle.class)).thenReturn(ARTICLE_CLASS_NAME_ID);
		when(mockPortal.getClassNameId(DDMStructure.class.getName())).thenReturn(STRUCTURE_CLASS_NAME_ID);
		when(mockServiceContext.getUserId()).thenReturn(USER_ID);
		when(mockServiceContext.getScopeGroupId()).thenReturn(GROUP_ID);
		when(mockDDMStructureLocalService.getStructure(GROUP_ID, ARTICLE_CLASS_NAME_ID, webContentStructure.getStructureKey())).thenReturn(mockDDMStructure);
		when(mockDDMTemplateLocalService.fetchTemplate(GROUP_ID, STRUCTURE_CLASS_NAME_ID, webContentStructure.getListingTemplateKey())).thenReturn(null);
		when(mockDDMStructure.getStructureId()).thenReturn(STRUCTURE_ID);
		when(mockServiceContext.getLocale()).thenReturn(LOCALE);
		when(mockDDMStructure.getName(LOCALE)).thenReturn(STRUCTURE_NAME);
		Map<Locale, String> nameMap = Collections.singletonMap(LOCALE, STRUCTURE_NAME + " Listing");
		String script = "scriptValue";
		when(StringUtil.read(getClass().getClassLoader(),
				"com/placecube/nhs/webcontent/structures/dependencies/ddm/" + webContentStructure.getStructureKey() + "/" + webContentStructure.getListingTemplateKey() + ".ftl")).thenReturn(script);

		importService.addStructureAndTemplates(mockServiceContext, webContentStructure);

		verify(mockDefaultDDMStructureHelper, times(1)).addDDMStructures(USER_ID, GROUP_ID, ARTICLE_CLASS_NAME_ID, ImportService.class.getClassLoader(),
				"com/placecube/nhs/webcontent/structures/dependencies/ddm/" + webContentStructure.getStructureKey() + "/" + webContentStructure.getStructureKey() + ".xml", mockServiceContext);
		verify(mockDDMTemplateLocalService, times(1)).addTemplate(USER_ID, GROUP_ID, STRUCTURE_CLASS_NAME_ID, STRUCTURE_ID, ARTICLE_CLASS_NAME_ID, webContentStructure.getListingTemplateKey(), nameMap,
				null, "display", null, "ftl", script, true, false, StringPool.BLANK, null, mockServiceContext);
	}

}
