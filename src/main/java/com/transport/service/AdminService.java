package com.transport.service;

import com.transport.model.Admin;
import com.transport.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Transactional
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Transactional
    public Admin findByUsernameAndPassword(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    @Transactional
    public Admin saveAdmin(Admin admin) {
        Admin savedAdmin = adminRepository.save(admin);
        return savedAdmin;
    }

    @Transactional
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
