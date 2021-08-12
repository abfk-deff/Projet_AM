package com.example.demo.services;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controller.FormService;
import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CommandeRepository;
import com.example.demo.dao.ServiceCommissionRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.Commande;
import com.example.demo.entities.ServiceCommission;



@Service
public class ServiceCommande {
	
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private CommandeRepository commandeRepo;
	/*
	 * @Autowired private CommissionRepository commissionRepo;
	 */
	@Autowired
	private ServiceCommissionRepository serComRepo;
	
	
	Long id;
	
	
	public String demandeCommission(Client client, ServiceCommission sevice) {
	
		Commande commande = new Commande();
		
		
		
		try {
			
			client = clientRepo.save(client);
			//id = client.getClientid();
			sevice = serComRepo.save(sevice);
			
			
		} catch (Exception e) {
		
		}
		
		java.util.Date date = new java.util.Date();
		commande.setMyClient(client);
		commande.setDateCommande(date);
		commande.setMyServiceCom(sevice);
		
		try {
			
			commandeRepo.save(commande);
			
		} catch (Exception e) {
			
		}
		
		return "Enregistrement bien effectue";
	}
	
	
	@SuppressWarnings("unchecked")
	public FormService selectionService(Client clien){
		
		// Client client1 = new Client();
		FormService formService = new FormService();
		List<Client> clients = new ArrayList<>();
		Client cli = new Client();
		final EntityManager em = null;
		List<ServiceCommission> services = new ArrayList<ServiceCommission>();
		
		try {
			clients = clientRepo.findAll();
			cli = clientRepo.findByTelephone(clien.getTelephone());
			
		} catch (Exception e) {} 
		
		if (cli != null) {
			String rqt = "select services from ServiceCommission sevices, Client client, Commande commande"
					+ "where c.clientId = commande.clientId and commande.commandeId = service.commandeId and clientId = :id";
			clients.clear();
			clients.add(clien);
			//formService.setMyClients(clients);;	
		  Query query = em.createQuery(rqt);
		  services = (List<ServiceCommission>) query.setParameter("id", clien.getClientid()).getResultList();
			formService.setMyService(services);
			return formService;
		} else {

			String rqt = "select services from ServiceCommission sevices, Client client, Commande commande"
					+ "where c.clientId = commande.clientId and commande.commandeId = service.commandeId";	
		
			Query query = em.createQuery(rqt);		  
			services = (List<ServiceCommission>) query.getResultList();
			formService.setMyService(services);
			//formService .setMyClients(clients);
			formService.setMyService(services);
			return formService;
		} 
	}

	
	public List<ServiceCommission> getServ(){
		
		List<ServiceCommission> ser = new ArrayList<>();
		serComRepo.findAll().forEach(ser::add);
		return ser;
	}
	
	public List<Client> selectClients(){
		
		List<Client> clients = new ArrayList<>();
		
		clientRepo.findAll().forEach(clients::add);
		
		return clients;
	}
	
	public ServiceCommission update(ServiceCommission serviceCommission) {
		
		ServiceCommission nouvauService =  serComRepo.findById(serviceCommission.getServiceComId()).get();
		nouvauService.setDescription(serviceCommission.getDescription());
		nouvauService.setPricCommission(serviceCommission.getPricCommission());
		nouvauService.setQteArticleCom(serviceCommission.getQteArticleCom());
		nouvauService.setArticleCommande(serviceCommission.getArticleCommande());
		nouvauService.setMyCommande(serviceCommission.getMyCommande());
		nouvauService.setTypeService(serviceCommission.getTypeService());
		return serComRepo.save(nouvauService);
	}
	
}
