package com.groupeisi.WebS.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.groupeisi.WebS.entities.Droits;

@Entity	
@Table (name="compte") // Création de la table appuser dans la base de donnée
public class Comptes implements Serializable{

	@Id // Clé primaire
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (name="username", nullable=false, length=200)
	private String username;
	@Column (name="password", nullable=false, length=200)
	private String password;
	
	public Comptes() {
		super();
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	List<Droits> droits = new ArrayList<Droits>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Droits> getDroits() {
		return droits;
	}

	public void setDroits(List<Droits> droits) {
		this.droits = droits;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
