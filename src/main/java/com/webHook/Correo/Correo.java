package com.webHook.Correo;

import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Correo {
  private String correoEnvia;
  
  private String contrasena;
  
  private String destinatario;
  
  private String NoPedido;
  
  public Correo() {}
  
  public Correo(String correoEnvia, String contrasena, String destinatario, String NoPedido) {
    this.correoEnvia = correoEnvia;
    this.contrasena = contrasena;
    this.destinatario = destinatario;
    this.NoPedido = NoPedido;
  }
  
  public String getNoPedido() {
    return this.NoPedido;
  }
  
  public void setNoPedido(String noPedido) {
    this.NoPedido = noPedido;
  }
  
  public String getCorreoEnvia() {
    return this.correoEnvia;
  }
  
  public void setCorreoEnvia(String correoEnvia) {
    this.correoEnvia = correoEnvia;
  }
  
  public String getContrasena() {
    return this.contrasena;
  }
  
  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }
  
  public String getDestinatario() {
    return this.destinatario;
  }
  
  public void setDestinatario(String destinatario) {
    this.destinatario = destinatario;
  }
  
  public void enviar_correo(String Titular, String monto, String referencia, String idUsuario, String Membresia, String oxxo) {
    Calendar fecha = Calendar.getInstance();
    int a = fecha.get(1);
    int mes = fecha.get(2) + 1;
    int dia = fecha.get(5);
    int hora = fecha.get(11);
    int minuto = fecha.get(12);
    int segundo = fecha.get(13);
    Properties propiedad = new Properties();
    propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
    propiedad.setProperty("mail.smtp.starttls.enable", "true");
    propiedad.setProperty("mail.smtp.port", "587");
    propiedad.setProperty("mail.smtp.auth", "true");
    Session sesion = Session.getDefaultInstance(propiedad);
    String asunto = "por tu pago!";
    String mensaje = "<html>\r\n<head>\r\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=\"utf-8\">\r\n    <title>Referencia de Pago</title>\r\n    <style type=\"text/css\">\r\n        /* Reset -------------------------------------------------------------------- */\r\n        *    { margin: 0;padding: 0; }\r\n        body { font-size: 14px; }\r\n\r\n        /* OPPS --------------------------------------------------------------------- */\r\n\r\n        h3 {\r\n            margin-bottom: 10px;\r\n            font-size: 15px;\r\n            font-weight: 600;\r\n            text-transform: uppercase;\r\n        }\r\n\r\n        .opps {\r\n            width: 496px; \r\n            border-radius: 4px;\r\n            box-sizing: border-box;\r\n            padding: 0 45px;\r\n            margin: 40px auto;\r\n            overflow: hidden;\r\n            border: 1px solid #b0afb5;\r\n            font-family: 'Open Sans', sans-serif;\r\n            color: #4f5365;\r\n        }\r\n\r\n        .opps-reminder {\r\n            position: relative;\r\n            top: -1px;\r\n            padding: 9px 0 10px;\r\n            font-size: 11px;\r\n            text-transform: uppercase;\r\n            text-align: center;\r\n            color: #ffffff;\r\n            background: #000000;\r\n        }\r\n\r\n        .opps-info {\r\n            margin-top: 26px;\r\n            position: relative;\r\n        }\r\n\r\n        .opps-info:after {\r\n            visibility: hidden;\r\n            display: block;\r\n            font-size: 0;\r\n            content: \\\" \\\";\r\n            clear: both;\r\n            height: 0;\r\n\r\n        }\r\n\r\n        .opps-brand {\r\n            width: 45%;\r\n            float: left;\r\n        }\r\n\r\n        .opps-brand img {\r\n            max-width: 150px;\r\n            margin-top: 2px;\r\n        }\r\n\r\n        .opps-ammount {\r\n            width: 55%;\r\n            float: right;\r\n        }\r\n\r\n        .opps-ammount h2 {\r\n            font-size: 36px;\r\n            color: #000000;\r\n            line-height: 24px;\r\n            margin-bottom: 15px;\r\n        }\r\n\r\n        .opps-ammount h2 sup {\r\n            font-size: 16px;\r\n            position: relative;\r\n            top: -2px\r\n        }\r\n\r\n        .opps-ammount p {\r\n            font-size: 10px;\r\n            line-height: 14px;\r\n        }\r\n\r\n        .opps-reference {\r\n            margin-top: 14px;\r\n        }\r\n\r\n        h1 {\r\n            font-size: 27px;\r\n            color: #000000;\r\n            text-align: center;\r\n            margin-top: -1px;\r\n            padding: 6px 0 7px;\r\n            border: 1px solid #b0afb5;\r\n            border-radius: 4px;\r\n            background: #f8f9fa;\r\n        }\r\n\r\n        .opps-instructions {\r\n            margin: 32px -45px 0;\r\n            padding: 32px 45px 45px;\r\n            border-top: 1px solid #b0afb5;\r\n            background: #f8f9fa;\r\n        }\r\n\r\n        ol {\r\n            margin: 17px 0 0 16px;\r\n        }\r\n\r\n        li + li {\r\n            margin-top: 10px;\r\n            color: #000000;\r\n        }\r\n\r\n        a {\r\n            color: #1155cc;\r\n        }\r\n\r\n        .opps-footnote {\r\n            margin-top: 22px;\r\n            padding: 22px 20 24px;\r\n            color: #108f30;\r\n            text-align: center;\r\n            border: 1px solid #108f30;\r\n            border-radius: 4px;\r\n            background: #ffffff;\r\n        }\r\n    </style>\r\n    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,600,700\" rel=\"stylesheet\">\r\n</head>\r\n\r\n<body>\r\n    <div class=\"opps\">\r\n        <div class=\"opps-header\">\r\n            <div class=\"opps-reminder\">Ficha digital. No es necesario imprimir.</div>\r\n            <div class=\"opps-info\">\r\n                <div class=\"opps-brand\"><img src=\"https://github.com/conekta-examples/oxxopay-payment-stub/blob/master/demo/oxxopay_brand.png?raw=true\" alt=\"OXXOPay\"></div>\r\n                <div class=\"opps-ammount\">\r\n                    <h3>Monto pagado</h3>\r\n                    <h2>$" + 
      
      monto + "<sup>MXN</sup></h2>\r\n" + 
      "                    <p>OXXO cobrara una comision adicional al momento de realizar el pago.</p>\r\n" + 
      "                </div>\r\n" + 
      "            </div><br><br><strong>" + Titular + "</strong><br>ID: " + idUsuario + "<br>Membres" + Membresia + "<br>" + "oxxo+\"<br>\r\n" + 
      "            <div class=\"opps-reference\">\r\n" + 
      "                <h3>Referencia</h>\r\n" + 
      "                    <h1>" + referencia + "</h1>\r\n" + 
      "            </div><br>\r\n" + 
      "        </div>\r\n" + 
      "        <div class=\"opps-instructions\">\r\n" + 
      "            \t<h3><center>" + dia + "/" + mes + "/" + a + "</center></h3>\r\n" + 
      "\t\t\t\t   <li>Confirmamos que tu pago se registrde forma exitosa.</li>\r\n" + 
      "\t\t\t\t\t<li>Si deseas facturar tu recibo, aqutienes los datos que necesitas:<br>Da clic aqu<a href=\"http://facturadoralpha.com/\">facturadoralpha.com</a> </li>\r\n" + 
      "                <li>Recuerda que tu recibo estardisponible para facturar sdurante el mes en el que hiciste tu pago.</li>\r\n" + 
      "                <li>Ben</li>\r\n" + 
      "\t\t\t\t\t<a href=\"https://www.facebook.com/ClubsAlpha\" class=\"nav-link\" target=\"_blank\"><img src=\"https://img.icons8.com/color/48/000000/facebook.png\"></a>\r\n" + 
      "\t\t\t\t\t<a href=\"https://twitter.com/clubs_alpha\" class=\"nav-link\" target=\"_blank\"><img src=\"https://img.icons8.com/fluent/48/000000/twitter.png\"/></a>\r\n" + 
      "\t\t\t\t\t<a href=\"https://www.instagram.com/clubs_alpha/\" class=\"nav-link\" target=\"_blank\"><img src=\"https://img.icons8.com/fluent/48/000000/instagram-new.png\"/></a>\r\n" + 
      "\t\t\t\t\t<a href=\"https://www.youtube.com/channel/UCsOHnVAqylhPuJSA_9SiN_A\" class=\"nav-link\" target=\"_blank\"><img src=\"https://img.icons8.com/color/48/000000/youtube-play.png\"/></a>\r\n" + 
      "\t\t\t\t\t<a href=\"https://open.spotify.com/playlist/61qFDt0ITvumda9vmB0oWV\" class=\"nav-link\" target=\"_blank\"><img src=\"https://img.icons8.com/fluent/48/000000/spotify.png\"/></a>\r\n" + 
      "            \r\n" + 
      "            <div class=\"opps-footnote\"><img src=\"https://www.clubalpha.com.mx/images/logo_positivo2.png\"\r\n" + 
      "                    alt=\"OXXOPay\"></div>\r\n" + 
      "        </div>\r\n" + 
      "    </div>\r\n" + 
      "</body>\r\n" + 
      "\r\n" + 
      "</html>";
    MimeMessage mail = new MimeMessage(sesion);
    try {
      mail.setFrom((Address)new InternetAddress(this.correoEnvia));
      mail.addRecipients(Message.RecipientType.BCC, (Address[])new InternetAddress[] { new InternetAddress(this.destinatario) });
      mail.setSubject(asunto);
      mail.setContent(mensaje, "text/html");
      Transport transporte = sesion.getTransport("smtp");
      transporte.connect(this.correoEnvia, this.contrasena);
      transporte.sendMessage((Message)mail, mail.getRecipients(Message.RecipientType.BCC));
      transporte.close();
    } catch (AddressException ex) {
      Logger.getLogger(com.webHook.Correo.Correo.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
    } catch (MessagingException ex) {
      Logger.getLogger(com.webHook.Correo.Correo.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
    } 
  }
}