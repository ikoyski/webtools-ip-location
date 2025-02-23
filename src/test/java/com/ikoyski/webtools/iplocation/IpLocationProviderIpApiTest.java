package com.ikoyski.webtools.iplocation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.iplocation.dto.IpLocationResponse;
import com.ikoyski.webtools.iplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtools.iplocation.provider.IpLocationProviderFactory;

@SpringBootTest
@ActiveProfiles("test")
class IpLocationProviderIpApiTest {

	@Autowired
	IpLocationProviderFactory ipLocationProviderFactory;

	@Test
	@DisplayName("IpLocationProviderIpApiTest.ipLocationProviderIpApiSuccess()")
	void ipLocationProviderIpApiSuccess() {
		// given
		final String IP = "8.8.8.8";
		IpLocationProviderBaseInterface ipLocationProvider = ipLocationProviderFactory.createIpLocationProvider();

		// when
		IpLocationResponse ipLocationResponse = ipLocationProvider.getIpLocation(IP);

		// then
		Assertions.assertNotNull(ipLocationResponse);
	}

	@Test
	@DisplayName("IpLocationProviderIpApiTest.ipLocationProviderIpApiException()")
	void ipLocationProviderIpApiException() {
		// given
		final String IP = "\\";
		IpLocationProviderBaseInterface ipLocationProvider = ipLocationProviderFactory.createIpLocationProvider();

		// when and then
		Assertions.assertThrows(Exception.class, () -> ipLocationProvider.getIpLocation(IP));
	}

}
