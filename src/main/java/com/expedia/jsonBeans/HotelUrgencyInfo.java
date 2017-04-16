
package com.expedia.beans.jsonBeans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "airAttachRemainingTime",
    "numberOfPeopleViewing",
    "numberOfPeopleBooked",
    "numberOfRoomsLeft",
    "lastBookedTime",
    "almostSoldStatus",
    "link",
    "almostSoldOutRoomTypeInfoCollection",
    "airAttachEnabled"
})
public class HotelUrgencyInfo {

    @JsonProperty("airAttachRemainingTime")
    private Long airAttachRemainingTime;
    @JsonProperty("numberOfPeopleViewing")
    private Long numberOfPeopleViewing;
    @JsonProperty("numberOfPeopleBooked")
    private Long numberOfPeopleBooked;
    @JsonProperty("numberOfRoomsLeft")
    private Long numberOfRoomsLeft;
    @JsonProperty("lastBookedTime")
    private Long lastBookedTime;
    @JsonProperty("almostSoldStatus")
    private String almostSoldStatus;
    @JsonProperty("link")
    private String link;
    @JsonProperty("almostSoldOutRoomTypeInfoCollection")
    private List<Object> almostSoldOutRoomTypeInfoCollection = null;
    @JsonProperty("airAttachEnabled")
    private Boolean airAttachEnabled;

    @JsonProperty("airAttachRemainingTime")
    public Long getAirAttachRemainingTime() {
        return airAttachRemainingTime;
    }

    @JsonProperty("airAttachRemainingTime")
    public void setAirAttachRemainingTime(Long airAttachRemainingTime) {
        this.airAttachRemainingTime = airAttachRemainingTime;
    }

    @JsonProperty("numberOfPeopleViewing")
    public Long getNumberOfPeopleViewing() {
        return numberOfPeopleViewing;
    }

    @JsonProperty("numberOfPeopleViewing")
    public void setNumberOfPeopleViewing(Long numberOfPeopleViewing) {
        this.numberOfPeopleViewing = numberOfPeopleViewing;
    }

    @JsonProperty("numberOfPeopleBooked")
    public Long getNumberOfPeopleBooked() {
        return numberOfPeopleBooked;
    }

    @JsonProperty("numberOfPeopleBooked")
    public void setNumberOfPeopleBooked(Long numberOfPeopleBooked) {
        this.numberOfPeopleBooked = numberOfPeopleBooked;
    }

    @JsonProperty("numberOfRoomsLeft")
    public Long getNumberOfRoomsLeft() {
        return numberOfRoomsLeft;
    }

    @JsonProperty("numberOfRoomsLeft")
    public void setNumberOfRoomsLeft(Long numberOfRoomsLeft) {
        this.numberOfRoomsLeft = numberOfRoomsLeft;
    }

    @JsonProperty("lastBookedTime")
    public Long getLastBookedTime() {
        return lastBookedTime;
    }

    @JsonProperty("lastBookedTime")
    public void setLastBookedTime(Long lastBookedTime) {
        this.lastBookedTime = lastBookedTime;
    }

    @JsonProperty("almostSoldStatus")
    public String getAlmostSoldStatus() {
        return almostSoldStatus;
    }

    @JsonProperty("almostSoldStatus")
    public void setAlmostSoldStatus(String almostSoldStatus) {
        this.almostSoldStatus = almostSoldStatus;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("almostSoldOutRoomTypeInfoCollection")
    public List<Object> getAlmostSoldOutRoomTypeInfoCollection() {
        return almostSoldOutRoomTypeInfoCollection;
    }

    @JsonProperty("almostSoldOutRoomTypeInfoCollection")
    public void setAlmostSoldOutRoomTypeInfoCollection(List<Object> almostSoldOutRoomTypeInfoCollection) {
        this.almostSoldOutRoomTypeInfoCollection = almostSoldOutRoomTypeInfoCollection;
    }

    @JsonProperty("airAttachEnabled")
    public Boolean getAirAttachEnabled() {
        return airAttachEnabled;
    }

    @JsonProperty("airAttachEnabled")
    public void setAirAttachEnabled(Boolean airAttachEnabled) {
        this.airAttachEnabled = airAttachEnabled;
    }

}
