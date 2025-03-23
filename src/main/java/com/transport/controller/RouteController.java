package com.transport.controller;

import com.transport.model.Route;
import com.transport.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
