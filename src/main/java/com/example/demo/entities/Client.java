package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="T_CLIENT")
public class Client extends Utilisateur implements Serializable {
	
	
	private static final long serialVersionUID = 7311678611282243505L;
	
	  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  private Long clientid;
	 
	@OneToMany(mappedBy = "myClient")
	private List<Commande> myCommande;

	
}
