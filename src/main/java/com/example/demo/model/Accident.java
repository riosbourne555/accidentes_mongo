package com.example.demo.model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "accidentes")
public class Accident {

	@Id
    private String id;
    @Field("Start_Time")
    private String startTime;
    @Field("End_Time")
    private String endTime;
    @Field("Description")
    private String description;
    @Field("City")
    private String city;
    @Field("State")
    private String state;
    @Field("Country")
    private String country;

    @Field("start_location")
    private Point startLocation;        
    @Field("end_location")
    private Point endLocation;

    @Field("Start_Lng")
    private Double start_lng;
    @Field("Start_Lat")
    private Double start_lat;

    @Field("End_Lng")
    private Double end_lng;
    @Field("End_Lat")
    private Double end_lat;

    @Field("distance(mi)")
    private Float distance;


    @Field("Severity")
    private String severity;

    public Accident() {
    }

    public Accident(@Value("description") String aDescription) {
        this.setDescription(aDescription);
    }

    public Accident(@Value("startTime") String aStartTime, @Value("endTime") String aEndTime,
            @Value("city") String aCity, @Value("state") String aState, @Value("country") String aCountry,
            @Value("description") String aDescription, @Value("severity") String aSeverity,
            @Value("start_coordinates") Double[] aStart_location, @Value("end_coordinates") Double[] aEnd_location) {
        this.setStartTime(aStartTime);
        this.setEndTime(aEndTime);
        this.setCity(aCity);
        this.setState(aState);
        this.setCountry(aCountry);
        this.setDescription(aDescription);
        this.setSeverity(aSeverity);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
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

    public Point getStart_location() {
        return startLocation;
    }

    public void setStart_location(Point start_location) {
        this.startLocation = start_location;
    }

    public Point getEnd_location() {
        return endLocation;
    }

    public void setEnd_location(Point end_location) {
        this.endLocation = end_location;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }


    public Double[] getEnd_coordinates() {
        return new Double[]{this.end_lng, this.end_lat};
    }


    public Double[] getStart_coordinates() {
        return new Double[]{this.start_lng, this.start_lat};
    }

}
