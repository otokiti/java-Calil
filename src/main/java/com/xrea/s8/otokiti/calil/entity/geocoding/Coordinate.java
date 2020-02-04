package com.xrea.s8.otokiti.calil.entity.geocoding;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"lng",
		"lat_dms",
		"lat",
		"lng_dms"
})
public final class Coordinate {

	@JsonProperty("lng")
	private Float lng;
	@JsonProperty("lat_dms")
	private String latDms;
	@JsonProperty("lat")
	private Float lat;
	@JsonProperty("lng_dms")
	private String lngDms;

	@JsonProperty("lng")
	public Float getLng() {
		return lng;
	}

	@JsonProperty("lng")
	public void setLng(Float lng) {
		this.lng = lng;
	}

	@JsonProperty("lat_dms")
	public String getLatDms() {
		return latDms;
	}

	@JsonProperty("lat_dms")
	public void setLatDms(String latDms) {
		this.latDms = latDms;
	}

	@JsonProperty("lat")
	public Float getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(Float lat) {
		this.lat = lat;
	}

	@JsonProperty("lng_dms")
	public String getLngDms() {
		return lngDms;
	}

	@JsonProperty("lng_dms")
	public void setLngDms(String lngDms) {
		this.lngDms = lngDms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((latDms == null) ? 0 : latDms.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		result = prime * result + ((lngDms == null) ? 0 : lngDms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (latDms == null) {
			if (other.latDms != null)
				return false;
		} else if (!latDms.equals(other.latDms))
			return false;
		if (lng == null) {
			if (other.lng != null)
				return false;
		} else if (!lng.equals(other.lng))
			return false;
		if (lngDms == null) {
			if (other.lngDms != null)
				return false;
		} else if (!lngDms.equals(other.lngDms))
			return false;
		return true;
	}
}
