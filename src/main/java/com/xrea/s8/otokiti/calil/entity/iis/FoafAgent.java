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
		"rdf:about",
		"dcndl:transcription"
})
public final class FoafAgent {

	@JsonProperty("foaf:name")
	private String foafName;
	@JsonProperty("rdf:about")
	private String rdfAbout;
	@JsonProperty("dcndl:transcription")
	private String dcndlTranscription;
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

	@JsonProperty("rdf:about")
	public String getRdfAbout() {
		return rdfAbout;
	}

	@JsonProperty("rdf:about")
	public void setRdfAbout(String rdfAbout) {
		this.rdfAbout = rdfAbout;
	}

	@JsonProperty("dcndl:transcription")
	public String getDcndlTranscription() {
		return dcndlTranscription;
	}

	@JsonProperty("dcndl:transcription")
	public void setDcndlTranscription(String dcndlTranscription) {
		this.dcndlTranscription = dcndlTranscription;
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
