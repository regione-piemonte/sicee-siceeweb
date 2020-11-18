/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.presentation.siceeweb.action.pdf.dto;

import java.util.Collection;
import java.util.Vector;

public class Attestato {

	String numCertificato;
	String validoFinaAl;
	boolean isResidenziale;
	String descClassificazione;
	int idOggetto;
	int numeroUI;
	String idMotivazione;
	String descMotivazioneAltro;
	
	String descRegione;
	String descComune;
	String indirizzo;
	String piano;
	String interno;
	String coordinate;
	
	String zonaClimatica;
	int annoCostruzione;
	String supUtileRisc;
	String supUtileRaffr;
	String volLordoRisc;
	String volLordoRaffr;

	Collection catasto;
	Catasto catasto1;
	Catasto catasto2;
	Catasto catasto3;
	Catasto catasto4;

	boolean isSerClimaInvernale;
	boolean isSerClimaEstivo;
	boolean isSerVentola;
	boolean isSerAcquaCalda;
	boolean isSerIlluminazione;
	boolean isSerTrasporto;
	
	String smileInverno;
	String smileEstate;
	
	boolean isEdifEnergZero;
	
	String classeEnergetica;
	String epglnren;
	
	String classeEdNuovi;
	String epglnrenEdNuovi;
	
	String classeEdEsistenti;
	String epglnrenEdEsistenti;
	String frecciaClasse;
	
	
	public static Collection generaAttestato()
    {
		/*
        Vector students = new Vector();
        try
        {
        	//org.objectweb.asm.Opcodes
        	//com.lowagie.text.SplitCharacter
        	Indirizzo ind = new Indirizzo();
            
        	Student student = new Student();
            student.setRoll_no("101");
            student.setName("Steve");
            student.setFathers_name("Jack");
            student.setStudying_in("I-A");
            student.setZodiaco("toro");
            student.setEta(22);
            ind.setSedime("Corso");
            ind.setVia("Unione Sovietica");
            student.setIndirizzo(ind);
            
            students.add(student);
            student = new Student();
            student.setRoll_no("102");
            student.setName("Mark");
            student.setFathers_name("Henry");
            student.setStudying_in("I-A");
            student.setZodiaco("capricorno");

            student.setEta(40);

            ind = new Indirizzo();
            ind.setSedime("Via");
            ind.setVia("Roma");
            student.setIndirizzo(ind);
            
            students.add(student);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return students;
        */
		
		Vector attestatoVector = new Vector();
		
		Attestato attestato = new Attestato();
		
		attestato.setNumCertificato("2014 301441 0032");
		attestato.setValidoFinaAl("12/04/2022");
		attestato.setResidenziale(true);
		attestato.setDescClassificazione("E1(2) Abitazioni adibite a residenza con occupazione saltuaria, quali case per vacanze, fine settimana e simili");
		attestato.setIdOggetto(2);
		attestato.setNumeroUI(3);
		attestato.setIdMotivazione("101");
		attestato.setDescMotivazioneAltro("prova");
		
		attestato.setZonaClimatica("A");
		attestato.setAnnoCostruzione(2000);
		attestato.setSupUtileRisc("6.61");
		attestato.setSupUtileRaffr("13,76");
		attestato.setVolLordoRisc("32,65");
		attestato.setVolLordoRaffr("2,6");
		
		attestato.setDescRegione("PIEMONTE");
		attestato.setDescComune("TORINO");
		attestato.setIndirizzo("CORSO UNIONE SOVIETICA");
		attestato.setPiano("1");
		attestato.setInterno("/E");
		attestato.setCoordinate("53.6 78.6");

		
		Catasto cat1 = new Catasto();
		cat1.setCodCatasto("L219");
		cat1.setSezione("1");
		cat1.setFoglio("2");
		cat1.setParticella("3");
		cat1.setSubalterno1Da("4");
		cat1.setSubalterno1A("50");
		
		cat1.setSubalterno2Da("51");
		cat1.setSubalterno2A("150");
		
		cat1.setSubalterno3Da("152");
		cat1.setSubalterno3A("500");
		
		cat1.setSubalterno4Da("501");
		cat1.setSubalterno4A("900");
		
		cat1.setAltroSub1("991");
		cat1.setAltroSub2("992");
		cat1.setAltroSub3("993");
		cat1.setAltroSub4("994");
		cat1.setAltroSub5("995");
		cat1.setAltroSub6("996");
		cat1.setAltroSub7("997");
		cat1.setAltroSub8("998");
		cat1.setAltroSub9("999");
		cat1.setAltroSub10("1000");

		cat1.setAltroSub11("1001");
		cat1.setAltroSub12("1002");
		cat1.setAltroSub13("1003");
		cat1.setAltroSub14("1004");
		cat1.setAltroSub15("1005");
		cat1.setAltroSub16("1006");
		cat1.setAltroSub17("1007");
		cat1.setAltroSub18("1008");
		cat1.setAltroSub19("1009");
		cat1.setAltroSub20("1010");

		Vector catastoColl = new Vector();
		catastoColl.add(cat1);
//		catastoColl.add(cat1);
//		catastoColl.add(cat1);
//		catastoColl.add(cat1);
//		catastoColl.add(cat1);
//		catastoColl.add(cat1);
		attestato.setCatasto(catastoColl);
//		attestato.setCatasto1(cat1);
//		attestato.setCatasto2(cat1);
		
		attestato.setSerClimaInvernale(false);
		attestato.setSerClimaEstivo(true);
		attestato.setSerVentola(false);
		attestato.setSerAcquaCalda(false);
		attestato.setSerIlluminazione(true);
		attestato.setSerTrasporto(true);
		
		attestato.setSmileInverno("smile_felice_new.png");
		attestato.setSmileEstate("smile_felice_new.png");
		
		attestato.setEdifEnergZero(true);
		
		attestato.setClasseEnergetica("A4");
		attestato.setFrecciaClasse("classe" + attestato.getClasseEnergetica() + ".png");

		attestato.setEpglnren("324,89");
		
		attestato.setClasseEdNuovi("C");
		attestato.setEpglnrenEdNuovi("893,23");
		
		attestato.setClasseEdEsistenti("B");
		attestato.setEpglnrenEdEsistenti("65,98");
		
		attestatoVector.add(attestato);
		
		return attestatoVector;
		
    }
	
	public static Collection getCatastoColl()
    {
		/*
        Vector students = new Vector();
        try
        {
        	//org.objectweb.asm.Opcodes
        	//com.lowagie.text.SplitCharacter
        	Indirizzo ind = new Indirizzo();
            
        	Student student = new Student();
            student.setRoll_no("101");
            student.setName("Steve");
            student.setFathers_name("Jack");
            student.setStudying_in("I-A");
            student.setZodiaco("toro");
            student.setEta(22);
            ind.setSedime("Corso");
            ind.setVia("Unione Sovietica");
            student.setIndirizzo(ind);
            
            students.add(student);
            student = new Student();
            student.setRoll_no("102");
            student.setName("Mark");
            student.setFathers_name("Henry");
            student.setStudying_in("I-A");
            student.setZodiaco("capricorno");

            student.setEta(40);

            ind = new Indirizzo();
            ind.setSedime("Via");
            ind.setVia("Roma");
            student.setIndirizzo(ind);
            
            students.add(student);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return students;
        */
		
		Vector catastoVector = new Vector();
		
		
		
		Catasto cat1 = new Catasto();
		cat1.setCodCatasto("L219");
		cat1.setSezione("1");
		cat1.setFoglio("2");
		cat1.setParticella("3");
		cat1.setSubalterno1Da("4");
		cat1.setSubalterno1A("50");
		
		cat1.setSubalterno2Da("51");
		cat1.setSubalterno2A("150");
		
		cat1.setSubalterno3Da("152");
		cat1.setSubalterno3A("500");
		
		cat1.setSubalterno4Da("501");
		cat1.setSubalterno4A("900");
		
		cat1.setAltroSub1("991");
		cat1.setAltroSub2("992");
		cat1.setAltroSub3("993");
		cat1.setAltroSub4("994");
		cat1.setAltroSub5("995");
		cat1.setAltroSub6("996");
		cat1.setAltroSub7("997");
		cat1.setAltroSub8("998");
		cat1.setAltroSub9("999");
		cat1.setAltroSub10("1000");

		cat1.setAltroSub11("1001");
		cat1.setAltroSub12("1002");
		cat1.setAltroSub13("1003");
		cat1.setAltroSub14("1004");
		cat1.setAltroSub15("1005");
		cat1.setAltroSub16("1006");
		cat1.setAltroSub17("1007");
		cat1.setAltroSub18("1008");
		cat1.setAltroSub19("1009");
		cat1.setAltroSub20("1010");

		catastoVector.add(cat1);
		catastoVector.add(cat1);
		//catastoVector.add(cat1);
//		catastoVector.add(cat1);
//		catastoVector.add(cat1);
//		catastoVector.add(cat1);
//		catastoVector.add(cat1);
		
		return catastoVector;
		
    }
	
	public String getNumCertificato() {
		return numCertificato;
	}
	public void setNumCertificato(String numCertificato) {
		this.numCertificato = numCertificato;
	}
	public String getValidoFinaAl() {
		return validoFinaAl;
	}
	public void setValidoFinaAl(String validoFinaAl) {
		this.validoFinaAl = validoFinaAl;
	}
	public boolean isResidenziale() {
		return isResidenziale;
	}
	public void setResidenziale(boolean isResidenziale) {
		this.isResidenziale = isResidenziale;
	}
	public String getDescClassificazione() {
		return descClassificazione;
	}
	public void setDescClassificazione(String descClassificazione) {
		this.descClassificazione = descClassificazione;
	}
	public int getIdOggetto() {
		return idOggetto;
	}
	public void setIdOggetto(int idOggetto) {
		this.idOggetto = idOggetto;
	}
	public int getNumeroUI() {
		return numeroUI;
	}
	public void setNumeroUI(int numeroUI) {
		this.numeroUI = numeroUI;
	}
	public String getIdMotivazione() {
		return idMotivazione;
	}
	public void setIdMotivazione(String idMotivazione) {
		this.idMotivazione = idMotivazione;
	}
	public String getDescMotivazioneAltro() {
		return descMotivazioneAltro;
	}
	public void setDescMotivazioneAltro(String descMotivazioneAltro) {
		this.descMotivazioneAltro = descMotivazioneAltro;
	}
	public String getZonaClimatica() {
		return zonaClimatica;
	}
	public void setZonaClimatica(String zonaClimatica) {
		this.zonaClimatica = zonaClimatica;
	}
	public int getAnnoCostruzione() {
		return annoCostruzione;
	}
	public void setAnnoCostruzione(int annoCostruzione) {
		this.annoCostruzione = annoCostruzione;
	}
	public String getSupUtileRisc() {
		return supUtileRisc;
	}
	public void setSupUtileRisc(String supUtileRisc) {
		this.supUtileRisc = supUtileRisc;
	}
	public String getSupUtileRaffr() {
		return supUtileRaffr;
	}
	public void setSupUtileRaffr(String supUtileRaffr) {
		this.supUtileRaffr = supUtileRaffr;
	}
	public String getVolLordoRisc() {
		return volLordoRisc;
	}
	public void setVolLordoRisc(String volLordoRisc) {
		this.volLordoRisc = volLordoRisc;
	}
	public String getVolLordoRaffr() {
		return volLordoRaffr;
	}
	public void setVolLordoRaffr(String volLordoRaffr) {
		this.volLordoRaffr = volLordoRaffr;
	}
	public String getDescRegione() {
		return descRegione;
	}
	public void setDescRegione(String descRegione) {
		this.descRegione = descRegione;
	}
	public String getDescComune() {
		return descComune;
	}
	public void setDescComune(String descComune) {
		this.descComune = descComune;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getPiano() {
		return piano;
	}
	public void setPiano(String piano) {
		this.piano = piano;
	}
	public String getInterno() {
		return interno;
	}
	public void setInterno(String interno) {
		this.interno = interno;
	}
	
	
	
	
	public void setCatasto(Collection catasto) {
		this.catasto = catasto;
	}
	
	public Collection getCatasto() {
		return catasto;
	}
	
	public Catasto getCatasto1() {
		return catasto1;
	}
	public void setCatasto1(Catasto catasto1) {
		this.catasto1 = catasto1;
	}
	public Catasto getCatasto2() {
		return catasto2;
	}
	public void setCatasto2(Catasto catasto2) {
		this.catasto2 = catasto2;
	}
	public Catasto getCatasto3() {
		return catasto3;
	}
	public void setCatasto3(Catasto catasto3) {
		this.catasto3 = catasto3;
	}
	public Catasto getCatasto4() {
		return catasto4;
	}
	public void setCatasto4(Catasto catasto4) {
		this.catasto4 = catasto4;
	}
	
	
	
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	public boolean isSerClimaInvernale() {
		return isSerClimaInvernale;
	}
	public void setSerClimaInvernale(boolean isSerClimaInvernale) {
		this.isSerClimaInvernale = isSerClimaInvernale;
	}
	public boolean isSerClimaEstivo() {
		return isSerClimaEstivo;
	}
	public void setSerClimaEstivo(boolean isSerClimaEstivo) {
		this.isSerClimaEstivo = isSerClimaEstivo;
	}
	public boolean isSerVentola() {
		return isSerVentola;
	}
	public void setSerVentola(boolean isSerVentola) {
		this.isSerVentola = isSerVentola;
	}
	public boolean isSerAcquaCalda() {
		return isSerAcquaCalda;
	}
	public void setSerAcquaCalda(boolean isSerAcquaCalda) {
		this.isSerAcquaCalda = isSerAcquaCalda;
	}
	public boolean isSerIlluminazione() {
		return isSerIlluminazione;
	}
	public void setSerIlluminazione(boolean isSerIlluminazione) {
		this.isSerIlluminazione = isSerIlluminazione;
	}
	public boolean isSerTrasporto() {
		return isSerTrasporto;
	}
	public void setSerTrasporto(boolean isSerTrasporto) {
		this.isSerTrasporto = isSerTrasporto;
	}
	
	
	public String getSmileInverno() {
		return smileInverno;
	}

	public void setSmileInverno(String smileInverno) {
		this.smileInverno = smileInverno;
	}

	public String getSmileEstate() {
		return smileEstate;
	}

	public void setSmileEstate(String smileEstate) {
		this.smileEstate = smileEstate;
	}

	public boolean isEdifEnergZero() {
		return isEdifEnergZero;
	}
	public void setEdifEnergZero(boolean isEdifEnergZero) {
		this.isEdifEnergZero = isEdifEnergZero;
	}
	public String getClasseEnergetica() {
		return classeEnergetica;
	}
	public void setClasseEnergetica(String classeEnergetica) {
		this.classeEnergetica = classeEnergetica;
	}
	public String getEpglnren() {
		return epglnren;
	}
	public void setEpglnren(String epglnren) {
		this.epglnren = epglnren;
	}
	public String getClasseEdNuovi() {
		return classeEdNuovi;
	}
	public void setClasseEdNuovi(String classeEdNuovi) {
		this.classeEdNuovi = classeEdNuovi;
	}
	public String getEpglnrenEdNuovi() {
		return epglnrenEdNuovi;
	}
	public void setEpglnrenEdNuovi(String epglnrenEdNuovi) {
		this.epglnrenEdNuovi = epglnrenEdNuovi;
	}
	public String getClasseEdEsistenti() {
		return classeEdEsistenti;
	}
	public void setClasseEdEsistenti(String classeEdEsistenti) {
		this.classeEdEsistenti = classeEdEsistenti;
	}
	public String getEpglnrenEdEsistenti() {
		return epglnrenEdEsistenti;
	}
	public void setEpglnrenEdEsistenti(String epglnrenEdEsistenti) {
		this.epglnrenEdEsistenti = epglnrenEdEsistenti;
	}
	public String getFrecciaClasse() {
		return frecciaClasse;
	}
	public void setFrecciaClasse(String frecciaClasse) {
		this.frecciaClasse = frecciaClasse;
	}
}
