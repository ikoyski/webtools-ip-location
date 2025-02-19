package com.ikoyski.webtools.iplocation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtools.iplocation.dto.IpLocationResponse;

@SpringBootTest
class IpLocationResponseTest {

	@Test
	@DisplayName("IpLocationResponseTest.ipLocationResponseSuccess()")
	void ipLocationResponseSuccess() {
		// given
		final String QUERY = "8.8.8.8";
		final String STATUS = "success";
		final String COUNTRY = "United States";
		final String COUNTRY_CODE = "US";
		final String REGION = "VA";
		final String REGION_NAME = "Virginia";
		final String CITY = "Ashburn";
		final String ZIP = "20149";
		final String LAT = "39.03";
		final String LON = "-77.5";
		final String TIMEZONE = "America/New_York";
		final String ISP = "Google LLC";
		final String ORG = "Google Public DNS";
		final String AS = "AS15169 Google LLC";
		IpLocationResponse ipLocationResponse = new IpLocationResponse();

		// when
		ipLocationResponse.setQuery(QUERY);
		ipLocationResponse.setStatus(STATUS);
		ipLocationResponse.setCountry(COUNTRY);
		ipLocationResponse.setCountryCode(COUNTRY_CODE);
		ipLocationResponse.setRegion(REGION);
		ipLocationResponse.setRegionName(REGION_NAME);
		ipLocationResponse.setCity(CITY);
		ipLocationResponse.setZip(ZIP);
		ipLocationResponse.setLat(LAT);
		ipLocationResponse.setLon(LON);
		ipLocationResponse.setTimezone(TIMEZONE);
		ipLocationResponse.setIsp(ISP);
		ipLocationResponse.setOrg(ORG);
		ipLocationResponse.setAs(AS);

		// then
		Assertions.assertEquals(ipLocationResponse.getQuery(), QUERY);
		Assertions.assertEquals(ipLocationResponse.getStatus(), STATUS);
		Assertions.assertEquals(ipLocationResponse.getCountry(), COUNTRY);
		Assertions.assertEquals(ipLocationResponse.getCountryCode(), COUNTRY_CODE);
		Assertions.assertEquals(ipLocationResponse.getRegion(), REGION);
		Assertions.assertEquals(ipLocationResponse.getRegionName(), REGION_NAME);
		Assertions.assertEquals(ipLocationResponse.getCity(), CITY);
		Assertions.assertEquals(ipLocationResponse.getZip(), ZIP);
		Assertions.assertEquals(ipLocationResponse.getLat(), LAT);
		Assertions.assertEquals(ipLocationResponse.getLon(), LON);
		Assertions.assertEquals(ipLocationResponse.getTimezone(), TIMEZONE);
		Assertions.assertEquals(ipLocationResponse.getIsp(), ISP);
		Assertions.assertEquals(ipLocationResponse.getOrg(), ORG);
		Assertions.assertEquals(ipLocationResponse.getAs(), AS);
	}
}
