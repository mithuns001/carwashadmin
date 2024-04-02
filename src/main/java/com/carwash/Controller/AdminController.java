package com.carwash.Controller;

import com.carwash.DTO.AdminDTO;
import com.carwash.Entity.Admin;
import com.carwash.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody AdminDTO adminDTO) {
        Admin existingAdmin = adminService.getAdminByUsername(adminDTO.getUsername());
        if (existingAdmin != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin already exists");
        }
        adminService.createAdmin(adminDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Admin created successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO) {
        Admin existingAdmin = adminService.getAdminById(id);
        if (existingAdmin != null) {
            existingAdmin.setUsername(adminDTO.getUsername());
            existingAdmin.setPassword(adminDTO.getPassword());
            adminService.updateAdmin(existingAdmin);
            return ResponseEntity.ok("Admin updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        Admin existingAdmin = adminService.getAdminById(id);
        if (existingAdmin != null) {
            adminService.deleteAdmin(id);
            return ResponseEntity.ok("Admin deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
