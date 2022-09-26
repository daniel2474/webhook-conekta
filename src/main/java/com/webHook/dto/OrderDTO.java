package com.webHook.dto;

import java.util.Date;

public class OrderDTO {
  private int noPedido;
  
  private double monto;
  
  private String notarjeta;
  
  private String folioInterbancario;
  
  private String noAutorizacion;
  
  private int fechaPago;
  
  private int horaPago;
  
  private String titularCuenta;
  
  private String json;
  
  private Date fechaCreacion;
  
  private boolean sincronizado;
  
  public OrderDTO() {}
  
  public OrderDTO(int noPedido, double monto, String notarjeta, String folioInterbancario, String noAutorizacion, int fechaPago, int horaPago, String titularCuenta, String json, Date fechaCreacion, boolean sincronizado) {
    this.noPedido = noPedido;
    this.monto = monto;
    this.notarjeta = notarjeta;
    this.folioInterbancario = folioInterbancario;
    this.noAutorizacion = noAutorizacion;
    this.fechaPago = fechaPago;
    this.horaPago = horaPago;
    this.titularCuenta = titularCuenta;
    this.json = json;
    this.fechaCreacion = fechaCreacion;
    this.sincronizado = sincronizado;
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
  
  public int getFechaPago() {
    return this.fechaPago;
  }
  
  public void setFechaPago(int fechaPago) {
    this.fechaPago = fechaPago;
  }
  
  public int getHoraPago() {
    return this.horaPago;
  }
  
  public void setHoraPago(int horaPago) {
    this.horaPago = horaPago;
  }
  
  public String getTitularCuenta() {
    return this.titularCuenta;
  }
  
  public void setTitularCuenta(String titularCuenta) {
    this.titularCuenta = titularCuenta;
  }
}