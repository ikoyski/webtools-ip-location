package com.ikoyski.webtools.iplocation.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ikoyski.webtools.iplocation.dto.IpLocationResponse;
import com.ikoyski.webtools.iplocation.service.IpLocationService;

@RestController
public class IpLocationController {

	private final IpLocationService ipLocationService;

	public IpLocationController(IpLocationService ipLocationService) {
		this.ipLocationService = ipLocationService;
	}

	@GetMapping(path = "api/v1/ipLocation/{ip}")
	@Cacheable(value = "ipLocation", key = "#ip")
	public IpLocationResponse getIpLocation(@PathVariable("ip") String ip) {
		return ipLocationService.getIpLocation(ip);
	}

}
