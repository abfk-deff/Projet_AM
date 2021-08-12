package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {

	
	public Client findByTelephone(int numTel);
}
