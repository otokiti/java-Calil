package com.xrea.s8.otokiti.calil.entity.iis;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"searchRetrieveResponse"
})
public final class Iis {

	@JsonProperty("searchRetrieveResponse")
	private SearchRetrieveResponse searchRetrieveResponse;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("searchRetrieveResponse")
	public SearchRetrieveResponse getSearchRetrieveResponse() {
		return searchRetrieveResponse;
	}

	@JsonProperty("searchRetrieveResponse")
	public void setSearchRetrieveResponse(SearchRetrieveResponse searchRetrieveResponse) {
		this.searchRetrieveResponse = searchRetrieveResponse;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}