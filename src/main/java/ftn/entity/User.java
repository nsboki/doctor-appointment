package ftn.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * User Entity
 * @author Boki
 *
 */

@Entity
@Table(name = "[user]")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseModel{
	
public enum Role {
	ROLE_ADMIN, 
	ROLE_GUEST,
	ROLE_DOCTOR, 
	ROLE_PATIENT
	}; 	//temporary use
	
	@Enumerated(EnumType.STRING)
	private Role role;		

	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	public User() {	
		this.setRole(Role.ROLE_GUEST);
		this.setActive(true);
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
