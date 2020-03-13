package com.placecube.nhs.taglibs.tag;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
@PrepareForTest({ PropsUtil.class, ServletContextUtil.class })
public class InputTypeTextTagTest extends PowerMockito {

	private InputTypeTextTag inputTypeTextTag;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Mock
	private ServletContext mockServletContext;

	@Mock
	private PageContext mockPageContext;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ServletContextUtil.class);

		inputTypeTextTag = new InputTypeTextTag();
	}

	@Test
	public void cleanUp_WhenNoError_SetsPortletNamespaceToNull() {
		inputTypeTextTag.setPortletNamespace("value");

		inputTypeTextTag.cleanUp();

		String expected = (String) Whitebox.getInternalState(inputTypeTextTag, "portletNamespace");
		assertNull(expected);
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldNameToNull() {
		inputTypeTextTag.setFieldName("value");
		assertNotNull(Whitebox.getInternalState(inputTypeTextTag, "fieldName"));

		inputTypeTextTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeTextTag, "fieldName"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldLabelToNull() {
		inputTypeTextTag.setFieldLabel("value");
		assertNotNull(Whitebox.getInternalState(inputTypeTextTag, "fieldLabel"));

		inputTypeTextTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeTextTag, "fieldLabel"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldValueToNull() {
		inputTypeTextTag.setFieldValue("value");
		assertNotNull(Whitebox.getInternalState(inputTypeTextTag, "fieldValue"));

		inputTypeTextTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeTextTag, "fieldValue"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsErrorMessageToNull() {
		inputTypeTextTag.setErrorMessage("value");
		assertNotNull(Whitebox.getInternalState(inputTypeTextTag, "errorMessage"));

		inputTypeTextTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeTextTag, "errorMessage"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsShowAspasswordToFalse() {
		inputTypeTextTag.setShowAsPassword(true);
		assertTrue((Boolean) Whitebox.getInternalState(inputTypeTextTag, "showAsPassword"));

		inputTypeTextTag.cleanUp();

		assertFalse((Boolean) Whitebox.getInternalState(inputTypeTextTag, "showAsPassword"));
	}

	@Test
	public void doStartTag_WhenNoError_ThenReturnsEvalBodyInclude() {
		int result = inputTypeTextTag.doStartTag();

		assertThat(result, equalTo(1));
	}

	@Test
	public void doStartTag_WhenNoError_ThenSetsAttributeNamespace() {
		inputTypeTextTag.doStartTag();

		assertThat(inputTypeTextTag.getAttributeNamespace(), equalTo("nhs-forms-ui:input-text"));
	}

	@Test
	public void getPage_WhenNoError_ThenReturnsTheViewJSP() {
		String result = inputTypeTextTag.getPage();

		assertThat(result, equalTo("/META-INF/taglibs/nhs-forms-ui/input-text/view.jsp"));
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributePortletNamespace() {
		String expected = "expectedValue";
		inputTypeTextTag.setPortletNamespace(expected);

		inputTypeTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("portletNamespace", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldName() {
		String expected = "expectedValue";
		inputTypeTextTag.setFieldName(expected);

		inputTypeTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldName", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldLabel() {
		String expected = "expectedValue";
		inputTypeTextTag.setFieldLabel(expected);

		inputTypeTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldLabel", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldValue() {
		String expected = "expectedValue";
		inputTypeTextTag.setFieldValue(expected);

		inputTypeTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldValue", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeErrorMessage() {
		String expected = "expectedValue";
		inputTypeTextTag.setErrorMessage(expected);

		inputTypeTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("errorMessage", expected);
	}

	@Test
	@Parameters({ "true", "false" })
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeShowAsPassword(boolean expected) {
		inputTypeTextTag.setShowAsPassword(expected);

		inputTypeTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("showAsPassword", expected);
	}

	@Test
	public void setPageContext_WhenNoError_ThenSetsThePageContext() {
		inputTypeTextTag = spy(new InputTypeTextTag());

		doNothing().when((IncludeTag) inputTypeTextTag).setPageContext(mockPageContext);
		when(mockPageContext.getRequest()).thenReturn(mockHttpServletRequest);
		when(ServletContextUtil.getServletContext()).thenReturn(mockServletContext);

		inputTypeTextTag.setPageContext(mockPageContext);

		verify(inputTypeTextTag, times(1)).setPageContext(mockPageContext);
	}

}
