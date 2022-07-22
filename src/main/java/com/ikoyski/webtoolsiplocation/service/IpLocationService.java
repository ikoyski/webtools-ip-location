package com.ikoyski.webtoolsiplocation.service;

import org.springframework.stereotype.Service;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;
import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderFactory;

@Service
public class IpLocationService {

	public IpLocationResponse getIpLocation(String ip) {
		IpLocationProviderBaseInterface ipLocationProvider = IpLocationProviderFactory
				.createIpLocationProvider(IpLocationProviderFactory.PROVIDER_IPAPI);
		return ipLocationProvider.getIpLocation(ip);
	}

}
