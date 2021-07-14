package com.mcu.backend.apirest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.mcu.backend.apirest.models.Usuario;
import com.mcu.backend.apirest.repository.IUsuarioRepository;

@Service
@Transactional
public class UserService {
	
	
	@Autowired
	private IUsuarioRepository repository;
	
	
	public Optional<Usuario> getByNombre(String nombre){
		return repository.findByNombre(nombre);
	}
	
	public boolean existsByNombre(String nombre) {
		return repository.existsByNombre(nombre);
	}
	
	public void save(Usuario usuario) {
		repository.save(usuario);
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario usr =repository.findByNombre(username);
//		
//		List<GrantedAuthority> roles = new ArrayList(); // lista de roles creadas
//		
//		roles.add(new SimpleGrantedAuthority("ADMIN")); //creo el rol con el nombre admin
//		
//		UserDetails  userDetails = new User(usr.getNombre(), usr.getClave(), roles);
//		return userDetails;
//	}
	
	

}
