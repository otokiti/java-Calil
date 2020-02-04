package com.xrea.s8.otokiti.calil.entity.geocoding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"result"
})
public final class Geocoding {

	@JsonProperty("result")
	private GeocodingResult result;

	@JsonProperty("result")
	public GeocodingResult getResult() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(GeocodingResult result) {
		this.result = result;
	}
}
