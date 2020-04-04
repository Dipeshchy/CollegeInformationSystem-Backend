package com.ncit.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.college.domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

//	To get universities by status 0 = unapproved, 1 = approved, 2 = rejected
	@Query("SELECT u from University u WHERE u.status =:status")
	public List<University> getUniversityByStatus(@Param("status") int status);

//	Update university status
	@Transactional
	@Modifying
	@Query("UPDATE University u SET u.status=:status WHERE u.id=:id")
	public void updateUniStatus(@Param("status") int status, @Param("id") int id);

//	Get active count uni
	@Query("SELECT COUNT(u.id) FROM University u WHERE u.status=1")
	public Long countUniActive();

//	Update university
	@Transactional
	@Modifying
	@Query("UPDATE University a SET a.name= :name, a.location = :location, a.estDate = :estDate , a.phone = :phone, a.email = :email, a.website = :website, a.description = :description, a.status = :status WHERE a.id = :id")
	public void updateUni(@Param("name") String name, @Param("location") String location,
			@Param("estDate") String estDate, @Param("phone") String phone, @Param("email") String email,
			@Param("website") String website, @Param("description") String description,@Param("status") int status, @Param("id") int id);
}
