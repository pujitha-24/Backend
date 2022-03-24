package com.dbs.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.entity.BankEntity;


@Repository
public interface BankRepo extends JpaRepository<BankEntity, String> {
	Optional<BankEntity> findById(String bic);
}
