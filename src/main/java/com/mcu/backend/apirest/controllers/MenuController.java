package com.mcu.backend.apirest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcu.backend.apirest.dto.Mensaje;
import com.mcu.backend.apirest.dto.NuevoMenu;
import com.mcu.backend.apirest.models.ItemMenu;
import com.mcu.backend.apirest.models.Menu;
import com.mcu.backend.apirest.models.RolMenu;
import com.mcu.backend.apirest.repository.IMenuRespository;
import com.mcu.backend.apirest.repository.IRolMenu;
import com.mcu.backend.apirest.repository.IRolRepository;
import com.mcu.backend.apirest.repository.IitemMenuRepository;

@Controller
@CrossOrigin
public class MenuController {

	@Autowired
	private IRolMenu iRolMenu;
	
	@Autowired
	private IRolRepository iRolRepository;
	
	@Autowired
	private IMenuRespository imenuRespository;
	
	@Autowired
	private IitemMenuRepository iitemMenuRepository;
	
	@PostMapping("/nuevomenu")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoMenu nuevomenu, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity(new Mensaje("campos mal puestos"),HttpStatus.BAD_REQUEST);
		}
		Menu menu = new Menu(nuevomenu.getNombre(),nuevomenu.getAccion(),nuevomenu.getTipo_menu());
		imenuRespository.save(menu);
		if(nuevomenu.getIdpadre().equals("0")) {
			
		}else {
			ItemMenu itemMenu = new ItemMenu(menu,Integer.parseInt(nuevomenu.getIdpadre()),Integer.parseInt(nuevomenu.getIdhijo()));
			iitemMenuRepository.save(itemMenu);			
		}
		
		RolMenu rolMenu = new RolMenu(Integer.parseInt(nuevomenu.getIdrol()),menu.getId());
		
		iRolMenu.save(rolMenu);
		
		return new ResponseEntity(new Mensaje("menu guardado"),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/gettipomenu", method = RequestMethod.GET,params = "tipo",headers = "Accept= application/json")
	private @ResponseBody List<Menu> getTipoMenu(@RequestParam(value = "tipo") String tipo){
		List<Menu> listmenu= imenuRespository.findByTipoMenu(tipo);
		if(listmenu.isEmpty()) {
			return null;
		}
		
		return listmenu;
	}
	
	@RequestMapping(value = "/getAllMenu", method = RequestMethod.GET,params = "tipo",headers = "Accept= application/json")
	private @ResponseBody List<Menu> getAllMenus(@RequestParam(value = "tipo") String tipo){
		List<Menu> listmenu= imenuRespository.findAll();
		if(listmenu.isEmpty()) {
			return null;
		}
		
		return listmenu;
	}
	
}
