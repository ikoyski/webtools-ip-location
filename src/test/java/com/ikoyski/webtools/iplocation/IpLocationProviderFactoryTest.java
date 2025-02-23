package com.ikoyski.webtools.iplocation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtools.iplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtools.iplocation.provider.IpLocationProviderFactory;

@SpringBootTest
class IpLocationProviderFactoryTest {

	@Autowired
	IpLocationProviderFactory ipLocationProviderFactory;

	@Test
	@DisplayName("IpLocationProviderFactoryTest.ipLocationProviderFactorySuccess()")
	void ipLocationProviderFactorySuccess() {
		// when
		IpLocationProviderBaseInterface ipLocationProvider = ipLocationProviderFactory.createIpLocationProvider();

		// then
		Assertions.assertNotNull(ipLocationProvider);
	}

	@Test
	@DisplayName("IpLocationProviderFactoryTest.ipLocationProviderFactoryException()")
	void ipLocationProviderFactoryException() {
		// when and then
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> ipLocationProviderFactory.createIpLocationProvider("Dummy"));
	}
}
