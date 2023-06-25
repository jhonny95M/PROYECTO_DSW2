package edu.cibertec.pe.entity;

import java.io.Serializable;

public class Error implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5899037751937355216L;
	private int type;
	private String msg;
	public int getType() {
		return type;
	}
	
	
	public Error(int type, String msg) {
		super();
		this.type = type;
		this.msg = msg;
	}
	
	public Error() {}


	public void setType(int type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
