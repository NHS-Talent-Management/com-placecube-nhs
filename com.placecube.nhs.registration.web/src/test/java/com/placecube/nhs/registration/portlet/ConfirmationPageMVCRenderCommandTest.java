package com.placecube.nhs.registration.portlet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

public class ConfirmationPageMVCRenderCommandTest extends PowerMockito {

	@InjectMocks
	private ConfirmationPageMVCRenderCommand confirmationPageMVCRenderCommand;

	@Mock
	private RenderRequest mockRenderRequest;

	@Mock
	private RenderResponse mockRenderResponse;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void render_WhenNoError_ThenReturnsConfirmationPageJSP() throws PortletException {
		String result = confirmationPageMVCRenderCommand.render(mockRenderRequest, mockRenderResponse);

		assertThat(result, equalTo("/confirmation-page.jsp"));
	}

}
