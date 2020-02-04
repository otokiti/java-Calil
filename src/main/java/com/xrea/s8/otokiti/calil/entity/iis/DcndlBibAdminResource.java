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
		"dcndl:bibRecordCategory",
		"dcndl:record",
		"dcndl:catalogingStatus",
		"rdf:about"
})
public final class DcndlBibAdminResource {

	@JsonProperty("dcndl:bibRecordCategory")
	private String dcndlBibRecordCategory;
	@JsonProperty("dcndl:record")
	private DcndlRecord dcndlRecord;
	@JsonProperty("dcndl:catalogingStatus")
	private String dcndlCatalogingStatus;
	@JsonProperty("rdf:about")
	private String rdfAbout;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("dcndl:bibRecordCategory")
	public String getDcndlBibRecordCategory() {
		return dcndlBibRecordCategory;
	}

	@JsonProperty("dcndl:bibRecordCategory")
	public void setDcndlBibRecordCategory(String dcndlBibRecordCategory) {
		this.dcndlBibRecordCategory = dcndlBibRecordCategory;
	}

	@JsonProperty("dcndl:record")
	public DcndlRecord getDcndlRecord() {
		return dcndlRecord;
	}

	@JsonProperty("dcndl:record")
	public void setDcndlRecord(DcndlRecord dcndlRecord) {
		this.dcndlRecord = dcndlRecord;
	}

	@JsonProperty("dcndl:catalogingStatus")
	public String getDcndlCatalogingStatus() {
		return dcndlCatalogingStatus;
	}

	@JsonProperty("dcndl:catalogingStatus")
	public void setDcndlCatalogingStatus(String dcndlCatalogingStatus) {
		this.dcndlCatalogingStatus = dcndlCatalogingStatus;
	}

	@JsonProperty("rdf:about")
	public String getRdfAbout() {
		return rdfAbout;
	}

	@JsonProperty("rdf:about")
	public void setRdfAbout(String rdfAbout) {
		this.rdfAbout = rdfAbout;
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
