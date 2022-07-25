package com.ikoyski.webtoolsiplocation.provider;

import org.springframework.web.client.RestTemplate;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;

public class IpLocationProviderIpApi implements IpLocationProviderBaseInterface {

	@Override
	public IpLocationResponse getIpLocation(String ip) {
		String uri = "http://ip-api.com/json/" + ip;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, IpLocationResponse.class);
	}

}
