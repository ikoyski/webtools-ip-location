package com.ikoyski.webtoolsiplocation.provider;

public class IpLocationProviderFactory {

	public static final String PROVIDER_IPAPI = "IpApi";

	public static IpLocationProviderBaseInterface createIpLocationProvider(String type) {
		IpLocationProviderBaseInterface ipLocationProvider;
		switch (type) {
		case PROVIDER_IPAPI:
			// using https://ip-api.com/
			ipLocationProvider = new IpLocationProvider_IpApi();
			break;
		default:
			throw new IllegalArgumentException("No such provider.");

		}
		return ipLocationProvider;
	}

}
