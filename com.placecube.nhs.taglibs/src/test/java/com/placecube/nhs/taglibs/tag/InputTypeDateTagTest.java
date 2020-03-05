package com.placecube.nhs.taglibs.tag;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
@PrepareForTest({ PropsUtil.class, ServletContextUtil.class })
public class InputTypeDateTagTest extends PowerMockito {

	private InputTypeDateTag inputTypeDateTag;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Mock
	private ServletContext mockServletContext;

	@Mock
	private PageContext mockPageContext;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ServletContextUtil.class);

		inputTypeDateTag = new InputTypeDateTag();
	}

	@Test
	public void cleanUp_WhenNoError_SetsErrorMessageToNull() {
		inputTypeDateTag.setErrorMessage("value");
		assertNotNull(Whitebox.getInternalState(inputTypeDateTag, "errorMessage"));

		inputTypeDateTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeDateTag, "errorMessage"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldHintToNull() {
		inputTypeDateTag.setFieldHint("value");
		assertNotNull(Whitebox.getInternalState(inputTypeDateTag, "fieldHint"));

		inputTypeDateTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeDateTag, "fieldHint"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldLabelToNull() {
		inputTypeDateTag.setFieldLabel("value");
		assertNotNull(Whitebox.getInternalState(inputTypeDateTag, "fieldLabel"));

		inputTypeDateTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeDateTag, "fieldLabel"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldNameToNull() {
		inputTypeDateTag.setFieldName("value");
		assertNotNull(Whitebox.getInternalState(inputTypeDateTag, "fieldName"));

		inputTypeDateTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeDateTag, "fieldName"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldValueToNull() {
		inputTypeDateTag.setFieldValue(new Date());
		assertNotNull(Whitebox.getInternalState(inputTypeDateTag, "fieldValue"));

		inputTypeDateTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeDateTag, "fieldValue"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsHideDayToFalse() {
		inputTypeDateTag.setHideDay(true);
		assertTrue((Boolean) Whitebox.getInternalState(inputTypeDateTag, "hideDay"));

		inputTypeDateTag.cleanUp();

		assertFalse((Boolean) Whitebox.getInternalState(inputTypeDateTag, "hideDay"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsHideMonthToFalse() {
		inputTypeDateTag.setHideMonth(true);
		assertTrue((Boolean) Whitebox.getInternalState(inputTypeDateTag, "hideMonth"));

		inputTypeDateTag.cleanUp();

		assertFalse((Boolean) Whitebox.getInternalState(inputTypeDateTag, "hideMonth"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsPortletNamespaceToNull() {
		inputTypeDateTag.setPortletNamespace("value");

		inputTypeDateTag.cleanUp();

		String expected = (String) Whitebox.getInternalState(inputTypeDateTag, "portletNamespace");
		assertNull(expected);
	}

	@Test
	public void doStartTag_WhenNoError_ThenReturnsEvalBodyInclude() {
		int result = inputTypeDateTag.doStartTag();

		assertThat(result, equalTo(1));
	}

	@Test
	public void doStartTag_WhenNoError_ThenSetsAttributeNamespace() {
		inputTypeDateTag.doStartTag();

		assertThat(inputTypeDateTag.getAttributeNamespace(), equalTo("nhs-forms-ui:date"));
	}

	@Test
	public void getPage_WhenNoError_ThenReturnsTheViewJSP() {
		String result = inputTypeDateTag.getPage();

		assertThat(result, equalTo("/META-INF/taglibs/nhs-forms-ui/date/view.jsp"));
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeErrorMessage() {
		String expected = "expectedValue";
		inputTypeDateTag.setErrorMessage(expected);

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("errorMessage", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldHint() {
		String expected = "expectedValue";
		inputTypeDateTag.setFieldHint(expected);

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldHint", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldLabel() {
		String expected = "expectedValue";
		inputTypeDateTag.setFieldLabel(expected);

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldLabel", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldName() {
		String expected = "expectedValue";
		inputTypeDateTag.setFieldName(expected);

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldName", expected);
	}

	@Test
	@Parameters({ "true", "false" })
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeHideDay(boolean expected) {
		inputTypeDateTag.setHideDay(expected);

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("hideDay", expected);
	}

	@Test
	@Parameters({ "true", "false" })
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeHideMonth(boolean expected) {
		inputTypeDateTag.setHideMonth(expected);

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("hideMonth", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributePortletNamespace() {
		String expected = "expectedValue";
		inputTypeDateTag.setPortletNamespace(expected);

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("portletNamespace", expected);
	}

	@Test
	public void setAttributes_WhenNoErrorAndFieldValueIsConfigured_ThenConfiguresRequestAttributeForTheDateValues() {
		Date expected = new Date(123456l);
		inputTypeDateTag.setFieldValue(expected);
		LocalDate localDate = Instant.ofEpochMilli(expected.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("dayValue", localDate.getDayOfMonth());
		verify(mockHttpServletRequest, times(1)).setAttribute("monthValue", localDate.getMonthValue());
		verify(mockHttpServletRequest, times(1)).setAttribute("yearValue", localDate.getYear());
	}

	@Test
	public void setAttributes_WhenNoErrorAndFieldValueIsNull_ThenConfigureRequestAttributeForTheDateWithEmptyValues() {
		inputTypeDateTag.setFieldValue(null);

		inputTypeDateTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("dayValue", StringPool.BLANK);
		verify(mockHttpServletRequest, times(1)).setAttribute("monthValue", StringPool.BLANK);
		verify(mockHttpServletRequest, times(1)).setAttribute("yearValue", StringPool.BLANK);
	}

	@Test
	public void setPageContext_WhenNoError_ThenSetsThePageContext() {
		inputTypeDateTag = spy(new InputTypeDateTag());

		doNothing().when((IncludeTag) inputTypeDateTag).setPageContext(mockPageContext);
		when(mockPageContext.getRequest()).thenReturn(mockHttpServletRequest);
		when(ServletContextUtil.getServletContext()).thenReturn(mockServletContext);

		inputTypeDateTag.setPageContext(mockPageContext);

		verify(inputTypeDateTag, times(1)).setPageContext(mockPageContext);
	}

}
