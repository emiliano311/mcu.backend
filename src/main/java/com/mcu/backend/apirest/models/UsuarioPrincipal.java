package com.mcu.backend.apirest.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UsuarioPrincipal implements UserDetails{

	private String nombre;
	private String clave;
	private Collection <? extends GrantedAuthority> authorities;
	
	
	public UsuarioPrincipal(String nombre, String clave, Collection<? extends GrantedAuthority> authorities) {
		this.nombre = nombre;
		this.clave = clave;
		this.authorities = authorities;
	}
	
	public static UsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority> autorities= 
				usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(
						rol.getRolNombre().name())).collect(Collectors.toList());
		
		return new UsuarioPrincipal(usuario.getNombre(), usuario.getClave(), autorities);
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return clave;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombre;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
