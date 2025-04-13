package com.transport.controller;

import com.transport.model.Route;
import com.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id);
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return routeService.saveRoute(route);
    }

    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable Long id, @RequestBody Route routeDetails) {
        Route route = routeService.getRouteById(id);
        if (route != null) {
            route.setSource(routeDetails.getSource());
            route.setDestination(routeDetails.getDestination());
            return routeService.saveRoute(route);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
    }

    @GetMapping("/routes/{id}/details")
    public ResponseEntity<?> getRouteDetails(@PathVariable Long id) {
        // Return route details with coordinates
        Map<String, Object> details = new HashMap<>();
        Route route = routeService.getRouteById(id);
        
        if (route != null) {
            details.put("route", route);
            details.put("coordinates", getRouteCoordinates(route));
            return ResponseEntity.ok(details);
        }
        
        return ResponseEntity.notFound().build();
    }

    private List<List<Double>> getRouteCoordinates(Route route) {
        // In a real app, fetch actual coordinates from database
        // This is just demo data
        List<List<Double>> coordinates = new ArrayList<>();
        coordinates.add(Arrays.asList(20.5937, 78.9629));
        coordinates.add(Arrays.asList(21.1458, 79.0882));
        return coordinates;
    }


}
