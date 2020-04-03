package com.ncit.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncit.college.domain.University;
import com.ncit.college.repository.UniversityRepository;

@Service
public class UniversityService {

	@Autowired
	private UniversityRepository repo;
	
	public List<University> listAll() {
		return repo.findAll();
	}
	
	public Optional<University> findById(int id) {
		return repo.findById(id);
	}
	
	public void save(University uni) {
		repo.save(uni);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public Long countActiveUni() {
		return repo.countUniActive();
	}
	
	public List<University> listByStatus(int status) {
		return repo.getUniversityByStatus(status);
	}
	
	public void updateUniStatus(int status, int id) {
		repo.updateUniStatus(status, id);
	}
	
}
