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
			ipLocationResponse = responseAdapter(
					restTemplate.getForObject(uri.toURL().toString(), IpApiResponse.class));
		} catch (URISyntaxException | RestClientException | MalformedURLException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, IpLocationProviderBaseInterface.ERROR_INVALID_URI,
					null);
		}
		return ipLocationResponse;
	}

	private IpLocationResponse responseAdapter(IpApiResponse response) {
		IpLocationResponse ipLocationResponse = new IpLocationResponse();
		ipLocationResponse.setQuery(response.getQuery());
		ipLocationResponse.setStatus(response.getStatus());
		ipLocationResponse.setCountry(response.getCountry());
		ipLocationResponse.setCountryCode(response.getCountryCode());
		ipLocationResponse.setRegion(response.getRegion());
		ipLocationResponse.setRegionName(response.getRegionName());
		ipLocationResponse.setCity(response.getCity());
		ipLocationResponse.setZip(response.getZip());
		ipLocationResponse.setLat(response.getLat());
		ipLocationResponse.setLon(response.getLon());
		ipLocationResponse.setTimezone(response.getTimezone());
		ipLocationResponse.setIsp(response.getIsp());
		ipLocationResponse.setOrg(response.getOrg());
		ipLocationResponse.setAs(response.getAs());
		return ipLocationResponse;
	}

	public static class IpApiResponse {

		private String query;
		private String status;
		private String country;
		private String countryCode;
		private String region;
		private String regionName;
		private String city;
		private String zip;
		private String lat;
		private String lon;
		private String timezone;
		private String isp;
		private String org;
		private String as;

		public String getQuery() {
			return query;
		}

		public void setQuery(String query) {
			this.query = query;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCountryCode() {
			return countryCode;
		}

		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getRegionName() {
			return regionName;
		}

		public void setRegionName(String regionName) {
			this.regionName = regionName;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getLon() {
			return lon;
		}

		public void setLon(String lon) {
			this.lon = lon;
		}

		public String getTimezone() {
			return timezone;
		}

		public void setTimezone(String timezone) {
			this.timezone = timezone;
		}

		public String getIsp() {
			return isp;
		}

		public void setIsp(String isp) {
			this.isp = isp;
		}

		public String getOrg() {
			return org;
		}

		public void setOrg(String org) {
			this.org = org;
		}

		public String getAs() {
			return as;
		}

		public void setAs(String as) {
			this.as = as;
		}

	}

}
