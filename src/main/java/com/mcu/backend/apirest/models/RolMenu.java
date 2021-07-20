package com.mcu.backend.apirest.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.core.sym.Name;


@Entity
@Table(name = "rol_menues")
public class RolMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_rol", referencedColumnName = "id", insertable = false, updatable = false)
	private Rol rol;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_menu", referencedColumnName = "id", insertable = false, updatable = false)
	private Menu menu;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	
	
	
	
}
