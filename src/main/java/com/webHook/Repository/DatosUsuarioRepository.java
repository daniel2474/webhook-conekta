package com.webHook.Repository;


import com.webHook.Entity.DatosUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario, UUID> {


}
