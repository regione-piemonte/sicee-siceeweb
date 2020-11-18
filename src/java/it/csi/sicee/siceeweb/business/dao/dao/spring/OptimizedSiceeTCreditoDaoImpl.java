/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.OptimizedSiceeTCreditoDao;
import it.csi.sicee.siceeweb.business.dao.dto.OptimizedSiceeTCredito;
import it.csi.sicee.siceeweb.business.dao.exceptions.OptimizedSiceeTCreditoDaoException;
import it.csi.sicee.siceeweb.util.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class OptimizedSiceeTCreditoDaoImpl extends AbstractDAO implements
		ParameterizedRowMapper<OptimizedSiceeTCredito>,
		OptimizedSiceeTCreditoDao {

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
	public OptimizedSiceeTCredito executeByFkCertificatore(
			String fkCertificatore)
			throws OptimizedSiceeTCreditoDaoException {
		try {
			StringBuffer query = new StringBuffer("");

			query.append("SELECT ID_CREDITO,");
			query.append(" FK_CERTIFICATORE,");
			query.append(" VALORE_CREDITO_FINALE");
			query.append(" FROM SICEE_T_CREDITO");
			query.append(" WHERE FK_CERTIFICATORE = ?");
			query.append(" ORDER BY ID_CREDITO DESC");

			if (log.isDebugEnabled())
				log.debug(query);
			
			List<OptimizedSiceeTCredito> rs = jdbcTemplate.query(query.toString(), this, fkCertificatore);
			if (rs.size() > 0)
				return jdbcTemplate.query(query.toString(), this, fkCertificatore).get(0);
			else
				return null;
		} catch (Exception e) {
			throw new OptimizedSiceeTCreditoDaoException("Query failed", e);
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
	 * @return OptimizedSiceeTCredito
	 */
	public OptimizedSiceeTCredito mapRow(ResultSet rs, int row)
			throws SQLException {
		OptimizedSiceeTCredito dto = new OptimizedSiceeTCredito();

		dto.setIdCredito(rs.getInt(1));
		dto.setFkCertificatore(rs.getString(2));
		dto.setValoreCreditoFinale(rs.getFloat(3));

		return dto;
	}

	
}
