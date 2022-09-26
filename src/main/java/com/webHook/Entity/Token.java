package com.webHook.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuracionAlpha")
public class Token {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column(name = "tokenAlpha", nullable = false, length = 100)
  private String tokenAlpha;
  
  @Column(name = "endpointAlpha", nullable = false, length = 100)
  private String endpointAlpha;
  
  @Column(name = "correoAlpha", nullable = false, length = 100)
  private String correo;
  
  @Column(name = "passwordAlpha", nullable = false, length = 100)
  private String pass;
  
  Token() {}
  
  public Token(long id, String tokenAlpha, String endpointAlpha, String correo, String pass) {
    this.id = id;
    this.tokenAlpha = tokenAlpha;
    this.endpointAlpha = endpointAlpha;
    this.correo = correo;
    this.pass = pass;
  }
  
  public String getCorreo() {
    return this.correo;
  }
  
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  
  public String getPass() {
    return this.pass;
  }
  
  public void setPass(String pass) {
    this.pass = pass;
  }
  
  public long getId() {
    return this.id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getTokenAlpha() {
    return this.tokenAlpha;
  }
  
  public void setTokenAlpha(String tokenAlpha) {
    this.tokenAlpha = tokenAlpha;
  }
  
  public String getEndpointAlpha() {
    return this.endpointAlpha;
  }
  
  public void setEndpointAlpha(String endpointAlpha) {
    this.endpointAlpha = endpointAlpha;
  }
}