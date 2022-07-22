package com.ikoyski.webtoolsiplocation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;
import com.ikoyski.webtoolsiplocation.service.IpLocationService;

@RestController
public class IpLocationController {

	private final IpLocationService ipLocationService;

	public IpLocationController(IpLocationService ipLocationService) {
		this.ipLocationService = ipLocationService;
	}

	@GetMapping(path = "api/v1/ipLocation/{ip}")
	public IpLocationResponse getIpLocation(@PathVariable("ip") String ip) {
		return ipLocationService.getIpLocation(ip);
	}

}
