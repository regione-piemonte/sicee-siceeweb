/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.OptimizedSiceeTCredito2018Dao;
import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCredito2018;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCredito2018DaoException;
import it.csi.sicee.siceeweb.util.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class OptimizedSiceeTCredito2018DaoImpl extends AbstractDAO implements
		ParameterizedRowMapper<OptimizedSiceeTCredito2018>,
		OptimizedSiceeTCredito2018Dao {

	protected static final Logger log = Logger
			.getLogger(Constants.APPLICATION_CODE + ".business");

	//protected SimpleJdbcTemplate jdbcTemplate;
	protected JdbcTemplate jdbcTemplate;
	protected DataSource dataSource;

	/**
	 * Method 'setDataSource'
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Method 'executeByFkCertificatore'.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return List<OptimizedSiceeTCredito>
	 * @throws OptimizedSiceeTCreditoDaoException the optimized sicee t credito dao exception
	 */	
	public List<OptimizedSiceeTCredito2018> executeByFkCertificatore(
			String fkCertificatore, String codTipoRic)
			throws OptimizedSiceeTCredito2018DaoException {
		try {
			StringBuffer query = new StringBuffer("");

			query.append("SELECT * FROM ");
			query.append("(SELECT ID_CREDITO, cr.FK_CERTIFICATORE, tr.S1_ID_TRANSAZIONE_MDP, FK_TIPO_OP_2018, d.DESCR_TIPO_OP_2018, VALORE_CREDITO_INIZIALE, ");
			query.append("VALORE_CREDITO_FINALE, DATA_OPERAZIONE, VALORE_OPERAZIONE, ce.NUM_CERTIFICATORE, FK_CERTIFICATORE_CERTIFICATO, ");
			query.append("PROGR_CERTIFICATO, ANNO ");
			query.append("FROM SICEE_T_CREDITO_2018 cr, SICEE_D_TIPO_OP_2018 d, SICEE_T_CERTIFICATORE ce, SICEE_T_TRANSAZIONE_2018 tr ");
			query.append("WHERE cr.FK_CERTIFICATORE = ? ");
			query.append("AND cr.FK_TIPO_OP_2018 = d.ID_TIPO_OP_2018 ");
			query.append("AND cr.FK_CERTIFICATORE_CERTIFICATO = ce.ID_CERTIFICATORE (+) ");
			query.append("AND cr.FK_TRANSAZIONE_2018 = tr.ID_TRANSAZIONE_2018 (+) ");
			query.append("ORDER BY ID_CREDITO DESC) ");

			if (codTipoRic.equals(Constants.COD_TIPO_RICERCA_PARZ))
			{
				query.append(" WHERE ROWNUM <= "+Constants.NUM_RICERCA_PARZ);
			}
			
			
			if (log.isDebugEnabled())
				log.debug(query);

			return jdbcTemplate.query(query.toString(), this, fkCertificatore);
			
		} catch (Exception e) {
			throw new OptimizedSiceeTCredito2018DaoException("Query failed", e);
		}

	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return OptimizedSiceeTCredito
	 */
	
	public OptimizedSiceeTCredito2018 mapRow(ResultSet rs, int row) throws SQLException
	{
		OptimizedSiceeTCredito2018 dto = new OptimizedSiceeTCredito2018();
		
		dto.setIdCredito(new Integer( rs.getInt( 1 ) ));

		dto.setFkCertificatore( rs.getString( 2 ) );
		dto.setIdTransazioneMdp( rs.getString( 3 ) );
		dto.setFkTipoOp2018( new Integer( rs.getInt(4) ) );
		dto.setDescrTipoOp2018( rs.getString( 5 ) );
		dto.setValoreCreditoIniziale( new Double( rs.getDouble( 6 ) ));
		if (rs.wasNull()) {
			dto.setValoreCreditoInizialeNull( true );
		}
		dto.setValoreCreditoFinale( new Double( rs.getDouble( 7 ) ));
		if (rs.wasNull()) {
			dto.setValoreCreditoFinaleNull( true );
		}
		dto.setDataOperazione( rs.getTimestamp( 8 ) );
		dto.setValoreOperazione( new Double( rs.getDouble( 9 ) ));
		if (rs.wasNull()) {
			dto.setValoreOperazioneNull( true );
		}
		dto.setNumCertificatore( rs.getString( 10 ) );
		dto.setFkCertificatoreCertificato( rs.getString( 11 ) );
		dto.setProgrCertificato( rs.getString( 12 ) );
		dto.setAnno( rs.getString( 13 ) );
		
		return dto;
	}
	
}
