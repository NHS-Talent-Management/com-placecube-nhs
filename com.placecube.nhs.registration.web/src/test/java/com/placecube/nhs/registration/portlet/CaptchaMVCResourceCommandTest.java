package com.placecube.nhs.registration.portlet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.captcha.util.CaptchaUtil;
import com.placecube.nhs.registration.portlet.CaptchaMVCResourceCommand;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CaptchaUtil.class)
public class CaptchaMVCResourceCommandTest extends PowerMockito {

	@InjectMocks
	private CaptchaMVCResourceCommand captchaMVCResourceCommand;

	@Mock
	private ResourceRequest mockResourceRequest;

	@Mock
	private ResourceResponse mockResourceResponse;

	@Before
	public void setUp() {
		mockStatic(CaptchaUtil.class);
	}

	@Test
	public void serveResource_WhenNoError_ThenReturnsTrue() throws PortletException {
		boolean result = captchaMVCResourceCommand.serveResource(mockResourceRequest, mockResourceResponse);

		assertTrue(result);
	}

	@Test
	public void serveResource_WhenNoError_ThenCallsCaptchaUtilServeResource() throws Exception {
		captchaMVCResourceCommand.serveResource(mockResourceRequest, mockResourceResponse);

		verifyStatic(times(1));
		CaptchaUtil.serveImage(mockResourceRequest, mockResourceResponse);
	}

	@Test(expected = PortletException.class)
	public void serveResource_WhenExceptionServingCaptchaImage_ThenThrowsPortletException() throws Exception {
		doThrow(new IOException()).when(CaptchaUtil.class);
		CaptchaUtil.serveImage(mockResourceRequest, mockResourceResponse);

		captchaMVCResourceCommand.serveResource(mockResourceRequest, mockResourceResponse);

	}

}
