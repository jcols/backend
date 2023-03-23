package com.example.log.educacion;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "educacion")
public class educacion {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(nullable = false, length = 128)
	@NotNull @Length(min = 2, max = 128)
	private String escuela;
        private String logo;
	private String titulo;
	private Date periodo;
        
	public educacion() {
	}
	
	public educacion(String escuela, String logo, String titulo, Date periodo) {
		this.escuela = escuela;
		this.logo = logo;
                this.titulo = titulo;
		this.periodo = periodo;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }


}

