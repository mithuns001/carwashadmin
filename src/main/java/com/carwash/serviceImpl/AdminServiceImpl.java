package com.carwash.serviceImpl;

import com.carwash.DTO.AdminDTO;
import com.carwash.Entity.Admin;
import com.carwash.Repository.AdminRepository;
import com.carwash.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin createAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin(adminDTO.getUsername(), adminDTO.getPassword());
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

	@Override
	public Admin getAdminById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdmin(Long id) {
		// TODO Auto-generated method stub
		
	}
}
