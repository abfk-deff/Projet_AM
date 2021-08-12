package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.entities.ServiceCommission;
import com.example.demo.services.ServiceCommande;
@CrossOrigin("*")
@RestController
public class DemandeServiceController {
	
	@Autowired
	private ServiceCommande service;
	
	//FormService formService = new FormService();;
	
	@PostMapping("/demande/service")
	public void insertionService(FormService formeService) {	
		try {
			
			   //service.demandeCommission(formeService.getMyClient(), formeService.getMyService());
			
		} catch (Exception e) {
			
		}
	}
	
	@GetMapping("/liste/service")
	public List<ServiceCommission> selectServices(){
		return service.getServ();
	} 
	
	@GetMapping("/liste/clients")
	public List<Client> getTlient(){
		
		return service.selectClients();
	}

}
