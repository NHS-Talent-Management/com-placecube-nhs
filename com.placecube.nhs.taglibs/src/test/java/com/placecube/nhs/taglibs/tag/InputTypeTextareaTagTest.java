package com.placecube.nhs.taglibs.tag;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

import junitparams.JUnitParamsRunner;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
@PrepareForTest({ PropsUtil.class, ServletContextUtil.class })
public class InputTypeTextareaTagTest extends PowerMockito {

	private InputTypeTextareaTag inputTypeTextareaTag;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Mock
	private ServletContext mockServletContext;

	@Mock
	private PageContext mockPageContext;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ServletContextUtil.class);

		inputTypeTextareaTag = new InputTypeTextareaTag();
	}

	@Test
	public void cleanUp_WhenNoError_SetsPortletNamespaceToNull() {
		inputTypeTextareaTag.setPortletNamespace("value");

		inputTypeTextareaTag.cleanUp();

		String expected = (String) Whitebox.getInternalState(inputTypeTextareaTag, "portletNamespace");
		assertNull(expected);
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldNameToNull() {
		inputTypeTextareaTag.setFieldName("value");
		assertNotNull(Whitebox.getInternalState(inputTypeTextareaTag, "fieldName"));

		inputTypeTextareaTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeTextareaTag, "fieldName"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldLabelToNull() {
		inputTypeTextareaTag.setFieldLabel("value");
		assertNotNull(Whitebox.getInternalState(inputTypeTextareaTag, "fieldLabel"));

		inputTypeTextareaTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeTextareaTag, "fieldLabel"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldValueToNull() {
		inputTypeTextareaTag.setFieldValue("value");
		assertNotNull(Whitebox.getInternalState(inputTypeTextareaTag, "fieldValue"));

		inputTypeTextareaTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeTextareaTag, "fieldValue"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsErrorMessageToNull() {
		inputTypeTextareaTag.setErrorMessage("value");
		assertNotNull(Whitebox.getInternalState(inputTypeTextareaTag, "errorMessage"));

		inputTypeTextareaTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeTextareaTag, "errorMessage"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldRowsToDefaultValue5() {
		int setValueNotDefault = 9909;
		inputTypeTextareaTag.setFieldRows(setValueNotDefault);
		assertThat(Whitebox.getInternalState(inputTypeTextareaTag, "fieldRows"), equalTo(setValueNotDefault));

		inputTypeTextareaTag.cleanUp();

		assertThat(Whitebox.getInternalState(inputTypeTextareaTag, "fieldRows"), equalTo(5));
	}

	@Test
	public void doStartTag_WhenNoError_ThenReturnsEvalBodyInclude() {
		int result = inputTypeTextareaTag.doStartTag();

		assertThat(result, equalTo(1));
	}

	@Test
	public void doStartTag_WhenNoError_ThenSetsAttributeNamespace() {
		inputTypeTextareaTag.doStartTag();

		assertThat(inputTypeTextareaTag.getAttributeNamespace(), equalTo("nhs-forms-ui:textarea"));
	}

	@Test
	public void getPage_WhenNoError_ThenReturnsTheViewJSP() {
		String result = inputTypeTextareaTag.getPage();

		assertThat(result, equalTo("/META-INF/taglibs/nhs-forms-ui/textarea/view.jsp"));
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributePortletNamespace() {
		String expected = "expectedValue";
		inputTypeTextareaTag.setPortletNamespace(expected);

		inputTypeTextareaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("portletNamespace", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldName() {
		String expected = "expectedValue";
		inputTypeTextareaTag.setFieldName(expected);

		inputTypeTextareaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldName", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldLabel() {
		String expected = "expectedValue";
		inputTypeTextareaTag.setFieldLabel(expected);

		inputTypeTextareaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldLabel", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldValue() {
		String expected = "expectedValue";
		inputTypeTextareaTag.setFieldValue(expected);

		inputTypeTextareaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldValue", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeErrorMessage() {
		String expected = "expectedValue";
		inputTypeTextareaTag.setErrorMessage(expected);

		inputTypeTextareaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("errorMessage", expected);
	}

	@Test
	public void setAttributes_WhenNoErrorAndFieldRowsGreaterThanZero_ThenConfiguresRequestAttributeFieldRows() {
		int expected = 15;
		inputTypeTextareaTag.setFieldRows(expected);

		inputTypeTextareaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldRows", expected);
	}

	@Test
	public void setAttributes_WhenNoErrorAndFieldRowsLessThanZero_ThenConfiguresRequestAttributeFieldRowsTo5() {
		int expected = 0;
		inputTypeTextareaTag.setFieldRows(expected);

		inputTypeTextareaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldRows", 5);
	}

	@Test
	public void setPageContext_WhenNoError_ThenSetsThePageContext() {
		inputTypeTextareaTag = spy(new InputTypeTextareaTag());

		doNothing().when((IncludeTag) inputTypeTextareaTag).setPageContext(mockPageContext);
		when(mockPageContext.getRequest()).thenReturn(mockHttpServletRequest);
		when(ServletContextUtil.getServletContext()).thenReturn(mockServletContext);

		inputTypeTextareaTag.setPageContext(mockPageContext);

		verify(inputTypeTextareaTag, times(1)).setPageContext(mockPageContext);
	}

}
