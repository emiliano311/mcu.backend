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
	
	private int id_rol;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_menu", referencedColumnName = "id", insertable = false, updatable = false)
	private int id_menu;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	
	
	
	
}
