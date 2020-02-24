package com.placecube.nhs.taglib.forms.tag;

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
import com.placecube.nhs.taglib.forms.context.ServletContextUtil;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
@PrepareForTest({ PropsUtil.class, ServletContextUtil.class })
public class InputTextTagTest extends PowerMockito {

	private InputTextTag inputTextTag;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Mock
	private ServletContext mockServletContext;

	@Mock
	private PageContext mockPageContext;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ServletContextUtil.class);

		inputTextTag = new InputTextTag();
	}

	@Test
	public void cleanUp_WhenNoError_SetsPortletNamespaceToNull() {
		inputTextTag.setPortletNamespace("value");

		inputTextTag.cleanUp();

		String expected = (String) Whitebox.getInternalState(inputTextTag, "portletNamespace");
		assertNull(expected);
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldNameToNull() {
		inputTextTag.setFieldName("value");
		assertNotNull(Whitebox.getInternalState(inputTextTag, "fieldName"));

		inputTextTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTextTag, "fieldName"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldLabelToNull() {
		inputTextTag.setFieldLabel("value");
		assertNotNull(Whitebox.getInternalState(inputTextTag, "fieldLabel"));

		inputTextTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTextTag, "fieldLabel"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldValueToNull() {
		inputTextTag.setFieldValue("value");
		assertNotNull(Whitebox.getInternalState(inputTextTag, "fieldValue"));

		inputTextTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTextTag, "fieldValue"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsErrorMessageToNull() {
		inputTextTag.setErrorMessage("value");
		assertNotNull(Whitebox.getInternalState(inputTextTag, "errorMessage"));

		inputTextTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTextTag, "errorMessage"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsShowAspasswordToFalse() {
		inputTextTag.setShowAsPassword(true);
		assertTrue((Boolean) Whitebox.getInternalState(inputTextTag, "showAsPassword"));

		inputTextTag.cleanUp();

		assertFalse((Boolean) Whitebox.getInternalState(inputTextTag, "showAsPassword"));
	}

	@Test
	public void doStartTag_WhenNoError_ThenReturnsEvalBodyInclude() {
		int result = inputTextTag.doStartTag();

		assertThat(result, equalTo(1));
	}

	@Test
	public void doStartTag_WhenNoError_ThenSetsAttributeNamespace() {
		inputTextTag.doStartTag();

		assertThat(inputTextTag.getAttributeNamespace(), equalTo("nhs-forms-ui:inputText"));
	}

	@Test
	public void getPage_WhenNoError_ThenReturnsTheViewJSP() {
		String result = inputTextTag.getPage();

		assertThat(result, equalTo("/META-INF/taglibs/nhs-forms-ui/input-text/view.jsp"));
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributePortletNamespace() {
		String expected = "expectedValue";
		inputTextTag.setPortletNamespace(expected);

		inputTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("portletNamespace", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldName() {
		String expected = "expectedValue";
		inputTextTag.setFieldName(expected);

		inputTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldName", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldLabel() {
		String expected = "expectedValue";
		inputTextTag.setFieldLabel(expected);

		inputTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldLabel", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldValue() {
		String expected = "expectedValue";
		inputTextTag.setFieldValue(expected);

		inputTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldValue", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeErrorMessage() {
		String expected = "expectedValue";
		inputTextTag.setErrorMessage(expected);

		inputTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("errorMessage", expected);
	}

	@Test
	@Parameters({ "true", "false" })
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeShowAsPassword(boolean expected) {
		inputTextTag.setShowAsPassword(expected);

		inputTextTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("showAsPassword", expected);
	}

	@Test
	public void setPageContext_WhenNoError_ThenSetsThePageContext() {
		inputTextTag = spy(new InputTextTag());

		doNothing().when((IncludeTag) inputTextTag).setPageContext(mockPageContext);
		when(mockPageContext.getRequest()).thenReturn(mockHttpServletRequest);
		when(ServletContextUtil.getServletContext()).thenReturn(mockServletContext);

		inputTextTag.setPageContext(mockPageContext);

		verify(inputTextTag, times(1)).setPageContext(mockPageContext);
	}

}
