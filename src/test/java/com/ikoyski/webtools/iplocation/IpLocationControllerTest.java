package com.ikoyski.webtools.iplocation;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ikoyski.webtools.iplocation.controller.IpLocationController;
import com.ikoyski.webtools.iplocation.service.IpLocationService;

@SpringBootTest
@ActiveProfiles("test")
class IpLocationControllerTest {

	@Autowired
	private IpLocationController ipLocationController;

	@MockitoBean
	private IpLocationService ipLocationService;

	@Test
	@DisplayName("IpLocationControllerTest.getIpLocationSucces()")
	void getIpLocationSucces() {
		// given
		final String IP = "8.8.8.8";

		// when
		ipLocationController.getIpLocation(IP);

		// then
		verify(ipLocationService).getIpLocation(IP);
	}

}
