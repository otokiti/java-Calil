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
		"foaf:name",
		"dcndl:transcription",
		"dcterms:description",
		"dcndl:location"
})
public final class FoafAgent_ {

	@JsonProperty("foaf:name")
	private String foafName;
	@JsonProperty("dcndl:transcription")
	private String dcndlTranscription;
	@JsonProperty("dcterms:description")
	private String dctermsDescription;
	@JsonProperty("dcndl:location")
	private String dcndlLocation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("foaf:name")
	public String getFoafName() {
		return foafName;
	}

	@JsonProperty("foaf:name")
	public void setFoafName(String foafName) {
		this.foafName = foafName;
	}

	@JsonProperty("dcndl:transcription")
	public String getDcndlTranscription() {
		return dcndlTranscription;
	}

	@JsonProperty("dcndl:transcription")
	public void setDcndlTranscription(String dcndlTranscription) {
		this.dcndlTranscription = dcndlTranscription;
	}

	@JsonProperty("dcterms:description")
	public String getDctermsDescription() {
		return dctermsDescription;
	}

	@JsonProperty("dcterms:description")
	public void setDctermsDescription(String dctermsDescription) {
		this.dctermsDescription = dctermsDescription;
	}

	@JsonProperty("dcndl:location")
	public String getDcndlLocation() {
		return dcndlLocation;
	}

	@JsonProperty("dcndl:location")
	public void setDcndlLocation(String dcndlLocation) {
		this.dcndlLocation = dcndlLocation;
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
