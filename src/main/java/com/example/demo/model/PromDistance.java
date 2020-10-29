package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class PromDistance {
    @Field("distance")
    private Float distance;
    @Field("totalDistance")
    private Float totalDistance;
    @Field("avgDistance")
    private Float avgDistance;

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getAvgDistance() {
        return avgDistance;
    }

    public void setAvgDistance(Float avgDistance) {
        this.avgDistance = avgDistance;
    }

    public Float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Float totalDistance) {
        this.totalDistance = totalDistance;
    }
}
