package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entities.Client;
import com.example.demo.entities.ServiceCommission;
import com.example.demo.services.ServiceCommande;

@SpringBootApplication
public class ProjetAmasApplication implements CommandLineRunner {
	
	@Autowired
	private ServiceCommande service;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetAmasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 Client client = new Client(); client.setNomUtilisateur("deff");
		  client.setPrenomutilsateur("Garou"); client.setTelephone(04567);
		   
		  ServiceCommission serv = new ServiceCommission();
		  serv.setArticleCommande("Savon"); serv.setDescription("Achat du savon");
		  serv.setQteArticleCom(43); serv.setTypeService("Achat immobilisation");
		  String msg;
		  try { 
			  msg = service.demandeCommission(client, serv);
			  System.out.println(msg); 
		  }
		 
		  catch (Exception e) {
			  // TODO: handle exception 
			  
		  }
		 
		
		
	}
}