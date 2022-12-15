package com.cotiviti.ecom.repository;

import com.cotiviti.ecom.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
