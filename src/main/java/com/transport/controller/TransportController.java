package com.transport.controller;

import com.transport.model.Transport;
import com.transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransportService transportService;

    @GetMapping
    public List<Transport> getAllTransports() {
        return transportService.getAllTransports();
    }

    @GetMapping("/{id}")
    public Transport getTransportById(@PathVariable Long id) {
        return transportService.getTransportById(id);
    }

    @PostMapping
    public Transport createTransport(@RequestBody Transport transport) {
        return transportService.saveTransport(transport);
    }

    @PutMapping("/{id}")
    public Transport updateTransport(@PathVariable Long id, @RequestBody Transport transportDetails) {
        Transport transport = transportService.getTransportById(id);
        if (transport != null) {
            transport.setVehicleType(transportDetails.getVehicleType());
            transport.setCapacity(transportDetails.getCapacity());
            return transportService.saveTransport(transport);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTransport(@PathVariable Long id) {
        transportService.deleteTransport(id);
    }
}
