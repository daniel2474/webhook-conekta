package com.webHook.Controller;


import com.webHook.Correo.Correo;
import com.webHook.Entity.Order;
import com.webHook.Entity.Token;
import com.webHook.Service.ConfiguracionService;
import com.webHook.Service.OrderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pagos"})
public class whController {
  private static Logger logJava = Logger.getLogger(com.webHook.Controller.whController.class);
  
  @Autowired
  OrderService orderService;
  
  @Autowired
  ConfiguracionService confiService;
  
  @PostMapping({"/oxxopay"})
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    BufferedReader get_body = request.getReader();
    String o = get_body.lines().collect(Collectors.joining());
    Order orderDTO = new Order();
    Date fecha = new Date();
    String type = " ";
    JSONObject jsonObject = new JSONObject(o);
    if (!comprueba(o)) {
      type = jsonObject.getString("type");
      if (type.equals("order.paid")) {
        int amount = 0, Unixfecha = 0;
        String noPedido = "", TitularCuenta = "", NoAutorizacion = "", FolioInterbancario = "", Reference = "", idUsuario = "", Membresia = "";
        JSONArray j = null;
        amount = jsonObject.getJSONObject("data").getJSONObject("object").getInt("amount");
        Unixfecha = jsonObject.getJSONObject("data").getJSONObject("object").getInt("created_at");
        try {
            noPedido = jsonObject.getJSONObject("data").getJSONObject("object").getJSONObject("metadata").getString("NoPedido");        	
        }catch(JSONException e) {
        	noPedido = String.valueOf(jsonObject.getJSONObject("data").getJSONObject("object").getJSONObject("metadata").getInt("NoPedido"));  
        }
        try {
            TitularCuenta = jsonObject.getJSONObject("customer_info").getString("name");        	
        }catch(JSONException e) {
        	
        }
        NoAutorizacion = jsonObject.getJSONObject("data").getJSONObject("object").getString("id");
        try {
        	idUsuario = jsonObject.getJSONObject("data").getJSONObject("object").getJSONObject("metadata").getString("IDCliente");
        }catch(JSONException e) {
        	idUsuario = String.valueOf(jsonObject.getJSONObject("data").getJSONObject("object").getJSONObject("metadata").getInt("IDCliente"));
        }
        try {
            Membresia = jsonObject.getJSONObject("data").getJSONObject("object").getJSONObject("metadata").getString("Membresia");        	
        }catch(JSONException e) {
        	 Membresia = String.valueOf(jsonObject.getJSONObject("data").getJSONObject("object").getJSONObject("metadata").getInt("Membresia")); 
        }
        j = jsonObject.getJSONObject("data").getJSONObject("object").getJSONObject("charges").getJSONArray("data");
        String correo = jsonObject.getJSONObject("data").getJSONObject("object").getJSONObject("customer_info").getString("email");
        for (Object ob : j) {
          JSONObject item = (JSONObject)ob;
          FolioInterbancario = item.getString("id");
          Reference = item.getJSONObject("payment_method").getString("reference");
        } 
        String[] fe = TimeStampDate(Unixfecha);
        Date FeCo = TimeStampDateC(Unixfecha);
        orderDTO.setNoPedido(Integer.parseInt(noPedido));
        orderDTO.setMonto(amount);
        orderDTO.setNotarjeta(Reference);
        orderDTO.setFolioInterbancario(FolioInterbancario);
        orderDTO.setNoAutorizacion(NoAutorizacion);
        orderDTO.setFechaPago(FeCo);
        orderDTO.setTitularCuenta(TitularCuenta);
        orderDTO.setJson(o);
        orderDTO.setFechaCreacion(fecha);
        Token t = this.confiService.getById(1).get();
        String body2 = "{\r\n\"NoPedido\":" + 
          orderDTO.getNoPedido() + ",\r\n" + 
          "\"Monto\":" + Amount(orderDTO.getMonto()) + ",\r\n" + 
          "\"Notarjeta\":" + "\"" + orderDTO.getNotarjeta() + "\"" + ",\r\n" + 
          "\"FolioInterbancario\":" + "\"" + orderDTO.getFolioInterbancario() + "\"" + ",\r\n" + 
          "\"NoAutorizacion\":" + "\"" + orderDTO.getNoAutorizacion() + "\"" + ",\r\n" + 
          "\"FechaPago\":" + "\"" + fe[0] + "\"" + ",\r\n" + 
          "\"HoraPago\":" + "\"" + fe[1] + "\"" + ",\r\n" + 
          "\"TitularCuenta\":" + "\"" + orderDTO.getTitularCuenta() + "\"" + ",\r\n" + 
          "\"Token\":" + "\"" + t.getTokenAlpha() + "\"" + "\r\n" + 
          "}";
        HttpClient client = HttpClient.newBuilder().build();
        String url = t.getEndpointAlpha();
        HttpRequest request1 = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(body2)).build();
        try {
          HttpResponse<?> response1 = client.send(request1, HttpResponse.BodyHandlers.discarding());
          CompletableFuture<String> client2 = HttpClient.newHttpClient().<String>sendAsync(request1, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
          switch (response1.statusCode()) {
            case 200:
              logJava.info(String.valueOf(response1.statusCode()) + ": Todo ha ido bien la peticise ha realizado de forma correcta");
              break;
            case 201:
              logJava.info(String.valueOf(response1.statusCode()) + ": Se ha creado un nuevo recurso");
              break;
            case 204:
              logJava.info(String.valueOf(response1.statusCode()) + ": No hay contenido en la respuesta (simplemente viene vacia)");
              break;
            case 301:
              logJava.warn(String.valueOf(response1.statusCode()) + ": El recurso se ha movido");
              break;
            case 400:
              logJava.warn(String.valueOf(response1.statusCode()) + ": Peticino valida , es un mensaje gensimplemente indica que la peticino se ha podido realizar");
              break;
            case 401:
              logJava.warn(String.valueOf(response1.statusCode()) + ": No tienes autoridad para acceder al recurso");
              break;
            case 403:
              logJava.warn(String.valueOf(response1.statusCode()) + ": No tienes permisos para acceder");
              break;
            case 404:
              logJava.warn(String.valueOf(response1.statusCode()) + ": Recurso no encontrado");
              break;
            case 405:
              logJava.warn(String.valueOf(response1.statusCode()) + ": El mGET ,POST etc no esta soportado");
              break;
            case 500:
              logJava.warn(String.valueOf(response1.statusCode()) + ": Error que proviene de una excepcidel lado servidor");
              break;
            default:
              logJava.warn(String.valueOf(response1.statusCode()) + ": Un error poco comun");
              break;
          } 
          if (200 <= response1.statusCode() && response1.statusCode() < 299) {
            orderDTO.setSincronizado(true);
            Correo co = new Correo(t.getCorreo(), t.getPass(), correo, noPedido);
            try {
              co.enviar_correo(orderDTO.getTitularCuenta(), Amount(orderDTO.getMonto()), orderDTO.getFolioInterbancario(), idUsuario, Membresia, ((String)client2.get()).toString());
              logJava.info("Correo Eviado Correctamente");
            } catch (Exception e) {
              logJava.warn("Correo No Eviado Correctamente");
            } 
          } else {
            orderDTO.setSincronizado(false);
            logJava.error("Error al sincronizar la orden " + response1.statusCode());
          } 
        } catch (IOException|InterruptedException e) {
          e.printStackTrace();
          logJava.warn("Error al llamar la api del club");
        } 
        this.orderService.save(orderDTO);
      } 
    } else {
      logJava.info("woo Comerce");
    } 
  }
  
  private String[] TimeStampDate(long timestampString) {
    Long timestamp = Long.valueOf(timestampString * 1000L);
    String date = (new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss")).format(new Date(timestamp.longValue()));
    String[] fechaHora = date.split("-");
    return fechaHora;
  }
  
  private Date TimeStampDateC(long timestampString) {
    Date time = new Date(timestampString * 1000L);
    return time;
  }
  
  private String Amount(double amount) {
    float moneda = (float)(amount / 100.0D);
    String formattedString = String.format("%.02f", new Object[] { Double.valueOf(Math.ceil(moneda)) });
    return formattedString;
  }
  
  private boolean comprueba(String o) {
    String cadenaDondeBuscar = o;
    String loQueQuieroBuscar = "tag";
    String[] palabras = loQueQuieroBuscar.split("\\s+");
    byte b;
    int i;
    String[] arrayOfString1;
    for (i = (arrayOfString1 = palabras).length, b = 0; b < i; ) {
      String palabra = arrayOfString1[b];
      if (cadenaDondeBuscar.contains(palabra))
        return true; 
      b++;
    } 
    return false;
  }
}