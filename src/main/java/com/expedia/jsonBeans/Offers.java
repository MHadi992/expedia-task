
package com.expedia.beans.jsonBeans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Hotel"
})
public class Offers {

    @JsonProperty("Hotel")
    private List<Hotel> hotel = null;

    @JsonProperty("Hotel")
    public List<Hotel> getHotels() {
        return hotel;
    }

    @JsonProperty("Hotel")
    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

}
