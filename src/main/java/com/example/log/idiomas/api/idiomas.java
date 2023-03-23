package com.example.log.idiomas.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "idiomas")
public class idiomas {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(nullable = false, length = 128)
	@NotNull @Length(min = 2, max = 128)
	private String idioma;
	
	private Integer grado;

	public idiomas() {
	}
	
	public idiomas(String idioma, Integer grado) {
		this.idioma = idioma;
		this.grado = grado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public float getGrado() {
		return grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

}

