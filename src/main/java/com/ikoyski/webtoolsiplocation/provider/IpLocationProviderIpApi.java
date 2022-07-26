package com.ikoyski.webtoolsiplocation.provider;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;

public class IpLocationProviderIpApi implements IpLocationProviderBaseInterface {

	@Override
	public IpLocationResponse getIpLocation(String ip) {
		IpLocationResponse ipLocationResponse = null;
		try {
			URI uri = new URI("http://ip-api.com/json/" + ip);
			RestTemplate restTemplate = new RestTemplate();
			ipLocationResponse = restTemplate.getForObject(uri.toURL().toString(), IpLocationResponse.class);
		} catch (URISyntaxException | RestClientException | MalformedURLException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, IpLocationProviderBaseInterface.ERROR_INVALID_URI,
					null);
		}
		return ipLocationResponse;
	}

}
