package com.ikoyski.webtools.iplocation.provider;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ikoyski.webtools.iplocation.dto.IpLocationResponse;

@Component
public class IpLocationProviderIpApi implements IpLocationProviderBaseInterface {
	
	@Value("${provider.ipApi.baseUrl}")
	private String BASE_URL;

	@Override
	public IpLocationResponse getIpLocation(String ip) {
		IpLocationResponse ipLocationResponse = null;
		try {
			URI uri = new URI(BASE_URL + "/" + ip);
			RestTemplate restTemplate = new RestTemplate();
			ipLocationResponse = restTemplate.getForObject(uri.toURL().toString(), IpLocationResponse.class);
		} catch (URISyntaxException | RestClientException | MalformedURLException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, IpLocationProviderBaseInterface.ERROR_INVALID_URI,
					null);
		}
		return ipLocationResponse;
	}

}
