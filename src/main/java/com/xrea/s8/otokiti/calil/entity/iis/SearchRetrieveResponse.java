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
		"xmlns",
		"records",
		"numberOfRecords",
		"nextRecordPosition",
		"version",
		"extraResponseData"
})
public final class SearchRetrieveResponse {

	@JsonProperty("xmlns")
	private String xmlns;
	@JsonProperty("records")
	private Records records;
	@JsonProperty("numberOfRecords")
	private Integer numberOfRecords;
	@JsonProperty("nextRecordPosition")
	private Integer nextRecordPosition;
	@JsonProperty("version")
	private Float version;
	@JsonProperty("extraResponseData")
	private String extraResponseData;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("xmlns")
	public String getXmlns() {
		return xmlns;
	}

	@JsonProperty("xmlns")
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	@JsonProperty("records")
	public Records getRecords() {
		return records;
	}

	@JsonProperty("records")
	public void setRecords(Records records) {
		this.records = records;
	}

	@JsonProperty("numberOfRecords")
	public Integer getNumberOfRecords() {
		return numberOfRecords;
	}

	@JsonProperty("numberOfRecords")
	public void setNumberOfRecords(Integer numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	@JsonProperty("nextRecordPosition")
	public Integer getNextRecordPosition() {
		return nextRecordPosition;
	}

	@JsonProperty("nextRecordPosition")
	public void setNextRecordPosition(Integer nextRecordPosition) {
		this.nextRecordPosition = nextRecordPosition;
	}

	@JsonProperty("version")
	public Float getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(Float version) {
		this.version = version;
	}

	@JsonProperty("extraResponseData")
	public String getExtraResponseData() {
		return extraResponseData;
	}

	@JsonProperty("extraResponseData")
	public void setExtraResponseData(String extraResponseData) {
		this.extraResponseData = extraResponseData;
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