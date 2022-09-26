package com.webHook.Service;

import com.webHook.Entity.Token;
import com.webHook.Repository.ConfiguracionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfiguracionService {
  @Autowired
  ConfiguracionRepository ConfiguracionRepository;
  
  public Optional<Token> getById(int id) {
    return this.ConfiguracionRepository.findById(id);
  }
}
