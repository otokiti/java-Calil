package com.xrea.s8.otokiti.calil.entity.iis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"dcterms:accessRights",
		"dcterms:subject",
		"dcndl:originalLanguage",
		"dcterms:creator",
		"dcterms:extent",
		"dcterms:date",
		"dc:creator",
		"dcterms:title",
		"dcndl:sourceIdentifier",
		"rdf:about",
		"dcterms:identifier",
		"dcterms:audience",
		"dcndl:publicationPlace",
		"dcndl:alternative",
		"dcndl:materialType",
		"rdfs:seeAlso",
		"dcndl:price",
		"dc:title",
		"dcterms:publisher",
		"dcterms:description",
		"dcterms:language",
		"dcterms:issued",
		"dcndl:seriesTitle"
})
public final class DcndlBibResource {

	@JsonProperty("dcterms:accessRights")
	private String dctermsAccessRights;
	@JsonProperty("dcterms:subject")
	private List<DctermsSubject> dctermsSubject = null;
	@JsonProperty("dcndl:originalLanguage")
	private DcndlOriginalLanguage dcndlOriginalLanguage;
	@JsonProperty("dcterms:creator")
	private List<DctermsCreator> dctermsCreator = null;
	@JsonProperty("dcterms:extent")
	private List<String> dctermsExtent = null;
	@JsonProperty("dcterms:date")
	private List<String> dctermsDate = null;
	@JsonProperty("dc:creator")
	private List<String> dcCreator = null;
	@JsonProperty("dcterms:title")
	private String dctermsTitle;
	@JsonProperty("dcndl:sourceIdentifier")
	private DcndlSourceIdentifier dcndlSourceIdentifier;
	@JsonProperty("rdf:about")
	private String rdfAbout;
	@JsonProperty("dcterms:identifier")
	private List<DctermsIdentifier> dctermsIdentifier = null;
	@JsonProperty("dcterms:audience")
	private String dctermsAudience;
	@JsonProperty("dcndl:publicationPlace")
	private DcndlPublicationPlace dcndlPublicationPlace;
	@JsonProperty("dcndl:alternative")
	private List<DcndlAlternative> dcndlAlternative = null;
	private List<DcndlMaterialType> dcndlMaterialType = null;
	@JsonProperty("rdfs:seeAlso")
	private List<RdfsSeeAlso> rdfsSeeAlso = null;
	@JsonProperty("dcndl:price")
	private String dcndlPrice;
	@JsonProperty("dc:title")
	private List<DcTitle> dcTitle = null;
	@JsonProperty("dcterms:publisher")
	private List<DctermsPublisher> dctermsPublisher = null;
	@JsonProperty("dcterms:description")
	private List<String> dctermsDescription = null;
	@JsonProperty("dcterms:language")
	private List<DctermsLanguage> dctermsLanguage = null;
	@JsonProperty("dcterms:issued")
	private List<DctermsIssued> dctermsIssued = null;
	@JsonProperty("dcndl:seriesTitle")
	private List<DcndlSeriesTitle> dcndlSeriesTitle = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("dcterms:accessRights")
	public String getDctermsAccessRights() {
		return dctermsAccessRights;
	}

	@JsonProperty("dcterms:accessRights")
	public void setDctermsAccessRights(String dctermsAccessRights) {
		this.dctermsAccessRights = dctermsAccessRights;
	}

	@JsonProperty("dcterms:subject")
	public List<DctermsSubject> getDctermsSubject() {
		return dctermsSubject;
	}

	@JsonProperty("dcterms:subject")
	public void setDctermsSubject(List<DctermsSubject> dctermsSubject) {
		this.dctermsSubject = dctermsSubject;
	}

	@JsonProperty("dcndl:originalLanguage")
	public DcndlOriginalLanguage getDcndlOriginalLanguage() {
		return dcndlOriginalLanguage;
	}

	@JsonProperty("dcndl:originalLanguage")
	public void setDcndlOriginalLanguage(DcndlOriginalLanguage dcndlOriginalLanguage) {
		this.dcndlOriginalLanguage = dcndlOriginalLanguage;
	}

	@JsonProperty("dcterms:creator")
	public List<DctermsCreator> getDctermsCreator() {
		return dctermsCreator;
	}

	@JsonProperty("dcterms:creator")
	public void setDctermsCreator(List<DctermsCreator> dctermsCreator) {
		this.dctermsCreator = dctermsCreator;
	}

	@JsonProperty("dcterms:extent")
	public List<String> getDctermsExtent() {
		return dctermsExtent;
	}

	@JsonProperty("dcterms:extent")
	public void setDctermsExtent(List<String> dctermsExtent) {
		this.dctermsExtent = dctermsExtent;
	}

	@JsonProperty("dcterms:date")
	public List<String> getDctermsDate() {
		return dctermsDate;
	}

	@JsonProperty("dcterms:date")
	public void setDctermsDate(List<String> dctermsDate) {
		this.dctermsDate = dctermsDate;
	}

	@JsonProperty("dc:creator")
	public List<String> getDcCreator() {
		return dcCreator;
	}

	@JsonProperty("dc:creator")
	public void setDcCreator(List<String> dcCreator) {
		this.dcCreator = dcCreator;
	}

	@JsonProperty("dcterms:title")
	public String getDctermsTitle() {
		return dctermsTitle;
	}

	@JsonProperty("dcterms:title")
	public void setDctermsTitle(String dctermsTitle) {
		this.dctermsTitle = dctermsTitle;
	}

	@JsonProperty("dcndl:sourceIdentifier")
	public DcndlSourceIdentifier getDcndlSourceIdentifier() {
		return dcndlSourceIdentifier;
	}

	@JsonProperty("dcndl:sourceIdentifier")
	public void setDcndlSourceIdentifier(DcndlSourceIdentifier dcndlSourceIdentifier) {
		this.dcndlSourceIdentifier = dcndlSourceIdentifier;
	}

	@JsonProperty("rdf:about")
	public String getRdfAbout() {
		return rdfAbout;
	}

	@JsonProperty("rdf:about")
	public void setRdfAbout(String rdfAbout) {
		this.rdfAbout = rdfAbout;
	}

	@JsonProperty("dcterms:identifier")
	public List<DctermsIdentifier> getDctermsIdentifier() {
		return dctermsIdentifier;
	}

	@JsonProperty("dcterms:identifier")
	public void setDctermsIdentifier(List<DctermsIdentifier> dctermsIdentifier) {
		this.dctermsIdentifier = dctermsIdentifier;
	}

	@JsonProperty("dcterms:audience")
	public String getDctermsAudience() {
		return dctermsAudience;
	}

	@JsonProperty("dcterms:audience")
	public void setDctermsAudience(String dctermsAudience) {
		this.dctermsAudience = dctermsAudience;
	}

	@JsonProperty("dcndl:publicationPlace")
	public DcndlPublicationPlace getDcndlPublicationPlace() {
		return dcndlPublicationPlace;
	}

	@JsonProperty("dcndl:publicationPlace")
	public void setDcndlPublicationPlace(DcndlPublicationPlace dcndlPublicationPlace) {
		this.dcndlPublicationPlace = dcndlPublicationPlace;
	}

	@JsonProperty("dcndl:alternative")
	public List<DcndlAlternative> getDcndlAlternative() {
		return dcndlAlternative;
	}

	@JsonProperty("dcndl:alternative")
	public void setDcndlAlternative(List<DcndlAlternative> dcndlAlternative) {
		this.dcndlAlternative = dcndlAlternative;
	}

	@JsonProperty("dcndl:materialType")
	public List<DcndlMaterialType> getDcndlMaterialType() {
		return dcndlMaterialType;
	}

	@JsonProperty("dcndl:materialType")
	public void setDcndlMaterialType(List<DcndlMaterialType> dcndlMaterialType) {
		this.dcndlMaterialType = dcndlMaterialType;
	}

	@JsonProperty("rdfs:seeAlso")
	public List<RdfsSeeAlso> getRdfsSeeAlso() {
		return rdfsSeeAlso;
	}

	@JsonProperty("rdfs:seeAlso")
	public void setRdfsSeeAlso(List<RdfsSeeAlso> rdfsSeeAlso) {
		this.rdfsSeeAlso = rdfsSeeAlso;
	}

	@JsonProperty("dcndl:price")
	public String getDcndlPrice() {
		return dcndlPrice;
	}

	@JsonProperty("dcndl:price")
	public void setDcndlPrice(String dcndlPrice) {
		this.dcndlPrice = dcndlPrice;
	}

	@JsonProperty("dc:title")
	public List<DcTitle> getDcTitle() {
		return dcTitle;
	}

	@JsonProperty("dc:title")
	public void setDcTitle(List<DcTitle> dcTitle) {
		this.dcTitle = dcTitle;
	}

	@JsonProperty("dcterms:publisher")
	public List<DctermsPublisher> getDctermsPublisher() {
		return dctermsPublisher;
	}

	@JsonProperty("dcterms:publisher")
	public void setDctermsPublisher(List<DctermsPublisher> dctermsPublisher) {
		this.dctermsPublisher = dctermsPublisher;
	}

	@JsonProperty("dcterms:description")
	public List<String> getDctermsDescription() {
		return dctermsDescription;
	}

	@JsonProperty("dcterms:description")
	public void setDctermsDescription(List<String> dctermsDescription) {
		this.dctermsDescription = dctermsDescription;
	}

	@JsonProperty("dcterms:language")
	public List<DctermsLanguage> getDctermsLanguage() {
		return dctermsLanguage;
	}

	@JsonProperty("dcterms:language")
	public void setDctermsLanguage(List<DctermsLanguage> dctermsLanguage) {
		this.dctermsLanguage = dctermsLanguage;
	}

	@JsonProperty("dcterms:issued")
	public List<DctermsIssued> getDctermsIssued() {
		return dctermsIssued;
	}

	@JsonProperty("dcterms:issued")
	public void setDctermsIssued(List<DctermsIssued> dctermsIssued) {
		this.dctermsIssued = dctermsIssued;
	}

	@JsonProperty("dcndl:seriesTitle")
	public List<DcndlSeriesTitle> getDcndlSeriesTitle() {
		return dcndlSeriesTitle;
	}

	@JsonProperty("dcndl:seriesTitle")
	public void setDcndlSeriesTitle(List<DcndlSeriesTitle> dcndlSeriesTitle) {
		this.dcndlSeriesTitle = dcndlSeriesTitle;
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
