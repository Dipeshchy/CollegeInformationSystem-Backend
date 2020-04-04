package com.ncit.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ncit.college.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	// for admin login. it takes admin from input and compare it with the password
	@Query("SELECT a FROM Admin a WHERE a.email= :email AND password = :password")
	Admin adminLogin(@Param("email") String email, @Param("password") String password);

//	List all admin except logged in
	@Query("SELECT a FROM Admin a WHERE a.email!= :email")
	List<Admin> listAllOthers(@Param("email") String email);

//	Update admin
	@Transactional
	@Modifying
	@Query("UPDATE Admin a SET a.email= :email, a.fullName = :fullName, a.password = :password WHERE a.id = :id")
	public void updateAdmin(@Param("email") String email, @Param("fullName") String fullName,
			@Param("password") String password, @Param("id") int id);
}
