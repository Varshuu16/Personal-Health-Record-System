package com.example.app1.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.app1.dto.AdminDto;
import com.example.app1.entity.Admin;

public interface AdminService {
    String createAdmin(AdminDto adminDto);
    AdminDto getAdmin(Long id);
    String updateAdmin(Long id, AdminDto adminDto);
    String deleteAdmin(Long id);
    
    Page<Admin> pageData(int page);
	int updateQuery(Long id, String name);
	
	    int deleteQuery(String name);
	    List<Admin> selectAdminByName(String name);
	
	    List<Admin> getAdminsByNameStartingWith(String prefix);
	    List<Admin> getAdminsByNameEndingWith(String suffix);
	    
	    List<Admin> getAdminsByStartOrEnd(String prefix, String suffix);
	    
	    List<Admin> getAdminsByContaining(String keyword);
	    List<Admin> getAdminsByNotContaining(String keyword);
	    
	    List<Admin> getAdminsIsNotLike(String pattern);
	    List<Admin> getAdminsIsLike(String pattern);
	    
	    String sendUserEmail(String toAddress);

}
