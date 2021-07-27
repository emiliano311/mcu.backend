package com.mcu.backend.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcu.backend.apirest.models.ItemMenu;

public interface IitemMenuRepository extends JpaRepository<ItemMenu, Integer> {

}
