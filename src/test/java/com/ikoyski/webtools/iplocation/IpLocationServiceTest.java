package com.ikoyski.webtools.iplocation;

import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ikoyski.webtools.iplocation.dto.IpLocationResponse;
import com.ikoyski.webtools.iplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtools.iplocation.service.IpLocationService;

@SpringBootTest
@ActiveProfiles("test")
class IpLocationServiceTest {

	@Autowired
	private IpLocationService ipLocationpService;

	@MockitoBean
	IpLocationProviderBaseInterface ipLocationProvider;

	@Test
	@DisplayName("IpLocationServiceTest.getIpLocationSuccess()")
	void getIpLocationSuccess() {
		// given
		final String IP = "8.8.8.8";
		final String COUNTRY_CODE = "US";
		IpLocationResponse ipLocationResponse = new IpLocationResponse();
		ipLocationResponse.setCountryCode(COUNTRY_CODE);
		doReturn(ipLocationResponse).when(ipLocationProvider).getIpLocation(IP);

		// when
		IpLocationResponse ipLocationResponse2 = ipLocationpService.getIpLocation(IP);

		// then
		Assertions.assertEquals(ipLocationResponse2.getCountryCode(), COUNTRY_CODE);
	}

}
