package com.ikoyski.webtoolsiplocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;
import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtoolsiplocation.provider.IpLocationProviderFactory;

@Service
public class IpLocationService {

	@Autowired
	private IpLocationProviderFactory ipLocationProviderFactory;

	public IpLocationResponse getIpLocation(String ip) {
		IpLocationProviderBaseInterface ipLocationProvider = ipLocationProviderFactory.createIpLocationProvider();
		return ipLocationProvider.getIpLocation(ip);
	}

}
