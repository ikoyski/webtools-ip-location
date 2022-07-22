package com.ikoyski.webtoolsiplocation.provider;

import com.ikoyski.webtoolsiplocation.dto.IpLocationResponse;

public interface IpLocationProviderBaseInterface {

	public IpLocationResponse getIpLocation(String ip);

}
