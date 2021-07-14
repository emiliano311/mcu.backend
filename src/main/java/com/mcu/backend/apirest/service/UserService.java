package com.mcu.backend.apirest.service;

import java.util.ArrayList;
import java.util.List;

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
public class UserService implements UserDetailsService {
	
	
	@Autowired
	private IUsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usr =repository.findByNombre(username);
		
		List<GrantedAuthority> roles = new ArrayList(); // lista de roles creadas
		
		roles.add(new SimpleGrantedAuthority("ADMIN")); //creo el rol con el nombre admin
		
		UserDetails  userDetails = new User(usr.getNombre(), usr.getClave(), roles);
		return userDetails;
	}
	
	

}
