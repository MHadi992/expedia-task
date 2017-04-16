package com.expedia.core;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.WebTarget;

/**
 *
 * This class cashes parameters for the JSON API also queries the
 * parameters into a WebTarget object.
 *
 * @since Apr 16, 2017
 */
public class ParamQueryBuilder {

	private static final String DATE_FORMAT_YYYY_MM_DD = "%1$tY-%1$tm-%1$td";
	
	private Map<String, String[]> parameters;
	private String query;

	public ParamQueryBuilder() {
		
		parameters = new LinkedHashMap<>();
		query = parameters.toString();
	}

	/**
	 * delegated method for integer values
	 * 
	 * @see #registerParameter(String, String)
	 * @param paramName
	 * @param intParam
	 */
	public void registerParameter(String paramName, Integer intParam) {
		
		if (intParam != null) {
			registerParameter(paramName, String.valueOf(intParam.intValue()));
		}
	}

	/**
	 * delegated method for Date values
	 * 
	 * @see #registerParameter(String, String)
	 * @param paramName
	 * @param dateParam
	 */
	public void registerParameter(String paramName, Date dateParam) {
		
		if (dateParam != null) {
			registerParameter(paramName, formatDate(dateParam));
		}
	}

	/**
	 * @return String representation of the inputed date formated based on the
	 *         selected format
	 * @param date
	 */
	private String formatDate(Date date) {
		return String.format(DATE_FORMAT_YYYY_MM_DD, date);
	}

	/**
	 * Adds parameter vs value per into the cached map, the values will be split
	 * by ',' after performing the needed validation. if the value is empty it
	 * will be removed from cache.
	 * 
	 * @param paramName
	 * @param paramValue
	 */
	public void registerParameter(String paramName, String paramValue) {

		if (paramValue == null) {
			return;
		}
		if (paramValue == null || paramValue.isEmpty()) {
			parameters.remove(paramName);
			return;
		}
		parameters.put(paramName, paramValue.split(","));
	}

	/**
	 * Default access to be accessed only from core package
	 * 
	 * @param target
	 * @return new instance of WebTarget target after querying all parameters.
	 */
	WebTarget buildTarget(WebTarget target) {

		for (Entry<String, String[]> parameter : parameters.entrySet()) {
			target = target.queryParam(parameter.getKey(), (Object[]) parameter.getValue());
		}
		return target;
	}

	/**
	 * @return true if and only if the query have been changed
	 */
	public boolean isQueryUpdated() {

		if (!query.equals(parameters.toString())) {
			query = parameters.toString();
			return true;
		}
		return false;
	}

	/**
	 * @return true if there is registered parameters
	 */
	public boolean hasQuery() {
		return !parameters.isEmpty();
	}
}
