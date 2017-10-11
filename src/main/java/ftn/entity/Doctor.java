package ftn.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)	
public class Doctor extends User{

	public Doctor() {
		this.setRole(Role.ROLE_DOCTOR);
	}

	
}
