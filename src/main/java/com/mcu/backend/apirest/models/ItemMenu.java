package com.mcu.backend.apirest.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_menues")
public class ItemMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_menu", referencedColumnName = "id", insertable = false, updatable = false)
	private Menu menu;
	
	private int padre;
	
	private int hijo;

	
	public ItemMenu() {}
	
	
	public ItemMenu(int padre, int hijo) {
		super();
		this.padre = padre;
		this.hijo = hijo;
	}


	public ItemMenu(Menu menu, int padre, int hijo) {
		super();
		this.menu = menu;
		this.padre = padre;
		this.hijo = hijo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getPadre() {
		return padre;
	}

	public void setPadre(int padre) {
		this.padre = padre;
	}

	public int getHijo() {
		return hijo;
	}

	public void setHijo(int hijo) {
		this.hijo = hijo;
	}
	
	
	
	
}
