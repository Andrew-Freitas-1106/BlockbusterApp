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
@Table(name = "USER")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class MyBlockbusterAppUserDataModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_ref;
	
	@NotBlank
	private String customer_name;
	
	@NotBlank
	private Integer customer_age;
	
	@NotBlank
	private Date dateUpdated;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationDate;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModified;
	
	
}
