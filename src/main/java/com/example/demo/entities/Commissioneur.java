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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="T_AGENT")
public class Commissioneur extends Utilisateur implements Serializable{
	
	
	private static final long serialVersionUID = 7935683835709561899L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commissionneurId;
	@OneToMany(mappedBy = "myCommissionneur")
	private List<Commission> myCommission;
	
	
	
}
