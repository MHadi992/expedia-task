
package com.expedia.beans.jsonBeans;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "hotelInfositeUrl", "hotelSearchResultUrl" })
public class HotelUrls {

	@JsonProperty("hotelInfositeUrl")
	private String hotelInfositeUrl;
	@JsonProperty("hotelSearchResultUrl")
	private String hotelSearchResultUrl;

	@SuppressWarnings("deprecation")
	@JsonProperty("hotelInfositeUrl")
	public String getHotelInfositeUrl() {
		try {
			return URLDecoder.decode(hotelInfositeUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return URLDecoder.decode(hotelInfositeUrl);
		}
	}

	@JsonProperty("hotelInfositeUrl")
	public void setHotelInfositeUrl(String hotelInfositeUrl) {
		this.hotelInfositeUrl = hotelInfositeUrl;
	}
	
	@SuppressWarnings("deprecation")
	@JsonProperty("hotelSearchResultUrl")
	public String getHotelSearchResultUrl() {
		try {
			return URLDecoder.decode(hotelSearchResultUrl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return URLDecoder.decode(hotelSearchResultUrl);
		}
	}

	@JsonProperty("hotelSearchResultUrl")
	public void setHotelSearchResultUrl(String hotelSearchResultUrl) {
		this.hotelSearchResultUrl = hotelSearchResultUrl;
	}

}
