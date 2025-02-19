package com.ikoyski.webtools.iplocation.provider;

import com.ikoyski.webtools.iplocation.dto.IpLocationResponse;

public interface IpLocationProviderBaseInterface {

	public static final String ERROR_INVALID_URI = "invalid uri";

	public IpLocationResponse getIpLocation(String ip);

}
