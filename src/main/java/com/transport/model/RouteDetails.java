package com.transport.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Model class that combines route information with geographical coordinates
 * for map display in the transport inquiry system.
 */
public class RouteDetails {
    private Route route;
    private List<List<Double>> coordinates;
    private String status;
    private Double distance;
    private String estimatedTime;
    private List<String> waypoints;
    
    // Default constructor
    public RouteDetails() {
        this.coordinates = new ArrayList<>();
        this.waypoints = new ArrayList<>();
    }
    
    // Constructor with route
    public RouteDetails(Route route) {
        this.route = route;
        this.coordinates = new ArrayList<>();
        this.waypoints = new ArrayList<>();
        this.status = "active";
    }
    
    // Getters and setters
    public Route getRoute() {
        return route;
    }
    
    public void setRoute(Route route) {
        this.route = route;
    }
    
    public List<List<Double>> getCoordinates() {
        return coordinates;
    }
    
    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Double getDistance() {
        return distance;
    }
    
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    
    public String getEstimatedTime() {
        return estimatedTime;
    }
    
    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    
    public List<String> getWaypoints() {
        return waypoints;
    }
    
    public void setWaypoints(List<String> waypoints) {
        this.waypoints = waypoints;
    }
    
    // Helper method to add a single coordinate point
    public void addCoordinate(Double latitude, Double longitude) {
        List<Double> point = new ArrayList<>();
        point.add(latitude);
        point.add(longitude);
        this.coordinates.add(point);
    }
    
    // Helper method to add a waypoint
    public void addWaypoint(String waypoint) {
        this.waypoints.add(waypoint);
    }
}
