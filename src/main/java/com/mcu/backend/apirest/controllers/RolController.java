package com.mcu.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcu.backend.apirest.repository.IRolRepository;

@Controller
@CrossOrigin
public class RolController {
	@Autowired
	private IRolRepository iRolRepository;
	
	
	@RequestMapping(value = "/getroles", method = RequestMethod.GET,headers = "Accept= application/json")
	private @ResponseBody List<?> getRoles(){
		List<?> listRoList= iRolRepository.findAll();
		if(listRoList.isEmpty()) {
			return null;
		}
		
		return listRoList;
	}
}
