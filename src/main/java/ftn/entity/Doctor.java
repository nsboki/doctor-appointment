package ftn.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)	
public class Doctor extends User{

	private String description;
	
	public Doctor() {
		this.setRole(Role.ROLE_DOCTOR);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
