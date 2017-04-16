package com.expedia.beans.managedBeans;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.expedia.beans.jsonBeans.Hotel;
import com.expedia.beans.jsonBeans.OfferErrorInfo;
import com.expedia.beans.jsonBeans.OfferInfo;
import com.expedia.beans.jsonBeans.OffersBean;
import com.expedia.core.ApiConsumer;

/**
 * This class is responsible for updating both the service query and the layout
 * content.
 */
@SessionScoped
@ManagedBean(name = "offersManager")
public class OffersManager {

	private static final String MIN_TOTAL_RATE_PARAM = "minTotalRate";
	private static final String MAX_TOTAL_RATE_PARAM = "maxTotalRate";
	private static final String MAX_GUEST_RATING_PARAM = "maxGuestRating";
	private static final String MIN_GUEST_RATING_PARAM = "minGuestRating";
	private static final String MAX_STAR_RATING_PARAM = "maxStarRating";
	private static final String MIN_STAR_RATING_PARAM = "minStarRating";
	private static final String LENGTH_OF_STAY_PARAM = "lengthOfStay";
	private static final String START_DATE_MAX_PARAM = "maxTripStartDate";
	private static final String START_DATE_MIN_PARAM = "minTripStartDate";
	private static final String DESTINATION_NAME_PARAM = "destinationName";

	private Date startDateMin;
	private Date startDateMax;

	private String destinationName;

	private String maxStarsRating;
	private String minGuestRating;
	private String maxGuestRating;
	private String minStarsRating;

	private Integer lengthOfStay;
	private Integer minTotalRate = 1;
	private Integer maxTotalRate = 100000;

	private List<Hotel> availableHotelOffers;

	private OfferInfo offerInfo;
	private OfferErrorInfo offerErrorInfo;

	private ApiConsumer apiConsumer;

	public OffersManager() {
		
		apiConsumer = new ApiConsumer();
		updateOffers();
	}

	/**
	 * 
	 * @return
	 */
	public String updateOffers() {

		registerParameters();
		OffersBean offers = apiConsumer.getOffers();
		setOfferInfo(offers.getOfferInfo());
		List<Hotel> hotels = offers.getOffers().getHotels();
		setAvailableHotelOffers(hotels);
		setOfferErrorInfo(offers.getOfferErrorInfo());
		return "offer";
	}

	/**
	 * 
	 */
	private void registerParameters() {

		apiConsumer.getParamQueryBuilder().registerParameter(DESTINATION_NAME_PARAM, getDestinationName());
		apiConsumer.getParamQueryBuilder().registerParameter(START_DATE_MIN_PARAM, getStartDateMin());
		apiConsumer.getParamQueryBuilder().registerParameter(START_DATE_MAX_PARAM, getStartDateMax());
		apiConsumer.getParamQueryBuilder().registerParameter(LENGTH_OF_STAY_PARAM, getLengthOfStay());
		apiConsumer.getParamQueryBuilder().registerParameter(MAX_STAR_RATING_PARAM, getMaxStarsRating());
		apiConsumer.getParamQueryBuilder().registerParameter(MIN_STAR_RATING_PARAM, getMinStarsRating());
		apiConsumer.getParamQueryBuilder().registerParameter(MAX_TOTAL_RATE_PARAM, (getMaxTotalRate() == 100000 ? null : getMaxTotalRate()));
		apiConsumer.getParamQueryBuilder().registerParameter(MIN_TOTAL_RATE_PARAM, (getMinTotalRate() == 1 ? null : getMinTotalRate()));
		apiConsumer.getParamQueryBuilder().registerParameter(MIN_GUEST_RATING_PARAM, getMinGuestRating());
		apiConsumer.getParamQueryBuilder().registerParameter(MAX_GUEST_RATING_PARAM, getMaxGuestRating());
	}

	/**
	 * @param offerInfo
	 */
	public void setOfferInfo(OfferInfo offerInfo) {

		this.offerInfo = offerInfo;
		if (getOfferErrorInfo() != null && getOfferErrorInfo().getErrorMessage().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(getOfferErrorInfo().getErrorMessage()));
		}
	}

	public Date getToday() {
		return new Date();
	}

	public void setAvailableHotelOffers(List<Hotel> availableHotelOffers) {
		this.availableHotelOffers = availableHotelOffers;
	}

	public List<Hotel> getAvailableHotelOffers() {
		return availableHotelOffers;
	}

	public OfferInfo getOfferInfo() {
		return offerInfo;
	}

	public Date getStartDateMin() {
		return startDateMin;
	}

	public void setStartDateMin(Date startDateMin) {
		this.startDateMin = startDateMin;
	}

	public Date getStartDateMax() {
		return startDateMax;
	}

	public void setStartDateMax(Date startDateMax) {
		this.startDateMax = startDateMax;
	}

	public Integer getLengthOfStay() {

		if (lengthOfStay != null && lengthOfStay == 0) {
			// return null to avoid setting the length of stay to a default
			// value (0).
			return null;
		}
		return lengthOfStay;
	}

	public void setLengthOfStay(Integer lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public Integer getMinTotalRate() {
		return minTotalRate;
	}

	public void setMinTotalRate(Integer minTotalRate) {
		this.minTotalRate = minTotalRate;
	}

	public Integer getMaxTotalRate() {
		return maxTotalRate;
	}

	public void setMaxTotalRate(Integer maxTotalRate) {
		this.maxTotalRate = maxTotalRate;
	}

	public String getMaxStarsRating() {
		return maxStarsRating;
	}

	public void setMaxStarsRating(String maxStarsRating) {
		this.maxStarsRating = maxStarsRating;
	}

	public String getMinGuestRating() {
		return minGuestRating;
	}

	public void setMinGuestRating(String minGuestRating) {
		this.minGuestRating = minGuestRating;
	}

	public String getMaxGuestRating() {
		return maxGuestRating;
	}

	public void setMaxGuestRating(String maxGuestRating) {
		this.maxGuestRating = maxGuestRating;
	}

	public String getMinStarsRating() {
		return minStarsRating;
	}

	public void setMinStarsRating(String minStarsRating) {
		this.minStarsRating = minStarsRating;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public OfferErrorInfo getOfferErrorInfo() {
		return offerErrorInfo;
	}

	public void setOfferErrorInfo(OfferErrorInfo offerErrorInfo) {
		this.offerErrorInfo = offerErrorInfo;
	}

}
