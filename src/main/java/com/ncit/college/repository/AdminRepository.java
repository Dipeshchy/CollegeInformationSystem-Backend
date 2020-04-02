package com.ncit.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncit.college.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	//	for admin login. it takes admin from input and compare it with the password
	@Query("SELECT a FROM Admin a WHERE a.email= :email AND password = :password")
	Admin adminLogin(@Param("email") String email, @Param("password") String password);
	
//	List all admin except logged in
	@Query("SELECT a FROM Admin a WHERE a.email!= :email")
	List<Admin> listAllOthers(@Param("email") String email);
}
