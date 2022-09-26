package com.webHook.Service;


import com.webHook.Entity.Order;
import com.webHook.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
  @Autowired
  OrderRepository OrderRepository;
  
  public void save(Order order) {
    this.OrderRepository.save(order);
  }
}
