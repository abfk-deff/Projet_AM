package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Client;
import com.example.demo.entities.ServiceCommission;

import lombok.Data;

@Data
public class FormService {

	Client myClient = new Client();
	//List<Client> myClients = new ArrayList<Client>();
	private List<ServiceCommission> myService = new ArrayList<ServiceCommission>();
}


