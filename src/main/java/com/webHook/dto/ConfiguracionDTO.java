package com.webHook.dto;

public class ConfiguracionDTO {
	  private long id;
	  
	  private String tokenAlpha;
	  
	  private String endpointAlpha;
	  
	  ConfiguracionDTO() {}
	  
	  public ConfiguracionDTO(String tokenAlpha, String endpointAlpha) {
	    this.tokenAlpha = tokenAlpha;
	    this.endpointAlpha = endpointAlpha;
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
