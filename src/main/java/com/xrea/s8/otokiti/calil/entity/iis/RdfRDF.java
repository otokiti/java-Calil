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
		"xmlns:dcterms",
		"dcndl:BibResource",
		"xmlns:dcndl",
		"xmlns:foaf",
		"xmlns:owl",
		"xmlns:rdf",
		"xmlns:rdfs",
		"dcndl:BibAdminResource",
		"xmlns:dc"
})
public final class RdfRDF {

	@JsonProperty("xmlns:dcterms")
	private String xmlnsDcterms;
	@JsonProperty("dcndl:BibResource")
	private DcndlBibResource dcndlBibResource;
	@JsonProperty("xmlns:dcndl")
	private String xmlnsDcndl;
	@JsonProperty("xmlns:foaf")
	private String xmlnsFoaf;
	@JsonProperty("xmlns:owl")
	private String xmlnsOwl;
	@JsonProperty("xmlns:rdf")
	private String xmlnsRdf;
	@JsonProperty("xmlns:rdfs")
	private String xmlnsRdfs;
	@JsonProperty("dcndl:BibAdminResource")
	private DcndlBibAdminResource dcndlBibAdminResource;
	@JsonProperty("xmlns:dc")
	private String xmlnsDc;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("xmlns:dcterms")
	public String getXmlnsDcterms() {
		return xmlnsDcterms;
	}

	@JsonProperty("xmlns:dcterms")
	public void setXmlnsDcterms(String xmlnsDcterms) {
		this.xmlnsDcterms = xmlnsDcterms;
	}

	@JsonProperty("dcndl:BibResource")
	public DcndlBibResource getDcndlBibResource() {
		return dcndlBibResource;
	}

	@JsonProperty("dcndl:BibResource")
	public void setDcndlBibResource(DcndlBibResource dcndlBibResource) {
		this.dcndlBibResource = dcndlBibResource;
	}

	@JsonProperty("xmlns:dcndl")
	public String getXmlnsDcndl() {
		return xmlnsDcndl;
	}

	@JsonProperty("xmlns:dcndl")
	public void setXmlnsDcndl(String xmlnsDcndl) {
		this.xmlnsDcndl = xmlnsDcndl;
	}

	@JsonProperty("xmlns:foaf")
	public String getXmlnsFoaf() {
		return xmlnsFoaf;
	}

	@JsonProperty("xmlns:foaf")
	public void setXmlnsFoaf(String xmlnsFoaf) {
		this.xmlnsFoaf = xmlnsFoaf;
	}

	@JsonProperty("xmlns:owl")
	public String getXmlnsOwl() {
		return xmlnsOwl;
	}

	@JsonProperty("xmlns:owl")
	public void setXmlnsOwl(String xmlnsOwl) {
		this.xmlnsOwl = xmlnsOwl;
	}

	@JsonProperty("xmlns:rdf")
	public String getXmlnsRdf() {
		return xmlnsRdf;
	}

	@JsonProperty("xmlns:rdf")
	public void setXmlnsRdf(String xmlnsRdf) {
		this.xmlnsRdf = xmlnsRdf;
	}

	@JsonProperty("xmlns:rdfs")
	public String getXmlnsRdfs() {
		return xmlnsRdfs;
	}

	@JsonProperty("xmlns:rdfs")
	public void setXmlnsRdfs(String xmlnsRdfs) {
		this.xmlnsRdfs = xmlnsRdfs;
	}

	@JsonProperty("dcndl:BibAdminResource")
	public DcndlBibAdminResource getDcndlBibAdminResource() {
		return dcndlBibAdminResource;
	}

	@JsonProperty("dcndl:BibAdminResource")
	public void setDcndlBibAdminResource(DcndlBibAdminResource dcndlBibAdminResource) {
		this.dcndlBibAdminResource = dcndlBibAdminResource;
	}

	@JsonProperty("xmlns:dc")
	public String getXmlnsDc() {
		return xmlnsDc;
	}

	@JsonProperty("xmlns:dc")
	public void setXmlnsDc(String xmlnsDc) {
		this.xmlnsDc = xmlnsDc;
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
