package com.example.demo.dto;

import com.example.demo.model.Accident;

public class AccidentDTO {

	public String id;
    public String startTime;
    public String endTime;
    public String city;
    public String state;
    public String country;
    public String description;
    public String severity;
    public Double[] estart_coordinates;
    public Double[] end_coordinates;

    public AccidentDTO(Accident anAccident) {
        this.setId(anAccident.getId());
        this.setStartTime(anAccident.getStartTime());
        this.setEndTime(anAccident.getEndTime());
        this.setCity(anAccident.getCity());
        this.setState(anAccident.getState());
        this.setCountry(anAccident.getCountry());
        this.setEnd_coordinates(anAccident.getEnd_coordinates());
        this.setEstart_coordinates(anAccident.getStart_coordinates());
        this.setDescription(anAccident.getDescription());
        this.setSeverity(anAccident.getSeverity());
    }

    public AccidentDTO(String id, String startTime, String endTime, String city, String state, String country,
            String severity, String description, Double[] startLocatio, Double[] endLocation) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.city = city;
        this.state = state;
        this.country = country;
        this.description = description;
        this.severity = severity;
        this.estart_coordinates = startLocatio;
        this.end_coordinates = endLocation;
    }

    public static AccidentDTO factory(String id, String startTime, String endTime, String city, String state,
            String country, String severity, String description, Double[] startLocatio, Double[] endLocation) {
        return new AccidentDTO(id, startTime, endTime, city, state, country, severity, description, startLocatio,
                endLocation);
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setEnd_coordinates(Double[] end_coordinates) {
        this.end_coordinates = end_coordinates;
    }
    public Double[] getEnd_coordinates() {
        return end_coordinates;
    }

    public void setEstart_coordinates(Double[] estart_coordinates) {
        this.estart_coordinates = estart_coordinates;
    }

    public Double[] getEstart_coordinates() {
        return estart_coordinates;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

}
