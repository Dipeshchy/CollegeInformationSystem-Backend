package com.ncit.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncit.college.utilities.PasswordUtil;
import com.ncit.college.domain.Admin;
import com.ncit.college.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;

	private PasswordUtil passwordUtil;

//	To Save or Create Admin
	public void save(Admin admin) {
		adminRepo.save(admin);
	}

//	To List all admin
	public List<Admin> listAll() {
		return adminRepo.findAll();
	}

//	List all admin except logged in
	public List<Admin> listAllOther(String email) {
		return adminRepo.listAllOthers(email);
	}

// To return count of all admin
	public Long count() {
		return adminRepo.count();
	}

//	To get single
	public Optional<Admin> getAdmin(int id) {
		return adminRepo.findById(id);
	}

//	To delete admin
	public void deleteAdmin(int id) {
		adminRepo.deleteById(id);
	}

//	Login
	public Admin adminLogin(Admin admin) {
		passwordUtil = new PasswordUtil();
		String email = admin.getEmail();
//		String password = passwordUtil.getSecurePassword(admin.getPassword());
		String password  = admin.getPassword();
		return adminRepo.adminLogin(email, password);
	}
}
