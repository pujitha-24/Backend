package com.dbs.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.entity.BankEntity;
import com.dbs.entity.CustomerEntity;
import com.dbs.entity.TransactionEntity;
import com.dbs.exceptions.CustomerNotFoundException;
import com.dbs.exceptions.InvalidAcHolderException;
import com.dbs.exceptions.InvalidBICException;
import com.dbs.exceptions.InvalidBankException;
import com.dbs.exceptions.InvalidCustomerIdException;
import com.dbs.exceptions.InvalidPasswordException;
import com.dbs.repository.BankRepo;
import com.dbs.repository.CustomerRepo;


@Service
public class CustomerService {
    CustomerRepo customerrepo;
    BankRepo bankrepo;
    

	public CustomerRepo getCustomerrepo() {
		return customerrepo;
	}
	@Autowired
	public void setCustomerrepo(CustomerRepo customerrepo) {
		this.customerrepo = customerrepo;
	}
	
	
	public BankRepo getBankrepo() {
		return bankrepo;
	}
	@Autowired
	public void setBankrepo(BankRepo bankrepo) {
		this.bankrepo = bankrepo;
	}
	public CustomerEntity findCustomer(String customerid, String password) throws InvalidCustomerIdException,InvalidPasswordException, CustomerNotFoundException {
		Optional<CustomerEntity> optionalcustomer = customerrepo.findById(customerid);
		if(optionalcustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		if(!optionalcustomer.isPresent()) {
			throw new InvalidCustomerIdException("Invalid CustomerId");
		}
		if (!optionalcustomer.get().getPassword().equals(password))
		{
			throw new InvalidPasswordException("Invalid Password");
		}
		return optionalcustomer.get();
	}
	
	
//	public String findBIC(String bic, String bankname, String customerid) throws InvalidBICException, InvalidBankException,InvalidCustomerIdException, CustomerNotFoundException {
//		Optional<BankEntity> optionalbank = bankrepo.findById(bic);
//		Optional<CustomerEntity> optionalcustomer = customerrepo.findById(customerid);
//		if(optionalcustomer.isEmpty()) {
//			throw new CustomerNotFoundException("Customer not found");
//		}
//		if(!optionalbank.isPresent() ) {
//			throw new InvalidBICException("Invalid bic "+bic);
//		}
//		else if (!optionalbank.get().getBankname().equals(bankname))
//		{
//			throw new InvalidBankException("Invalid Bank");
//		}
//		else if(!bic.equals(optionalcustomer.get().getBic())) {
//			throw new InvalidCustomerIdException("Invalid CustomerId");
//		}
//		
//		
//		return optionalcustomer.get().getAcholdername();
//	
//		
//		
//	}


	public String transactionupdate(TransactionEntity transactionentity) throws CustomerNotFoundException{
		Optional<CustomerEntity> optionalcustomer = customerrepo.findById(transactionentity.getMaincustomerid());
		Optional<CustomerEntity> receivecustomer = customerrepo.findById(transactionentity.getCustomerid());
		String overdraft=optionalcustomer.get().getOverdraft();
		Long clearbal=optionalcustomer.get().getClearbalance();
		Long loanamount=optionalcustomer.get().getOveramount();
		if(optionalcustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		if(overdraft=="Yes" && loanamount<=0) {
			optionalcustomer.get().setOverdraft("No");
			customerrepo.save(optionalcustomer.get());
		}
		if(overdraft=="No" || transactionentity.getAmount()>loanamount+clearbal){
			return "Transaction amount Exceeded";
		}
		if(transactionentity.getAmount()<=clearbal) {
			optionalcustomer.get().setClearbalance(clearbal-transactionentity.getAmount());
			Long recbal=transactionentity.getAmount() + receivecustomer.get().getClearbalance();
			receivecustomer.get().setClearbalance(recbal);
			
		}
		else {
		optionalcustomer.get().setOveramount(clearbal+loanamount-transactionentity.getAmount());
		optionalcustomer.get().setClearbalance(0);
		Long recbal=transactionentity.getAmount() + receivecustomer.get().getClearbalance();
		receivecustomer.get().setClearbalance(recbal);
		}	
		Long mainfinal=optionalcustomer.get().getClearbalance();
		customerrepo.save(optionalcustomer.get());
		
		return Long.toString(mainfinal);
		
	}
	public Boolean findTransaction(TransactionEntity transactionentity) throws InvalidBICException, CustomerNotFoundException, InvalidAcHolderException {
		Optional<CustomerEntity> optionalcustomer = customerrepo.findById(transactionentity.getCustomerid());
		Optional<BankEntity> optionalbank = bankrepo.findById(transactionentity.getBic());
		if(optionalcustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		if(!optionalbank.isPresent() ) {
			throw new InvalidBICException("Invalid bic ");
		}
		if(sdnListContains(transactionentity.getAcholdername().toLowerCase())) {
			return false;
		}
		else if(!optionalcustomer.get().getAcholdername().equals(transactionentity.getAcholdername())) {
			throw new InvalidAcHolderException("Invalid Acount Holder Name");
			
		}
		else if (!optionalbank.get().getBankname().equals(transactionentity.getBankname()))
		{
			throw new InvalidBankException("Invalid Bank");
		}
		else if(!transactionentity.getBic().equals(optionalcustomer.get().getBic())) {
			throw new InvalidCustomerIdException("Invalid CustomerId");
		}
		
		
		return true;
	}
	
	private Boolean sdnListContains(String lowerCase) {
		// TODO Auto-generated method stub
		String filePath = "src/sdnlist.txt";
		
	    Scanner sc;
		try {
			sc = new Scanner(new File(filePath));
			while (sc.hasNextLine()) {
				if(sc.nextLine().toLowerCase().contains(lowerCase)) {
					return true;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return false;
		
	}
	
	
	
}
