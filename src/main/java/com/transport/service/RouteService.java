package com.transport.service;

import com.transport.model.Route;
import com.transport.model.RouteDetails;
import com.transport.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Transactional
    public Route getRouteById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    @Transactional
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    @Transactional
    public RouteDetails getRouteDetailsWithCoordinates(Long routeId) {
        Route route = routeRepository.findById(routeId).orElse(null);
        if (route == null) {
            return null;
        }

        // Create a RouteDetails object with route info and coordinates
        RouteDetails details = new RouteDetails();
        details.setRoute(route);

        // In a real app, you would fetch actual coordinates from your database
        // This is just an example
        List<List<Double>> coordinates = new ArrayList<>();

        // Example: Generate dummy coordinates for demo
        // In production, these would come from your database
        coordinates.add(Arrays.asList(20.5937, 78.9629)); // Start point
        coordinates.add(Arrays.asList(20.7, 79.0)); // Waypoint
        coordinates.add(Arrays.asList(20.9, 79.2)); // Waypoint
        coordinates.add(Arrays.asList(21.1458, 79.0882)); // End point

        details.setCoordinates(coordinates);
        return details;
    }

    public Double calculateDistance(String source, String destination) {
        // In a real application, you would use a geocoding service to get coordinates
        // For this example, you could use hardcoded coordinates or a geocoding API

        // Example implementation using a REST client to call a Python microservice
        // that performs the calculation using geopy
        return restTemplate.getForObject(
                "/calculate-distance?source={source}&destination={destination}",
                Double.class,
                source,
                destination);
    }

}