package ftn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class BaseModel {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	@Column(nullable = false)
	private boolean active = true;

	@PrePersist
	protected void onCreate() {
		regDate = new Date();
	}

	private Date getCreated() {
		return regDate;
	} 
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}
	
}
