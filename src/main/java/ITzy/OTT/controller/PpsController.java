package ITzy.OTT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ITzy.OTT.dto.PpsDto;
import ITzy.OTT.service.PpsService;

@Controller
public class PpsController {

	@Autowired
	PpsService service;
	
	@RequestMapping(value = "ppslist.do", method =RequestMethod.GET)
	public String ppslist() {
		return "ppslist";
	}
		
	
	@RequestMapping(value = "ppswrite.do", method =RequestMethod.GET)
	public String ppswrite() {
		return "ppswrite";
	}
	
		
	
	
	
}
