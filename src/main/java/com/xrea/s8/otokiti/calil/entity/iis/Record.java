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
		"recordPosition",
		"recordSchema",
		"recordPacking",
		"recordData"
})
public final class Record {

	@JsonProperty("recordPosition")
	private Integer recordPosition;
	@JsonProperty("recordSchema")
	private String recordSchema;
	@JsonProperty("recordPacking")
	private String recordPacking;
	@JsonProperty("recordData")
	private String recordData;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("recordPosition")
	public Integer getRecordPosition() {
		return recordPosition;
	}

	@JsonProperty("recordPosition")
	public void setRecordPosition(Integer recordPosition) {
		this.recordPosition = recordPosition;
	}

	@JsonProperty("recordSchema")
	public String getRecordSchema() {
		return recordSchema;
	}

	@JsonProperty("recordSchema")
	public void setRecordSchema(String recordSchema) {
		this.recordSchema = recordSchema;
	}

	@JsonProperty("recordPacking")
	public String getRecordPacking() {
		return recordPacking;
	}

	@JsonProperty("recordPacking")
	public void setRecordPacking(String recordPacking) {
		this.recordPacking = recordPacking;
	}

	@JsonProperty("recordData")
	public String getRecordData() {
		return recordData;
	}

	@JsonProperty("recordData")
	public void setRecordData(String recordData) {
		this.recordData = recordData;
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