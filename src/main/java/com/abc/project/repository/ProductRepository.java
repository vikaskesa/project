package com.abc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.project.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
