package com.abc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.project.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
