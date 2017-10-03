package ftn.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * User Entity
 * @author Boki
 *
 */

@Entity	
public class User {
	
//public enum Role {ADMIN, DOCTOR, PATIENT}; 	//temporary use
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@ManyToOne
	private Role role;				//TODO: changed before integration with angular code
	private String username;
	private String password;
//	@JsonFormat(pattern = "MM/dd/yyyy")
//	private LocalDate regDate;
//	@ManyToOne
//	private User doctorId;			//TODO: after integration angular code uncomment code
	
	
	
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
