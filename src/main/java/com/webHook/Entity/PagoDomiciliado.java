package com.webHook.Entity;

import javax.persistence.*;

@Entity
@Table(name = "pago_domiciliado")
public class PagoDomiciliado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

   @Column(name = "informacion", nullable = false, length = 10000)
   private String informacion;

public String getInformacion() {
	return informacion;
}

public void setInformacion(String informacion) {
	this.informacion = informacion;
}
   
   

}
