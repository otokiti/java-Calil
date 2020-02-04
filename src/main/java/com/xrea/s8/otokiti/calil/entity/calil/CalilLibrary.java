package com.xrea.s8.otokiti.calil.entity.calil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"category",
		"city",
		"short",
		"libkey",
		"distance",
		"pref",
		"faid",
		"geocode",
		"systemid",
		"address",
		"libid",
		"tel",
		"systemname",
		"isil",
		"post",
		"url_pc",
		"formal"
})
public final class CalilLibrary {

	@JsonProperty("category")
	private String category;
	@JsonProperty("city")
	private String city;
	@JsonProperty("short")
	private String _short;
	@JsonProperty("libkey")
	private String libkey;
	@JsonProperty("distance")
	private String distance;
	@JsonProperty("pref")
	private String pref;
	@JsonProperty("faid")
	private Object faid;
	@JsonProperty("geocode")
	private String geocode;
	@JsonProperty("systemid")
	private String systemid;
	@JsonProperty("address")
	private String address;
	@JsonProperty("libid")
	private String libid;
	@JsonProperty("tel")
	private String tel;
	@JsonProperty("systemname")
	private String systemname;
	@JsonProperty("isil")
	private String isil;
	@JsonProperty("post")
	private String post;
	@JsonProperty("url_pc")
	private String urlPc;
	@JsonProperty("formal")
	private String formal;

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("short")
	public String getShort() {
		return _short;
	}

	@JsonProperty("short")
	public void setShort(String _short) {
		this._short = _short;
	}

	@JsonProperty("libkey")
	public String getLibkey() {
		return libkey;
	}

	@JsonProperty("libkey")
	public void setLibkey(String libkey) {
		this.libkey = libkey;
	}

	@JsonProperty("distance")
	public String getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(String distance) {
		this.distance = distance;
	}

	@JsonProperty("pref")
	public String getPref() {
		return pref;
	}

	@JsonProperty("pref")
	public void setPref(String pref) {
		this.pref = pref;
	}

	@JsonProperty("faid")
	public Object getFaid() {
		return faid;
	}

	@JsonProperty("faid")
	public void setFaid(Object faid) {
		this.faid = faid;
	}

	@JsonProperty("geocode")
	public String getGeocode() {
		return geocode;
	}

	@JsonProperty("geocode")
	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}

	@JsonProperty("systemid")
	public String getSystemid() {
		return systemid;
	}

	@JsonProperty("systemid")
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("libid")
	public String getLibid() {
		return libid;
	}

	@JsonProperty("libid")
	public void setLibid(String libid) {
		this.libid = libid;
	}

	@JsonProperty("tel")
	public String getTel() {
		return tel;
	}

	@JsonProperty("tel")
	public void setTel(String tel) {
		this.tel = tel;
	}

	@JsonProperty("systemname")
	public String getSystemname() {
		return systemname;
	}

	@JsonProperty("systemname")
	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}

	@JsonProperty("isil")
	public String getIsil() {
		return isil;
	}

	@JsonProperty("isil")
	public void setIsil(String isil) {
		this.isil = isil;
	}

	@JsonProperty("post")
	public String getPost() {
		return post;
	}

	@JsonProperty("post")
	public void setPost(String post) {
		this.post = post;
	}

	@JsonProperty("url_pc")
	public String getUrlPc() {
		return urlPc;
	}

	@JsonProperty("url_pc")
	public void setUrlPc(String urlPc) {
		this.urlPc = urlPc;
	}

	@JsonProperty("formal")
	public String getFormal() {
		return formal;
	}

	@JsonProperty("formal")
	public void setFormal(String formal) {
		this.formal = formal;
	}
}