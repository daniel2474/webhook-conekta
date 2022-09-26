package com.webHook.Repository;


import com.webHook.Entity.Token;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Token, Long> {
  Optional<Token> findById(long paramLong);
  
  boolean existsById(long paramLong);
}
