package com.dbs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.entity.CustomerEntity;
import com.dbs.entity.TransactionEntity;
import com.dbs.exceptions.CustomerNotFoundException;
import com.dbs.exceptions.InvalidAcHolderException;
import com.dbs.exceptions.InvalidBICException;
import com.dbs.exceptions.InvalidBankException;
import com.dbs.exceptions.InvalidCustomerIdException;
import com.dbs.exceptions.InvalidPasswordException;
import com.dbs.service.CustomerService;





@RestController
@CrossOrigin(origins="http://localhost:4200")
@Validated
public class CustomerController {
	CustomerService customerservice;
	
	public CustomerService getCustomerservice() {
		return customerservice;
	}

	@Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	@PostMapping(value="/Login")
	public CustomerEntity findCustomerById(@RequestBody CustomerEntity customerentity) throws InvalidCustomerIdException, InvalidPasswordException, CustomerNotFoundException{
		return customerservice.findCustomer(customerentity.getCustomerid(),customerentity.getPassword());
	}
	
	@PostMapping(value="/TransferTo")
	public Boolean Transfer(@RequestBody TransactionEntity transactionentity) throws InvalidCustomerIdException ,InvalidBICException, InvalidBankException, CustomerNotFoundException, InvalidAcHolderException {
		return customerservice.findTransaction(transactionentity);
	}
	

	@RequestMapping(value="/Transaction", method=RequestMethod.PUT)
	public String update(@RequestBody TransactionEntity transactionentity) throws CustomerNotFoundException{
		return customerservice.transactionupdate(transactionentity);
		
	}
	
	
	
}
