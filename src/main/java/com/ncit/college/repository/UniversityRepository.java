package com.ncit.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncit.college.domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
	
//	To get universities by status 0 = unapproved, 1 = approved, 2 = rejected
	@Query("SELECT u from University u WHERE u.status =:status")
	public List<University> getUniversityByStatus(@Param("status") int status);
	
//	Update university status
	@Query("UPDATE University u SET u.status=:status WHERE u.id=:id")
	public void updateUniStatus(@Param("status") int status, @Param("id") int id);
	
//	Get active count uni
	@Query("SELECT COUNT FROM University u WHERE u.status=1")
	public Long countUniActive();
}
