package com.webHook.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderAlpha")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name = "noPedido", nullable = false, length = 20)
  private int noPedido;
  
  @Column(name = "monto", nullable = false, length = 10)
  private double monto;
  
  @Column(name = "notarjeta", nullable = false, length = 50)
  private String notarjeta;
  
  @Column(name = "folioInterbancario", nullable = false, length = 50)
  private String folioInterbancario;
  
  @Column(name = "noAutorizacion", nullable = false, length = 50)
  private String noAutorizacion;
  
  @Column(name = "fechaPago", nullable = false)
  private Date fechaPago;
  
  @Column(name = "titularCuenta", nullable = false, length = 50)
  private String titularCuenta;
  
  @Column(name = "json", nullable = false, length = 50000)
  private String json;
  
  @Column(name = "fechaCreacion", nullable = false)
  private Date fechaCreacion;
  
  @Column(name = "sincronizado", nullable = false)
  private boolean sincronizado;
  
  public Order() {}
  
  public Order(int noPedido, double monto, String notarjeta, String folioInterbancario, String noAutorizacion, Date fechaPago, String titularCuenta, String json, Date fechaCreacion, boolean sincronizado) {
    this.noPedido = noPedido;
    this.monto = monto;
    this.notarjeta = notarjeta;
    this.folioInterbancario = folioInterbancario;
    this.noAutorizacion = noAutorizacion;
    this.fechaPago = fechaPago;
    this.titularCuenta = titularCuenta;
    this.json = json;
    this.fechaCreacion = fechaCreacion;
    this.sincronizado = sincronizado;
  }
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public Date getFechaCreacion() {
    return this.fechaCreacion;
  }
  
  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }
  
  public boolean isSincronizado() {
    return this.sincronizado;
  }
  
  public void setSincronizado(boolean sincronizado) {
    this.sincronizado = sincronizado;
  }
  
  public String getJson() {
    return this.json;
  }
  
  public void setJson(String json) {
    this.json = json;
  }
  
  public int getNoPedido() {
    return this.noPedido;
  }
  
  public void setNoPedido(int noPedido) {
    this.noPedido = noPedido;
  }
  
  public double getMonto() {
    return this.monto;
  }
  
  public void setMonto(double monto) {
    this.monto = monto;
  }
  
  public String getNotarjeta() {
    return this.notarjeta;
  }
  
  public void setNotarjeta(String notarjeta) {
    this.notarjeta = notarjeta;
  }
  
  public String getFolioInterbancario() {
    return this.folioInterbancario;
  }
  
  public void setFolioInterbancario(String folioInterbancario) {
    this.folioInterbancario = folioInterbancario;
  }
  
  public String getNoAutorizacion() {
    return this.noAutorizacion;
  }
  
  public void setNoAutorizacion(String noAutorizacion) {
    this.noAutorizacion = noAutorizacion;
  }
  
  public Date getFechaPago() {
    return this.fechaPago;
  }
  
  public void setFechaPago(Date fechaPago) {
    this.fechaPago = fechaPago;
  }
  
  public String getTitularCuenta() {
    return this.titularCuenta;
  }
  
  public void setTitularCuenta(String titularCuenta) {
    this.titularCuenta = titularCuenta;
  }
}