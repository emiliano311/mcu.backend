package com.mcu.backend.apirest.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {

	@NotBlank
	private String nombre;
	@NotBlank
	private String clave;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
