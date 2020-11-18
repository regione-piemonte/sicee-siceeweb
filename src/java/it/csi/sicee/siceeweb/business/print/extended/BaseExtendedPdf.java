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
import it.csi.sicee.siceeweb.util.Constants;
import it.csi.sicee.siceeweb.util.GenericUtil;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseExtendedPdf.
 */
public abstract class BaseExtendedPdf {
	
	/** The Constant log. */
	protected static final Logger log = Logger
	.getLogger(Constants.APPLICATION_CODE + ".business");
	
	/** The servlet context. */
	private ServletContext servletContext;
	
	/** The title. */
	private String title;
	
	/** The subject. */
	private String subject;
	
	/** The keyword. */
	private String keyword;
	
	/** The author. */
	private String author;
	
	/** The creator. */
	private String creator;
	
	/** The section font. */
	protected Font sectionFont = new Font(Font.HELVETICA, 12, Font.NORMAL);
	
	/** The chapter font. */
	protected Font chapterFont = new Font(Font.HELVETICA, 12, Font.BOLD);
	
	/** The footer font. */
	protected Font footerFont = new Font(Font.HELVETICA, 10, Font.ITALIC);
	
	/** The header table font. */
	protected Font headerTableFont = new Font(Font.HELVETICA, 8, Font.BOLD);
	
	/** The row table font. */
	protected Font rowTableFont = new Font(Font.HELVETICA, 8, Font.NORMAL);
	
	/** The content font. */
	protected Font contentFont = new Font(Font.HELVETICA, 10, Font.NORMAL);
	
	/** The base font. */
	protected BaseFont baseFont = null;

	/** The baos. */
	protected ByteArrayOutputStream baos;
	
	/** The baos stamper. */
	protected ByteArrayOutputStream baosStamper;
	
	
	/**
	 * Gets the servlet context.
	 *
	 * @return the servlet context
	 */
	public final ServletContext getServletContext() {
		return servletContext;
	}

	/**
	 * Sets the servlet context.
	 *
	 * @param servletContext the new servlet context
	 */
	public final void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * Gets the file path.
	 *
	 * @param servletContext the servlet context
	 * @return the file path
	 */
	protected final InputStream getFilePath(ServletContext servletContext) {
		if (getTemplateFilename() == null) {
			throw new IllegalArgumentException("Metodo getTemplateFilename non ridefinito!");
		}
		
		InputStream myPath = servletContext.getResourceAsStream("/template/"
				+ getTemplateFilename());

		return myPath;
	}
	
	/**
	 * Gets the file path.
	 *
	 * @param fileName the file name
	 * @param servletContext the servlet context
	 * @return the file path
	 */
	protected final InputStream getFilePath(String fileName, ServletContext servletContext) {
		if (getTemplateFilename() == null) {
			throw new IllegalArgumentException("Metodo getTemplateFilename non ridefinito!");
		}
		
		InputStream myPath = servletContext.getResourceAsStream("/template/"
				+ fileName);

		return myPath;
	}
	
	/**
	 * Gets the file path.
	 *
	 * @param fileName the file name
	 * @param servletContext the servlet context
	 * @return the file path
	 */
	protected final InputStream getFilePathImg2015(String fileName, ServletContext servletContext) {
		if (getTemplateFilename() == null) {
			throw new IllegalArgumentException("Metodo getTemplateFilename non ridefinito!");
		}
		
		InputStream myPath = servletContext.getResourceAsStream("/img/attestato2015/"
				+ fileName);

		return myPath;
	}
	
	/**
	 * Stampa modulo.
	 *
	 * @param dati the dati
	 * @param servletContext the servlet context
	 * @param sfondo the sfondo
	 * @param foto the foto
	 * @return the byte array input stream
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws DocumentException the document exception
	 */
	public final ByteArrayInputStream stampaModulo(GenericDto dati,
			ServletContext servletContext, String sfondo, boolean foto) throws IOException, DocumentException {
		if (!checkGenericDto(dati)) {
			throw new IllegalArgumentException("Parametro DTO errato!");
		}
		setServletContext(servletContext);
		PdfReader reader = new PdfReader(getFilePath(servletContext));
		return stampaModulo(dati, reader, sfondo, foto);
	}
	
	/**
	 * Check generic dto.
	 *
	 * @param dati the dati
	 * @return true, if successful
	 */
	public abstract boolean checkGenericDto(GenericDto dati);
	
	/**
	 * Stampa modulo.
	 *
	 * @param dati the dati
	 * @param reader the reader
	 * @param sfondo the sfondo
	 * @param foto the foto
	 * @return the byte array input stream
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws DocumentException the document exception
	 */
	public abstract ByteArrayInputStream stampaModulo(GenericDto dati,
			PdfReader reader, String sfondo, boolean foto) throws IOException, DocumentException;
	
	/**
	 * Gets the template filename.
	 *
	 * @return the template filename
	 */
	public abstract String getTemplateFilename();
	

	/**
	 * Gets the stamper.
	 *
	 * @param reader the reader
	 * @param os the os
	 * @return the stamper
	 * @throws DocumentException the document exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected PdfStamper getStamper(PdfReader reader, OutputStream os)
			throws DocumentException, IOException {
				PdfStamper stamp;
				stamp = new PdfStamper(reader, os);
				stamp.setEncryption(PdfWriter.STRENGTH128BITS, null, null,
				        PdfWriter.AllowPrinting | PdfWriter.AllowScreenReaders);
				//ByteArrayOutputStream oss = new ByteArrayOutputStream();
				//stamp = PdfStamper.createSignature(reader, os, '\0', new File(""), true);
				return stamp;
			}
	
	/**
	 * Creates the pdf.
	 *
	 * @param dati the dati
	 * @return the document
	 * @throws DocumentException the document exception
	 */
	protected abstract Document createPdf(GenericDto dati) throws DocumentException;	
	
	/**
	 * Adds the content page.
	 *
	 * @param document the document
	 * @param dati the dati
	 * @throws DocumentException the document exception
	 */
	protected abstract void addContentPage(Document document, GenericDto dati) throws DocumentException;
	
	/**
	 * Adds the footer page.
	 *
	 * @param doc the doc
	 * @throws DocumentException the document exception
	 */
	protected abstract void addFooterPage(Document doc) throws DocumentException;
	
	/**
	 * Adds the title page.
	 *
	 * @param document the document
	 * @throws DocumentException the document exception
	 */
	protected abstract void addTitlePage(Document document) throws DocumentException;
	
	/**
	 * Adds the meta data.
	 *
	 * @param document the document
	 * @throws DocumentException the document exception
	 */
	protected abstract void addMetaData(Document document) throws DocumentException;
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the keyword.
	 *
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * Sets the keyword.
	 *
	 * @param keyword the new keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the creator.
	 *
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * Sets the creator.
	 *
	 * @param creator the new creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * Write to pdf.
	 *
	 * @param doc the doc
	 * @throws DocumentException the document exception
	 */
	protected void writeToPdf(Document doc) throws DocumentException {
		baos = new ByteArrayOutputStream();
		PdfWriter.getInstance(doc, baos);
		doc.open();
	}
	
	/**
	 * Gets the table cell.
	 *
	 * @param txt the txt
	 * @param font the font
	 * @param col the col
	 * @param colSpan the col span
	 * @return the table cell
	 */
	protected PdfPCell getTableCell(String txt, Font font, Color col, int colSpan) {
		PdfPCell cell = getTableCell(txt, font, col, colSpan, Rectangle.BOX);
		return cell;
	}
	
	/**
	 * Gets the table cell.
	 *
	 * @param txt the txt
	 * @param font the font
	 * @param col the col
	 * @param colSpan the col span
	 * @param border the border
	 * @return the table cell
	 */
	protected PdfPCell getTableCell(String txt, Font font, Color col, int colSpan, int border) {
		PdfPCell cell = getTableCell(txt, font, col, colSpan, border, Element.ALIGN_CENTER);
		return cell;
	}


	/**
	 * Gets the table cell.
	 *
	 * @param txt the txt
	 * @param font the font
	 * @param col the col
	 * @param colSpan the col span
	 * @param border the border
	 * @param alignment the alignment
	 * @return the table cell
	 */
	protected PdfPCell getTableCell(String txt, Font font, Color col, int colSpan, int border, int alignment) {
		PdfPCell cell = null;
		if (colSpan > 0) {
			cell = new PdfPCell(new Paragraph(txt, font));
			cell.setColspan(colSpan);
		} else {
			cell = new PdfPCell(new Phrase(txt, font));
		}

		cell.setBackgroundColor(col);		
		cell.setBorder(border);
		cell.setHorizontalAlignment(alignment);
		
		//cell.getDefaultCell().setBorderColor(Color.WHITE);

		return cell;
	}
	
	/**
	 * Adds the empty line.
	 *
	 * @param obj the obj
	 * @param i the i
	 * @throws DocumentException the document exception
	 */
	protected void addEmptyLine(Paragraph obj, int i) throws DocumentException {
		for (int j = 0; j < i; j++) {
			obj.add(Chunk.NEWLINE);
		}

	}
	
	/**
	 * Gets the under text.
	 *
	 * @param under the under
	 * @param txt the txt
	 * @param posx the posx
	 * @param posy the posy
	 * @return the under text
	 */
	protected void getUnderText(PdfContentByte under, String txt, float posx,
			float posy) {
		getUnderText(under, txt, posx, posy, 8);
	}
	
	/**
	 * Gets the under text.
	 *
	 * @param under the under
	 * @param txt the txt
	 * @param posx the posx
	 * @param posy the posy
	 * @param dimFont the dim font
	 * @return the under text
	 */
	protected void getUnderText(PdfContentByte under, String txt, float posx,
			float posy, int dimFont) {
		under.beginText();
		under.setTextMatrix(posx, posy);
		under.setFontAndSize(baseFont, dimFont);
		under.showText(txt);
		under.endText();
	}
	
	
	/**
	 * Adds the logo and page number.
	 *
	 * @param dati the dati
	 * @return the pdf stamper
	 * @throws DocumentException the document exception
	 */
	protected abstract PdfStamper addLogoAndPageNumber(GenericDto dati)
			throws DocumentException;
}