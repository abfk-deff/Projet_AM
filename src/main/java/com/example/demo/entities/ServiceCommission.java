package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="T_SERVICE")
public class ServiceCommission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7572572045186137169L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ServiceComId;
	private String articleCommande;
	private int qteArticleCom;
	private double prixArticle;
	private String typeService;
	private double pricCommission;
	private String description;

	  @OneToMany(mappedBy = "myServiceCom")
	  private List<Commande> myCommande;
	  //private List<LigneCommande> ligneCommande;
	 
}
