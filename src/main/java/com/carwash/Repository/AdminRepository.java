package com.carwash.Repository;


import com.carwash.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    // You can define custom queries here if needed
    
    // Example: Find admin by username
    Admin findByUsername(String username);
}
