package com.placecube.nhs.taglib.forms.tag;

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
import com.placecube.nhs.taglib.forms.context.ServletContextUtil;

import junitparams.JUnitParamsRunner;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
@PrepareForTest({ PropsUtil.class, ServletContextUtil.class })
public class TextAreaTagTest extends PowerMockito {

	private TextAreaTag textAreaTag;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Mock
	private ServletContext mockServletContext;

	@Mock
	private PageContext mockPageContext;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ServletContextUtil.class);

		textAreaTag = new TextAreaTag();
	}

	@Test
	public void cleanUp_WhenNoError_SetsPortletNamespaceToNull() {
		textAreaTag.setPortletNamespace("value");

		textAreaTag.cleanUp();

		String expected = (String) Whitebox.getInternalState(textAreaTag, "portletNamespace");
		assertNull(expected);
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldNameToNull() {
		textAreaTag.setFieldName("value");
		assertNotNull(Whitebox.getInternalState(textAreaTag, "fieldName"));

		textAreaTag.cleanUp();

		assertNull(Whitebox.getInternalState(textAreaTag, "fieldName"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldLabelToNull() {
		textAreaTag.setFieldLabel("value");
		assertNotNull(Whitebox.getInternalState(textAreaTag, "fieldLabel"));

		textAreaTag.cleanUp();

		assertNull(Whitebox.getInternalState(textAreaTag, "fieldLabel"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldValueToNull() {
		textAreaTag.setFieldValue("value");
		assertNotNull(Whitebox.getInternalState(textAreaTag, "fieldValue"));

		textAreaTag.cleanUp();

		assertNull(Whitebox.getInternalState(textAreaTag, "fieldValue"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsErrorMessageToNull() {
		textAreaTag.setErrorMessage("value");
		assertNotNull(Whitebox.getInternalState(textAreaTag, "errorMessage"));

		textAreaTag.cleanUp();

		assertNull(Whitebox.getInternalState(textAreaTag, "errorMessage"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldRowsToDefaultValue5() {
		int setValueNotDefault = 9909;
		textAreaTag.setFieldRows(setValueNotDefault);
		assertThat(Whitebox.getInternalState(textAreaTag, "fieldRows"), equalTo(setValueNotDefault));

		textAreaTag.cleanUp();

		assertThat(Whitebox.getInternalState(textAreaTag, "fieldRows"), equalTo(5));
	}

	@Test
	public void doStartTag_WhenNoError_ThenReturnsEvalBodyInclude() {
		int result = textAreaTag.doStartTag();

		assertThat(result, equalTo(1));
	}

	@Test
	public void doStartTag_WhenNoError_ThenSetsAttributeNamespace() {
		textAreaTag.doStartTag();

		assertThat(textAreaTag.getAttributeNamespace(), equalTo("nhs-forms-ui:textarea"));
	}

	@Test
	public void getPage_WhenNoError_ThenReturnsTheViewJSP() {
		String result = textAreaTag.getPage();

		assertThat(result, equalTo("/META-INF/taglibs/nhs-forms-ui/textarea/view.jsp"));
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributePortletNamespace() {
		String expected = "expectedValue";
		textAreaTag.setPortletNamespace(expected);

		textAreaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("portletNamespace", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldName() {
		String expected = "expectedValue";
		textAreaTag.setFieldName(expected);

		textAreaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldName", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldLabel() {
		String expected = "expectedValue";
		textAreaTag.setFieldLabel(expected);

		textAreaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldLabel", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldValue() {
		String expected = "expectedValue";
		textAreaTag.setFieldValue(expected);

		textAreaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldValue", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeErrorMessage() {
		String expected = "expectedValue";
		textAreaTag.setErrorMessage(expected);

		textAreaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("errorMessage", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldRows() {
		int expected = 15;
		textAreaTag.setFieldRows(expected);

		textAreaTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldRows", expected);
	}

	@Test
	public void setPageContext_WhenNoError_ThenSetsThePageContext() {
		textAreaTag = spy(new TextAreaTag());

		doNothing().when((IncludeTag) textAreaTag).setPageContext(mockPageContext);
		when(mockPageContext.getRequest()).thenReturn(mockHttpServletRequest);
		when(ServletContextUtil.getServletContext()).thenReturn(mockServletContext);

		textAreaTag.setPageContext(mockPageContext);

		verify(textAreaTag, times(1)).setPageContext(mockPageContext);
	}

}
