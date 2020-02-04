package com.xrea.s8.otokiti.calil.entity.geocoding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"address",
		"coordinate",
		"open_location_code",
		"google_maps",
		"needs_to_verify",
		"version",
		"url",
		"error"
})
public final class GeocodingResult {

	@JsonProperty("address")
	private String address;
	@JsonProperty("coordinate")
	private Coordinate coordinate;
	@JsonProperty("open_location_code")
	private String openLocationCode;
	@JsonProperty("google_maps")
	private String googleMaps;
	@JsonProperty("needs_to_verify")
	private String needsToVerify;
	@JsonProperty("version")
	private Float version;
	@JsonProperty("url")
	private String url;
	@JsonProperty("error")
	private String error;

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("coordinate")
	public Coordinate getCoordinate() {
		return coordinate;
	}

	@JsonProperty("coordinate")
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@JsonProperty("open_location_code")
	public String getOpenLocationCode() {
		return openLocationCode;
	}

	@JsonProperty("open_location_code")
	public void setOpenLocationCode(String openLocationCode) {
		this.openLocationCode = openLocationCode;
	}

	@JsonProperty("google_maps")
	public String getGoogleMaps() {
		return googleMaps;
	}

	@JsonProperty("google_maps")
	public void setGoogleMaps(String googleMaps) {
		this.googleMaps = googleMaps;
	}

	@JsonProperty("needs_to_verify")
	public String getNeedsToVerify() {
		return needsToVerify;
	}

	@JsonProperty("needs_to_verify")
	public void setNeedsToVerify(String needsToVerify) {
		this.needsToVerify = needsToVerify;
	}

	@JsonProperty("version")
	public Float getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(Float version) {
		this.version = version;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("error")
	public String getError() {
		return error;
	}

	@JsonProperty("error")
	public void setError(String error) {
		this.error = error;
	}
}
