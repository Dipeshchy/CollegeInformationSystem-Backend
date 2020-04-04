package com.ncit.college.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ncit.college.domain.Admin;
import com.ncit.college.domain.University;
import com.ncit.college.service.UniversityService;

@Controller
@CrossOrigin("*")
public class UniversityController {

	@Autowired
	private UniversityService uniService;

//	List all universities
	@GetMapping(value = "/api/university")
	public ResponseEntity<List<University>> listAllUni() {
		List<University> allUnis = uniService.listAll();
		return ResponseEntity.ok().body(allUnis);
	}

//	List university by status
	@GetMapping(value = "/api/university/list/status/{status}")
	public ResponseEntity<List<University>> getByStatus(@PathVariable int status) {
		List<University> allUniByStatus = uniService.listByStatus(status);
		return ResponseEntity.ok().body(allUniByStatus);
	}

//	Get single university
	@GetMapping(value = "/api/university/{id}")
	public ResponseEntity<University> getSingleUni(@PathVariable int id) {
		Optional<University> uni = uniService.findById(id);
		if (uni.isPresent()) {
			University uni1 = uni.get();
			return ResponseEntity.ok().body(uni1);
		}
		return ResponseEntity.status(404).body(null);
	}

//	Save university
	@PostMapping(value = "/api/university")
	public ResponseEntity<?> saveUni(@RequestBody University uni) {
		uniService.save(uni);
		return ResponseEntity.ok().body("success");
	}
	
//	update university
	@PutMapping(value =" /api/university/{id}")
	public ResponseEntity<?> updateUni(@RequestBody University uni, @PathVariable int id) {
		University uni1 = new University();
		uni1.setId(id);
		uni1.setDescription(uni.getDescription());
		uni1.setEmail(uni.getEmail());
		uni1.setEstDate(uni.getEstDate());
		uni1.setLocation(uni.getLocation());
		uni1.setName(uni1.getName());
		uni1.setPhone(uni.getPhone());
		uni1.setStatus(uni.getStatus());
		uni1.setWebsite(uni.getWebsite());
		uniService.updateUni(uni1);
		return ResponseEntity.ok().body("success");
	}

//	Delete University
	@DeleteMapping(value = "/api/university/{id}")
	public ResponseEntity<?> deleteUni(@PathVariable int id) {
		uniService.delete(id);
		return ResponseEntity.ok().body("success");
	}

}
