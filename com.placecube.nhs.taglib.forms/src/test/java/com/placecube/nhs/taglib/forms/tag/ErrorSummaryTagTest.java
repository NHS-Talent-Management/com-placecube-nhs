package com.placecube.nhs.taglib.forms.tag;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

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

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
@PrepareForTest({ PropsUtil.class, ServletContextUtil.class })
public class ErrorSummaryTagTest extends PowerMockito {

	private ErrorSummaryTag errorSummaryTag;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Mock
	private ServletContext mockServletContext;

	@Mock
	private PageContext mockPageContext;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ServletContextUtil.class);

		errorSummaryTag = new ErrorSummaryTag();
	}

	@Test
	public void cleanUp_WhenNoError_SetsPortletNamespaceToNull() {
		errorSummaryTag.setPortletNamespace("value");

		errorSummaryTag.cleanUp();

		String expected = (String) Whitebox.getInternalState(errorSummaryTag, "portletNamespace");
		assertNull(expected);
	}

	@Test
	public void cleanUp_WhenNoError_SetsErrorMapToEmpty() {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("key", "value");
		errorSummaryTag.setErrors(errorMap);
		Map<String, String> internalState = (Map<String, String>) Whitebox.getInternalState(errorSummaryTag, "errors");
		assertNotNull(internalState);
		assertFalse(internalState.isEmpty());

		errorSummaryTag.cleanUp();

		internalState = (Map<String, String>) Whitebox.getInternalState(errorSummaryTag, "errors");
		assertNotNull(internalState);
		assertTrue(internalState.isEmpty());
	}

	@Test
	public void doStartTag_WhenNoError_ThenReturnsEvalBodyInclude() {
		int result = errorSummaryTag.doStartTag();

		assertThat(result, equalTo(1));
	}

	@Test
	public void doStartTag_WhenNoError_ThenSetsAttributeNamespace() {
		errorSummaryTag.doStartTag();

		assertThat(errorSummaryTag.getAttributeNamespace(), equalTo("nhs-forms-ui:errorSummary"));
	}

	@Test
	public void getPage_WhenNoError_ThenReturnsTheViewJSP() {
		String result = errorSummaryTag.getPage();

		assertThat(result, equalTo("/META-INF/taglibs/nhs-forms-ui/error-summary/view.jsp"));
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributePortletNamespace() {
		String expected = "expectedValue";
		errorSummaryTag.setPortletNamespace(expected);

		errorSummaryTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("portletNamespace", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeErrors() {
		Map<String, String> expected = new HashMap<>();
		expected.put("key", "value");
		errorSummaryTag.setErrors(expected);

		errorSummaryTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("errors", expected);
	}

	@Test
	public void setPageContext_WhenNoError_ThenSetsThePageContext() {
		errorSummaryTag = spy(new ErrorSummaryTag());

		doNothing().when((IncludeTag) errorSummaryTag).setPageContext(mockPageContext);
		when(mockPageContext.getRequest()).thenReturn(mockHttpServletRequest);
		when(ServletContextUtil.getServletContext()).thenReturn(mockServletContext);

		errorSummaryTag.setPageContext(mockPageContext);

		verify(errorSummaryTag, times(1)).setPageContext(mockPageContext);
	}

}
