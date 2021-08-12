package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="T_COMMISSION")
public class Commission implements Serializable {

	
				  private static final long serialVersionUID = 4780215757181090947L;
				  
				  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
				  private Long commissionId; 
				  
				 // @Temporal(TemporalType.DATE)
				  private Date dateCom;
				  
				  @ManyToOne
				  private Commissioneur myCommissionneur;
				   
					/* @ManyToOne private ServiceCommission myServiceCom; */
				  
				  @ManyToOne //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) private
				  Commande myCommande;
				 
}
