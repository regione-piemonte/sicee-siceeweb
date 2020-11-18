/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoPagamentoDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoPagamento;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoPagamentoPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeDTipoPagamentoDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeDTipoPagamentoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoPagamento>, SiceeDTipoPagamentoDao
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
	 * @return SiceeDTipoPagamentoPk
	 */
	
	public SiceeDTipoPagamentoPk insert(SiceeDTipoPagamento dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_PAGAMENTO, DESCR, FLG_PAGAM_ATTIVO ) VALUES ( ?, ?, ? )",dto.getIdTipoPagamento(),dto.getDescr(),dto.getFlgPagamAttivo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_PAGAMENTO table.
	 */
	
	public void update(SiceeDTipoPagamentoPk pk, SiceeDTipoPagamento dto) throws SiceeDTipoPagamentoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_PAGAMENTO = ?, DESCR = ?, FLG_PAGAM_ATTIVO = ? WHERE ID_TIPO_PAGAMENTO = ?",dto.getIdTipoPagamento(),dto.getDescr(),dto.getFlgPagamAttivo(),pk.getIdTipoPagamento());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_PAGAMENTO table.
	 */
	
	public void delete(SiceeDTipoPagamentoPk pk) throws SiceeDTipoPagamentoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_PAGAMENTO = ?",pk.getIdTipoPagamento());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoPagamento
	 */
	public SiceeDTipoPagamento mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoPagamento dto = new SiceeDTipoPagamento();
		dto.setIdTipoPagamento( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setFlgPagamAttivo( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_TIPO_PAGAMENTO";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria 'ID_TIPO_PAGAMENTO = :idTipoPagamento'.
	 */
	
	public SiceeDTipoPagamento findByPrimaryKey(Integer idTipoPagamento) throws SiceeDTipoPagamentoDaoException
	{
		try {
			List<SiceeDTipoPagamento> list = jdbcTemplate.query("SELECT ID_TIPO_PAGAMENTO, DESCR, FLG_PAGAM_ATTIVO FROM " + getTableName() + " WHERE ID_TIPO_PAGAMENTO = ?", this,idTipoPagamento);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoPagamentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria ''.
	 */
	
	public List<SiceeDTipoPagamento> findAll() throws SiceeDTipoPagamentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_PAGAMENTO, DESCR, FLG_PAGAM_ATTIVO FROM " + getTableName() + " ORDER BY ID_TIPO_PAGAMENTO", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoPagamentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria 'ID_TIPO_PAGAMENTO = :idTipoPagamento'.
	 */
	
	public List<SiceeDTipoPagamento> findWhereIdTipoPagamentoEquals(Integer idTipoPagamento) throws SiceeDTipoPagamentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_PAGAMENTO, DESCR, FLG_PAGAM_ATTIVO FROM " + getTableName() + " WHERE ID_TIPO_PAGAMENTO = ? ORDER BY ID_TIPO_PAGAMENTO", this,idTipoPagamento);
		}
		catch (Exception e) {
			throw new SiceeDTipoPagamentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipoPagamento> findWhereDescrEquals(String descr) throws SiceeDTipoPagamentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_PAGAMENTO, DESCR, FLG_PAGAM_ATTIVO FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoPagamentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_PAGAMENTO table that match the criteria 'FLG_PAGAM_ATTIVO = :flgPagamAttivo'.
	 */
	
	public List<SiceeDTipoPagamento> findWhereFlgPagamAttivoEquals(String flgPagamAttivo) throws SiceeDTipoPagamentoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_PAGAMENTO, DESCR, FLG_PAGAM_ATTIVO FROM " + getTableName() + " WHERE FLG_PAGAM_ATTIVO = ? ORDER BY FLG_PAGAM_ATTIVO", this,flgPagamAttivo);
		}
		catch (Exception e) {
			throw new SiceeDTipoPagamentoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_PAGAMENTO table that matches the specified primary-key value.
	 */
	public SiceeDTipoPagamento findByPrimaryKey(SiceeDTipoPagamentoPk pk) throws SiceeDTipoPagamentoDaoException
	{
		return findByPrimaryKey( pk.getIdTipoPagamento() );
	}

}
