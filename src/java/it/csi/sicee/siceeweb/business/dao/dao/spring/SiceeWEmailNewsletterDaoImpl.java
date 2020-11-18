/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeWEmailNewsletterDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeWEmailNewsletter;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeWEmailNewsletterDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeWEmailNewsletterDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeWEmailNewsletter>, SiceeWEmailNewsletterDao
{
	protected SimpleJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	/**
	 * Method 'setDataSource'
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 */
	
	public void insert(SiceeWEmailNewsletter dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( EMAIL ) VALUES ( ? )",dto.getEmail());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeWEmailNewsletter
	 */
	public SiceeWEmailNewsletter mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeWEmailNewsletter dto = new SiceeWEmailNewsletter();
		dto.setEmail( rs.getString( 1 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_W_EMAIL_NEWSLETTER";
	}

	/** 
	 * Returns all rows from the SICEE_W_EMAIL_NEWSLETTER table that match the criteria ''.
	 */
	
	public List<SiceeWEmailNewsletter> findAll() throws SiceeWEmailNewsletterDaoException
	{
		try {
			return jdbcTemplate.query("SELECT EMAIL FROM " + getTableName() + "", this);
		}
		catch (Exception e) {
			throw new SiceeWEmailNewsletterDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_W_EMAIL_NEWSLETTER table that match the criteria 'EMAIL = :eMail'.
	 */
	
	public SiceeWEmailNewsletter findWhereEmailEquals(String eMail) throws SiceeWEmailNewsletterDaoException
	{
		try {
			List<SiceeWEmailNewsletter> list = jdbcTemplate.query("SELECT EMAIL FROM " + getTableName() + " WHERE EMAIL = ?", this,eMail);			
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeWEmailNewsletterDaoException("Query failed", e);
		}
		
	}

}
