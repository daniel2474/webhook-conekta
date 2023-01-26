package com.webHook.Repository;


import com.webHook.Entity.FiservRespuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FiservRespuestaRepository extends JpaRepository<FiservRespuesta, UUID> {


}
