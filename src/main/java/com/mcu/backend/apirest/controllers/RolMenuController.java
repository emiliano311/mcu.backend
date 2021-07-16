package com.mcu.backend.apirest.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mcu.backend.apirest.models.rol_menu;
import com.mcu.backend.apirest.repository.IRolMenu;

@RestController
@RequestMapping("/v")
public class RolMenuController {

	@Autowired
	private IRolMenu iRolMenu;
	
	private static final Logger logger = LoggerFactory.getLogger(RolMenuController.class);
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET,params = "data" ,produces = "application/json")
	private @ResponseBody List<rol_menu> getMenuList(@RequestParam(value = "data") String data){
		logger.error("rolnombre:"+data);
		if(data.isEmpty()) {
			return null;
		}
		List<rol_menu> listMenus = iRolMenu.obtenerMenu(data);
		if(listMenus.isEmpty()) {
			
			return null;
		}
		return listMenus;
	}
}
