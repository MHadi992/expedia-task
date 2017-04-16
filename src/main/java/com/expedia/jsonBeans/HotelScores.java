
package com.expedia.beans.jsonBeans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rawAppealScore",
    "movingAverageScore"
})
public class HotelScores {

    @JsonProperty("rawAppealScore")
    private Double rawAppealScore;
    @JsonProperty("movingAverageScore")
    private Double movingAverageScore;

    @JsonProperty("rawAppealScore")
    public Double getRawAppealScore() {
        return rawAppealScore;
    }

    @JsonProperty("rawAppealScore")
    public void setRawAppealScore(Double rawAppealScore) {
        this.rawAppealScore = rawAppealScore;
    }

    @JsonProperty("movingAverageScore")
    public Double getMovingAverageScore() {
        return movingAverageScore;
    }

    @JsonProperty("movingAverageScore")
    public void setMovingAverageScore(Double movingAverageScore) {
        this.movingAverageScore = movingAverageScore;
    }

}
