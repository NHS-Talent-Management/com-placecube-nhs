package com.placecube.nhs.taglibs.tag;

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

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.taglib.util.IncludeTag;
import com.placecube.nhs.taglibs.context.ServletContextUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ PropsUtil.class, ServletContextUtil.class })
public class InputTypeCheckboxTagTest extends PowerMockito {

	private InputTypeCheckboxTag inputTypeCheckboxTag;

	@Mock
	private HttpServletRequest mockHttpServletRequest;

	@Mock
	private ServletContext mockServletContext;

	@Mock
	private PageContext mockPageContext;

	@Before
	public void setUp() {
		mockStatic(PropsUtil.class, ServletContextUtil.class);

		inputTypeCheckboxTag = new InputTypeCheckboxTag();
	}

	@Test
	public void cleanUp_WhenNoError_SetsPortletNamespaceToNull() {
		inputTypeCheckboxTag.setPortletNamespace("value");

		inputTypeCheckboxTag.cleanUp();

		String expected = (String) Whitebox.getInternalState(inputTypeCheckboxTag, "portletNamespace");
		assertNull(expected);
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldOptionsMapToEmpty() {
		Map<String, String> fieldOptionsMap = new HashMap<>();
		fieldOptionsMap.put("key", "value");
		inputTypeCheckboxTag.setFieldOptions(fieldOptionsMap);
		Map<String, String> internalState = (Map<String, String>) Whitebox.getInternalState(inputTypeCheckboxTag, "fieldOptions");
		assertNotNull(internalState);
		assertFalse(internalState.isEmpty());

		inputTypeCheckboxTag.cleanUp();

		internalState = (Map<String, String>) Whitebox.getInternalState(inputTypeCheckboxTag, "fieldOptions");
		assertNotNull(internalState);
		assertTrue(internalState.isEmpty());
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldNameToNull() {
		inputTypeCheckboxTag.setFieldName("value");
		assertNotNull(Whitebox.getInternalState(inputTypeCheckboxTag, "fieldName"));

		inputTypeCheckboxTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeCheckboxTag, "fieldName"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldHintToNull() {
		inputTypeCheckboxTag.setFieldHint("value");
		assertNotNull(Whitebox.getInternalState(inputTypeCheckboxTag, "fieldHint"));

		inputTypeCheckboxTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeCheckboxTag, "fieldHint"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldLabelToNull() {
		inputTypeCheckboxTag.setFieldLabel("value");
		assertNotNull(Whitebox.getInternalState(inputTypeCheckboxTag, "fieldLabel"));

		inputTypeCheckboxTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeCheckboxTag, "fieldLabel"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsFieldValueToNull() {
		inputTypeCheckboxTag.setFieldValue("value");
		assertNotNull(Whitebox.getInternalState(inputTypeCheckboxTag, "fieldValue"));

		inputTypeCheckboxTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeCheckboxTag, "fieldValue"));
	}

	@Test
	public void cleanUp_WhenNoError_SetsErrorMessageToNull() {
		inputTypeCheckboxTag.setErrorMessage("value");
		assertNotNull(Whitebox.getInternalState(inputTypeCheckboxTag, "errorMessage"));

		inputTypeCheckboxTag.cleanUp();

		assertNull(Whitebox.getInternalState(inputTypeCheckboxTag, "errorMessage"));
	}

	@Test
	public void doStartTag_WhenNoError_ThenReturnsEvalBodyInclude() {
		int result = inputTypeCheckboxTag.doStartTag();

		assertThat(result, equalTo(1));
	}

	@Test
	public void doStartTag_WhenNoError_ThenSetsAttributeNamespace() {
		inputTypeCheckboxTag.doStartTag();

		assertThat(inputTypeCheckboxTag.getAttributeNamespace(), equalTo("nhs-forms-ui:input-checkbox"));
	}

	@Test
	public void getPage_WhenNoError_ThenReturnsTheViewJSP() {
		String result = inputTypeCheckboxTag.getPage();

		assertThat(result, equalTo("/META-INF/taglibs/nhs-forms-ui/checkbox/view.jsp"));
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributePortletNamespace() {
		String expected = "expectedValue";
		inputTypeCheckboxTag.setPortletNamespace(expected);

		inputTypeCheckboxTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("portletNamespace", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldOptions() {
		Map<String, String> expected = new HashMap<>();
		expected.put("key", "value");
		inputTypeCheckboxTag.setFieldOptions(expected);

		inputTypeCheckboxTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldOptions", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldName() {
		String expected = "expectedValue";
		inputTypeCheckboxTag.setFieldName(expected);

		inputTypeCheckboxTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldName", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldHint() {
		String expected = "expectedValue";
		inputTypeCheckboxTag.setFieldHint(expected);

		inputTypeCheckboxTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldHint", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldLabel() {
		String expected = "expectedValue";
		inputTypeCheckboxTag.setFieldLabel(expected);

		inputTypeCheckboxTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldLabel", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeFieldValue() {
		String expected = "expectedValue";
		inputTypeCheckboxTag.setFieldValue(expected);

		inputTypeCheckboxTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("fieldValue", expected);
	}

	@Test
	public void setAttributes_WhenNoError_ThenConfiguresRequestAttributeErrorMessage() {
		String expected = "expectedValue";
		inputTypeCheckboxTag.setErrorMessage(expected);

		inputTypeCheckboxTag.setAttributes(mockHttpServletRequest);

		verify(mockHttpServletRequest, times(1)).setAttribute("errorMessage", expected);
	}

	@Test
	public void setPageContext_WhenNoError_ThenSetsThePageContext() {
		inputTypeCheckboxTag = spy(new InputTypeCheckboxTag());

		doNothing().when((IncludeTag) inputTypeCheckboxTag).setPageContext(mockPageContext);
		when(mockPageContext.getRequest()).thenReturn(mockHttpServletRequest);
		when(ServletContextUtil.getServletContext()).thenReturn(mockServletContext);

		inputTypeCheckboxTag.setPageContext(mockPageContext);

		verify(inputTypeCheckboxTag, times(1)).setPageContext(mockPageContext);
	}
}
