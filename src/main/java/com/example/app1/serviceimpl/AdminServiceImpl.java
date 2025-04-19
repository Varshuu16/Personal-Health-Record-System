package com.example.app1.serviceimpl;

import com.example.app1.dto.AdminDto;
import com.example.app1.entity.Admin;
import com.example.app1.repository.AdminRepository;
import com.example.app1.service.AdminService;
import com.example.app1.utilPackage.Emailsmtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public String createAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setName(adminDto.getName());
        admin.setEmail(adminDto.getEmail());
        adminRepository.save(admin);
        return "Admin created successfully";
    }

    @Override
    public AdminDto getAdmin(Long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            AdminDto adminDto = new AdminDto();
            adminDto.setAdminID(admin.getAdminID());
            adminDto.setName(admin.getName());
            adminDto.setEmail(admin.getEmail());
            return adminDto;
        } else {
            throw new RuntimeException("Admin not found");
        }
    }

    @Override
    public String updateAdmin(Long id, AdminDto adminDto) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setName(adminDto.getName());
            admin.setEmail(adminDto.getEmail());
            adminRepository.save(admin);
            return "Admin updated successfully";
        } else {
            return "Admin not found";
        }
    }

    @Override
    public String deleteAdmin(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return "Admin deleted successfully";
        } else {
            return "Admin not found";
        }
    }
    @Override
    public Page<Admin> pageData(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return adminRepository.findAll(pageable);
    }
    @Override
	public int updateQuery(Long id, String name) {
		return adminRepository.updateQuery(id,name);
	}

    @Override
    public int deleteQuery(String name) {
        return adminRepository.deleteQuery(name);
    }

	@Override
	public List<Admin> selectAdminByName(String name) {
		return adminRepository.selectAdminByName(name);
	}
    
	@Override
    public List<Admin> getAdminsByNameStartingWith(String prefix) {
        return adminRepository.findByNameStartingWith(prefix);
    }
	@Override
    public List<Admin> getAdminsByNameEndingWith(String suffix) {
        return adminRepository.findByNameEndingWith(suffix);
    }
	 @Override
	    public List<Admin> getAdminsByStartOrEnd(String prefix, String suffix) {
	        return adminRepository.findByNameStartingWithOrNameEndingWith(prefix, suffix);
	    }
	 
	 @Override
	    public List<Admin> getAdminsByContaining(String keyword) {
	        return adminRepository.findByNameContaining(keyword);
	    }

	    @Override
	    public List<Admin> getAdminsByNotContaining(String keyword) {
	        return adminRepository.findByNameNotContaining(keyword);
	    }
	    
	    @Override
	    public List<Admin> getAdminsIsNotLike(String pattern) {
	        return adminRepository.findByNameIsNotLike(pattern);
	    }

	    @Override
	    public List<Admin> getAdminsIsLike(String pattern) {
	        return adminRepository.findByNameIsLike(pattern);
	    }
	    @Autowired
	    private Emailsmtp emailsmtp;
	    @Override
		public String sendUserEmail(String toAddress) {
	        emailsmtp.sendMail(toAddress);
	        return "Email Send Successfully" + toAddress;
	    }


}
