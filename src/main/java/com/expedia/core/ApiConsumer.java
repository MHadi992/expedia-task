package com.expedia.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.expedia.beans.jsonBeans.OffersBean;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Manages the connection and the retrieval and parsing of
 * data as object modules from the JSON API.
 *
 * @since Apr 16, 2017
 */
public class ApiConsumer {


	private static final String SERVICE_PROVIDER = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";

	private Client client;
	private WebTarget target;
	private ObjectMapper mapper;
	private OffersBean offers;

	private ParamQueryBuilder paramQueryBuilder;

	public ParamQueryBuilder getParamQueryBuilder() {
		return paramQueryBuilder;
	}

	public ApiConsumer() {
		
		paramQueryBuilder = new ParamQueryBuilder();
		client = ClientBuilder.newClient();
		mapper = new ObjectMapper();
		setTarget();
		updateOffers(target);
	}

	private void setTarget() {
		target = client.target(SERVICE_PROVIDER);
	}

	/**
	 * Retrieves the cached data that is retrieved from the API after updating
	 * it when required
	 * 
	 * @return OffersBean offers
	 */
	public OffersBean getOffers() {

		WebTarget currentTarget = null;
		if (paramQueryBuilder.hasQuery()) {
			currentTarget = paramQueryBuilder.buildTarget(target);
		} else {
			currentTarget = target;
		}
		if (paramQueryBuilder .isQueryUpdated()) {
			updateOffers(currentTarget);
		}
		return offers;
	}

	/**
	 * Updates the cached data from the API.
	 * 
	 * @param WebTarget
	 *            currentTarget
	 */
	private void updateOffers(WebTarget currentTarget) {

		try {
			offers = mapper.readValue(requestData(currentTarget), OffersBean.class);
		} catch (Exception e) {
			System.out.println("Failed to update existing offers, due to: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * requests the data from the API.
	 * 
	 * @param currentTarget
	 * @return WebTarget currentTarget
	 */
	private String requestData(WebTarget currentTarget) {
		return currentTarget.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
	}
}
