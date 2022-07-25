package com.ikoyski.webtoolsiplocation.provider;

public class IpLocationProviderFactory {

	public static final String PROVIDER_IPAPI = "IpApi";

	private IpLocationProviderFactory() {
		super();
	}

	public static IpLocationProviderBaseInterface createIpLocationProvider(String type) {
		IpLocationProviderBaseInterface ipLocationProvider;
		if (PROVIDER_IPAPI.equals(type)) {
			// using https://ip-api.com/
			ipLocationProvider = new IpLocationProviderIpApi();
		} else {
			throw new IllegalArgumentException("No such provider.");
		}
		return ipLocationProvider;
	}

}
