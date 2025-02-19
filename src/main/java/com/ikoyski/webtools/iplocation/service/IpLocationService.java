package com.ikoyski.webtools.iplocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikoyski.webtools.iplocation.dto.IpLocationResponse;
import com.ikoyski.webtools.iplocation.provider.IpLocationProviderBaseInterface;
import com.ikoyski.webtools.iplocation.provider.IpLocationProviderFactory;

@Service
public class IpLocationService {

	@Autowired
	private IpLocationProviderFactory ipLocationProviderFactory;

	public IpLocationResponse getIpLocation(String ip) {
		IpLocationProviderBaseInterface ipLocationProvider = ipLocationProviderFactory.createIpLocationProvider();
		return ipLocationProvider.getIpLocation(ip);
	}

}
