package com.ikoyski.webtoolsiplocation.iplocation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;
import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderFactory;

@SpringBootTest
class IpLocationProviderIpApiTest {

	@Test
	@DisplayName("IpLocationProviderIpApiTest.ipLocationProviderIpApiSuccess()")
	void ipLocationProviderIpApiSuccess() {
		// given
		final String IP = "8.8.8.8";
		IpLocationProviderFactory ipLocationProviderFactory = new IpLocationProviderFactory();
		IpLocationProviderBaseInterface ipLocationProvider = ipLocationProviderFactory
				.createIpLocationProvider(IpLocationProviderFactory.PROVIDER_IPAPI);

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
		IpLocationProviderFactory ipLocationProviderFactory = new IpLocationProviderFactory();
		IpLocationProviderBaseInterface ipLocationProvider = ipLocationProviderFactory
				.createIpLocationProvider(IpLocationProviderFactory.PROVIDER_IPAPI);

		// when and then
		Assertions.assertThrows(Exception.class, () -> ipLocationProvider.getIpLocation(IP));
	}

}
