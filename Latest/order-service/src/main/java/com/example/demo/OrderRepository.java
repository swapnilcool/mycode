package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.OrderVO;
public interface OrderRepository extends JpaRepository<OrderVO, Integer> {
}
