package com.mcu.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcu.backend.apirest.models.Menu;

public interface IMenuRespository extends JpaRepository<Menu, Integer> {

}
