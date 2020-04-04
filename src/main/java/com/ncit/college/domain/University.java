package com.ncit.college.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author dipesh
 *
 */
@Entity(name = "University")
@Table(name = "university")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private int id;
	@Column(unique = true)
	private String name;
	private String location;
	private String estDate;
	private String phone;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String website;
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	private String description;
//	 0 = unapproved, 1 = accepted, 2 = rejected
	private int status;
	@Column(nullable = true)
	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
	private List<College> college;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEstDate() {
		return estDate;
	}
	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<College> getCollege() {
		return college;
	}
	public void setCollege(List<College> college) {
		this.college = college;
	}
	
	
	
	
}
