package com.example.demo.entities;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="typeUser", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("User")
@MappedSuperclass
public abstract class Utilisateur {

	 //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private String nomUtilisateur;
	  private String prenomutilsateur;
	  private int telephone;
	  
}