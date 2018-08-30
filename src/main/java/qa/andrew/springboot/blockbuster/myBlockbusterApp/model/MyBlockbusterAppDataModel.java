package qa.andrew.springboot.blockbuster.myBlockbusterApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DVD")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class MyBlockbusterAppDataModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank
	private String dvd_name;
	
	@NotBlank
	private Boolean avaliable;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationDate;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModified;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDvd_name() {
		return dvd_name;
	}

	public void setDvd_name(String dvd_name) {
		this.dvd_name = dvd_name;
	}

	public Boolean getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(Boolean avaliable) {
		this.avaliable = avaliable;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getLastModified() {
		return lastModified;
	}
	
	
}
