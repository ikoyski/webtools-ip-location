package com.ikoyski.webtoolsiplocation.iplocation;

import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;
import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtoolsiplocation.service.IpLocationService;

@SpringBootTest
public class IpLocationServiceTest {

	@Autowired
	private IpLocationService ipLocationpService;

	@MockBean
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
