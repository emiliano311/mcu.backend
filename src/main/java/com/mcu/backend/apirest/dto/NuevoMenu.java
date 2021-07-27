package com.mcu.backend.apirest.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class NuevoMenu {
	@NotBlank
	private String nombre;
	
	private String accion;
	
	@NotBlank
	private String tipo_menu;
	
	private String idpadre;
	
	private String idhijo;
	
	private String idrol;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getTipo_menu() {
		return tipo_menu;
	}

	public void setTipo_menu(String tipo_menu) {
		this.tipo_menu = tipo_menu;
	}

	public String getIdpadre() {
		return idpadre;
	}

	public void setIdpadre(String idpadre) {
		this.idpadre = idpadre;
	}

	public String getIdhijo() {
		return idhijo;
	}

	public void setIdhijo(String idhijo) {
		this.idhijo = idhijo;
	}

	public String getIdrol() {
		return idrol;
	}

	public void setIdrol(String idrol) {
		this.idrol = idrol;
	}
	
}
