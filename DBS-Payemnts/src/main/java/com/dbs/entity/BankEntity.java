package com.dbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankEntity {
	@Id
	String bic;
	String bankname;
	public BankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankEntity(String bic, String bankname) {
		super();
		this.bic = bic;
		this.bankname = bankname;
	}

	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	@Override
	public String toString() {
		return "BankEntity [BIC=" + bic + ", bankname=" + bankname + "]";
	}
	

}
