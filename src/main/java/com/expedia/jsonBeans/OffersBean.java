
package com.expedia.beans.jsonBeans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offerInfo",
    "userInfo",
    "offers"
})

/**
 * Representation of the entity retrieved from the API.
 *
 * @since Apr 16, 2017
 */
public class OffersBean {

    @JsonProperty("offerInfo")
    private OfferInfo offerInfo;
    @JsonProperty("userInfo")
    private UserInfo userInfo;
    @JsonProperty("offers")
    private Offers offers;
    @JsonProperty("offerErrorInfo")
    private OfferErrorInfo offerErrorInfo;

    @JsonProperty("offerErrorInfo")
    public OfferErrorInfo getOfferErrorInfo() {
        return offerErrorInfo;
    }

    @JsonProperty("offerErrorInfo")
    public void setOfferErrorInfo(OfferErrorInfo offerErrorInfo) {
        this.offerErrorInfo = offerErrorInfo;
    }
    
    @JsonProperty("offerInfo")
    public OfferInfo getOfferInfo() {
        return offerInfo;
    }

    @JsonProperty("offerInfo")
    public void setOfferInfo(OfferInfo offerInfo) {
        this.offerInfo = offerInfo;
    }

    @JsonProperty("userInfo")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @JsonProperty("userInfo")
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @JsonProperty("offers")
    public Offers getOffers() {
        return offers;
    }

    @JsonProperty("offers")
    public void setOffers(Offers offers) {
        this.offers = offers;
    }

}
