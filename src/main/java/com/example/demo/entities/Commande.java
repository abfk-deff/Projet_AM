package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="T_COMMANDE")
public class Commande implements Serializable{

		private static final long serialVersionUID = -1281226706130321991L;
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long commandeId;
		@Temporal(TemporalType.DATE)
	    private java.util.Date dateCommande;
		private int quantity;
	    private double price;
		
		  @OneToMany(mappedBy = "myCommande") 
		  private List<Commission> myCommission;
		 
	    @ManyToOne
	    private ServiceCommission myServiceCom;
	    
	    @ManyToOne
	    private Client myClient;
		/*
		 * @ManyToOne private Commissioneur myCommissionneur; private double
		 * totalAmount;
		 */
}
