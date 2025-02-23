package com.ikoyski.webtools.iplocation.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IpLocationProviderFactory {

	public static final String PROVIDER_IPAPI = "IPAPI";

	@Autowired
	IpLocationProviderIpApi ipLocationProviderIpApi;

	@Value("${provider.default}")
	private String PROVIDER_DEFAULT;

	public IpLocationProviderBaseInterface createIpLocationProvider() {
		return createIpLocationProvider(PROVIDER_DEFAULT);
	}

	public IpLocationProviderBaseInterface createIpLocationProvider(String type) {
		if (PROVIDER_IPAPI.equals(type)) {
			return ipLocationProviderIpApi;
		} else {
			throw new IllegalArgumentException("No such provider.");
		}
	}

}
