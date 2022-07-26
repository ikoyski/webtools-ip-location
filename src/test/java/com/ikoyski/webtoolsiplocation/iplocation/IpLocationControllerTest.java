package com.ikoyski.webtoolsiplocation.iplocation;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ikoyski.webtoolsiplocation.controller.IpLocationController;
import com.ikoyski.webtoolsiplocation.service.IpLocationService;

@SpringBootTest
class IpLocationControllerTest {

	@Autowired
	private IpLocationController ipLocationController;

	@MockBean
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
