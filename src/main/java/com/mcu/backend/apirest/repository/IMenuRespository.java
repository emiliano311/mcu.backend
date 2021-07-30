package com.mcu.backend.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcu.backend.apirest.models.Menu;

public interface IMenuRespository extends JpaRepository<Menu, Integer> {

	List<Menu> findByTipoMenu(String tipomenu);
	Optional<Menu> findById(int id);
}
