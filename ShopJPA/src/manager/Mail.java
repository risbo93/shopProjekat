package manager;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import model.Kupovina;
import model.Stavka;

public class Mail {
	
	public static String listaProizvoda(List<Stavka> listaStavki) {
		String recenica="";
		for (Stavka stavka : listaStavki) {
			recenica+="<p>Naziv: "+stavka.getStvari().getNaziv()+", cena: "+stavka.getStvari().getCena()+", kolicina: "+stavka.getKolicina()+". </p>";
		}
		return recenica;
	}
	
	public static void sendMail(Kupovina kupovina, List<Stavka> listaStavki) throws AddressException, MessagingException {
		final String username = "mailzaprogramiranje@gmail.com";
		final String password = "boris543";
	
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable", "true"); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.port", "587");  
		props.put("mail.debug", "true");  
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("mailzaprogramiranje@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(kupovina.getDostava().getEmail()));
			msg.setSubject("Obavestenje");
			
			BodyPart msgBodyPart = new MimeBodyPart();
			String message = "<html> <head><h1>Izvestaj o porudzbini</h1></head><body><p>Imate poruzbinu preko vase dostave:</p></p><p><h3>"+listaProizvoda(listaStavki)+"<h3></p><p><strong>Ukupna cena: "+StavkaManager.cenaStavkiOsobe(listaStavki)+" rsd</strong></p><img src=\"https://ww1.prweb.com/prfiles/2010/03/29/3140524/webstorelogo.jpg\"></body></html>";
			msgBodyPart.setContent(message,"text/html");
			
			Multipart multipart = new MimeMultipart();
		 	
		 	//set text message part
		 	multipart.addBodyPart(msgBodyPart);
		 	msg.setContent(multipart);
		 	Transport.send(msg);
		}catch(MessagingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws AddressException, MessagingException {
		List<Stavka> listaStavkiKupovine = StavkaManager.getStavkasByIdKupovina(1);
		sendMail(KupovinaManager.getKupovinaById(1),listaStavkiKupovine);
	}
}
