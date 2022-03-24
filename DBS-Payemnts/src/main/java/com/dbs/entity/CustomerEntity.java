package com.dbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerEntity {
	@Id
    String customerid;
    String bic;
    String acholdername;
	long clearbalance;
    String overdraft;
    String password;
    long overamount;
    public CustomerEntity() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
	public CustomerEntity(String customerid, String bic, String acholdername, long clearbalance, String overdraft, String password,Long overamount) {
		super();
		this.customerid = customerid;
		this.bic = bic;
		this.acholdername = acholdername;
		this.clearbalance = clearbalance;
		this.overdraft = overdraft;
		this.password = password;
		this.overamount =overamount;
	}

	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getAcholdername() {
		return acholdername;
	}
	public void setAcholdername(String acholdername) {
		this.acholdername = acholdername;
	}
	public long getClearbalance() {
		return clearbalance;
	}
	public void setClearbalance(long clearbalance) {
		this.clearbalance = clearbalance;
	}
	public String getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getOveramount() {
		return overamount;
	}
	public void setOveramount(long overamount) {
		this.overamount = overamount;
	}
	@Override
	public String toString() {
		return "CustomerEntity [customerid=" + customerid + ", bic=" + bic + ", acholdername=" + acholdername
				+ ", clearbalance=" + clearbalance + ", overdraft=" + overdraft + ", password=" + password
				+ ", overamount=" + overamount + "]";
	}

	
    
    
}
