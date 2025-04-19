package com.example.app1.controller;

import com.example.app1.dto.AdminDto;
import com.example.app1.entity.Admin;
import com.example.app1.service.AdminService;
import com.example.app1.utilPackage.Emailsmtp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public String createAdmin(@RequestBody AdminDto adminDto) {
        return adminService.createAdmin(adminDto);
    }

    @GetMapping("/get/{id}")
    public AdminDto getAdmin(@PathVariable Long id) {
        return adminService.getAdmin(id);
    }

    @PutMapping("/update/{id}")
    public String updateAdmin(@PathVariable Long id, @RequestBody AdminDto adminDto) {
        return adminService.updateAdmin(id, adminDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }
    @GetMapping("/page")
    public List<Admin> pageData(@RequestParam int page) {
        return adminService.pageData(page).getContent(); 
    }
    @GetMapping("/updateQuery")
    public int updateQuery(@RequestParam Long id, @RequestParam String name) {
        return adminService.updateQuery(id, name);
    }
    @DeleteMapping("/deleteQuery")
    public int deleteQuery(@RequestParam String name) {
        return adminService.deleteQuery(name);
    }
    @GetMapping("/selectAdmin")
    public List<Admin> selectAdminByName(@RequestParam String name) {
        return adminService.selectAdminByName(name);
    }
    
    @GetMapping("/startsWith")
    public List<Admin> getAdminsByNameStartingWith(@RequestParam String prefix) {
        return adminService.getAdminsByNameStartingWith(prefix);
    }
    
    @GetMapping("/endsWith")
    public List<Admin> getAdminsByNameEndingWith(@RequestParam String suffix) {
        return adminService.getAdminsByNameEndingWith(suffix);
    }
    
    @GetMapping("/startOrEnd")
    public List<Admin> getAdminsByStartOrEnd(@RequestParam String prefix, @RequestParam String suffix) {
        return adminService.getAdminsByStartOrEnd(prefix, suffix);
    }
    
    @GetMapping("/containing")
    public List<Admin> getAdminsByContaining(@RequestParam String keyword) {
        return adminService.getAdminsByContaining(keyword);
    }

    @GetMapping("/notContaining")
    public List<Admin> getAdminsByNotContaining(@RequestParam String keyword) {
        return adminService.getAdminsByNotContaining(keyword);
    }
    
    @GetMapping("/name/isNotLike")
    public List<Admin> getAdminsIsNotLike(@RequestParam("pattern") String pattern) {
        return adminService.getAdminsIsNotLike(pattern);
    }

    @GetMapping("/name/isLike")
    public List<Admin> getAdminsIsLike(@RequestParam("pattern") String pattern) {
        return adminService.getAdminsIsLike(pattern);
    }
    @Autowired
    private Emailsmtp emailsmtp;
    
    @PostMapping("/Email")
    public String sendEmail(@RequestParam("toAddress") String toAddress) {
    	return adminService.sendUserEmail(toAddress);
}
    
}
