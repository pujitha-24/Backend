package com.dbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionEntity {
	@Id
	String customerid;
    String acholdername;
    String bic;
    String bankname;
    String acounttype;
    Long amount;
    String maincustomerid;
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionEntity(String customerid, String acholdername, String bic, String bankname, String acounttype,
			Long amount, String maincustomerid) {
		super();
		this.customerid = customerid;
		this.acholdername = acholdername;
		this.bic = bic;
		this.bankname = bankname;
		this.acounttype = acounttype;
		this.amount = amount;
		this.maincustomerid= maincustomerid;
	}
	
	
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAcholdername() {
		return acholdername;
	}
	public void setAcholdername(String acholdername) {
		this.acholdername = acholdername;
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
	public String getAcounttype() {
		return acounttype;
	}
	public void setAcounttype(String acounttype) {
		this.acounttype = acounttype;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public String getMaincustomerid() {
		return maincustomerid;
	}
	public void setMaincustomerid(String maincustomerid) {
		this.maincustomerid = maincustomerid;
	}
	@Override
	public String toString() {
		return "TransactionEntity [customerid=" + customerid + ", acholdername=" + acholdername + ", bic=" + bic
				+ ", bankname=" + bankname + ", acounttype=" + acounttype + ", amount=" + amount + ", maincustomerid="
				+ maincustomerid + "]";
	}

	

}
