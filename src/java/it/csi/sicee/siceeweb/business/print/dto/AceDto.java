/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/**
 * 
 */
package it.csi.sicee.siceeweb.business.print.dto;



import java.io.InputStream;
import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AceDto.
 *
 * @author rpanebianco
 */
public class AceDto extends GenericDto implements Serializable {
	
	/** The Constant PROVINCIA. */
	public static final String PROVINCIA = "Provincia";
	
	/** The Constant COMUNE. */
	public static final String COMUNE = "Comune";
	
	/** The Constant INDIRIZZO. */
	public static final String INDIRIZZO = "Indirizzo";
	
	/** The Constant DATI_CAT_SEZ. */
	public static final String DATI_CAT_SEZ = "Dati_cat_sez";
	
	/** The Constant DATI_CAT_F. */
	public static final String DATI_CAT_F = "Dati_cat_f";
	
	/** The Constant DATI_CAT_N. */
	public static final String DATI_CAT_N = "Dati_cat_n";
	
	/** The Constant DATI_CAT_SUB. */
	public static final String DATI_CAT_SUB = "Dati_cat_sub";
	
	/** The Constant PIANO_N. */
	public static final String PIANO_N = "Piano_n";
	
	/** The Constant PIANO_DI. */
	public static final String PIANO_DI = "Piano_di";
	
	/** The Constant PROGETTISTA. */
	public static final String PROGETTISTA = "Progettista";
	
	/** The Constant DIRETTORE_LAVORI. */
	public static final String DIRETTORE_LAVORI = "Direttore_lavori";
	
	/** The Constant COSTRUTTORE. */
	public static final String COSTRUTTORE = "Costruttore";
	
	/** The Constant DESTINAZIONE_USO. */
	public static final String DESTINAZIONE_USO = "Destinazione_uso";
	
	/** The Constant ANNO_COSTRUZIONE. */
	public static final String ANNO_COSTRUZIONE = "Anno_costruzione";
	
	/** The Constant TIPOLOGIA_EDIFICIO. */
	public static final String TIPOLOGIA_EDIFICIO = "Tipologia_edificio";
	
	/** The Constant VOLUME_LORDO_RISCALDATO. */
	public static final String VOLUME_LORDO_RISCALDATO = "Volume_lordo_riscaldato";
	
	/** The Constant SUPERF_DISP_TOTALE. */
	public static final String SUPERF_DISP_TOTALE = "Superf_disp_totale";
	
	/** The Constant FATTORE_FORMA. */
	public static final String FATTORE_FORMA = "Fattore_forma";
	
	/** The Constant TRASM_MED_SUP_OP. */
	public static final String TRASM_MED_SUP_OP = "Trasm_med_sup_op";
	
	/** The Constant TRASM_MED_SUP_TRASP. */
	public static final String TRASM_MED_SUP_TRASP = "Trasm_med_sup_trasp";
	
	/** The Constant SUP_UTILE_SU_M_CUBI. */
	public static final String SUP_UTILE_SU_M_CUBI = "Sup_utile_su_m_cubi";
	
	/** The Constant ZONA_CLIM_GRADI_GIORNO. */
	public static final String ZONA_CLIM_GRADI_GIORNO = "Zona_clim_gradi_giorno";
	
	/** The Constant TIPOL_IMP_RISC. */
	public static final String TIPOL_IMP_RISC = "Tipol_imp_risc";
	
	/** The Constant COMBUSTIBILE_RISC. */
	public static final String COMBUSTIBILE_RISC = "Combustibile_risc";
	
	/** The Constant COMBUSTIBILE_ACQUA_CALDA_SAN. */
	public static final String COMBUSTIBILE_ACQUA_CALDA_SAN = "Combistibile_acqua_calda_san";
	
	/** The Constant QH. */
	public static final String QH = "Qh";
	
	/** The Constant LIMITE_LEGGE. */
	public static final String LIMITE_LEGGE = "Limite_legge";
	
	/** The Constant LIMITE_DI_LEGGE. */
	public static final String LIMITE_DI_LEGGE = "Limite_di_legge";
	
	/** The Constant QH_W. */
	public static final String QH_W = "Qh_w";
	
	/** The Constant INDICE_PREST_EN_REALE. */
	public static final String INDICE_PREST_EN_REALE = "Indice_prest_en_reale";
	
	/** The Constant QUOTA_EN_COP_F_RIN. */
	public static final String QUOTA_EN_COP_F_RIN = "Quota_en_cop_f_rin";
	
	/** The Constant CLASSE_ENERGETICA. */
	public static final String CLASSE_ENERGETICA = "Classe_energetica";
	
	/** The Constant ETTARI_BOSCO. */
	public static final String ETTARI_BOSCO = "Ettari_bosco";
	
	/** The Constant EMISSIONI_GAS_SERRA. */
	public static final String EMISSIONI_GAS_SERRA = "Emissioni_gas_serra";
	
	/** The Constant EDIFICIO_INTERVENTO_1. */
	public static final String EDIFICIO_INTERVENTO_1 = "Edificio_intervento_1";
	
	/** The Constant EDIFICIO_INTERVENTO_2. */
	public static final String EDIFICIO_INTERVENTO_2 = "Edificio_intervento_2";
	
	/** The Constant EDIFICIO_INTERVENTO_3. */
	public static final String EDIFICIO_INTERVENTO_3 = "Edificio_intervento_3";
	
	/** The Constant EDIFICIO_INTERVENTO_4. */
	public static final String EDIFICIO_INTERVENTO_4 = "Edificio_intervento_4";
	
	/** The Constant EDIFICIO_PRIORITA_1. */
	public static final String EDIFICIO_PRIORITA_1 = "Edificio_priorita_1";
	
	/** The Constant EDIFICIO_PRIORITA_2. */
	public static final String EDIFICIO_PRIORITA_2 = "Edificio_priorita_2";
	
	/** The Constant EDIFICIO_PRIORITA_3. */
	public static final String EDIFICIO_PRIORITA_3 = "Edificio_priorita_3";
	
	/** The Constant EDIFICIO_PRIORITA_4. */
	public static final String EDIFICIO_PRIORITA_4 = "Edificio_priorita_4";
	
	/** The Constant EDIFICIO_TEMPO_RIT_1. */
	public static final String EDIFICIO_TEMPO_RIT_1 = "Edificio_tempo_rit_1";
	
	/** The Constant EDIFICIO_TEMPO_RIT_2. */
	public static final String EDIFICIO_TEMPO_RIT_2 = "Edificio_tempo_rit_2";
	
	/** The Constant EDIFICIO_TEMPO_RIT_3. */
	public static final String EDIFICIO_TEMPO_RIT_3 = "Edificio_tempo_rit_3";
	
	/** The Constant EDIFICIO_TEMPO_RIT_4. */
	public static final String EDIFICIO_TEMPO_RIT_4 = "Edificio_tempo_rit_4";
	
	/** The Constant IMPIANTO_INTERVENTO_1. */
	public static final String IMPIANTO_INTERVENTO_1 = "Impianto_intervento_1";
	
	/** The Constant IMPIANTO_INTERVENTO_2. */
	public static final String IMPIANTO_INTERVENTO_2 = "Impianto_intervento_2";
	
	/** The Constant IMPIANTO_INTERVENTO_3. */
	public static final String IMPIANTO_INTERVENTO_3 = "Impianto_intervento_3";
	
	/** The Constant IMPIANTO_INTERVENTO_4. */
	public static final String IMPIANTO_INTERVENTO_4 = "Impianto_intervento_4";
	
	/** The Constant IMPIANTO_PRIORITA_1. */
	public static final String IMPIANTO_PRIORITA_1 = "Impianto_priorita_1";
	
	/** The Constant IMPIANTO_PRIORITA_2. */
	public static final String IMPIANTO_PRIORITA_2 = "Impianto_priorita_2";
	
	/** The Constant IMPIANTO_PRIORITA_3. */
	public static final String IMPIANTO_PRIORITA_3 = "Impianto_priorita_3";
	
	/** The Constant IMPIANTO_PRIORITA_4. */
	public static final String IMPIANTO_PRIORITA_4 = "Impianto_priorita_4";
	
	/** The Constant IMPIANTO_TEMPO_RIT_1. */
	public static final String IMPIANTO_TEMPO_RIT_1 = "Impianto_tempo_rit_1";
	
	/** The Constant IMPIANTO_TEMPO_RIT_2. */
	public static final String IMPIANTO_TEMPO_RIT_2 = "Impianto_tempo_rit_2";
	
	/** The Constant IMPIANTO_TEMPO_RIT_3. */
	public static final String IMPIANTO_TEMPO_RIT_3 = "Impianto_tempo_rit_3";
	
	/** The Constant IMPIANTO_TEMPO_RIT_4. */
	public static final String IMPIANTO_TEMPO_RIT_4 = "Impianto_tempo_rit_4";
	
	/** The Constant N_CERTIFICATO. */
	public static final String N_CERTIFICATO = "N_certificato";
	
	/** The Constant DATA_SCADENZA. */
	public static final String DATA_SCADENZA = "Data_scadenza";
	
	/** The Constant N_CERTIFICATO_A. */
	public static final String N_CERTIFICATO_A = "N_certificato_A";
	
	/** The Constant CLASSE_EN_GLOB_NAZ_EDIF. */
	public static final String CLASSE_EN_GLOB_NAZ_EDIF = "Classe_en_glob_naz_edif";
	
	/** The Constant PREST_ENER_RAGG. */
	public static final String PREST_ENER_RAGG = "Prest_ener_ragg";
	
	/** The Constant PREST_RISC. */
	public static final String PREST_RISC = "Prest_risc";
	
	/** The Constant LIMITE_NORM_NAZ_RISC. */
	public static final String LIMITE_NORM_NAZ_RISC = "Limite_norm_naz_risc";
	
	/** The Constant QUALITA_INV_RAFFRESC. */
	public static final String QUALITA_INV_RAFFRESC = "Qualita_inv_raffresc";
	
	/** The Constant RENDIMENTO_MED_GLOB_STAG_IMP. */
	public static final String RENDIMENTO_MED_GLOB_STAG_IMP = "Rendimento_med_glob_stag_imp";
	
	/** The Constant LIMITE_NORM_REND_MED_GLOB. */
	public static final String LIMITE_NORM_REND_MED_GLOB = "Limite_norm_rend_med_glob";
	
	/** The Constant VALORE_PREST_EN_POM_CAL. */
	public static final String VALORE_PREST_EN_POM_CAL = "Valore_prest_en_pom_cal";
	
	/** The Constant LIMITE_NORM_PREST_EN_POM_CAL. */
	public static final String LIMITE_NORM_PREST_EN_POM_CAL = "Limite_norm_prest_en_pom_cal";
	
	/** The Constant MOTIVO_RIL_ATTEST. */
	public static final String MOTIVO_RIL_ATTEST = "Motivo_ril_attest";
	
	/** The Constant DATA_TIT_ABIT_COSTR. */
	public static final String DATA_TIT_ABIT_COSTR = "Data_tit_abit_costr";
	
	/** The Constant N_DECRETO_LGS. */
	public static final String N_DECRETO_LGS = "N_decreto_lgs";
	
	/** The Constant DECRETO_LGS_S_N. */
	public static final String DECRETO_LGS_S_N = "Decreto_lgs_s_n";
	
	/** The Constant DECRETO_LGS_S_N_OPTION_SI. */
	public static final String DECRETO_LGS_S_N_OPTION_SI = "Si";
	
	/** The Constant DECRETO_LGS_S_N_OPTION_NO. */
	public static final String DECRETO_LGS_S_N_OPTION_NO = "No";
	
	/** The Constant NOME_CERTIFICATORE. */
	public static final String NOME_CERTIFICATORE = "Nome_certificatore";
	
	/** The Constant LUOGO_NASCITA_CERTIFICATORE. */
	public static final String LUOGO_NASCITA_CERTIFICATORE = "Luogo_nascita_certificatore";
	
	/** The Constant DATA_NASCITA_CERTIFICATORE. */
	public static final String DATA_NASCITA_CERTIFICATORE = "Data_nascita_certificatore";
	
	/** The Constant LUOGO_RESIDENZA_CERTIFICATORE. */
	public static final String LUOGO_RESIDENZA_CERTIFICATORE = "Luogo_residenza_certificatore";
	
	/** The Constant CF_CERTIFICATORE. */
	public static final String CF_CERTIFICATORE = "Cf_certificatore";
	
	/** The Constant LUOGO_COMPILAZIONE. */
	public static final String LUOGO_COMPILAZIONE = "Luogo_compilazione";
	
	/** The Constant DATA_COMPILAZIONE. */
	public static final String DATA_COMPILAZIONE = "Data_compilazione";
	
	/** The Constant FIRMA_CERTIFICATORE. */
	public static final String FIRMA_CERTIFICATORE = "Firma_certificatore";
	
	/** The Constant RADIO_CERTIFICAZIONE. */
	public static final String RADIO_CERTIFICAZIONE = "RadioCertificazione";
	
	/** The Constant RADIO_CERTIFICAZIONE_VALORE_1. */
	public static final String RADIO_CERTIFICAZIONE_VALORE_1 = "Certificazione1"; 
	
	/** The Constant RADIO_CERTIFICAZIONE_VALORE_2. */
	public static final String RADIO_CERTIFICAZIONE_VALORE_2 = "Certificazione2";
	
	/** The Constant RADIO_CERTIFICAZIONE_VALORE_3. */
	public static final String RADIO_CERTIFICAZIONE_VALORE_3 = "Certificazione3";
	
	/** The Constant EDIFICIO_PERFORMANTE. */
	public static final String EDIFICIO_PERFORMANTE = "edificio_performante";
	
	/** The Constant CLASSE_ENERGETICA_A_PIU. */
	public static final String CLASSE_ENERGETICA_A_PIU = "A+";
	
	/** The Constant CLASSE_ENERGETICA_A. */
	public static final String CLASSE_ENERGETICA_A = "A";
	
	/** The Constant CLASSE_ENERGETICA_B. */
	public static final String CLASSE_ENERGETICA_B = "B";
	
	/** The Constant CLASSE_ENERGETICA_C. */
	public static final String CLASSE_ENERGETICA_C = "C";
	
	/** The Constant CLASSE_ENERGETICA_D. */
	public static final String CLASSE_ENERGETICA_D = "D";
	
	/** The Constant CLASSE_ENERGETICA_E. */
	public static final String CLASSE_ENERGETICA_E = "E";
	
	/** The Constant CLASSE_ENERGETICA_F. */
	public static final String CLASSE_ENERGETICA_F = "F";
	
	/** The Constant CLASSE_ENERGETICA_G. */
	public static final String CLASSE_ENERGETICA_G = "G";
	
	/** The Constant CLASSE_ENERGETICA_NC. */
	public static final String CLASSE_ENERGETICA_NC = "NC";
	
	/** The provincia. */
	private String provincia;
	
	/** The comune. */
	private String comune;
	
	/** The indirizzo. */
	private String indirizzo;
	
	/** The dati cat sez. */
	private String datiCatSez;
	
	/** The dati cat f. */
	private String datiCatF;
	
	/** The dati cat n. */
	private String datiCatN;
	
	/** The dati cat sub. */
	private String datiCatSub;
	
	/** The piano n. */
	private String pianoN;
	
	/** The piano di. */
	private String pianoDi;

	/** The num appartamenti unita. */
	private String numAppartamentiUnita;
	
	/** The scala. */
	private String scala;
	
	/** The interno. */
	private String interno;
	
	
	/** The progettista. */
	private String progettista;
	
	/** The cap progettista. */
	private String capProgettista;
	
	/** The cell progettista. */
	private String cellProgettista;
	
	/** The cognome progettista. */
	private String cognomeProgettista;
	
	/** The descr comune progettista. */
	private String descrComuneProgettista;
	
	/** The descr indirizzo progettista. */
	private String descrIndirizzoProgettista;
	
	/** The descr prov progettista. */
	private String descrProvProgettista;
	
	/** The descr reg progettista. */
	private String descrRegProgettista;
	
	/** The email progettista. */
	private String emailProgettista;
	
	/** The fax progettista. */
	private String faxProgettista;
	
	/** The nome progettista. */
	private String nomeProgettista;
	
	/** The num civ progettista. */
	private String numCivProgettista;
	
	/** The tel progettista. */
	private String telProgettista;
	
	
	/** The direttore lavori. */
	private String direttoreLavori;
	
	/** The cap direttore lavori. */
	private String capDirettoreLavori;
	
	/** The cell direttore lavori. */
	private String cellDirettoreLavori;
	
	/** The cognome direttore lavori. */
	private String cognomeDirettoreLavori;
	
	/** The descr comune direttore lavori. */
	private String descrComuneDirettoreLavori;
	
	/** The descr indirizzo direttore lavori. */
	private String descrIndirizzoDirettoreLavori;
	
	/** The descr prov direttore lavori. */
	private String descrProvDirettoreLavori;
	
	/** The descr reg direttore lavori. */
	private String descrRegDirettoreLavori;
	
	/** The email direttore lavori. */
	private String emailDirettoreLavori;
	
	/** The fax direttore lavori. */
	private String faxDirettoreLavori;
	
	/** The nome direttore lavori. */
	private String nomeDirettoreLavori;
	
	/** The num civ direttore lavori. */
	private String numCivDirettoreLavori;
	
	/** The tel direttore lavori. */
	private String telDirettoreLavori;

	
	/** The costruttore. */
	private String costruttore;
	
	/** The cap costruttore. */
	private String capCostruttore;
	
	/** The cell costruttore. */
	private String cellCostruttore;
	
	/** The cognome costruttore. */
	private String cognomeCostruttore;
	
	/** The descr comune costruttore. */
	private String descrComuneCostruttore;
	
	/** The descr indirizzo costruttore. */
	private String descrIndirizzoCostruttore;
	
	/** The descr prov costruttore. */
	private String descrProvCostruttore;
	
	/** The descr reg costruttore. */
	private String descrRegCostruttore;
	
	/** The email costruttore. */
	private String emailCostruttore;
	
	/** The fax costruttore. */
	private String faxCostruttore;
	
	/** The nome costruttore. */
	private String nomeCostruttore;
	
	/** The num civ costruttore. */
	private String numCivCostruttore;
	
	/** The tel costruttore. */
	private String telCostruttore;
	
	/** The cocertificatore. */
	private String cocertificatore;
	
	/** The nome cocertificatore. */
	private String nomeCocertificatore;
	
	/** The cognome cocertificatore. */
	private String cognomeCocertificatore;
	
	/** The matricola cocertificatore. */
	private String matricolaCocertificatore;
	
	/** The destinazione uso. */
	private String destinazioneUso;
	
	/** The anno costruzione. */
	private String annoCostruzione;
	
	/** The anno ultima ristrutturazione. */
	private String annoUltimaRistrutturazione;
	
	/** The descrizione edificio. */
	private String descrizioneEdificio;
	
	/** The flag uso pubblico. */
	private String flagUsoPubblico;
	
	/** The superficie utile climatizzata. */
	private String superficieUtileClimatizzata;
	
	
	/** The volume lordo riscaldato. */
	private String volumeLordoRiscaldato;
	
	/** The superf disp totale. */
	private String superfDispTotale;
	
	/** The fattore forma. */
	private String fattoreForma;
	
	/** The trasm med sup op. */
	private String trasmMedSupOp;
	
	/** The trasm med sup trasp. */
	private String trasmMedSupTrasp;
	
	/** The tipol imp risc. */
	private String tipolImpRisc;
	
	/** The combustibile risc. */
	private String combustibileRisc;
	
	/** The combustibile acqua calda san. */
	private String combustibileAcquaCaldaSan;
	
	/** The qh. */
	private String qh;
	
	/** The limite legge. */
	private Float limiteLegge;
	
	/** The qh w. */
	private String qhW;
	
	/** The qh w per classe energetica. */
	private String qhWPerClasseEnergetica;
	
	/** The fabbisogno energia termica acqua calda sanitaria fonti rinnovabili. */
	private String fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili;
	
	/** The fabbisogno energia termica acqua calda sanitaria fonti rinnovabili per classe energetica. */
	private String fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica;
	
	/** The e t agacs. */
	private String eTAgacs;
	
	/** The e t agacs to. */
	private String eTAgacsTo;
	
	/** The e pacs. */
	private String ePacs;
	
	/** The fabbisogno energia utile climatizzazione estiva. */
	private String fabbisognoEnergiaUtileClimatizzazioneEstiva;
	
	/** The fabbisogno energia elettrica illuminazione. */
	private String fabbisognoEnergiaElettricaIlluminazione; 
	
	/** The rendimento di generazione. */
	private String rendimentoDiGenerazione;
	
	/** The rendimento di regolazione. */
	private String rendimentoDiRegolazione;
	
	/** The rendimento di emissione. */
	private String rendimentoDiEmissione;
	
	/** The rendimento di distribuzione. */
	private String rendimentoDiDistribuzione;
	
	/** The indice di prestazione energetica climatizzazione estiva. */
	private String indiceDiPrestazioneEnergeticaClimatizzazioneEstiva;
	
	/** The indice prestazione energetica illuminazione. */
	private String indicePrestazioneEnergeticaIlluminazione;
	
	/** The indice prestazione energetica globale. */
	private String indicePrestazioneEnergeticaGlobale;
	
	/** The quoziente qh. */
	private Float quozienteQh;
	
	/** The limite di normativa regionale. */
	private String limiteDiNormativaRegionale;
	
	/** The quoziente qhw. */
	private Float quozienteQhw;
	
	/** The e pacs to. */
	private String ePacsTo;
	
	/** The quoziente emissione gas serra. */
	private Float quozienteEmissioneGasSerra;
	
	/** The indice prest en glob. */
	private String indicePrestEnGlob;
	
	/** The quota en cop f rin. */
	private String quotaEnCopFRin;
	
	/** The classe energetica. */
	private String classeEnergetica;
	
	/** The classe energetica linea. */
	private String classeEnergeticaLinea;
	
	/** The servizi energetici inclusi nella classificazione. */
	private String serviziEnergeticiInclusiNellaClassificazione;
	
	/** The tecnologie uso fonti rinnovabili. */
	private String tecnologieUsoFontiRinnovabili;
	
	/** The anno installazione. */
	private String annoInstallazione;
	
	/** The energia termica prodotta. */
	private String energiaTermicaProdotta;
	
	/** The energia elettrica prodotta. */
	private String energiaElettricaProdotta; 
	
	/** The autoconsumo termico. */
	private String autoconsumoTermico;
	
	/** The autoconsumo elettrico. */
	private String autoconsumoElettrico;
	
	/** The motivazione rilascio. */
	private String motivazioneRilascio;
	
	/** The metodologia di calcolo adottata. */
	private String metodologiaDiCalcoloAdottata;
	
	/** The software utilizzato. */
	private String  softwareUtilizzato; 
	
	/** The denominazione produttore. */
	private String denominazioneProduttore;
	
	/** The rispondenza aunit s11300. */
	private String rispondenzaAUNITS11300;
	
	                                               
	/** The ettari bosco. */
	private String ettariBosco;
	
	/** The emissioni gas serra. */
	private String emissioniGasSerra;
	
	/** The edificio intervento1. */
	private String edificioIntervento1;
	
	/** The edificio intervento2. */
	private String edificioIntervento2;
	
	/** The edificio intervento3. */
	private String edificioIntervento3;
	
	/** The edificio intervento4. */
	private String edificioIntervento4;
	
	/** The edificio priorita1. */
	private String edificioPriorita1;
	
	/** The edificio priorita2. */
	private String edificioPriorita2;
	
	/** The edificio priorita3. */
	private String edificioPriorita3;
	
	/** The edificio priorita4. */
	private String edificioPriorita4;
	
	/** The edificio tempo rit1. */
	private String edificioTempoRit1;
	
	/** The edificio tempo rit2. */
	private String edificioTempoRit2;
	
	/** The edificio tempo rit3. */
	private String edificioTempoRit3;
	
	/** The edificio tempo rit4. */
	private String edificioTempoRit4;
	
	/** The impianto intervento1. */
	private String impiantoIntervento1;
	
	/** The impianto intervento2. */
	private String impiantoIntervento2;
	
	/** The impianto intervento3. */
	private String impiantoIntervento3;
	
	/** The impianto intervento4. */
	private String impiantoIntervento4;
	
	/** The impianto priorita1. */
	private String impiantoPriorita1;
	
	/** The impianto priorita2. */
	private String impiantoPriorita2;
	
	/** The impianto priorita3. */
	private String impiantoPriorita3;
	
	/** The impianto priorita4. */
	private String impiantoPriorita4;
	
	/** The impianto tempo rit1. */
	private String impiantoTempoRit1;
	
	/** The impianto tempo rit2. */
	private String impiantoTempoRit2;
	
	/** The impianto tempo rit3. */
	private String impiantoTempoRit3;
	
	/** The impianto tempo rit4. */
	private String impiantoTempoRit4;
	
	/** The n certificato. */
	private String nCertificato;
	
	/** The data scadenza. */
	private String dataScadenza;
	
	/** The n certificato a. */
	private String nCertificatoA;
	
	/** The classe en glob naz edif. */
	private String classeEnGlobNazEdif;
	
	/** The prest ener ragg. */
	private String prestEnerRagg;
	
	/** The prest risc. */
	private String prestRisc; //Epi
	
	/** The indice di prestazione energetica per il riscaldamento invernale to. */
	private String indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo; //Epi To
	
	/** The indice di prestazione energetica per il riscaldamento invernale nazionale. */
	private String indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale; //Epi Naz
	
	/** The limite norm naz risc. */
	private String limiteNormNazRisc;
	
	/** The qualita inv raffresc. */
	private String qualitaInvRaffresc;
	
	/** The rendimento med glob stag imp. */
	private String rendimentoMedGlobStagImp;
	
	/** The limite norm rend med glob. */
	private String limiteNormRendMedGlob;
	
	/** The valore prest en pom cal. */
	private String valorePrestEnPomCal;
	
	/** The altre info. */
	private String altreInfo;
	
	/** The data effettuazione sopralluogo. */
	private String dataEffettuazioneSopralluogo;
	
	/** The note sopralluogo. */
	private String noteSopralluogo;
	
	/** The dati redazione. */
	private String datiRedazione;
	
	/** The motivo non conformita. */
	private String motivoNonConformita;
	
	/** The ulteriori note normative en. */
	private String ulterioriNoteNormativeEn;
	
	/** The impianto col bollino. */
	private String impiantoColBollino;
	
	/** The num bollino. */
	private String numBollino;
	
	/** The codice impianto. */
	private String codiceImpianto;
	
	/** The anno install generatore. */
	private String annoInstallGeneratore;
	
	/** The potenza utile nominale complessiva. */
	private String potenzaUtileNominaleComplessiva; 
	
	/** The classe efficienza energetica. */
	private String classeEfficienzaEnergetica;
	
	/** The fonte energetica utilizzata. */
	private String fonteEnergeticaUtilizzata;
	
	/** The unita immobiliari servite. */
	private String unitaImmobiliariServite;
	
	/** The flg ripartizione. */
	private String flgRipartizione;
	
	/** The tipo impianto. */
	private String tipoImpianto;
	
	/** The tipo terminali erogazione. */
	private String tipoTerminaliErogazione;
	
	/** The tipo di distribuzione. */
	private String tipoDiDistribuzione;
	
	/** The tipo di regolazione. */
	private String tipoDiRegolazione;
	
	/** The anno installazione sistema. */
	private String annoInstallazioneSistema;
	
	/** The potenza utile nominale complessiva per acqua calda. */
	private String potenzaUtileNominaleComplessivaPerAcquaCalda;
	
	/** The classe efficienza energetica per acqua calda. */
	private String classeEfficienzaEnergeticaPerAcquaCalda;
	
	/** The motivo ril attest. */
	private String motivoRilAttest;
	
	/** The data tit abit costr. */
	private String dataTitAbitCostr;
	
	/** The n decreto lgs. */
	private String nDecretoLgs;
	
	/** The combo decreto lgs. */
	private String comboDecretoLgs;
	
	/** The nome certificatore. */
	private String nomeCertificatore;
	
	/** The luogo nascita certificatore. */
	private String luogoNascitaCertificatore;
	
	/** The data nascita certificatore. */
	private String dataNascitaCertificatore;
	
	/** The luogo residenza certificatore. */
	private String luogoResidenzaCertificatore;
	
	/** The cf certificatore. */
	private String cfCertificatore;
	
	/** The luogo compilazione. */
	private String luogoCompilazione;
	
	/** The data compilazione. */
	private String dataCompilazione;
	
	/** The firma certificatore. */
	private String firmaCertificatore;
	
	/** The radio certificazione. */
	private String radioCertificazione;
	
	/** The limite norm prest en pom cal. */
	private String limiteNormPrestEnPomCal;
	
	/** The sup utile sum cubi. */
	private String supUtileSumCubi;
	
	/** The zona clim gradi giorno. */
	private String zonaClimGradiGiorno;
	
	/** The limite di legge. */
	private String limiteDiLegge;
	
	/** The edificio performante. */
	private String edificioPerformante;
	
	/** The fonte energetica utilizzata per acqua calda. */
	private String fonteEnergeticaUtilizzataPerAcquaCalda;
	
	/** The annuale termico da fossile. */
	private String annualeTermicoDaFossile;   
	
	/** The annuale elettrico da fossile. */
	private String annualeElettricoDaFossile;   
	
	/** The annuale termico da fonti rinnovabili. */
	private String annualeTermicoDaFontiRinnovabili;   
	
	/** The annuale elettrico da fonti rinnovabili. */
	private String annualeElettricoDaFontiRinnovabili;   
	
	/** The medio complessivo termico. */
	private String medioComplessivoTermico;   
	
	/** The medio complessivo elettrico. */
	private String medioComplessivoElettrico;
	
	
	/**
	 * Gets the edificio performante.
	 *
	 * @return the edificio performante
	 */
	public String getEdificioPerformante() {
		return edificioPerformante;
	}
	
	/**
	 * Sets the edificio performante.
	 *
	 * @param edificioPerformante the new edificio performante
	 */
	public void setEdificioPerformante(String edificioPerformante) {
		this.edificioPerformante = edificioPerformante;
	}
	
	/**
	 * Gets the limite di legge.
	 *
	 * @return the limite di legge
	 */
	public String getLimiteDiLegge() {
		return limiteDiLegge;
	}
	
	/**
	 * Sets the limite di legge.
	 *
	 * @param limiteDiLegge the new limite di legge
	 */
	public void setLimiteDiLegge(String limiteDiLegge) {
		this.limiteDiLegge = limiteDiLegge;
	}
	
	/** The foto edificio. */
	private InputStream fotoEdificio;
	
	/**
	 * Gets the comune.
	 *
	 * @return the comune
	 */
	public String getComune() {
		return comune;
	}
	
	/**
	 * Sets the comune.
	 *
	 * @param comune the new comune
	 */
	public void setComune(String comune) {
		this.comune = comune;
	}
	
	/**
	 * Gets the provincia.
	 *
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	
	/**
	 * Sets the provincia.
	 *
	 * @param provincia the new provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	/**
	 * Gets the indirizzo.
	 *
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * Sets the indirizzo.
	 *
	 * @param indirizzo the new indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	/**
	 * Gets the dati cat sez.
	 *
	 * @return the dati cat sez
	 */
	public String getDatiCatSez() {
		return datiCatSez;
	}
	
	/**
	 * Sets the dati cat sez.
	 *
	 * @param datiCatSez the new dati cat sez
	 */
	public void setDatiCatSez(String datiCatSez) {
		this.datiCatSez = datiCatSez;
	}
	
	/**
	 * Gets the dati cat f.
	 *
	 * @return the dati cat f
	 */
	public String getDatiCatF() {
		return datiCatF;
	}
	
	/**
	 * Sets the dati cat f.
	 *
	 * @param datiCatF the new dati cat f
	 */
	public void setDatiCatF(String datiCatF) {
		this.datiCatF = datiCatF;
	}
	
	/**
	 * Gets the dati cat n.
	 *
	 * @return the dati cat n
	 */
	public String getDatiCatN() {
		return datiCatN;
	}
	
	/**
	 * Sets the dati cat n.
	 *
	 * @param datiCatN the new dati cat n
	 */
	public void setDatiCatN(String datiCatN) {
		this.datiCatN = datiCatN;
	}
	
	/**
	 * Gets the dati cat sub.
	 *
	 * @return the dati cat sub
	 */
	public String getDatiCatSub() {
		return datiCatSub;
	}
	
	/**
	 * Sets the dati cat sub.
	 *
	 * @param datiCatSub the new dati cat sub
	 */
	public void setDatiCatSub(String datiCatSub) {
		this.datiCatSub = datiCatSub;
	}
	
	/**
	 * Gets the piano n.
	 *
	 * @return the piano n
	 */
	public String getPianoN() {
		return pianoN;
	}
	
	/**
	 * Sets the piano n.
	 *
	 * @param pianoN the new piano n
	 */
	public void setPianoN(String pianoN) {
		this.pianoN = pianoN;
	}
	
	/**
	 * Gets the piano di.
	 *
	 * @return the piano di
	 */
	public String getPianoDi() {
		return pianoDi;
	}
	
	/**
	 * Sets the piano di.
	 *
	 * @param pianoDi the new piano di
	 */
	public void setPianoDi(String pianoDi) {
		this.pianoDi = pianoDi;
	}
	
	/**
	 * Gets the num appartamenti unita.
	 *
	 * @return the num appartamenti unita
	 */
	public String getNumAppartamentiUnita() {
		return numAppartamentiUnita;
	}
	
	/**
	 * Sets the num appartamenti unita.
	 *
	 * @param numAppartamentiUnita the new num appartamenti unita
	 */
	public void setNumAppartamentiUnita(String numAppartamentiUnita) {
		this.numAppartamentiUnita = numAppartamentiUnita;
	}
	
	/**
	 * Gets the scala.
	 *
	 * @return the scala
	 */
	public String getScala() {
		return scala;
	}
	
	/**
	 * Sets the scala.
	 *
	 * @param scala the new scala
	 */
	public void setScala(String scala) {
		this.scala = scala;
	}
	
	/**
	 * Gets the interno.
	 *
	 * @return the interno
	 */
	public String getInterno() {
		return interno;
	}
	
	/**
	 * Sets the interno.
	 *
	 * @param interno the new interno
	 */
	public void setInterno(String interno) {
		this.interno = interno;
	}
	
	/**
	 * Gets the progettista.
	 *
	 * @return the progettista
	 */
	public String getProgettista() {
		return progettista;
	}
	
	/**
	 * Sets the progettista.
	 *
	 * @param progettista the new progettista
	 */
	public void setProgettista(String progettista) {
		this.progettista = progettista;
	}
	
	/**
	 * Gets the cap progettista.
	 *
	 * @return the cap progettista
	 */
	public String getCapProgettista() {
		return capProgettista;
	}
	
	/**
	 * Sets the cap progettista.
	 *
	 * @param capProgettista the new cap progettista
	 */
	public void setCapProgettista(String capProgettista) {
		this.capProgettista = capProgettista;
	}
	
	/**
	 * Gets the cell progettista.
	 *
	 * @return the cell progettista
	 */
	public String getCellProgettista() {
		return cellProgettista;
	}
	
	/**
	 * Sets the cell progettista.
	 *
	 * @param cellProgettista the new cell progettista
	 */
	public void setCellProgettista(String cellProgettista) {
		this.cellProgettista = cellProgettista;
	}
	
	/**
	 * Gets the cognome progettista.
	 *
	 * @return the cognome progettista
	 */
	public String getCognomeProgettista() {
		return cognomeProgettista;
	}
	
	/**
	 * Sets the cognome progettista.
	 *
	 * @param cognomeProgettista the new cognome progettista
	 */
	public void setCognomeProgettista(String cognomeProgettista) {
		this.cognomeProgettista = cognomeProgettista;
	}
	
	/**
	 * Gets the descr comune progettista.
	 *
	 * @return the descr comune progettista
	 */
	public String getDescrComuneProgettista() {
		return descrComuneProgettista;
	}
	
	/**
	 * Sets the descr comune progettista.
	 *
	 * @param descrComuneProgettista the new descr comune progettista
	 */
	public void setDescrComuneProgettista(String descrComuneProgettista) {
		this.descrComuneProgettista = descrComuneProgettista;
	}
	
	/**
	 * Gets the descr indirizzo progettista.
	 *
	 * @return the descr indirizzo progettista
	 */
	public String getDescrIndirizzoProgettista() {
		return descrIndirizzoProgettista;
	}
	
	/**
	 * Sets the descr indirizzo progettista.
	 *
	 * @param descrIndirizzoProgettista the new descr indirizzo progettista
	 */
	public void setDescrIndirizzoProgettista(String descrIndirizzoProgettista) {
		this.descrIndirizzoProgettista = descrIndirizzoProgettista;
	}
	
	/**
	 * Gets the descr prov progettista.
	 *
	 * @return the descr prov progettista
	 */
	public String getDescrProvProgettista() {
		return descrProvProgettista;
	}
	
	/**
	 * Sets the descr prov progettista.
	 *
	 * @param descrProvProgettista the new descr prov progettista
	 */
	public void setDescrProvProgettista(String descrProvProgettista) {
		this.descrProvProgettista = descrProvProgettista;
	}
	
	/**
	 * Gets the descr reg progettista.
	 *
	 * @return the descr reg progettista
	 */
	public String getDescrRegProgettista() {
		return descrRegProgettista;
	}
	
	/**
	 * Sets the descr reg progettista.
	 *
	 * @param descrRegProgettista the new descr reg progettista
	 */
	public void setDescrRegProgettista(String descrRegProgettista) {
		this.descrRegProgettista = descrRegProgettista;
	}
	
	/**
	 * Gets the email progettista.
	 *
	 * @return the email progettista
	 */
	public String getEmailProgettista() {
		return emailProgettista;
	}
	
	/**
	 * Sets the email progettista.
	 *
	 * @param emailProgettista the new email progettista
	 */
	public void setEmailProgettista(String emailProgettista) {
		this.emailProgettista = emailProgettista;
	}
	
	/**
	 * Gets the fax progettista.
	 *
	 * @return the fax progettista
	 */
	public String getFaxProgettista() {
		return faxProgettista;
	}
	
	/**
	 * Sets the fax progettista.
	 *
	 * @param faxProgettista the new fax progettista
	 */
	public void setFaxProgettista(String faxProgettista) {
		this.faxProgettista = faxProgettista;
	}
	
	/**
	 * Gets the nome progettista.
	 *
	 * @return the nome progettista
	 */
	public String getNomeProgettista() {
		return nomeProgettista;
	}
	
	/**
	 * Sets the nome progettista.
	 *
	 * @param nomeProgettista the new nome progettista
	 */
	public void setNomeProgettista(String nomeProgettista) {
		this.nomeProgettista = nomeProgettista;
	}
	
	/**
	 * Gets the num civ progettista.
	 *
	 * @return the num civ progettista
	 */
	public String getNumCivProgettista() {
		return numCivProgettista;
	}
	
	/**
	 * Sets the num civ progettista.
	 *
	 * @param numCivProgettista the new num civ progettista
	 */
	public void setNumCivProgettista(String numCivProgettista) {
		this.numCivProgettista = numCivProgettista;
	}
	
	/**
	 * Gets the tel progettista.
	 *
	 * @return the tel progettista
	 */
	public String getTelProgettista() {
		return telProgettista;
	}
	
	/**
	 * Sets the tel progettista.
	 *
	 * @param telProgettista the new tel progettista
	 */
	public void setTelProgettista(String telProgettista) {
		this.telProgettista = telProgettista;
	}
	
	/**
	 * Gets the direattore lavori.
	 *
	 * @return the direattore lavori
	 */
	public String getDireattoreLavori() {
		return direttoreLavori;
	}
	
	/**
	 * Sets the direattore lavori.
	 *
	 * @param direttoreLavori the new direattore lavori
	 */
	public void setDireattoreLavori(String direttoreLavori) {
		this.direttoreLavori = direttoreLavori;
	}
	
	/**
	 * Gets the cap direttore lavori.
	 *
	 * @return the cap direttore lavori
	 */
	public String getCapDirettoreLavori() {
		return capDirettoreLavori;
	}
	
	/**
	 * Sets the cap direttore lavori.
	 *
	 * @param capDirettoreLavori the new cap direttore lavori
	 */
	public void setCapDirettoreLavori(String capDirettoreLavori) {
		this.capDirettoreLavori = capDirettoreLavori;
	}
	
	/**
	 * Gets the cell direttore lavori.
	 *
	 * @return the cell direttore lavori
	 */
	public String getCellDirettoreLavori() {
		return cellDirettoreLavori;
	}
	
	/**
	 * Sets the cell direttore lavori.
	 *
	 * @param cellDirettoreLavori the new cell direttore lavori
	 */
	public void setCellDirettoreLavori(String cellDirettoreLavori) {
		this.cellDirettoreLavori = cellDirettoreLavori;
	}
	
	/**
	 * Gets the cognome direttore lavori.
	 *
	 * @return the cognome direttore lavori
	 */
	public String getCognomeDirettoreLavori() {
		return cognomeDirettoreLavori;
	}
	
	/**
	 * Sets the cognome direttore lavori.
	 *
	 * @param cognomeDirettoreLavori the new cognome direttore lavori
	 */
	public void setCognomeDirettoreLavori(String cognomeDirettoreLavori) {
		this.cognomeDirettoreLavori = cognomeDirettoreLavori;
	}
	
	/**
	 * Gets the descr comune direttore lavori.
	 *
	 * @return the descr comune direttore lavori
	 */
	public String getDescrComuneDirettoreLavori() {
		return descrComuneDirettoreLavori;
	}
	
	/**
	 * Sets the descr comune direttore lavori.
	 *
	 * @param descrComuneDirettoreLavori the new descr comune direttore lavori
	 */
	public void setDescrComuneDirettoreLavori(String descrComuneDirettoreLavori) {
		this.descrComuneDirettoreLavori = descrComuneDirettoreLavori;
	}
	
	/**
	 * Gets the descr indirizzo direttore lavori.
	 *
	 * @return the descr indirizzo direttore lavori
	 */
	public String getDescrIndirizzoDirettoreLavori() {
		return descrIndirizzoDirettoreLavori;
	}
	
	/**
	 * Sets the descr indirizzo direttore lavori.
	 *
	 * @param descrIndirizzoDirettoreLavori the new descr indirizzo direttore lavori
	 */
	public void setDescrIndirizzoDirettoreLavori(
			String descrIndirizzoDirettoreLavori) {
		this.descrIndirizzoDirettoreLavori = descrIndirizzoDirettoreLavori;
	}
	
	/**
	 * Gets the descr prov direttore lavori.
	 *
	 * @return the descr prov direttore lavori
	 */
	public String getDescrProvDirettoreLavori() {
		return descrProvDirettoreLavori;
	}
	
	/**
	 * Sets the descr prov direttore lavori.
	 *
	 * @param descrProvDirettoreLavori the new descr prov direttore lavori
	 */
	public void setDescrProvDirettoreLavori(String descrProvDirettoreLavori) {
		this.descrProvDirettoreLavori = descrProvDirettoreLavori;
	}
	
	/**
	 * Gets the descr reg direttore lavori.
	 *
	 * @return the descr reg direttore lavori
	 */
	public String getDescrRegDirettoreLavori() {
		return descrRegDirettoreLavori;
	}
	
	/**
	 * Sets the descr reg direttore lavori.
	 *
	 * @param descrRegDirettoreLavori the new descr reg direttore lavori
	 */
	public void setDescrRegDirettoreLavori(String descrRegDirettoreLavori) {
		this.descrRegDirettoreLavori = descrRegDirettoreLavori;
	}
	
	/**
	 * Gets the email direttore lavori.
	 *
	 * @return the email direttore lavori
	 */
	public String getEmailDirettoreLavori() {
		return emailDirettoreLavori;
	}
	
	/**
	 * Sets the email direttore lavori.
	 *
	 * @param emailDirettoreLavori the new email direttore lavori
	 */
	public void setEmailDirettoreLavori(String emailDirettoreLavori) {
		this.emailDirettoreLavori = emailDirettoreLavori;
	}
	
	/**
	 * Gets the fax direttore lavori.
	 *
	 * @return the fax direttore lavori
	 */
	public String getFaxDirettoreLavori() {
		return faxDirettoreLavori;
	}
	
	/**
	 * Sets the fax direttore lavori.
	 *
	 * @param faxDirettoreLavori the new fax direttore lavori
	 */
	public void setFaxDirettoreLavori(String faxDirettoreLavori) {
		this.faxDirettoreLavori = faxDirettoreLavori;
	}
	
	/**
	 * Gets the nome direttore lavori.
	 *
	 * @return the nome direttore lavori
	 */
	public String getNomeDirettoreLavori() {
		return nomeDirettoreLavori;
	}
	
	/**
	 * Sets the nome direttore lavori.
	 *
	 * @param nomeDirettoreLavori the new nome direttore lavori
	 */
	public void setNomeDirettoreLavori(String nomeDirettoreLavori) {
		this.nomeDirettoreLavori = nomeDirettoreLavori;
	}
	
	/**
	 * Gets the num civ direttore lavori.
	 *
	 * @return the num civ direttore lavori
	 */
	public String getNumCivDirettoreLavori() {
		return numCivDirettoreLavori;
	}
	
	/**
	 * Sets the num civ direttore lavori.
	 *
	 * @param numCivDirettoreLavori the new num civ direttore lavori
	 */
	public void setNumCivDirettoreLavori(String numCivDirettoreLavori) {
		this.numCivDirettoreLavori = numCivDirettoreLavori;
	}
	
	/**
	 * Gets the tel direttore lavori.
	 *
	 * @return the tel direttore lavori
	 */
	public String getTelDirettoreLavori() {
		return telDirettoreLavori;
	}
	
	/**
	 * Sets the tel direttore lavori.
	 *
	 * @param telDirettoreLavori the new tel direttore lavori
	 */
	public void setTelDirettoreLavori(String telDirettoreLavori) {
		this.telDirettoreLavori = telDirettoreLavori;
	}
	
	/**
	 * Gets the direttore lavori.
	 *
	 * @return the direttore lavori
	 */
	public String getDirettoreLavori() {
		return direttoreLavori;
	}
	
	/**
	 * Sets the direttore lavori.
	 *
	 * @param direttoreLavori the new direttore lavori
	 */
	public void setDirettoreLavori(String direttoreLavori) {
		this.direttoreLavori = direttoreLavori;
	}
	
	/**
	 * Gets the costruttore.
	 *
	 * @return the costruttore
	 */
	public String getCostruttore() {
		return costruttore;
	}
	
	/**
	 * Sets the costruttore.
	 *
	 * @param costruttore the new costruttore
	 */
	public void setCostruttore(String costruttore) {
		this.costruttore = costruttore;
	}
	
	/**
	 * Gets the cap costruttore.
	 *
	 * @return the cap costruttore
	 */
	public String getCapCostruttore() {
		return capCostruttore;
	}
	
	/**
	 * Sets the cap costruttore.
	 *
	 * @param capCostruttore the new cap costruttore
	 */
	public void setCapCostruttore(String capCostruttore) {
		this.capCostruttore = capCostruttore;
	}
	
	/**
	 * Gets the cell costruttore.
	 *
	 * @return the cell costruttore
	 */
	public String getCellCostruttore() {
		return cellCostruttore;
	}
	
	/**
	 * Sets the cell costruttore.
	 *
	 * @param cellCostruttore the new cell costruttore
	 */
	public void setCellCostruttore(String cellCostruttore) {
		this.cellCostruttore = cellCostruttore;
	}
	
	/**
	 * Gets the cognome costruttore.
	 *
	 * @return the cognome costruttore
	 */
	public String getCognomeCostruttore() {
		return cognomeCostruttore;
	}
	
	/**
	 * Sets the cognome costruttore.
	 *
	 * @param cognomeCostruttore the new cognome costruttore
	 */
	public void setCognomeCostruttore(String cognomeCostruttore) {
		this.cognomeCostruttore = cognomeCostruttore;
	}
	
	/**
	 * Gets the descr comune costruttore.
	 *
	 * @return the descr comune costruttore
	 */
	public String getDescrComuneCostruttore() {
		return descrComuneCostruttore;
	}
	
	/**
	 * Sets the descr comune costruttore.
	 *
	 * @param descrComuneCostruttore the new descr comune costruttore
	 */
	public void setDescrComuneCostruttore(String descrComuneCostruttore) {
		this.descrComuneCostruttore = descrComuneCostruttore;
	}
	
	/**
	 * Gets the descr indirizzo costruttore.
	 *
	 * @return the descr indirizzo costruttore
	 */
	public String getDescrIndirizzoCostruttore() {
		return descrIndirizzoCostruttore;
	}
	
	/**
	 * Sets the descr indirizzo costruttore.
	 *
	 * @param descrIndirizzoCostruttore the new descr indirizzo costruttore
	 */
	public void setDescrIndirizzoCostruttore(String descrIndirizzoCostruttore) {
		this.descrIndirizzoCostruttore = descrIndirizzoCostruttore;
	}
	
	/**
	 * Gets the descr prov costruttore.
	 *
	 * @return the descr prov costruttore
	 */
	public String getDescrProvCostruttore() {
		return descrProvCostruttore;
	}
	
	/**
	 * Sets the descr prov costruttore.
	 *
	 * @param descrProvCostruttore the new descr prov costruttore
	 */
	public void setDescrProvCostruttore(String descrProvCostruttore) {
		this.descrProvCostruttore = descrProvCostruttore;
	}
	
	/**
	 * Gets the descr reg costruttore.
	 *
	 * @return the descr reg costruttore
	 */
	public String getDescrRegCostruttore() {
		return descrRegCostruttore;
	}
	
	/**
	 * Sets the descr reg costruttore.
	 *
	 * @param descrRegCostruttore the new descr reg costruttore
	 */
	public void setDescrRegCostruttore(String descrRegCostruttore) {
		this.descrRegCostruttore = descrRegCostruttore;
	}
	
	/**
	 * Gets the email costruttore.
	 *
	 * @return the email costruttore
	 */
	public String getEmailCostruttore() {
		return emailCostruttore;
	}
	
	/**
	 * Sets the email costruttore.
	 *
	 * @param emailCostruttore the new email costruttore
	 */
	public void setEmailCostruttore(String emailCostruttore) {
		this.emailCostruttore = emailCostruttore;
	}
	
	/**
	 * Gets the fax costruttore.
	 *
	 * @return the fax costruttore
	 */
	public String getFaxCostruttore() {
		return faxCostruttore;
	}
	
	/**
	 * Sets the fax costruttore.
	 *
	 * @param faxCostruttore the new fax costruttore
	 */
	public void setFaxCostruttore(String faxCostruttore) {
		this.faxCostruttore = faxCostruttore;
	}
	
	/**
	 * Gets the nome costruttore.
	 *
	 * @return the nome costruttore
	 */
	public String getNomeCostruttore() {
		return nomeCostruttore;
	}
	
	/**
	 * Sets the nome costruttore.
	 *
	 * @param nomeCostruttore the new nome costruttore
	 */
	public void setNomeCostruttore(String nomeCostruttore) {
		this.nomeCostruttore = nomeCostruttore;
	}
	
	/**
	 * Gets the num civ costruttore.
	 *
	 * @return the num civ costruttore
	 */
	public String getNumCivCostruttore() {
		return numCivCostruttore;
	}
	
	/**
	 * Sets the num civ costruttore.
	 *
	 * @param numCivCostruttore the new num civ costruttore
	 */
	public void setNumCivCostruttore(String numCivCostruttore) {
		this.numCivCostruttore = numCivCostruttore;
	}
	
	/**
	 * Gets the tel costruttore.
	 *
	 * @return the tel costruttore
	 */
	public String getTelCostruttore() {
		return telCostruttore;
	}
	
	/**
	 * Sets the tel costruttore.
	 *
	 * @param telCostruttore the new tel costruttore
	 */
	public void setTelCostruttore(String telCostruttore) {
		this.telCostruttore = telCostruttore;
	}
	
	/**
	 * Gets the cocertificatore.
	 *
	 * @return the cocertificatore
	 */
	public String getCocertificatore() {
		return cocertificatore;
	}
	
	/**
	 * Sets the cocertificatore.
	 *
	 * @param cocertificatore the new cocertificatore
	 */
	public void setCocertificatore(String cocertificatore) {
		this.cocertificatore = cocertificatore;
	}
	
	/**
	 * Gets the nome cocertificatore.
	 *
	 * @return the nome cocertificatore
	 */
	public String getNomeCocertificatore() {
		return nomeCocertificatore;
	}
	
	/**
	 * Sets the nome cocertificatore.
	 *
	 * @param nomeCocertificatore the new nome cocertificatore
	 */
	public void setNomeCocertificatore(String nomeCocertificatore) {
		this.nomeCocertificatore = nomeCocertificatore;
	}
	
	/**
	 * Gets the cognome cocertificatore.
	 *
	 * @return the cognome cocertificatore
	 */
	public String getCognomeCocertificatore() {
		return cognomeCocertificatore;
	}
	
	/**
	 * Sets the cognome cocertificatore.
	 *
	 * @param cognomeCocertificatore the new cognome cocertificatore
	 */
	public void setCognomeCocertificatore(String cognomeCocertificatore) {
		this.cognomeCocertificatore = cognomeCocertificatore;
	}
	
	/**
	 * Gets the matricola cocertificatore.
	 *
	 * @return the matricola cocertificatore
	 */
	public String getMatricolaCocertificatore() {
		return matricolaCocertificatore;
	}
	
	/**
	 * Sets the matricola cocertificatore.
	 *
	 * @param matricolaCocertificatore the new matricola cocertificatore
	 */
	public void setMatricolaCocertificatore(String matricolaCocertificatore) {
		this.matricolaCocertificatore = matricolaCocertificatore;
	}
	
	/**
	 * Gets the destinazione uso.
	 *
	 * @return the destinazione uso
	 */
	public String getDestinazioneUso() {
		return destinazioneUso;
	}
	
	/**
	 * Sets the destinazione uso.
	 *
	 * @param destinazioneUso the new destinazione uso
	 */
	public void setDestinazioneUso(String destinazioneUso) {
		this.destinazioneUso = destinazioneUso;
	}
	
	/**
	 * Gets the anno costruzione.
	 *
	 * @return the anno costruzione
	 */
	public String getAnnoCostruzione() {
		return annoCostruzione;
	}
	
	/**
	 * Sets the anno costruzione.
	 *
	 * @param annoCostruzione the new anno costruzione
	 */
	public void setAnnoCostruzione(String annoCostruzione) {
		this.annoCostruzione = annoCostruzione;
	}
	
	/**
	 * Sets the anno ultima ristrutturazione.
	 *
	 * @param annoUltimaRistrutturazione the new anno ultima ristrutturazione
	 */
	public void setAnnoUltimaRistrutturazione(String annoUltimaRistrutturazione) {
		this.annoUltimaRistrutturazione = annoUltimaRistrutturazione;
	}
	
	/**
	 * Gets the anno ultima ristrutturazione.
	 *
	 * @return the anno ultima ristrutturazione
	 */
	public String getAnnoUltimaRistrutturazione() {
		return annoUltimaRistrutturazione;
	}
	
	/**
	 * Gets the descrizione edificio.
	 *
	 * @return the descrizione edificio
	 */
	public String getDescrizioneEdificio() {
		return descrizioneEdificio;
	}
	
	/**
	 * Sets the descrizione edificio.
	 *
	 * @param descrizioneEdificio the new descrizione edificio
	 */
	public void setDescrizioneEdificio(String descrizioneEdificio) {
		this.descrizioneEdificio = descrizioneEdificio;
	}
	
	/**
	 * Sets the flag uso pubblico.
	 *
	 * @param flagUsoPubblico the new flag uso pubblico
	 */
	public void setFlagUsoPubblico(String flagUsoPubblico) {
		this.flagUsoPubblico = flagUsoPubblico;
	}
	
	/**
	 * Gets the flag uso pubblico.
	 *
	 * @return the flag uso pubblico
	 */
	public String getFlagUsoPubblico() {
		return flagUsoPubblico;
	}
	
	/**
	 * Gets the superficie utile climatizzata.
	 *
	 * @return the superficie utile climatizzata
	 */
	public String getSuperficieUtileClimatizzata() {
		return superficieUtileClimatizzata;
	}
	
	/**
	 * Sets the superficie utile climatizzata.
	 *
	 * @param superficieUtileClimatizzata the new superficie utile climatizzata
	 */
	public void setSuperficieUtileClimatizzata(String superficieUtileClimatizzata) {
		this.superficieUtileClimatizzata = superficieUtileClimatizzata;
	}
	
	/**
	 * Gets the volume lordo riscaldato.
	 *
	 * @return the volume lordo riscaldato
	 */
	public String getVolumeLordoRiscaldato() {
		return volumeLordoRiscaldato;
	}
	
	/**
	 * Sets the volume lordo riscaldato.
	 *
	 * @param volumeLordoRiscaldato the new volume lordo riscaldato
	 */
	public void setVolumeLordoRiscaldato(String volumeLordoRiscaldato) {
		this.volumeLordoRiscaldato = volumeLordoRiscaldato;
	}
	
	/**
	 * Gets the superf disp totale.
	 *
	 * @return the superf disp totale
	 */
	public String getSuperfDispTotale() {
		return superfDispTotale;
	}
	
	/**
	 * Sets the superf disp totale.
	 *
	 * @param superfDispTotale the new superf disp totale
	 */
	public void setSuperfDispTotale(String superfDispTotale) {
		this.superfDispTotale = superfDispTotale;
	}
	
	/**
	 * Gets the fattore forma.
	 *
	 * @return the fattore forma
	 */
	public String getFattoreForma() {
		return fattoreForma;
	}
	
	/**
	 * Sets the fattore forma.
	 *
	 * @param fattoreForma the new fattore forma
	 */
	public void setFattoreForma(String fattoreForma) {
		this.fattoreForma = fattoreForma;
	}
	
	/**
	 * Gets the trasm med sup op.
	 *
	 * @return the trasm med sup op
	 */
	public String getTrasmMedSupOp() {
		return trasmMedSupOp;
	}
	
	/**
	 * Sets the trasm med sup op.
	 *
	 * @param trasmMedSupOp the new trasm med sup op
	 */
	public void setTrasmMedSupOp(String trasmMedSupOp) {
		this.trasmMedSupOp = trasmMedSupOp;
	}
	
	/**
	 * Gets the trasm med sup trasp.
	 *
	 * @return the trasm med sup trasp
	 */
	public String getTrasmMedSupTrasp() {
		return trasmMedSupTrasp;
	}
	
	/**
	 * Sets the trasm med sup trasp.
	 *
	 * @param trasmMedSupTrasp the new trasm med sup trasp
	 */
	public void setTrasmMedSupTrasp(String trasmMedSupTrasp) {
		this.trasmMedSupTrasp = trasmMedSupTrasp;
	}
	
	/**
	 * Gets the tipol imp risc.
	 *
	 * @return the tipol imp risc
	 */
	public String getTipolImpRisc() {
		return tipolImpRisc;
	}
	
	/**
	 * Sets the tipol imp risc.
	 *
	 * @param tipolImpRisc the new tipol imp risc
	 */
	public void setTipolImpRisc(String tipolImpRisc) {
		this.tipolImpRisc = tipolImpRisc;
	}
	
	/**
	 * Gets the combustibile risc.
	 *
	 * @return the combustibile risc
	 */
	public String getCombustibileRisc() {
		return combustibileRisc;
	}
	
	/**
	 * Sets the combustibile risc.
	 *
	 * @param combustibileRisc the new combustibile risc
	 */
	public void setCombustibileRisc(String combustibileRisc) {
		this.combustibileRisc = combustibileRisc;
	}
	
	/**
	 * Gets the combustibile acqua calda san.
	 *
	 * @return the combustibile acqua calda san
	 */
	public String getCombustibileAcquaCaldaSan() {
		return combustibileAcquaCaldaSan;
	}
	
	/**
	 * Sets the combustibile acqua calda san.
	 *
	 * @param combustibileAcquaCaldaSan the new combustibile acqua calda san
	 */
	public void setCombustibileAcquaCaldaSan(String combustibileAcquaCaldaSan) {
		this.combustibileAcquaCaldaSan = combustibileAcquaCaldaSan;
	}
	
	/**
	 * Gets the qh.
	 *
	 * @return the qh
	 */
	public String getQh() {
		return qh;
	}
	
	/**
	 * Sets the qh.
	 *
	 * @param qh the new qh
	 */
	public void setQh(String qh) {
		this.qh = qh;
	}
	
	/**
	 * Gets the limite legge.
	 *
	 * @return the limite legge
	 */
	public Float getLimiteLegge() {
		return limiteLegge;
	}
	
	/**
	 * Sets the limite legge.
	 *
	 * @param limiteLegge the new limite legge
	 */
	public void setLimiteLegge(Float limiteLegge) {
		this.limiteLegge = limiteLegge;
	}
	
	/**
	 * Gets the qh w.
	 *
	 * @return the qh w
	 */
	public String getQhW() {
		return qhW;
	}
	
	/**
	 * Sets the qh w.
	 *
	 * @param qhW the new qh w
	 */
	public void setQhW(String qhW) {
		this.qhW = qhW;
	}
	
	/**
	 * Gets the qh w per classe energetica.
	 *
	 * @return the qh w per classe energetica
	 */
	public String getQhWPerClasseEnergetica() {
		return qhWPerClasseEnergetica;
	}
	
	/**
	 * Sets the qh w per classe energetica.
	 *
	 * @param qhWPerClasseEnergetica the new qh w per classe energetica
	 */
	public void setQhWPerClasseEnergetica(String qhWPerClasseEnergetica) {
		this.qhWPerClasseEnergetica = qhWPerClasseEnergetica;
	}
	
	/**
	 * Sets the fabbisogno energia termica acqua calda sanitaria fonti rinnovabili.
	 *
	 * @param setFabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili the new fabbisogno energia termica acqua calda sanitaria fonti rinnovabili
	 */
	public void setFabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili(String setFabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili) {
		this.fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili = fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili;
	}
	
	/**
	 * Gets the fabbisogno energia termica acqua calda sanitaria fonti rinnovabili.
	 *
	 * @return the fabbisogno energia termica acqua calda sanitaria fonti rinnovabili
	 */
	public String getFabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili() {
		return fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabili;
	}
	
	/**
	 * Sets the fabbisogno energia termica acqua calda sanitaria fonti rinnovabili per classe energetica.
	 *
	 * @param fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica the new fabbisogno energia termica acqua calda sanitaria fonti rinnovabili per classe energetica
	 */
	public void setFabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica(String fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica) {
		this.fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica = fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica;
	}
	
	/**
	 * Gets the fabbisogno energia termica acqua calda sanitaria fonti rinnovabili per classe energetica.
	 *
	 * @return the fabbisogno energia termica acqua calda sanitaria fonti rinnovabili per classe energetica
	 */
	public String getFabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica() {
		return fabbisognoEnergiaTermicaAcquaCaldaSanitariaFontiRinnovabiliPerClasseEnergetica;
	}
	
	
	/**
	 * Gets the e t agacs.
	 *
	 * @return the e t agacs
	 */
	public String geteTAgacs() {
		return eTAgacs;
	}
	
	/**
	 * Sets the e t agacs.
	 *
	 * @param eTAgacs the new e t agacs
	 */
	public void seteTAgacs(String eTAgacs) {
		this.eTAgacs = eTAgacs;
	}
	
	/**
	 * Gets the e t agacs to.
	 *
	 * @return the e t agacs to
	 */
	public String geteTAgacsTo() {
		return eTAgacsTo;
	}
	
	/**
	 * Sets the e t agacs to.
	 *
	 * @param eTAgacsTo the new e t agacs to
	 */
	public void seteTAgacsTo(String eTAgacsTo) {
		this.eTAgacsTo = eTAgacsTo;
	}
	
	/**
	 * Sets the e pacs.
	 *
	 * @param ePacs the new e pacs
	 */
	public void setePacs(String ePacs) {
		this.ePacs = ePacs;
	}
	
	/**
	 * Gets the e pacs.
	 *
	 * @return the e pacs
	 */
	public String getePacs() {
		return ePacs;
	}
	
	/**
	 * Sets the fabbisogno energia utile climatizzazione estiva.
	 *
	 * @param fabbisognoEnergiaUtileClimatizzazioneEstiva the new fabbisogno energia utile climatizzazione estiva
	 */
	public void setFabbisognoEnergiaUtileClimatizzazioneEstiva(
			String fabbisognoEnergiaUtileClimatizzazioneEstiva) {
		this.fabbisognoEnergiaUtileClimatizzazioneEstiva = fabbisognoEnergiaUtileClimatizzazioneEstiva;
	}
	
	/**
	 * Gets the fabbisogno energia utile climatizzazione estiva.
	 *
	 * @return the fabbisogno energia utile climatizzazione estiva
	 */
	public String getFabbisognoEnergiaUtileClimatizzazioneEstiva() {
		return fabbisognoEnergiaUtileClimatizzazioneEstiva;
	}
	
	/**
	 * Sets the fabbisogno energia elettrica illuminazione.
	 *
	 * @param fabbisognoEnergiaElettricaIlluminazione the new fabbisogno energia elettrica illuminazione
	 */
	public void setFabbisognoEnergiaElettricaIlluminazione(
			String fabbisognoEnergiaElettricaIlluminazione) {
		this.fabbisognoEnergiaElettricaIlluminazione = fabbisognoEnergiaElettricaIlluminazione;
	}
	
	/**
	 * Gets the fabbisogno energia elettrica illuminazione.
	 *
	 * @return the fabbisogno energia elettrica illuminazione
	 */
	public String getFabbisognoEnergiaElettricaIlluminazione() {
		return fabbisognoEnergiaElettricaIlluminazione;
	}
	
	/**
	 * Sets the rendimento di generazione.
	 *
	 * @param rendimentoDiGenerazione the new rendimento di generazione
	 */
	public void setRendimentoDiGenerazione(String rendimentoDiGenerazione) {
		this.rendimentoDiGenerazione = rendimentoDiGenerazione;
	}
	
	/**
	 * Gets the rendimento di generazione.
	 *
	 * @return the rendimento di generazione
	 */
	public String getRendimentoDiGenerazione() {
		return rendimentoDiGenerazione;
	}
	
	/**
	 * Sets the rendimento di regolazione.
	 *
	 * @param rendimentoDiRegolazione the new rendimento di regolazione
	 */
	public void setRendimentoDiRegolazione(String rendimentoDiRegolazione) {
		this.rendimentoDiRegolazione = rendimentoDiRegolazione;
	}
	
	/**
	 * Gets the rendimento di regolazione.
	 *
	 * @return the rendimento di regolazione
	 */
	public String getRendimentoDiRegolazione() {
		return rendimentoDiRegolazione;
	}
	
	/**
	 * Sets the rendimento di emissione.
	 *
	 * @param rendimentoDiEmissione the new rendimento di emissione
	 */
	public void setRendimentoDiEmissione(String rendimentoDiEmissione) {
		this.rendimentoDiEmissione = rendimentoDiEmissione;
	}
	
	/**
	 * Gets the rendimento di emissione.
	 *
	 * @return the rendimento di emissione
	 */
	public String getRendimentoDiEmissione() {
		return rendimentoDiEmissione;
	}
	
	/**
	 * Sets the rendimento di distribuzione.
	 *
	 * @param rendimentoDiDistribuzione the new rendimento di distribuzione
	 */
	public void setRendimentoDiDistribuzione(String rendimentoDiDistribuzione) {
		this.rendimentoDiDistribuzione = rendimentoDiDistribuzione;
	}
	
	/**
	 * Gets the rendimento di distribuzione.
	 *
	 * @return the rendimento di distribuzione
	 */
	public String getRendimentoDiDistribuzione() {
		return rendimentoDiDistribuzione;
	}
	
	/**
	 * Sets the indice di prestazione energetica climatizzazione estiva.
	 *
	 * @param indiceDiPrestazioneEnergeticaClimatizzazioneEstiva the new indice di prestazione energetica climatizzazione estiva
	 */
	public void setIndiceDiPrestazioneEnergeticaClimatizzazioneEstiva(
			String indiceDiPrestazioneEnergeticaClimatizzazioneEstiva) {
		this.indiceDiPrestazioneEnergeticaClimatizzazioneEstiva = indiceDiPrestazioneEnergeticaClimatizzazioneEstiva;
	}
	
	/**
	 * Gets the indice di prestazione energetica climatizzazione estiva.
	 *
	 * @return the indice di prestazione energetica climatizzazione estiva
	 */
	public String getIndiceDiPrestazioneEnergeticaClimatizzazioneEstiva() {
		return indiceDiPrestazioneEnergeticaClimatizzazioneEstiva;
	}
	
	/**
	 * Sets the indice prestazione energetica illuminazione.
	 *
	 * @param indicePrestazioneEnergeticaIlluminazione the new indice prestazione energetica illuminazione
	 */
	public void setIndicePrestazioneEnergeticaIlluminazione(
			String indicePrestazioneEnergeticaIlluminazione) {
		this.indicePrestazioneEnergeticaIlluminazione = indicePrestazioneEnergeticaIlluminazione;
	}
	
	/**
	 * Gets the indice prestazione energetica illuminazione.
	 *
	 * @return the indice prestazione energetica illuminazione
	 */
	public String getIndicePrestazioneEnergeticaIlluminazione() {
		return indicePrestazioneEnergeticaIlluminazione;
	}
	
	/**
	 * Sets the indice prestazione energetica globale.
	 *
	 * @param indicePrestazioneEnergeticaGlobale the new indice prestazione energetica globale
	 */
	public void setIndicePrestazioneEnergeticaGlobale(
			String indicePrestazioneEnergeticaGlobale) {
		this.indicePrestazioneEnergeticaGlobale = indicePrestazioneEnergeticaGlobale;
	}
	
	/**
	 * Gets the indice prestazione energetica globale.
	 *
	 * @return the indice prestazione energetica globale
	 */
	public String getIndicePrestazioneEnergeticaGlobale() {
		return indicePrestazioneEnergeticaGlobale;
	}

	/**
	 * Gets the indice prest en glob.
	 *
	 * @return the indice prest en glob
	 */
	public String getIndicePrestEnGlob() {
		return indicePrestEnGlob;
	}
	
	/**
	 * Sets the limite di normativa regionale.
	 *
	 * @param limiteDiNormativaRegionale the new limite di normativa regionale
	 */
	public void setLimiteDiNormativaRegionale(String limiteDiNormativaRegionale) {
		this.limiteDiNormativaRegionale = limiteDiNormativaRegionale;
	}
	
	/**
	 * Gets the limite di normativa regionale.
	 *
	 * @return the limite di normativa regionale
	 */
	public String getLimiteDiNormativaRegionale() {
		return limiteDiNormativaRegionale;
	}
	
	/**
	 * Sets the e pacs to.
	 *
	 * @param ePacsTo the new e pacs to
	 */
	public void setePacsTo(String ePacsTo) {
		this.ePacsTo = ePacsTo;
	}
	
	/**
	 * Gets the e pacs to.
	 *
	 * @return the e pacs to
	 */
	public String getePacsTo() {
		return ePacsTo;
	}
	
	/**
	 * Sets the indice prest en glob.
	 *
	 * @param indicePrestEnGlob the new indice prest en glob
	 */
	public void setIndicePrestEnGlob(String indicePrestEnGlob) {
		this.indicePrestEnGlob = indicePrestEnGlob;
	}
	
	/**
	 * Gets the quota en cop f rin.
	 *
	 * @return the quota en cop f rin
	 */
	public String getQuotaEnCopFRin() {
		return quotaEnCopFRin;
	}
	
	/**
	 * Sets the quota en cop f rin.
	 *
	 * @param quotaEnCopFRin the new quota en cop f rin
	 */
	public void setQuotaEnCopFRin(String quotaEnCopFRin) {
		this.quotaEnCopFRin = quotaEnCopFRin;
	}
	
	/**
	 * Gets the classe energetica.
	 *
	 * @return the classe energetica
	 */
	public String getClasseEnergetica() {
		return classeEnergetica;
	}
	
	/**
	 * Sets the classe energetica.
	 *
	 * @param classeEnergetica the new classe energetica
	 */
	public void setClasseEnergetica(String classeEnergetica) {
		this.classeEnergetica = classeEnergetica;
	}
	
	/**
	 * Sets the servizi energetici inclusi nella classificazione.
	 *
	 * @param serviziEnergeticiInclusiNellaClassificazione the new servizi energetici inclusi nella classificazione
	 */
	public void setServiziEnergeticiInclusiNellaClassificazione(
			String serviziEnergeticiInclusiNellaClassificazione) {
		this.serviziEnergeticiInclusiNellaClassificazione = serviziEnergeticiInclusiNellaClassificazione;
	}
	
	/**
	 * Gets the servizi energetici inclusi nella classificazione.
	 *
	 * @return the servizi energetici inclusi nella classificazione
	 */
	public String getServiziEnergeticiInclusiNellaClassificazione() {
		return serviziEnergeticiInclusiNellaClassificazione;
	}
	
	/**
	 * Gets the ettari bosco.
	 *
	 * @return the ettari bosco
	 */
	public String getEttariBosco() {
		return ettariBosco;
	}
	
	/**
	 * Sets the ettari bosco.
	 *
	 * @param ettariBosco the new ettari bosco
	 */
	public void setEttariBosco(String ettariBosco) {
		this.ettariBosco = ettariBosco;
	}
	
	/**
	 * Gets the emissioni gas serra.
	 *
	 * @return the emissioni gas serra
	 */
	public String getEmissioniGasSerra() {
		return emissioniGasSerra;
	}
	
	/**
	 * Sets the emissioni gas serra.
	 *
	 * @param emissioniGasSerra the new emissioni gas serra
	 */
	public void setEmissioniGasSerra(String emissioniGasSerra) {
		this.emissioniGasSerra = emissioniGasSerra;
	}
	
	/**
	 * Gets the edificio intervento1.
	 *
	 * @return the edificio intervento1
	 */
	public String getEdificioIntervento1() {
		return edificioIntervento1;
	}
	
	/**
	 * Sets the edificio intervento1.
	 *
	 * @param edificioIntervento1 the new edificio intervento1
	 */
	public void setEdificioIntervento1(String edificioIntervento1) {
		this.edificioIntervento1 = edificioIntervento1;
	}
	
	/**
	 * Gets the edificio intervento2.
	 *
	 * @return the edificio intervento2
	 */
	public String getEdificioIntervento2() {
		return edificioIntervento2;
	}
	
	/**
	 * Sets the edificio intervento2.
	 *
	 * @param edificioIntervento2 the new edificio intervento2
	 */
	public void setEdificioIntervento2(String edificioIntervento2) {
		this.edificioIntervento2 = edificioIntervento2;
	}
	
	/**
	 * Gets the edificio intervento3.
	 *
	 * @return the edificio intervento3
	 */
	public String getEdificioIntervento3() {
		return edificioIntervento3;
	}
	
	/**
	 * Sets the edificio intervento3.
	 *
	 * @param edificioIntervento3 the new edificio intervento3
	 */
	public void setEdificioIntervento3(String edificioIntervento3) {
		this.edificioIntervento3 = edificioIntervento3;
	}
	
	/**
	 * Gets the edificio intervento4.
	 *
	 * @return the edificio intervento4
	 */
	public String getEdificioIntervento4() {
		return edificioIntervento4;
	}
	
	/**
	 * Sets the edificio intervento4.
	 *
	 * @param edificioIntervento4 the new edificio intervento4
	 */
	public void setEdificioIntervento4(String edificioIntervento4) {
		this.edificioIntervento4 = edificioIntervento4;
	}
	
	/**
	 * Gets the edificio priorita1.
	 *
	 * @return the edificio priorita1
	 */
	public String getEdificioPriorita1() {
		return edificioPriorita1;
	}
	
	/**
	 * Sets the edificio priorita1.
	 *
	 * @param edificioPriorita1 the new edificio priorita1
	 */
	public void setEdificioPriorita1(String edificioPriorita1) {
		this.edificioPriorita1 = edificioPriorita1;
	}
	
	/**
	 * Gets the edificio priorita2.
	 *
	 * @return the edificio priorita2
	 */
	public String getEdificioPriorita2() {
		return edificioPriorita2;
	}
	
	/**
	 * Sets the edificio priorita2.
	 *
	 * @param edificioPriorita2 the new edificio priorita2
	 */
	public void setEdificioPriorita2(String edificioPriorita2) {
		this.edificioPriorita2 = edificioPriorita2;
	}
	
	/**
	 * Gets the edificio priorita3.
	 *
	 * @return the edificio priorita3
	 */
	public String getEdificioPriorita3() {
		return edificioPriorita3;
	}
	
	/**
	 * Sets the edificio priorita3.
	 *
	 * @param edificioPriorita3 the new edificio priorita3
	 */
	public void setEdificioPriorita3(String edificioPriorita3) {
		this.edificioPriorita3 = edificioPriorita3;
	}
	
	/**
	 * Gets the edificio priorita4.
	 *
	 * @return the edificio priorita4
	 */
	public String getEdificioPriorita4() {
		return edificioPriorita4;
	}
	
	/**
	 * Sets the edificio priorita4.
	 *
	 * @param edificioPriorita4 the new edificio priorita4
	 */
	public void setEdificioPriorita4(String edificioPriorita4) {
		this.edificioPriorita4 = edificioPriorita4;
	}
	
	/**
	 * Gets the edificio tempo rit1.
	 *
	 * @return the edificio tempo rit1
	 */
	public String getEdificioTempoRit1() {
		return edificioTempoRit1;
	}
	
	/**
	 * Sets the edificio tempo rit1.
	 *
	 * @param edificioTempoRit1 the new edificio tempo rit1
	 */
	public void setEdificioTempoRit1(String edificioTempoRit1) {
		this.edificioTempoRit1 = edificioTempoRit1;
	}
	
	/**
	 * Gets the edificio tempo rit2.
	 *
	 * @return the edificio tempo rit2
	 */
	public String getEdificioTempoRit2() {
		return edificioTempoRit2;
	}
	
	/**
	 * Sets the edificio tempo rit2.
	 *
	 * @param edificioTempoRit2 the new edificio tempo rit2
	 */
	public void setEdificioTempoRit2(String edificioTempoRit2) {
		this.edificioTempoRit2 = edificioTempoRit2;
	}
	
	/**
	 * Gets the edificio tempo rit3.
	 *
	 * @return the edificio tempo rit3
	 */
	public String getEdificioTempoRit3() {
		return edificioTempoRit3;
	}
	
	/**
	 * Sets the edificio tempo rit3.
	 *
	 * @param edificioTempoRit3 the new edificio tempo rit3
	 */
	public void setEdificioTempoRit3(String edificioTempoRit3) {
		this.edificioTempoRit3 = edificioTempoRit3;
	}
	
	/**
	 * Gets the edificio tempo rit4.
	 *
	 * @return the edificio tempo rit4
	 */
	public String getEdificioTempoRit4() {
		return edificioTempoRit4;
	}
	
	/**
	 * Sets the edificio tempo rit4.
	 *
	 * @param edificioTempoRit4 the new edificio tempo rit4
	 */
	public void setEdificioTempoRit4(String edificioTempoRit4) {
		this.edificioTempoRit4 = edificioTempoRit4;
	}
	
	/**
	 * Gets the impianto intervento1.
	 *
	 * @return the impianto intervento1
	 */
	public String getImpiantoIntervento1() {
		return impiantoIntervento1;
	}
	
	/**
	 * Sets the impianto intervento1.
	 *
	 * @param impiantoIntervento1 the new impianto intervento1
	 */
	public void setImpiantoIntervento1(String impiantoIntervento1) {
		this.impiantoIntervento1 = impiantoIntervento1;
	}
	
	/**
	 * Gets the impianto intervento2.
	 *
	 * @return the impianto intervento2
	 */
	public String getImpiantoIntervento2() {
		return impiantoIntervento2;
	}
	
	/**
	 * Sets the impianto intervento2.
	 *
	 * @param impiantoIntervento2 the new impianto intervento2
	 */
	public void setImpiantoIntervento2(String impiantoIntervento2) {
		this.impiantoIntervento2 = impiantoIntervento2;
	}
	
	/**
	 * Gets the impianto intervento3.
	 *
	 * @return the impianto intervento3
	 */
	public String getImpiantoIntervento3() {
		return impiantoIntervento3;
	}
	
	/**
	 * Sets the impianto intervento3.
	 *
	 * @param impiantoIntervento3 the new impianto intervento3
	 */
	public void setImpiantoIntervento3(String impiantoIntervento3) {
		this.impiantoIntervento3 = impiantoIntervento3;
	}
	
	/**
	 * Gets the impianto intervento4.
	 *
	 * @return the impianto intervento4
	 */
	public String getImpiantoIntervento4() {
		return impiantoIntervento4;
	}
	
	/**
	 * Sets the impianto intervento4.
	 *
	 * @param impiantoIntervento4 the new impianto intervento4
	 */
	public void setImpiantoIntervento4(String impiantoIntervento4) {
		this.impiantoIntervento4 = impiantoIntervento4;
	}
	
	/**
	 * Gets the impianto priorita1.
	 *
	 * @return the impianto priorita1
	 */
	public String getImpiantoPriorita1() {
		return impiantoPriorita1;
	}
	
	/**
	 * Sets the impianto priorita1.
	 *
	 * @param impiantoPriorita1 the new impianto priorita1
	 */
	public void setImpiantoPriorita1(String impiantoPriorita1) {
		this.impiantoPriorita1 = impiantoPriorita1;
	}
	
	/**
	 * Gets the impianto priorita2.
	 *
	 * @return the impianto priorita2
	 */
	public String getImpiantoPriorita2() {
		return impiantoPriorita2;
	}
	
	/**
	 * Sets the impianto priorita2.
	 *
	 * @param impiantoPriorita2 the new impianto priorita2
	 */
	public void setImpiantoPriorita2(String impiantoPriorita2) {
		this.impiantoPriorita2 = impiantoPriorita2;
	}
	
	/**
	 * Gets the impianto priorita3.
	 *
	 * @return the impianto priorita3
	 */
	public String getImpiantoPriorita3() {
		return impiantoPriorita3;
	}
	
	/**
	 * Sets the impianto priorita3.
	 *
	 * @param impiantoPriorita3 the new impianto priorita3
	 */
	public void setImpiantoPriorita3(String impiantoPriorita3) {
		this.impiantoPriorita3 = impiantoPriorita3;
	}
	
	/**
	 * Gets the impianto priorita4.
	 *
	 * @return the impianto priorita4
	 */
	public String getImpiantoPriorita4() {
		return impiantoPriorita4;
	}
	
	/**
	 * Sets the impianto priorita4.
	 *
	 * @param impiantoPriorita4 the new impianto priorita4
	 */
	public void setImpiantoPriorita4(String impiantoPriorita4) {
		this.impiantoPriorita4 = impiantoPriorita4;
	}
	
	/**
	 * Gets the impianto tempo rit1.
	 *
	 * @return the impianto tempo rit1
	 */
	public String getImpiantoTempoRit1() {
		return impiantoTempoRit1;
	}
	
	/**
	 * Sets the impianto tempo rit1.
	 *
	 * @param impiantoTempoRit1 the new impianto tempo rit1
	 */
	public void setImpiantoTempoRit1(String impiantoTempoRit1) {
		this.impiantoTempoRit1 = impiantoTempoRit1;
	}
	
	/**
	 * Gets the impianto tempo rit2.
	 *
	 * @return the impianto tempo rit2
	 */
	public String getImpiantoTempoRit2() {
		return impiantoTempoRit2;
	}
	
	/**
	 * Sets the impianto tempo rit2.
	 *
	 * @param impiantoTempoRit2 the new impianto tempo rit2
	 */
	public void setImpiantoTempoRit2(String impiantoTempoRit2) {
		this.impiantoTempoRit2 = impiantoTempoRit2;
	}
	
	/**
	 * Gets the impianto tempo rit3.
	 *
	 * @return the impianto tempo rit3
	 */
	public String getImpiantoTempoRit3() {
		return impiantoTempoRit3;
	}
	
	/**
	 * Sets the impianto tempo rit3.
	 *
	 * @param impiantoTempoRit3 the new impianto tempo rit3
	 */
	public void setImpiantoTempoRit3(String impiantoTempoRit3) {
		this.impiantoTempoRit3 = impiantoTempoRit3;
	}
	
	/**
	 * Gets the impianto tempo rit4.
	 *
	 * @return the impianto tempo rit4
	 */
	public String getImpiantoTempoRit4() {
		return impiantoTempoRit4;
	}
	
	/**
	 * Sets the impianto tempo rit4.
	 *
	 * @param impiantoTempoRit4 the new impianto tempo rit4
	 */
	public void setImpiantoTempoRit4(String impiantoTempoRit4) {
		this.impiantoTempoRit4 = impiantoTempoRit4;
	}
	
	/**
	 * Gets the n certificato.
	 *
	 * @return the n certificato
	 */
	public String getNCertificato() {
		return nCertificato;
	}
	
	/**
	 * Sets the n certificato.
	 *
	 * @param certificato the new n certificato
	 */
	public void setNCertificato(String certificato) {
		nCertificato = certificato;
	}
	
	/**
	 * Gets the data scadenza.
	 *
	 * @return the data scadenza
	 */
	public String getDataScadenza() {
		return dataScadenza;
	}
	
	/**
	 * Sets the data scadenza.
	 *
	 * @param dataScadenza the new data scadenza
	 */
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	/**
	 * Gets the n certificato a.
	 *
	 * @return the n certificato a
	 */
	public String getNCertificatoA() {
		return nCertificatoA;
	}
	
	/**
	 * Sets the n certificato a.
	 *
	 * @param certificatoA the new n certificato a
	 */
	public void setNCertificatoA(String certificatoA) {
		nCertificatoA = certificatoA;
	}
	
	/**
	 * Gets the classe en glob naz edif.
	 *
	 * @return the classe en glob naz edif
	 */
	public String getClasseEnGlobNazEdif() {
		return classeEnGlobNazEdif;
	}
	
	/**
	 * Sets the classe en glob naz edif.
	 *
	 * @param classeEnGlobNazEdif the new classe en glob naz edif
	 */
	public void setClasseEnGlobNazEdif(String classeEnGlobNazEdif) {
		this.classeEnGlobNazEdif = classeEnGlobNazEdif;
	}
	
	/**
	 * Gets the prest ener ragg.
	 *
	 * @return the prest ener ragg
	 */
	public String getPrestEnerRagg() {
		return prestEnerRagg;
	}
	
	/**
	 * Sets the prest ener ragg.
	 *
	 * @param prestEnerRagg the new prest ener ragg
	 */
	public void setPrestEnerRagg(String prestEnerRagg) {
		this.prestEnerRagg = prestEnerRagg;
	}
	
	/**
	 * Gets the prest risc.
	 *
	 * @return the prest risc
	 */
	public String getPrestRisc() {
		return prestRisc;
	}
	
	/**
	 * Sets the prest risc.
	 *
	 * @param prestRisc the new prest risc
	 */
	public void setPrestRisc(String prestRisc) {
		this.prestRisc = prestRisc;
	}
	
	/**
	 * Gets the indice di prestazione energetica per il riscaldamento invernale to.
	 *
	 * @return the indice di prestazione energetica per il riscaldamento invernale to
	 */
	public String getIndiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo() {
		return indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo ;
	}
	
	/**
	 * Sets the indice di prestazione energetica per il riscaldamento invernale to.
	 *
	 * @param indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo the new indice di prestazione energetica per il riscaldamento invernale to
	 */
	public void setIndiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo(String indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo) {
		this.indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo  = indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleTo;
	}
	
	/**
	 * Sets the indice di prestazione energetica per il riscaldamento invernale nazionale.
	 *
	 * @param indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale the new indice di prestazione energetica per il riscaldamento invernale nazionale
	 */
	public void setIndiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale(
			String indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale) {
		this.indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale = indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale;
	}
	
	/**
	 * Gets the indice di prestazione energetica per il riscaldamento invernale nazionale.
	 *
	 * @return the indice di prestazione energetica per il riscaldamento invernale nazionale
	 */
	public String getIndiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale() {
		return indiceDiPrestazioneEnergeticaPerIlRiscaldamentoInvernaleNazionale;
	}
	
	/**
	 * Gets the limite norm naz risc.
	 *
	 * @return the limite norm naz risc
	 */
	public String getLimiteNormNazRisc() {
		return limiteNormNazRisc;
	}
	
	/**
	 * Sets the limite norm naz risc.
	 *
	 * @param limiteNormNazRisc the new limite norm naz risc
	 */
	public void setLimiteNormNazRisc(String limiteNormNazRisc) {
		this.limiteNormNazRisc = limiteNormNazRisc;
	}
	
	/**
	 * Gets the qualita inv raffresc.
	 *
	 * @return the qualita inv raffresc
	 */
	public String getQualitaInvRaffresc() {
		return qualitaInvRaffresc;
	}
	
	/**
	 * Sets the qualita inv raffresc.
	 *
	 * @param qualitaInvRaffresc the new qualita inv raffresc
	 */
	public void setQualitaInvRaffresc(String qualitaInvRaffresc) {
		this.qualitaInvRaffresc = qualitaInvRaffresc;
	}
	
	/**
	 * Gets the rendimento med glob stag imp.
	 *
	 * @return the rendimento med glob stag imp
	 */
	public String getRendimentoMedGlobStagImp() {
		return rendimentoMedGlobStagImp;
	}
	
	/**
	 * Sets the rendimento med glob stag imp.
	 *
	 * @param rendimentoMedGlobStagImp the new rendimento med glob stag imp
	 */
	public void setRendimentoMedGlobStagImp(String rendimentoMedGlobStagImp) {
		this.rendimentoMedGlobStagImp = rendimentoMedGlobStagImp;
	}
	
	/**
	 * Gets the limite norm rend med glob.
	 *
	 * @return the limite norm rend med glob
	 */
	public String getLimiteNormRendMedGlob() {
		return limiteNormRendMedGlob;
	}
	
	/**
	 * Sets the limite norm rend med glob.
	 *
	 * @param limiteNormRendMedGlob the new limite norm rend med glob
	 */
	public void setLimiteNormRendMedGlob(String limiteNormRendMedGlob) {
		this.limiteNormRendMedGlob = limiteNormRendMedGlob;
	}
	
	/**
	 * Gets the valore prest en pom cal.
	 *
	 * @return the valore prest en pom cal
	 */
	public String getValorePrestEnPomCal() {
		return valorePrestEnPomCal;
	}
	
	/**
	 * Sets the valore prest en pom cal.
	 *
	 * @param valorePrestEnPomCal the new valore prest en pom cal
	 */
	public void setValorePrestEnPomCal(String valorePrestEnPomCal) {
		this.valorePrestEnPomCal = valorePrestEnPomCal;
	}
	
	/**
	 * Sets the altre info.
	 *
	 * @param altreInfo the new altre info
	 */
	public void setAltreInfo(String altreInfo) {
		this.altreInfo = altreInfo;
	}
	
	/**
	 * Gets the altre info.
	 *
	 * @return the altre info
	 */
	public String getAltreInfo() {
		return altreInfo;
	}
	
	/**
	 * Sets the data effettuazione sopralluogo.
	 *
	 * @param dataEffettuazioneSopralluogo the new data effettuazione sopralluogo
	 */
	public void setDataEffettuazioneSopralluogo(
			String dataEffettuazioneSopralluogo) {
		this.dataEffettuazioneSopralluogo = dataEffettuazioneSopralluogo;
	}
	
	/**
	 * Gets the data effettuazione sopralluogo.
	 *
	 * @return the data effettuazione sopralluogo
	 */
	public String getDataEffettuazioneSopralluogo() {
		return dataEffettuazioneSopralluogo;
	}
	
	/**
	 * Sets the note sopralluogo.
	 *
	 * @param noteSopralluogo the new note sopralluogo
	 */
	public void setNoteSopralluogo(String noteSopralluogo) {
		this.noteSopralluogo = noteSopralluogo;
	}
	
	/**
	 * Gets the note sopralluogo.
	 *
	 * @return the note sopralluogo
	 */
	public String getNoteSopralluogo() {
		return noteSopralluogo;
	}
	
	/**
	 * Sets the dati redazione.
	 *
	 * @param datiRedazione the new dati redazione
	 */
	public void setDatiRedazione(String datiRedazione) {
		this.datiRedazione = datiRedazione;
	}
	
	/**
	 * Gets the dati redazione.
	 *
	 * @return the dati redazione
	 */
	public String getDatiRedazione() {
		return datiRedazione;
	}
	
	/**
	 * Sets the motivo non conformita.
	 *
	 * @param motivoNonConformita the new motivo non conformita
	 */
	public void setMotivoNonConformita(String motivoNonConformita) {
		this.motivoNonConformita = motivoNonConformita;
	}
	
	/**
	 * Gets the motivo non conformita.
	 *
	 * @return the motivo non conformita
	 */
	public String getMotivoNonConformita() {
		return motivoNonConformita;
	}
	
	/**
	 * Gets the motivo ril attest.
	 *
	 * @return the motivo ril attest
	 */
	public String getMotivoRilAttest() {
		return motivoRilAttest;
	}
	
	/**
	 * Sets the motivo ril attest.
	 *
	 * @param motivoRilAttest the new motivo ril attest
	 */
	public void setMotivoRilAttest(String motivoRilAttest) {
		this.motivoRilAttest = motivoRilAttest;
	}
	
	/**
	 * Gets the data tit abit costr.
	 *
	 * @return the data tit abit costr
	 */
	public String getDataTitAbitCostr() {
		return dataTitAbitCostr;
	}
	
	/**
	 * Sets the data tit abit costr.
	 *
	 * @param dataTitAbitCostr the new data tit abit costr
	 */
	public void setDataTitAbitCostr(String dataTitAbitCostr) {
		this.dataTitAbitCostr = dataTitAbitCostr;
	}
	
	/**
	 * Gets the n decreto lgs.
	 *
	 * @return the n decreto lgs
	 */
	public String getNDecretoLgs() {
		return nDecretoLgs;
	}
	
	/**
	 * Sets the n decreto lgs.
	 *
	 * @param decretoLgs the new n decreto lgs
	 */
	public void setNDecretoLgs(String decretoLgs) {
		nDecretoLgs = decretoLgs;
	}
	
	/**
	 * Gets the combo decreto lgs.
	 *
	 * @return the combo decreto lgs
	 */
	public String getComboDecretoLgs() {
		return comboDecretoLgs;
	}
	
	/**
	 * Sets the combo decreto lgs.
	 *
	 * @param comboDecretoLgs the new combo decreto lgs
	 */
	public void setComboDecretoLgs(String comboDecretoLgs) {
		this.comboDecretoLgs = comboDecretoLgs;
	}
	
	/**
	 * Sets the ulteriori note normative en.
	 *
	 * @param ulterioriNoteNormativeEn the new ulteriori note normative en
	 */
	public void setUlterioriNoteNormativeEn(String ulterioriNoteNormativeEn) {
		this.ulterioriNoteNormativeEn = ulterioriNoteNormativeEn;
	}
	
	/**
	 * Gets the ulteriori note normative en.
	 *
	 * @return the ulteriori note normative en
	 */
	public String getUlterioriNoteNormativeEn() {
		return ulterioriNoteNormativeEn;
	}
	
	/**
	 * Sets the impianto col bollino.
	 *
	 * @param impiantoColBollino the new impianto col bollino
	 */
	public void setImpiantoColBollino(String impiantoColBollino) {
		this.impiantoColBollino = impiantoColBollino;
	}
	
	/**
	 * Gets the impianto col bollino.
	 *
	 * @return the impianto col bollino
	 */
	public String getImpiantoColBollino() {
		return impiantoColBollino;
	}
	
	/**
	 * Sets the num bollino.
	 *
	 * @param numBollino the new num bollino
	 */
	public void setNumBollino(String numBollino) {
		this.numBollino = numBollino;
	}
	
	/**
	 * Gets the num bollino.
	 *
	 * @return the num bollino
	 */
	public String getNumBollino() {
		return numBollino;
	}
	
	/**
	 * Sets the codice impianto.
	 *
	 * @param codiceImpianto the new codice impianto
	 */
	public void setCodiceImpianto(String codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	
	/**
	 * Gets the codice impianto.
	 *
	 * @return the codice impianto
	 */
	public String getCodiceImpianto() {
		return codiceImpianto;
	}
	
	/**
	 * Sets the anno install generatore.
	 *
	 * @param annoInstallGeneratore the new anno install generatore
	 */
	public void setAnnoInstallGeneratore(String annoInstallGeneratore) {
		this.annoInstallGeneratore = annoInstallGeneratore;
	}
	
	/**
	 * Gets the anno install generatore.
	 *
	 * @return the anno install generatore
	 */
	public String getAnnoInstallGeneratore() {
		return annoInstallGeneratore;
	}
	
	/**
	 * Sets the potenza utile nominale complessiva.
	 *
	 * @param potenzaUtileNominaleComplessiva the new potenza utile nominale complessiva
	 */
	public void setPotenzaUtileNominaleComplessiva(
			String potenzaUtileNominaleComplessiva) {
		this.potenzaUtileNominaleComplessiva = potenzaUtileNominaleComplessiva;
	}
	
	/**
	 * Gets the potenza utile nominale complessiva.
	 *
	 * @return the potenza utile nominale complessiva
	 */
	public String getPotenzaUtileNominaleComplessiva() {
		return potenzaUtileNominaleComplessiva;
	}
	
	/**
	 * Sets the classe efficienza energetica.
	 *
	 * @param classeEfficienzaEnergetica the new classe efficienza energetica
	 */
	public void setClasseEfficienzaEnergetica(String classeEfficienzaEnergetica) {
		this.classeEfficienzaEnergetica = classeEfficienzaEnergetica;
	}
	
	/**
	 * Gets the classe efficienza energetica.
	 *
	 * @return the classe efficienza energetica
	 */
	public String getClasseEfficienzaEnergetica() {
		return classeEfficienzaEnergetica;
	}
	
	/**
	 * Sets the fonte energetica utilizzata.
	 *
	 * @param fonteEnergeticaUtilizzata the new fonte energetica utilizzata
	 */
	public void setFonteEnergeticaUtilizzata(String fonteEnergeticaUtilizzata) {
		this.fonteEnergeticaUtilizzata = fonteEnergeticaUtilizzata;
	}
	
	/**
	 * Gets the fonte energetica utilizzata.
	 *
	 * @return the fonte energetica utilizzata
	 */
	public String getFonteEnergeticaUtilizzata() {
		return fonteEnergeticaUtilizzata;
	}
	
	/**
	 * Sets the unita immobiliari servite.
	 *
	 * @param unitaImmobiliariServite the new unita immobiliari servite
	 */
	public void setUnitaImmobiliariServite(String unitaImmobiliariServite) {
		this.unitaImmobiliariServite = unitaImmobiliariServite;
	}
	
	/**
	 * Gets the unita immobiliari servite.
	 *
	 * @return the unita immobiliari servite
	 */
	public String getUnitaImmobiliariServite() {
		return unitaImmobiliariServite;
	}
	
	/**
	 * Sets the flg ripartizione.
	 *
	 * @param flgRipartizione the new flg ripartizione
	 */
	public void setFlgRipartizione(String flgRipartizione) {
		this.flgRipartizione = flgRipartizione;
	}
	
	/**
	 * Gets the flg ripartizione.
	 *
	 * @return the flg ripartizione
	 */
	public String getFlgRipartizione() {
		return flgRipartizione;
	}
	
	/**
	 * Sets the tipo impianto.
	 *
	 * @param tipoImpianto the new tipo impianto
	 */
	public void setTipoImpianto(String tipoImpianto) {
		this.tipoImpianto = tipoImpianto;
	}
	
	/**
	 * Gets the tipo impianto.
	 *
	 * @return the tipo impianto
	 */
	public String getTipoImpianto() {
		return tipoImpianto;
	}
	
	/**
	 * Sets the tipo terminali erogazione.
	 *
	 * @param tipoTerminaliErogazione the new tipo terminali erogazione
	 */
	public void setTipoTerminaliErogazione(String tipoTerminaliErogazione) {
		this.tipoTerminaliErogazione = tipoTerminaliErogazione;
	}
	
	/**
	 * Gets the tipo terminali erogazione.
	 *
	 * @return the tipo terminali erogazione
	 */
	public String getTipoTerminaliErogazione() {
		return tipoTerminaliErogazione;
	}
	
	/**
	 * Sets the tipo di distribuzione.
	 *
	 * @param tipoDiDistribuzione the new tipo di distribuzione
	 */
	public void setTipoDiDistribuzione(String tipoDiDistribuzione) {
		this.tipoDiDistribuzione = tipoDiDistribuzione;
	}
	
	/**
	 * Gets the tipo di distribuzione.
	 *
	 * @return the tipo di distribuzione
	 */
	public String getTipoDiDistribuzione() {
		return tipoDiDistribuzione;
	}
	
	/**
	 * Sets the tipo di regolazione.
	 *
	 * @param tipoDiRegolazione the new tipo di regolazione
	 */
	public void setTipoDiRegolazione(String tipoDiRegolazione) {
		this.tipoDiRegolazione = tipoDiRegolazione;
	}
	
	/**
	 * Gets the tipo di regolazione.
	 *
	 * @return the tipo di regolazione
	 */
	public String getTipoDiRegolazione() {
		return tipoDiRegolazione;
	}
	
	/**
	 * Sets the anno installazione sistema.
	 *
	 * @param annoInstallazioneSistema the new anno installazione sistema
	 */
	public void setAnnoInstallazioneSistema(String annoInstallazioneSistema) {
		this.annoInstallazioneSistema = annoInstallazioneSistema;
	}
	
	/**
	 * Gets the anno installazione sistema.
	 *
	 * @return the anno installazione sistema
	 */
	public String getAnnoInstallazioneSistema() {
		return annoInstallazioneSistema;
	}
	
	/**
	 * Sets the potenza utile nominale complessiva per acqua calda.
	 *
	 * @param potenzaUtileNominaleComplessivaPerAcquaCalda the new potenza utile nominale complessiva per acqua calda
	 */
	public void setPotenzaUtileNominaleComplessivaPerAcquaCalda(
			String potenzaUtileNominaleComplessivaPerAcquaCalda) {
		this.potenzaUtileNominaleComplessivaPerAcquaCalda = potenzaUtileNominaleComplessivaPerAcquaCalda;
	}
	
	/**
	 * Gets the potenza utile nominale complessiva per acqua calda.
	 *
	 * @return the potenza utile nominale complessiva per acqua calda
	 */
	public String getPotenzaUtileNominaleComplessivaPerAcquaCalda() {
		return potenzaUtileNominaleComplessivaPerAcquaCalda;
	}
	
	/**
	 * Sets the classe efficienza energetica per acqua calda.
	 *
	 * @param classeEfficienzaEnergeticaPerAcquaCalda the new classe efficienza energetica per acqua calda
	 */
	public void setClasseEfficienzaEnergeticaPerAcquaCalda(
			String classeEfficienzaEnergeticaPerAcquaCalda) {
		this.classeEfficienzaEnergeticaPerAcquaCalda = classeEfficienzaEnergeticaPerAcquaCalda;
	}
	
	/**
	 * Gets the classe efficienza energetica per acqua calda.
	 *
	 * @return the classe efficienza energetica per acqua calda
	 */
	public String getClasseEfficienzaEnergeticaPerAcquaCalda() {
		return classeEfficienzaEnergeticaPerAcquaCalda;
	}
	
	/**
	 * Sets the fonte energetica utilizzata per acqua calda.
	 *
	 * @param fonteEnergeticaUtilizzataPerAcquaCalda the new fonte energetica utilizzata per acqua calda
	 */
	public void setFonteEnergeticaUtilizzataPerAcquaCalda(
			String fonteEnergeticaUtilizzataPerAcquaCalda) {
		this.fonteEnergeticaUtilizzataPerAcquaCalda = fonteEnergeticaUtilizzataPerAcquaCalda;
	}
	
	/**
	 * Gets the fonte energetica utilizzata per acqua calda.
	 *
	 * @return the fonte energetica utilizzata per acqua calda
	 */
	public String getFonteEnergeticaUtilizzataPerAcquaCalda() {
		return fonteEnergeticaUtilizzataPerAcquaCalda;
	}
	
	/**
	 * Gets the annuale termico da fossile.
	 *
	 * @return the annuale termico da fossile
	 */
	public String getAnnualeTermicoDaFossile() {
		return annualeTermicoDaFossile;
	}
	
	/**
	 * Sets the annuale termico da fossile.
	 *
	 * @param annualeTermicoDaFossile the new annuale termico da fossile
	 */
	public void setAnnualeTermicoDaFossile(String annualeTermicoDaFossile) {
		this.annualeTermicoDaFossile = annualeTermicoDaFossile;
	}
	
	/**
	 * Gets the annuale elettrico da fossile.
	 *
	 * @return the annuale elettrico da fossile
	 */
	public String getAnnualeElettricoDaFossile() {
		return annualeElettricoDaFossile;
	}
	
	/**
	 * Sets the annuale elettrico da fossile.
	 *
	 * @param annualeElettricoDaFossile the new annuale elettrico da fossile
	 */
	public void setAnnualeElettricoDaFossile(String annualeElettricoDaFossile) {
		this.annualeElettricoDaFossile = annualeElettricoDaFossile;
	}
	
	/**
	 * Gets the annuale termico da fonti rinnovabili.
	 *
	 * @return the annuale termico da fonti rinnovabili
	 */
	public String getAnnualeTermicoDaFontiRinnovabili() {
		return annualeTermicoDaFontiRinnovabili;
	}
	
	/**
	 * Sets the annuale termico da fonti rinnovabili.
	 *
	 * @param annualeTermicoDaFontiRinnovabili the new annuale termico da fonti rinnovabili
	 */
	public void setAnnualeTermicoDaFontiRinnovabili(
			String annualeTermicoDaFontiRinnovabili) {
		this.annualeTermicoDaFontiRinnovabili = annualeTermicoDaFontiRinnovabili;
	}
	
	/**
	 * Gets the annuale elettrico da fonti rinnovabili.
	 *
	 * @return the annuale elettrico da fonti rinnovabili
	 */
	public String getAnnualeElettricoDaFontiRinnovabili() {
		return annualeElettricoDaFontiRinnovabili;
	}
	
	/**
	 * Sets the annuale elettrico da fonti rinnovabili.
	 *
	 * @param annualeElettricoDaFontiRinnovabili the new annuale elettrico da fonti rinnovabili
	 */
	public void setAnnualeElettricoDaFontiRinnovabili(
			String annualeElettricoDaFontiRinnovabili) {
		this.annualeElettricoDaFontiRinnovabili = annualeElettricoDaFontiRinnovabili;
	}
	
	/**
	 * Gets the medio complessivo termico.
	 *
	 * @return the medio complessivo termico
	 */
	public String getMedioComplessivoTermico() {
		return medioComplessivoTermico;
	}
	
	/**
	 * Sets the medio complessivo termico.
	 *
	 * @param medioComplessivoTermico the new medio complessivo termico
	 */
	public void setMedioComplessivoTermico(String medioComplessivoTermico) {
		this.medioComplessivoTermico = medioComplessivoTermico;
	}
	
	/**
	 * Gets the medio complessivo elettrico.
	 *
	 * @return the medio complessivo elettrico
	 */
	public String getMedioComplessivoElettrico() {
		return medioComplessivoElettrico;
	}
	
	/**
	 * Sets the medio complessivo elettrico.
	 *
	 * @param medioComplessivoElettrico the new medio complessivo elettrico
	 */
	public void setMedioComplessivoElettrico(String medioComplessivoElettrico) {
		this.medioComplessivoElettrico = medioComplessivoElettrico;
	}
	
	/**
	 * Gets the nome certificatore.
	 *
	 * @return the nome certificatore
	 */
	public String getNomeCertificatore() {
		return nomeCertificatore;
	}
	
	/**
	 * Sets the nome certificatore.
	 *
	 * @param nomeCertificatore the new nome certificatore
	 */
	public void setNomeCertificatore(String nomeCertificatore) {
		this.nomeCertificatore = nomeCertificatore;
	}
	
	/**
	 * Gets the luogo nascita certificatore.
	 *
	 * @return the luogo nascita certificatore
	 */
	public String getLuogoNascitaCertificatore() {
		return luogoNascitaCertificatore;
	}
	
	/**
	 * Sets the luogo nascita certificatore.
	 *
	 * @param luogoNascitaCertificatore the new luogo nascita certificatore
	 */
	public void setLuogoNascitaCertificatore(String luogoNascitaCertificatore) {
		this.luogoNascitaCertificatore = luogoNascitaCertificatore;
	}
	
	/**
	 * Gets the data nascita certificatore.
	 *
	 * @return the data nascita certificatore
	 */
	public String getDataNascitaCertificatore() {
		return dataNascitaCertificatore;
	}
	
	/**
	 * Sets the data nascita certificatore.
	 *
	 * @param dataNascitaCertificatore the new data nascita certificatore
	 */
	public void setDataNascitaCertificatore(String dataNascitaCertificatore) {
		this.dataNascitaCertificatore = dataNascitaCertificatore;
	}
	
	/**
	 * Gets the luogo residenza certificatore.
	 *
	 * @return the luogo residenza certificatore
	 */
	public String getLuogoResidenzaCertificatore() {
		return luogoResidenzaCertificatore;
	}
	
	/**
	 * Sets the luogo residenza certificatore.
	 *
	 * @param luogoResidenzaCertificatore the new luogo residenza certificatore
	 */
	public void setLuogoResidenzaCertificatore(String luogoResidenzaCertificatore) {
		this.luogoResidenzaCertificatore = luogoResidenzaCertificatore;
	}
	
	/**
	 * Gets the cf certificatore.
	 *
	 * @return the cf certificatore
	 */
	public String getCfCertificatore() {
		return cfCertificatore;
	}
	
	/**
	 * Sets the cf certificatore.
	 *
	 * @param cfCertificatore the new cf certificatore
	 */
	public void setCfCertificatore(String cfCertificatore) {
		this.cfCertificatore = cfCertificatore;
	}
	
	/**
	 * Gets the luogo compilazione.
	 *
	 * @return the luogo compilazione
	 */
	public String getLuogoCompilazione() {
		return luogoCompilazione;
	}
	
	/**
	 * Sets the luogo compilazione.
	 *
	 * @param luogoCompilazione the new luogo compilazione
	 */
	public void setLuogoCompilazione(String luogoCompilazione) {
		this.luogoCompilazione = luogoCompilazione;
	}
	
	/**
	 * Gets the data compilazione.
	 *
	 * @return the data compilazione
	 */
	public String getDataCompilazione() {
		return dataCompilazione;
	}
	
	/**
	 * Sets the data compilazione.
	 *
	 * @param dataCompilazione the new data compilazione
	 */
	public void setDataCompilazione(String dataCompilazione) {
		this.dataCompilazione = dataCompilazione;
	}
	
	/**
	 * Gets the firma certificatore.
	 *
	 * @return the firma certificatore
	 */
	public String getFirmaCertificatore() {
		return firmaCertificatore;
	}
	
	/**
	 * Sets the firma certificatore.
	 *
	 * @param firmaCertificatore the new firma certificatore
	 */
	public void setFirmaCertificatore(String firmaCertificatore) {
		this.firmaCertificatore = firmaCertificatore;
	}
	
	/**
	 * Gets the radio certificazione.
	 *
	 * @return the radio certificazione
	 */
	public String getRadioCertificazione() {
		return radioCertificazione;
	}
	
	/**
	 * Sets the radio certificazione.
	 *
	 * @param radioCertificazione the new radio certificazione
	 */
	public void setRadioCertificazione(String radioCertificazione) {
		this.radioCertificazione = radioCertificazione;
	}
	
	/**
	 * Gets the limite norm prest en pom cal.
	 *
	 * @return the limite norm prest en pom cal
	 */
	public String getLimiteNormPrestEnPomCal() {
		return limiteNormPrestEnPomCal;
	}
	
	/**
	 * Sets the limite norm prest en pom cal.
	 *
	 * @param limiteNormPrestEnPomCal the new limite norm prest en pom cal
	 */
	public void setLimiteNormPrestEnPomCal(String limiteNormPrestEnPomCal) {
		this.limiteNormPrestEnPomCal = limiteNormPrestEnPomCal;
	}
	
	/**
	 * Gets the sup utile sum cubi.
	 *
	 * @return the sup utile sum cubi
	 */
	public String getSupUtileSumCubi() {
		return supUtileSumCubi;
	}
	
	/**
	 * Sets the sup utile sum cubi.
	 *
	 * @param supUtileSumCubi the new sup utile sum cubi
	 */
	public void setSupUtileSumCubi(String supUtileSumCubi) {
		this.supUtileSumCubi = supUtileSumCubi;
	}
	
	/**
	 * Gets the zona clim gradi giorno.
	 *
	 * @return the zona clim gradi giorno
	 */
	public String getZonaClimGradiGiorno() {
		return zonaClimGradiGiorno;
	}
	
	/**
	 * Sets the zona clim gradi giorno.
	 *
	 * @param zonaClimGradiGiorno the new zona clim gradi giorno
	 */
	public void setZonaClimGradiGiorno(String zonaClimGradiGiorno) {
		this.zonaClimGradiGiorno = zonaClimGradiGiorno;
	}
	
	/**
	 * Gets the foto edificio.
	 *
	 * @return the foto edificio
	 */
	public InputStream getFotoEdificio() {
		return fotoEdificio;
	}
	
	/**
	 * Sets the foto edificio.
	 *
	 * @param fotoEdificio the new foto edificio
	 */
	public void setFotoEdificio(InputStream fotoEdificio) {
		this.fotoEdificio = fotoEdificio;
	}
	
	/**
	 * Gets the quoziente qhw.
	 *
	 * @return the quoziente qhw
	 */
	public Float getQuozienteQhw() {
		return quozienteQhw;
	}
	
	/**
	 * Sets the quoziente qhw.
	 *
	 * @param quozienteQhw the new quoziente qhw
	 */
	public void setQuozienteQhw(Float quozienteQhw) {
		this.quozienteQhw = quozienteQhw;
	}
	
	/**
	 * Gets the quoziente qh.
	 *
	 * @return the quoziente qh
	 */
	public Float getQuozienteQh() {
		return quozienteQh;
	}
	
	/**
	 * Sets the quoziente qh.
	 *
	 * @param quozienteQh the new quoziente qh
	 */
	public void setQuozienteQh(Float quozienteQh) {
		this.quozienteQh = quozienteQh;
	}
	
	/**
	 * Gets the quoziente emissione gas serra.
	 *
	 * @return the quoziente emissione gas serra
	 */
	public Float getQuozienteEmissioneGasSerra() {
		return quozienteEmissioneGasSerra;
	}
	
	/**
	 * Sets the quoziente emissione gas serra.
	 *
	 * @param quozienteEmissioneGasSerra the new quoziente emissione gas serra
	 */
	public void setQuozienteEmissioneGasSerra(Float quozienteEmissioneGasSerra) {
		this.quozienteEmissioneGasSerra = quozienteEmissioneGasSerra;
	}
	
	/**
	 * Gets the classe energetica linea.
	 *
	 * @return the classe energetica linea
	 */
	public String getClasseEnergeticaLinea() {
		return classeEnergeticaLinea;
	}
	
	/**
	 * Sets the classe energetica linea.
	 *
	 * @param classeEnergeticaLinea the new classe energetica linea
	 */
	public void setClasseEnergeticaLinea(String classeEnergeticaLinea) {
		this.classeEnergeticaLinea = classeEnergeticaLinea;
	}
	
	/**
	 * Sets the tecnologie uso fonti rinnovabili.
	 *
	 * @param tecnologieUsoFontiRinnovabili the new tecnologie uso fonti rinnovabili
	 */
	public void setTecnologieUsoFontiRinnovabili(
			String tecnologieUsoFontiRinnovabili) {
		this.tecnologieUsoFontiRinnovabili = tecnologieUsoFontiRinnovabili;
	}
	
	/**
	 * Gets the tecnologie uso fonti rinnovabili.
	 *
	 * @return the tecnologie uso fonti rinnovabili
	 */
	public String getTecnologieUsoFontiRinnovabili() {
		return tecnologieUsoFontiRinnovabili;
	}
	
	/**
	 * Sets the anno installazione.
	 *
	 * @param annoInstallazione the new anno installazione
	 */
	public void setAnnoInstallazione(String annoInstallazione) {
		this.annoInstallazione = annoInstallazione;
	}
	
	/**
	 * Gets the anno installazione.
	 *
	 * @return the anno installazione
	 */
	public String getAnnoInstallazione() {
		return annoInstallazione;
	}
	
	/**
	 * Sets the energia termica prodotta.
	 *
	 * @param energiaTermicaProdotta the new energia termica prodotta
	 */
	public void setEnergiaTermicaProdotta(String energiaTermicaProdotta) {
		this.energiaTermicaProdotta = energiaTermicaProdotta;
	}
	
	/**
	 * Gets the energia termica prodotta.
	 *
	 * @return the energia termica prodotta
	 */
	public String getEnergiaTermicaProdotta() {
		return energiaTermicaProdotta;
	}
	
	/**
	 * Sets the energia elettrica prodotta.
	 *
	 * @param energiaElettricaProdotta the new energia elettrica prodotta
	 */
	public void setEnergiaElettricaProdotta(String energiaElettricaProdotta) {
		this.energiaElettricaProdotta = energiaElettricaProdotta;
	}
	
	/**
	 * Gets the energia elettrica prodotta.
	 *
	 * @return the energia elettrica prodotta
	 */
	public String getEnergiaElettricaProdotta() {
		return energiaElettricaProdotta;
	}
	
	/**
	 * Sets the autoconsumo termico.
	 *
	 * @param autoconsumoTermico the new autoconsumo termico
	 */
	public void setAutoconsumoTermico(String autoconsumoTermico) {
		this.autoconsumoTermico = autoconsumoTermico;
	}
	
	/**
	 * Gets the autoconsumo termico.
	 *
	 * @return the autoconsumo termico
	 */
	public String getAutoconsumoTermico() {
		return autoconsumoTermico;
	}
	
	/**
	 * Sets the autoconsumo elettrico.
	 *
	 * @param autoconsumoElettrico the new autoconsumo elettrico
	 */
	public void setAutoconsumoElettrico(String autoconsumoElettrico) {
		this.autoconsumoElettrico = autoconsumoElettrico;
	}
	
	/**
	 * Gets the autoconsumo elettrico.
	 *
	 * @return the autoconsumo elettrico
	 */
	public String getAutoconsumoElettrico() {
		return autoconsumoElettrico;
	}
	
	/**
	 * Sets the motivazione rilascio.
	 *
	 * @param motivazioneRilascio the new motivazione rilascio
	 */
	public void setMotivazioneRilascio(String motivazioneRilascio) {
		this.motivazioneRilascio = motivazioneRilascio;
	}
	
	/**
	 * Gets the motivazione rilascio.
	 *
	 * @return the motivazione rilascio
	 */
	public String getMotivazioneRilascio() {
		return motivazioneRilascio;
	}
	
	/**
	 * Sets the metodologia di calcolo adottata.
	 *
	 * @param metodologiaDiCalcoloAdottata the new metodologia di calcolo adottata
	 */
	public void setMetodologiaDiCalcoloAdottata(
			String metodologiaDiCalcoloAdottata) {
		this.metodologiaDiCalcoloAdottata = metodologiaDiCalcoloAdottata;
	}
	
	/**
	 * Gets the metodologia di calcolo adottata.
	 *
	 * @return the metodologia di calcolo adottata
	 */
	public String getMetodologiaDiCalcoloAdottata() {
		return metodologiaDiCalcoloAdottata;
	}
	
	/**
	 * Sets the software utilizzato.
	 *
	 * @param softwareUtilizzato the new software utilizzato
	 */
	public void setSoftwareUtilizzato(String softwareUtilizzato) {
		this.softwareUtilizzato = softwareUtilizzato;
	}
	
	/**
	 * Gets the software utilizzato.
	 *
	 * @return the software utilizzato
	 */
	public String getSoftwareUtilizzato() {
		return softwareUtilizzato;
	}
	
	/**
	 * Sets the denominazione produttore.
	 *
	 * @param denominazioneProduttore the new denominazione produttore
	 */
	public void setDenominazioneProduttore(String denominazioneProduttore) {
		this.denominazioneProduttore = denominazioneProduttore;
	}
	
	/**
	 * Gets the denominazione produttore.
	 *
	 * @return the denominazione produttore
	 */
	public String getDenominazioneProduttore() {
		return denominazioneProduttore;
	}
	
	/**
	 * Sets the rispondenza aunit s11300.
	 *
	 * @param rispondenzaAUNITS11300 the new rispondenza aunit s11300
	 */
	public void setRispondenzaAUNITS11300(String rispondenzaAUNITS11300) {
		this.rispondenzaAUNITS11300 = rispondenzaAUNITS11300;
	}
	
	/**
	 * Gets the rispondenza aunit s11300.
	 *
	 * @return the rispondenza aunit s11300
	 */
	public String getRispondenzaAUNITS11300() {
		return rispondenzaAUNITS11300;
	}
	
	
}
