package rs.ac.uns.ftn.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class User {
	
	public enum Role {ADMIN, DOCTOR, PATIENT};
	
	@Id 
	@GeneratedValue
	private Long id;
	private Role role;	
	private String username;
	private String password;
	@JsonFormat(pattern = "MM/dd/yyy")
	private LocalDate regDate;
	
	
	
	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
