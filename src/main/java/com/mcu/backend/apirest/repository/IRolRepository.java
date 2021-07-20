package com.mcu.backend.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcu.backend.apirest.enums.RolNombre;
import com.mcu.backend.apirest.models.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
	
	Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
