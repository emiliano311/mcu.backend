package com.mcu.backend.apirest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mcu.backend.apirest.models.Usuario;
import com.mcu.backend.apirest.repository.IUsuarioRepository;


@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private IUsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(1);
		us.setNombre("admin");
		us.setClave(encoder.encode("123"));
		Usuario retorno= repository.save(us);
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
