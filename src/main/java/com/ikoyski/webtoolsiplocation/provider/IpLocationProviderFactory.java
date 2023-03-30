package com.ikoyski.webtoolsiplocation.provider;

public class IpLocationProviderFactory {

	public static final String PROVIDER_IPAPI = "IpApi";

	public IpLocationProviderBaseInterface createIpLocationProvider(String type) {
		if (PROVIDER_IPAPI.equals(type)) {
			// using https://ip-api.com/
			return new IpLocationProviderIpApi();
		} else {
			throw new IllegalArgumentException("No such provider.");
		}
	}

}
