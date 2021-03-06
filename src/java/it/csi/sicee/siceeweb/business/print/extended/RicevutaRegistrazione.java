/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceeweb.business.print.extended;

import it.csi.sicee.siceeweb.business.print.dto.GenericDto;
import it.csi.sicee.siceeweb.business.print.dto.RicevutaAcquistoAceDto;
import it.csi.sicee.siceeweb.business.print.dto.RicevutaRegistrazioneDto;
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.Converter;
import it.csi.sicee.siceeweb.util.GenericUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

// TODO: Auto-generated Javadoc
/**
 * The Class RicevutaRegistrazione.
 */
public class RicevutaRegistrazione extends BaseExtendedPdf{
	
	/** The Constant log. */
	protected static final Logger log = Logger
	.getLogger(Constants.APPLICATION_CODE + ".business");

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#stampaModulo(it.csi.sicee.siceeweb.business.print.dto.GenericDto, com.lowagie.text.pdf.PdfReader, java.lang.String, boolean)
	 */
	@Override
	public ByteArrayInputStream stampaModulo(GenericDto dati,
			PdfReader reader, String sfondo, boolean foto)
			throws IOException, DocumentException {
		
		/*PdfStamper stamper = getStamper(reader, baos);
		AcroFields form = stamper.getAcroFields();
		
		RicevutaRegistrazioneDto dto = (RicevutaRegistrazioneDto) dati;
		
		form.setField(RicevutaRegistrazioneDto.DATA_ACQUISTO, dto.getDataAcquisto());
		form.setField(RicevutaRegistrazioneDto.MATRICOLA, dto.getMatricola());
		form.setField(RicevutaRegistrazioneDto.NOME, dto.getNome());
		form.setField(RicevutaRegistrazioneDto.FIRMA, dto.getFirma());
		
			
		stamper.close();*/
		createPdf(dati);
		addLogoAndPageNumber(dati);
		
		return new ByteArrayInputStream(baosStamper.toByteArray());
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#getTemplateFilename()
	 */
	@Override
	public String getTemplateFilename() {
		return "template_acquisto_registrazione.pdf";
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#checkGenericDto(it.csi.sicee.siceeweb.business.print.dto.GenericDto)
	 */
	@Override
	public boolean checkGenericDto(GenericDto dati) {		
		return dati instanceof RicevutaRegistrazioneDto;
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#createPdf(it.csi.sicee.siceeweb.business.print.dto.GenericDto)
	 */
	@Override
	protected Document createPdf(GenericDto dati) throws DocumentException {
		Document doc = new Document(PageSize.A4, 50f, 50f, 100f, 120f);

		try {
			writeToPdf(doc);

			addMetaData(doc);

			addTitlePage(doc);
			
			addContentPage(doc, dati);

			addFooterPage(doc);

			doc.close();
		} catch (Exception e) {
			log.error("", e);
		}

		return doc;
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addContentPage(com.lowagie.text.Document, it.csi.sicee.siceeweb.business.print.dto.GenericDto)
	 */
	@Override
	protected void addContentPage(Document document, GenericDto dati)
			throws DocumentException {
		Paragraph p = new Paragraph();
		Paragraph par = null;
		p.setAlignment(Element.ALIGN_JUSTIFIED);

		addEmptyLine(p, 2);

		RicevutaRegistrazioneDto dto = (RicevutaRegistrazioneDto) dati;

		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append("Data pagamento: " + dto.getDataAcquisto() + "\n");
		strBuffer.append("Certificatore: " + dto.getNome() + "\n");
		strBuffer.append("Numero matricola: " + dto.getMatricola() + "\n");
		
		par = new Paragraph(strBuffer.toString(), this.contentFont);
		p.add(par);
		addEmptyLine(p, 1);		
		
		par = new Paragraph("Si attesta che il certificatore ha effettuato il pagamento di " + Converter.convertToString(dto.getValore()) + " euro per l'iscrizione annuale.", this.contentFont);
		p.add(par);
		addEmptyLine(p, 1);
		document.add(p);
		
		
		if (document.isOpen()) {
			document.newPage();
		} else {
			log.warn("� impossibile aggiungere la title page: lo stream di Document non � aperto!");
		}
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addFooterPage(com.lowagie.text.Document)
	 */
	@Override
	protected void addFooterPage(Document doc) throws DocumentException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addTitlePage(com.lowagie.text.Document)
	 */
	@Override
	protected void addTitlePage(Document document) throws DocumentException {
		Paragraph p = new Paragraph();
		p.setAlignment(Element.ALIGN_CENTER);

		Paragraph par = new Paragraph("RICEVUTA PAGAMENTO ONERE ANNUALE DI ISCRIZIONE ALL'ELENCO REGIONALE CERTIFICATORI", this.chapterFont);

		p.add(par);

		if (document.isOpen()) {
			document.add(p);
		} else {
			log.warn("� impossibile aggiungere la title page: lo stream di Document non � aperto!");
		}
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addMetaData(com.lowagie.text.Document)
	 */
	@Override
	protected void addMetaData(Document document) throws DocumentException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addLogoAndPageNumber(it.csi.sicee.siceeweb.business.print.dto.GenericDto)
	 */
	@Override
	protected PdfStamper addLogoAndPageNumber(GenericDto dati)
			throws DocumentException {
		PdfStamper stamp = null;
		try {
			RicevutaRegistrazioneDto dto = (RicevutaRegistrazioneDto) dati;
			// crea un'istanza di PdfReader: consente la lettura del PDF			
			PdfReader reader = new PdfReader(baos.toByteArray());

			int n = reader.getNumberOfPages();
			// crea un'istanza del PdfStamper: consente la copia della
			// pagina in un nuovo stream
			baosStamper = new ByteArrayOutputStream();
			stamp = getStamper(reader, baosStamper);
			int i = 1;

			// carica l'immagine usata come Logo
			Image img = null;
			if (!GenericUtil.isNullOrEmpty(dati.getLogo())) {
				img = Image.getInstance(dati.getLogo());
				img.setAbsolutePosition(40f, 750f);
				img.scaleAbsolute(90f, 90f);
				img.setAlignment(0);
			}
			baseFont = BaseFont.createFont(BaseFont.TIMES_ITALIC, BaseFont.WINANSI,
					BaseFont.EMBEDDED);

			PdfContentByte under = null;

			while (i <= n) {
				// recupera il contenuto in byte del nuovo PDF...
				under = stamp.getUnderContent(i);
				if (!GenericUtil.isNullOrEmpty(img)) {
					under.addImage(img);
				}

				getUnderText(under, "Pagina " + i + " di " + n, 250f, 40f);

				if (i == n) {

					getUnderText(under, "Torino, " + dto.getDataOdierna(),

							50f, 130f, 10);
					getUnderText(under, dto.getFirma(), 400f, 130f, 10);
					int j = 0;
					for (String id:dto.getSede()) {
						getUnderText(under, id, 400f, 120f - (10 * j++), 10);
					}
				}

				i++;
			}

			stamp.close();
		} catch (Exception e) {
			log.error("", e);
		}

		return stamp;
	}





}
