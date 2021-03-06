package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

}
