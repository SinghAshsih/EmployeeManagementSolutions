package com.blueliner.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueliner.employee.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
