package edu.cibertec.pe.entity;

import java.io.Serializable;



public class Cliente implements Serializable {
	
	private static final long serialVersionUID = -4751197415014941744L;
	private int cod;
	private String nom;
	private String apleP;
	private String apleM;
	
	public Cliente(int cod, String nom, String apleP, String apleM, String direc, String rubro) {
		super();
		this.cod = cod;
		this.nom = nom;
		this.apleP = apleP;
		this.apleM = apleM;
		this.direc = direc;
		this.rubro = rubro;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getApleP() {
		return apleP;
	}
	public void setApleP(String apleP) {
		this.apleP = apleP;
	}
	public String getApleM() {
		return apleM;
	}
	public void setApleM(String apleM) {
		this.apleM = apleM;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	private String direc;
	private String rubro;
}
