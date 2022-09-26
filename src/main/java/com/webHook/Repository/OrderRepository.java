package com.webHook.Repository;



import com.webHook.Entity.Order;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
  Optional<Order> findByNoPedido(String paramString);
  
  boolean existsByNoPedido(String paramString);
}
