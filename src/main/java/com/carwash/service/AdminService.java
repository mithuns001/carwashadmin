package com.carwash.service;

import com.carwash.DTO.AdminDTO;
import com.carwash.Entity.Admin;

public interface AdminService {
    Admin createAdmin(AdminDTO adminDTO);
    Admin getAdminByUsername(String username);
    Admin getAdminById(Long id);
    Admin updateAdmin(Admin admin);
    void deleteAdmin(Long id);
}
