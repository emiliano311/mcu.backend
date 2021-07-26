package com.mcu.backend.apirest.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mcu.backend.apirest.interfaces.IMenu;
import com.mcu.backend.apirest.models.RolMenu;
import com.mcu.backend.apirest.repository.IRolMenu;

@RestController
@CrossOrigin
@RequestMapping("/v")
public class RolMenuController {

	@Autowired
	private IRolMenu iRolMenu;
	
	private static final Logger logger = LoggerFactory.getLogger(RolMenuController.class);
	
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
}
