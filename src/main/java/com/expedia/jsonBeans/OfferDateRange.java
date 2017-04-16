
package com.expedia.beans.jsonBeans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "travelStartDate", "travelEndDate", "lengthOfStay" })
public class OfferDateRange {

	private String dateTravelStarts = null;
	private String dateTravelEnds = null;

	@JsonProperty("travelStartDate")
	private List<Long> travelStartDate = null;

	@JsonProperty("travelEndDate")
	private List<Long> travelEndDate = null;
	@JsonProperty("lengthOfStay")
	private Long lengthOfStay;

	@JsonProperty("travelStartDate")
	public List<Long> getTravelStartDate() {
		return travelStartDate;
	}

	@JsonProperty("travelStartDate")
	public void setTravelStartDate(List<Long> travelStartDate) {

		if (travelStartDate != null && !travelStartDate.isEmpty()) {
			dateTravelStarts = travelStartDate.toString().replace(", ", "-").replace("[", "").replace("]", "");
		}
		this.travelStartDate = travelStartDate;
	}

	@JsonProperty("travelEndDate")
	public List<Long> getTravelEndDate() {
		return travelEndDate;
	}

	@JsonProperty("travelEndDate")
	public void setTravelEndDate(List<Long> travelEndDate) {

		if (travelEndDate != null && !travelEndDate.isEmpty()) {
			dateTravelEnds = travelEndDate.toString().replace(", ", "-").replace("[", "").replace("]", "");
		}
		this.travelEndDate = travelEndDate;
	}

	@JsonProperty("lengthOfStay")
	public Long getLengthOfStay() {
		return lengthOfStay;
	}

	@JsonProperty("lengthOfStay")
	public void setLengthOfStay(Long lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public String getDateTravelEnds() {
		return dateTravelEnds;
	}

	public void setDateTravelEnds(String travelEnd) {
		this.dateTravelEnds = travelEnd;
	}

	public String getDateTravelStarts() {
		return dateTravelStarts;
	}

	public void setDateTravelStarts(String dateOfTravelStart) {
		this.dateTravelStarts = dateOfTravelStart;
	}

}
