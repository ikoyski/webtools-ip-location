package com.ikoyski.webtoolsiplocation.iplocation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderFactory;

@SpringBootTest
class IpLocationProviderFactoryTest {

	@Test
	@DisplayName("IpLocationProviderFactoryTest.ipLocationProviderFactorySuccess()")
	void ipLocationProviderFactorySuccess() {
		// given
		IpLocationProviderFactory ipLocationProviderFactory = new IpLocationProviderFactory();

		// when
		IpLocationProviderBaseInterface ipLocationProvider = ipLocationProviderFactory
				.createIpLocationProvider(IpLocationProviderFactory.PROVIDER_IPAPI);

		// then
		Assertions.assertNotNull(ipLocationProvider);
	}

	@Test
	@DisplayName("IpLocationProviderFactoryTest.ipLocationProviderFactoryException()")
	void ipLocationProviderFactoryException() {
		// given
		IpLocationProviderFactory ipLocationProviderFactory = new IpLocationProviderFactory();

		// when and then
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> ipLocationProviderFactory.createIpLocationProvider("Dummy"));
	}
}
