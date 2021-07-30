package com.mcu.backend.apirest.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mcu.backend.apirest.dto.Mensaje;
import com.mcu.backend.apirest.dto.NuevoMenu;
import com.mcu.backend.apirest.dto.NuevoUsuario;
import com.mcu.backend.apirest.enums.RolNombre;
import com.mcu.backend.apirest.interfaces.IMenu;
import com.mcu.backend.apirest.models.ItemMenu;
import com.mcu.backend.apirest.models.Menu;
import com.mcu.backend.apirest.models.Rol;
import com.mcu.backend.apirest.models.RolMenu;
import com.mcu.backend.apirest.models.Usuario;
import com.mcu.backend.apirest.repository.IMenuRespository;
import com.mcu.backend.apirest.repository.IRolMenu;
import com.mcu.backend.apirest.repository.IRolRepository;
import com.mcu.backend.apirest.repository.IitemMenuRepository;

@RestController
@CrossOrigin
@RequestMapping("/v")
public class AdmMenuController {

	@Autowired
	private IRolMenu iRolMenu;
	
	@Autowired
	private IRolRepository iRolRepository;
	
	@Autowired
	private IMenuRespository imenuRespository;
	
	@Autowired
	private IitemMenuRepository iitemMenuRepository;
	private static final Logger logger = LoggerFactory.getLogger(AdmMenuController.class);
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET,params = "data" ,headers="Accept= application/json")
	private @ResponseBody List<?> getMenuList(@RequestParam(value = "data") String data){
		logger.error("rolnombre:"+data);
		if(data.isEmpty()) {
			return null;
		}
		List<?> listMenus = iRolMenu.obtenerMenu(data);
		if(listMenus.isEmpty()) {
			
			return null;
		}
		return listMenus;
	}
	
	@RequestMapping(value = "/opmenu", method = RequestMethod.GET,params = "idmenu" ,headers="Accept= application/json")
	private @ResponseBody List<?> getMenuOpList(@RequestParam(value = "idmenu") String idmenu){
		logger.error("idmenu:"+idmenu);
		if(idmenu.isEmpty()) {
			return null;
		}
		List<?> listMenus = iRolMenu.obtenerOpcionesMenu(Integer.parseInt(idmenu));
		if(listMenus.isEmpty()) {
			
			return null;
		}
		return listMenus;
	}
	
	@RequestMapping(value = "/getlist", method = RequestMethod.GET ,headers="Accept= application/json")
	private @ResponseBody List<?> getListMenu(){
		List<?> listMenus = iRolMenu.getListMenu();
		if(listMenus.isEmpty()) {
			
			return null;
		}
		return listMenus;
	}
	
	

}
