/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.OptimizedSiceeTCorso2015Dao;
import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCorso2015;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCorso2015DaoException;
import it.csi.sicee.siceeweb.util.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class OptimizedSiceeTCorso2015DaoImpl extends AbstractDAO implements
		ParameterizedRowMapper<OptimizedSiceeTCorso2015>,
		OptimizedSiceeTCorso2015Dao {

	protected static final Logger log = Logger
			.getLogger(Constants.APPLICATION_CODE + ".business");

	protected SimpleJdbcTemplate jdbcTemplate;
	protected DataSource dataSource;

	/**
	 * Method 'setDataSource'
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	/**
	 * Method 'executeByCodiceFiscale'.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return List<OptimizedSiceeTCorso2015>
	 * @throws OptimizedSiceeTCorso2015DaoException the optimized sicee t corso 2015 dao exception
	 */	
	public List<OptimizedSiceeTCorso2015> executeByCodiceFiscale(
			String codiceFiscale)
			throws OptimizedSiceeTCorso2015DaoException {
		try {
			//StringBuffer query = getInitQueryCertificati();

			StringBuffer query = new StringBuffer("");

			query.append("SELECT C.ID_CORSO AS ID_CORSO,");
			query.append(" C.TITOLO AS TITOLO,");
			query.append(" ESL.DENOMINAZIONE AS DENOMINAZIONE,");
			query.append(" C.TOTALE_ORE AS TOTALE_ORE,");
			query.append(" P.DATA_ESAME AS DATA_ESAME,");
			query.append(" P.ESITO_ESAME AS ESITO_ESAME,");
			query.append(" (SELECT IDENTIFIC_DOC FROM SICEE_T_DOCUMENTO D");
			query.append(" WHERE D.FK_CORSO = C.ID_CORSO");
			query.append(" AND D.ID_CERTIFICATORE = (SELECT ID_CERTIFICATORE");
			query.append(" FROM SICEE_T_CERTIFICATORE");
			query.append(" WHERE CODICE_FISCALE = ?)) AS IDENTIFIC_DOC");
			query.append(" FROM SICEE_T_ENTEFORM_SL_2015 ESL,");
			query.append(" SICEE_T_ENTEFORM_2015 E, SICEE_T_CORSO_2015 C,");
			query.append(" SICEE_T_PARTECIPANTE_2015 P");
			query.append(" WHERE ESL.ID_ENTE_SL = E.FK_ENTE_SL");
			query.append(" AND E.ID_ENTE = C.FK_ENTE");
			query.append(" AND C.ID_CORSO = P.FK_CORSO");
			query.append(" AND P.CODICE_FISCALE = ?");
			query.append(" ORDER BY P.DATA_ESAME");

			if (log.isDebugEnabled())
				log.debug(query);
			
			return jdbcTemplate.query(query.toString(), this, codiceFiscale, codiceFiscale);
		} catch (Exception e) {
			throw new OptimizedSiceeTCorso2015DaoException("Query failed", e);
		}

	}

	private StringBuffer getInitQueryCertificati() {
		StringBuffer query = new StringBuffer("");
		return query;
	}

	
	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return OptimizedSiceeTCorso2015
	 */
	public OptimizedSiceeTCorso2015 mapRow(ResultSet rs, int row)
			throws SQLException {
		OptimizedSiceeTCorso2015 dto = new OptimizedSiceeTCorso2015();

		dto.setIdCorso(rs.getInt(1));
		dto.setTitolo(rs.getString(2));
		dto.setDenominazione(rs.getString(3));
		dto.setTotaleOre(rs.getInt(4));
		if (rs.wasNull()) {
			dto.setTotaleOre(null);
		}
		dto.setDataEsame(rs.getDate(5));
		dto.setEsitoEsame(rs.getString(6));
		dto.setIdentificDoc(rs.getString(7));

		return dto;
	}

	
}
