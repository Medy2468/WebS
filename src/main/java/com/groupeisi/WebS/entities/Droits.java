package com.groupeisi.WebS.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.groupeisi.WebS.entities.Comptes;

@Entity	
@Table (name="droit") // Création de la table appuser dans la base de donnée
public class Droits implements Serializable{

	@Id // Clé primaire
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (name="name", nullable=false, length=200, unique=true)
	private String name;
	
	@ManyToMany(mappedBy="droits")
	List<Comptes> comptes = new ArrayList<Comptes>();

	public Droits() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Comptes> getComptes() {
		return comptes;
	}

	public void setComptes(List<Comptes> comptes) {
		this.comptes = comptes;
	}
}
