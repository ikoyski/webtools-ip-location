package com.ikoyski.webtoolsiplocation.provider;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;

public interface IpLocationProviderBaseInterface {

	public static final String ERROR_INVALID_URI = "invalid uri";

	public IpLocationResponse getIpLocation(String ip);

}
