package com.mcu.backend.apirest.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import com.sun.istack.NotNull;

@Entity 
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(unique = true)
	private String nombre;
	@NotNull
	private String clave;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_rol",joinColumns = @JoinColumn(name="usuario_id"),inverseJoinColumns = @JoinColumn(name="rol_id "))
	private Set<Rol> roles = new HashSet<>();
	
	
	public Usuario() {
	}
	
	
	
	public Usuario( String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}
	


	public Usuario(int id, String nombre, String clave, Set<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.roles = roles;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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



	public Set<Rol> getRoles() {
		return roles;
	}



	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	
}
