/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/**
 * 
 */
package it.csi.sicee.siceeweb.util;




import it.csi.sicee.siceeorch.dto.siceeorch.Documento;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class MailSender.
 *
 * @author 70140
 */
public class MailSender implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3596869004264743871L;
	
	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE+ ".business");
	
	/**
	 * Send mail.
	 *
	 * @param emailVo the email vo
	 * @param doc the doc
	 * @throws Exception the exception
	 */
	public void sendMail(it.csi.sicee.siceeweb.util.Mail emailVo, Documento doc) throws Exception {
		log.debug("[MailSender::sendMail] BEGIN");
		//GenericUtil.stampaVO(emailVO);	
        // Create a mail session
		File allegato = null;
		
		try {
        java.util.Properties props = new java.util.Properties();        
        props.put("mail.smtp.host", emailVo.getHost());
        props.put("mail.smtp.port", emailVo.getPort());
        Session session = Session.getDefaultInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(emailVo.getMittente()));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailVo.getDestinatario()));
        if(StringUtils.isNotEmpty(emailVo.getDestinatarioCC())){
        	msg.setRecipient(Message.RecipientType.CC, new InternetAddress(emailVo.getDestinatarioCC()));
        }
        msg.setSubject(emailVo.getOggetto());
        MimeMultipart  mp = new MimeMultipart();
        
       
        MimeBodyPart html = new MimeBodyPart();
        html.setText(emailVo.getTesto(), "text/plain");                
        html.setContent(emailVo.getHtml(),"text/html");
        


        
        
     // create and fill the second message part
        if (doc != null) {
        	MimeBodyPart attachmentPart = new MimeBodyPart();

//			JIRA SICEE-515
        	allegato = createFileWithData(doc);
        	
        	FileDataSource fileDataSource = new FileDataSource(allegato) {
        	                @Override
        	                public String getContentType() {
        	                    return "application/xml";
        	                }
        	            };
        	            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
        	            attachmentPart.setFileName(doc.getNome());        	            
        	mp.addBodyPart(attachmentPart);
        }
     // create the Multipart and its parts to it
        
        //mp.addBodyPart(text);
        mp.addBodyPart(html);
        
        // add the Multipart to the message
        msg.setContent(mp);        
        
		// Aggiunto questo comando per risolvere il problema di invio mail
        log.debug("[MailSender::sendMail] - stampo il ContextClassLoader: "+Thread.currentThread().getContextClassLoader());
		if (Thread.currentThread().getContextClassLoader() == null)
		{
			log.debug("[MailSender::sendMail] - stampo il this.getClass().getClassLoader(): "+this.getClass().getClassLoader());

			Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
			
			log.debug("[MailSender::sendMail] - stampo il ContextClassLoader - dopo: "+Thread.currentThread().getContextClassLoader());
		}
        // Send the message
        Transport.send(msg);
		} catch (Exception e) {
			log.error("Errore nell'invio della mail", e);
			throw e;
		} finally {
//			JIRA SICEE-515
			if (allegato != null && allegato.exists()) {
				boolean isDelete = allegato.delete();
				
				if (log.isDebugEnabled()) {					
					log.debug("[MailSender::sendMail] "+allegato+": file.delete(): "+isDelete);
				}
			}
			log.debug("[MailSender::sendMail] END");
		}
                
	}
	
	
	
	/**
	 * Creates the file with data.
	 *
	 * @param doc the doc
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private File createFileWithData(Documento doc) throws IOException
	{		
		int pos = doc.getNome().lastIndexOf(".");
		File file = File.createTempFile(doc.getNome(), doc.getNome().substring(pos));
//		file.deleteOnExit();
		OutputStream src = new FileOutputStream(file);
		src.write(doc.getDoc());
		src.close();
		return file;
	}
	
	/*public static void main(String[] args) {
		MailSender ms = new MailSender();
		try {
			
			Mail emailVO = new Mail();
			emailVO.setDestinatario("marco.boz@csi.it");
			emailVO.setDestinatarioCC("");
			emailVO.setHost("mailtest.csi.it");
			emailVO.setPort("25");
			emailVO.setMittente("visitors@visitors.org");
			emailVO.setOggetto("Greetings");
			emailVO.setTesto("We are for peace, always,We are the V");
			String msg = "<BODY><P >Buongiorno sig. @nome.notaio@ @cognome.notaio@,<BR></P><P >come da richiesta effettuata tramite SICEE, la presente per inviarle l'ACE numero @codice.ace@ trasmesso dal certificatore @nome.certificatore@ @cognome.certificatore@ il giorno @data.invio@.</P><P >In allegato si riporta l'ACE originale firmato digitalmente dal certificatore e la ricevuta di trasmissione.</P><P >La verifica della firma digitale pu&ograve; essere effettuata con il software DiKe, il programma sviluppato da InfoCert, oppure con la funzione di verifica on line presente nella sezione Servizi per gli utenti sul sito di InfoCert.<BR></P><P >Per ulteriori informazioni <A HREF=\"https://www.firma.infocert.it/guida/verificare_firma.php\">cliccare qui</A><I> </I></P><P >Inoltre, di seguito &egrave; riportata la copia della ricevuta di trasmissione dell'ACE richiesto</P><P ><BR></P><P><B>Ricevuta Codici ACE</B></P><P ><BR></P><P >Buongiorno, con la presente si attesta che il certificato @codice.ace@ firmato digitalmente da @nome.certificatore@ @cognome.certificatore@ &egrave; stato correttamente ricevuto dal SICEE in data @data.trasmissione@</P><P ><BR></P><P >Dott.Roberto Quaglia</P><P >Regione Piemonte</P><P >Settore politiche energetiche</P><P >Via G. Pomba 29 - 10123</P><P >Torino</P><P ><BR></P><P >Distinti saluti</P></BODY>";
			msg = msg.replaceAll("@cr@", "");
			log.debug(msg);
			emailVO.setHtml(msg);
			Documento doc = new Documento();
			doc.setNome("pippo.txt");
			doc.setDoc("Prova".getBytes());
			ms.sendMail(emailVO, doc);
		} catch (Exception e) {
			log.error(e);
		}
	}*/

	
}
