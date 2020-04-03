package com.ncit.college.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncit.college.domain.Admin;
import com.ncit.college.domain.DashboardData;
import com.ncit.college.service.AdminService;
import com.ncit.college.service.UniversityService;

@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UniversityService uniService;
	
//	get details number in admin dashboard
	@GetMapping(value="/api/admin/dashboard")
	public ResponseEntity<?> getDetailsInDasgboard() {
		DashboardData dsb = new DashboardData();
		dsb.setAdminCount(adminService.count());
		dsb.setUniversityCount(uniService.countActiveUni());
		return ResponseEntity.status(200).body(dsb);
	}

//	List all admin
	@GetMapping(value = "/api/admin")
	public ResponseEntity<List<Admin>> listAllAdmin() {
		List<Admin> allAdmin = adminService.listAll();
//		return ResponseEntity.ok().body(allAdmin);	
		return ResponseEntity.status(200).body(allAdmin);
	}
	
	// Get all admin list otehrs except logged in
		@GetMapping(value = "/api/admin/other")
		public ResponseEntity<List<Admin>> getAllOtherAdmin(@RequestBody String email) {
			List<Admin> adminnlist = adminService.listAllOther(email);
			return ResponseEntity.ok().body(adminnlist);
		}

//	Create Admin or save
	@PostMapping(value = "/api/admin")
	public ResponseEntity<?> saveAdmin(@RequestBody Admin admin) {
		adminService.save(admin);
		return ResponseEntity.ok().body("success.");
	}

	// Delete admin
	@DeleteMapping(value = "/api/admin/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") int id) {
		adminService.deleteAdmin(id);
		return ResponseEntity.status(200).body("success");
	}

	// Get a single admin for edit
	@GetMapping(value = "/api/admin/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable("id") int id) {
		Optional<Admin> admin = adminService.getAdmin(id);
		if (admin.isPresent()) {
			Admin admin1 = admin.get();
			return ResponseEntity.ok().body(admin1);
		}
		return ResponseEntity.status(404).body("failure");
	}

//		Admin login
	@PostMapping(value = "/api/admin/login")
	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin) {
		Admin loggedInAdmin = adminService.adminLogin(admin);
		return ResponseEntity.ok().body(loggedInAdmin);
	}
}
