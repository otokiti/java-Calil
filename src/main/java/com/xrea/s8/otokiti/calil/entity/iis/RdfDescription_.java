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
		"dcndl:transcription",
		"rdf:value"
})
public final class RdfDescription_ {

	@JsonProperty("dcndl:transcription")
	private String dcndlTranscription;
	@JsonProperty("rdf:value")
	private String rdfValue;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("dcndl:transcription")
	public String getDcndlTranscription() {
		return dcndlTranscription;
	}

	@JsonProperty("dcndl:transcription")
	public void setDcndlTranscription(String dcndlTranscription) {
		this.dcndlTranscription = dcndlTranscription;
	}

	@JsonProperty("rdf:value")
	public String getRdfValue() {
		return rdfValue;
	}

	@JsonProperty("rdf:value")
	public void setRdfValue(String rdfValue) {
		this.rdfValue = rdfValue;
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
