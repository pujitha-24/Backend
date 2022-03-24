package com.dbs.repository;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.dbs.entity.CustomerEntity;



@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, String> {
	Optional<CustomerEntity> findById(String customerid);
	// SELECT * FROM employee WHERE deptno = 20
	// SELECT * FROM Employee e where e.department.id = 20
	
//	@Query("SELECT e FROM PaymentsEntity e WHERE e.customerid= ?1")
//	List<PaymentsEntity> findAllByDept(int dept_id);
}

