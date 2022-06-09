package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDocAggiuntivaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntiva;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntivaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDocAggiuntivaDaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SiceeTDocAggiuntivaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTDocAggiuntiva>, SiceeTDocAggiuntivaDao {
	protected JdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public SiceeTDocAggiuntivaPk insert(SiceeTDocAggiuntiva dto) {
		dto.setIdDocAggiuntiva(incrementer.nextIntValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " (ID_DOC_AGGIUNTIVA,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,ID_TIPO_DOC_AGG,ID_CERTIFICATORE,PROGR_CERTIFICATO,ANNO,DT_UPLOAD,DT_DELETE) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",dto.getIdDocAggiuntiva(),dto.getNomeDocOriginale(),dto.getNomeDoc(),dto.getUidIndex(),dto.getIdTipoDocAgg(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDtUpload(),dto.getDtDelete());
		return new SiceeTDocAggiuntivaPk(dto.getIdDocAggiuntiva());
	}

	@Override
	public void update(SiceeTDocAggiuntivaPk pk, SiceeTDocAggiuntiva dto) throws SiceeTDocAggiuntivaDaoException {
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DOC_AGGIUNTIVA = ?,NOME_DOC_ORIGINALE = ?,NOME_DOC = ?,UID_INDEX = ?,ID_TIPO_DOC_AGG = ?,ID_CERTIFICATORE = ?,PROGR_CERTIFICATO = ?,ANNO = ?,DT_UPLOAD = ?,DT_DELETE = ? WHERE ID_DOC_AGGIUNTIVA = ?",dto.getIdDocAggiuntiva(),dto.getNomeDocOriginale(),dto.getNomeDoc(),dto.getUidIndex(),dto.getIdTipoDocAgg(),dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getDtUpload(),dto.getDtDelete(),pk.getIdDocAggiuntiva());
	}

	@Override
	public void delete(SiceeTDocAggiuntivaPk pk) throws SiceeTDocAggiuntivaDaoException {
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DOC_AGGIUNTIVA = ?",pk.getIdDocAggiuntiva());
	}

	@Override
	public SiceeTDocAggiuntiva findByPrimaryKey(Integer idDoc) throws SiceeTDocAggiuntivaDaoException {
		try {
			List<SiceeTDocAggiuntiva> list = jdbcTemplate.query("SELECT ID_DOC_AGGIUNTIVA,NOME_DOC_ORIGINALE,NOME_DOC,UID_INDEX,ID_TIPO_DOC_AGG,ID_CERTIFICATORE,PROGR_CERTIFICATO,ANNO,DT_UPLOAD,DT_DELETE FROM " + getTableName() + " WHERE ID_DOC_AGGIUNTIVA = ?", this,idDoc);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDocAggiuntivaDaoException("Query failed", e);
		}
	}

	@Override
	public List<SiceeTDocAggiuntiva> findByApe(String idCertificatore, String progrCertificato, String anno) throws SiceeTDocAggiuntivaDaoException {
		try {
			List<SiceeTDocAggiuntiva> list = jdbcTemplate.query("SELECT ID_DOC_AGGIUNTIVA, NOME_DOC_ORIGINALE, NOME_DOC, UID_INDEX, ID_TIPO_DOC_AGG,ID_CERTIFICATORE,PROGR_CERTIFICATO,ANNO,DT_UPLOAD,DT_DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list;
		}
		catch (Exception e) {
			throw new SiceeTDocAggiuntivaDaoException("Query failed", e);
		}
	}

	@Override
	public SiceeTDocAggiuntiva mapRow(ResultSet rs, int i) throws SQLException {
		SiceeTDocAggiuntiva dto = new SiceeTDocAggiuntiva();
		dto.setIdDocAggiuntiva( rs.getInt( 1));

		dto.setNomeDocOriginale( rs.getString( 2));
		if (rs.wasNull()) {
			dto.setNomeDocOriginale( null );
		}
		dto.setNomeDoc( rs.getString( 3));
		if (rs.wasNull()) {
			dto.setNomeDoc( null );
		}
		dto.setUidIndex(rs.getString(4));
		if (rs.wasNull()) {
			dto.setUidIndex( null );
		}
		dto.setIdTipoDocAgg(rs.getInt(5));
		if (rs.wasNull()) {
			dto.setIdTipoDocAgg( null );
		}
		dto.setIdCertificatore(rs.getString(6));

		dto.setProgrCertificato(rs.getString(7));

		dto.setAnno(rs.getString(8));

		dto.setDtUpload(rs.getDate(9));
		if (rs.wasNull()) {
			dto.setDtUpload( null );
		}
		dto.setDtDelete(rs.getDate(10));
		if (rs.wasNull()) {
			dto.setDtDelete( null );
		}

		return dto;
	}

	public String getTableName()
	{
		return "SICEE_T_DOC_AGGIUNTIVA";
	}
}
