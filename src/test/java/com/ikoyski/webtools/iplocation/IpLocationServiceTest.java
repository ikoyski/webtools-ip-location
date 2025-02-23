package com.ikoyski.webtools.iplocation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.iplocation.dto.IpLocationResponse;
import com.ikoyski.webtools.iplocation.service.IpLocationService;

@SpringBootTest
@ActiveProfiles("test")
class IpLocationServiceTest {

	@Autowired
	private IpLocationService ipLocationpService;

	@Test
	@DisplayName("IpLocationServiceTest.getIpLocationSuccess()")
	void getIpLocationSuccess() {
		// given
		final String IP = "8.8.8.8";
		final String COUNTRY_CODE = "US";

		// when
		IpLocationResponse ipLocationResponse = ipLocationpService.getIpLocation(IP);

		// then
		Assertions.assertEquals(ipLocationResponse.getCountryCode(), COUNTRY_CODE);
	}

}
