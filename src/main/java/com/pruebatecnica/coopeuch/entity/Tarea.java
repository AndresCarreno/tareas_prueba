package com.pruebatecnica.coopeuch.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TAREA")
public class Tarea {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Debe ingresar una descripción")
	@Column(name = "DESCRIP")
	private String descrip;
	
	@Column(name = "CREATION_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private LocalDateTime creationDate;
	
	@NotNull(message = "Debe indicar su vigencia")
	@Column(name = "AVAILABLE")
	private Boolean available;

	public Tarea () {}
	
	public Tarea(Long id, @NotNull(message = "Debe ingresar una descripción") String descrip,
			@NotNull(message = "Debe indicar fecha de creación") LocalDateTime creationDate,
			@NotNull(message = "Debe indicar su vigencia") Boolean available) {
		super();
		this.id = id;
		this.descrip = descrip;
		this.creationDate = creationDate;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
	
	
	
}
