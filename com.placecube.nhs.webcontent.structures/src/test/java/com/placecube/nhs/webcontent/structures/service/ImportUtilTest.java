package com.placecube.nhs.webcontent.structures.service;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StringUtil.class })
public class ImportUtilTest extends PowerMockito {

	private static final Long USER_ID = 1l;
	private static final Long GROUP_ID = 2l;
	private static final Long ARTICLE_CLASS_NAME_ID = 4l;
	private static final Long STRUCTURE_CLASS_NAME_ID = 5l;
	private static final Long STRUCTURE_ID = 6l;
	private static final Locale LOCALE = Locale.CANADA_FRENCH;
	private static final String TEMPLATE_KEY = "templateKeyValue";
	private static final String STRUCTURE_KEY = "structureKeyValue";

	@InjectMocks
	private ImportUtil importUtil;

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

	@Before
	public void setUp() {
		mockStatic(StringUtil.class);
	}

	@Test
	public void createTemplate_WhenTemplateFound_ThenDoesNotCreateTemplate() throws Exception {
		when(mockPortal.getClassNameId(DDMStructure.class.getName())).thenReturn(STRUCTURE_CLASS_NAME_ID);
		when(mockServiceContext.getScopeGroupId()).thenReturn(GROUP_ID);
		when(mockDDMTemplateLocalService.fetchTemplate(GROUP_ID, STRUCTURE_CLASS_NAME_ID, TEMPLATE_KEY)).thenReturn(mockDDMTemplate);

		importUtil.createTemplate(mockServiceContext, STRUCTURE_KEY, TEMPLATE_KEY, ARTICLE_CLASS_NAME_ID, mockDDMStructure);

		verify(mockDDMTemplateLocalService, never()).addTemplate(anyLong(), anyLong(), anyLong(), anyLong(), anyLong(), anyString(), any(), any(), anyString(), any(), anyString(), anyString(),
				anyBoolean(), anyBoolean(), anyString(), any(), any(ServiceContext.class));
	}

	@Test
	public void createTemplate_WhenTemplateNotFound_ThenCreateTheTemplate() throws Exception {
		when(mockPortal.getClassNameId(DDMStructure.class.getName())).thenReturn(STRUCTURE_CLASS_NAME_ID);
		when(mockServiceContext.getUserId()).thenReturn(USER_ID);
		when(mockServiceContext.getScopeGroupId()).thenReturn(GROUP_ID);
		when(mockDDMStructure.getStructureId()).thenReturn(STRUCTURE_ID);
		when(mockServiceContext.getLocale()).thenReturn(LOCALE);
		Map<Locale, String> nameMap = Collections.singletonMap(LOCALE, TEMPLATE_KEY);
		String script = "scriptValue";
		when(StringUtil.read(getClass().getClassLoader(), "com/placecube/nhs/webcontent/structures/dependencies/ddm/" + STRUCTURE_KEY + "/" + TEMPLATE_KEY + ".ftl")).thenReturn(script);

		importUtil.createTemplate(mockServiceContext, STRUCTURE_KEY, TEMPLATE_KEY, ARTICLE_CLASS_NAME_ID, mockDDMStructure);

		verify(mockDDMTemplateLocalService, times(1)).addTemplate(USER_ID, GROUP_ID, STRUCTURE_CLASS_NAME_ID, STRUCTURE_ID, ARTICLE_CLASS_NAME_ID, TEMPLATE_KEY, nameMap, null, "display", null, "ftl",
				script, true, false, StringPool.BLANK, null, mockServiceContext);
	}

}
