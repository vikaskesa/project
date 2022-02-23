package com.abc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.project.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
