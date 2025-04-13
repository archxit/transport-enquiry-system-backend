package com.transport.service;

import com.transport.model.Transport;
import com.transport.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TransportService {
    @Autowired
    private TransportRepository transportRepository;

    @Transactional
    public List<Transport> getAllTransports() {
        return transportRepository.findAll();
    }

    @Transactional
    public Transport getTransportById(Long id) {
        return transportRepository.findById(id).orElse(null);
    }

    @Transactional
    public Transport saveTransport(Transport transport) {
        return transportRepository.save(transport);
    }

    @Transactional
    public void deleteTransport(Long id) {
        transportRepository.deleteById(id);
    }
}
