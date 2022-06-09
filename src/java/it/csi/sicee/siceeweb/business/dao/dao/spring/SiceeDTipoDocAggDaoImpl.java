package it.csi.sicee.siceeweb.business.dao.dao.spring;

import it.csi.sicee.siceeweb.business.dao.dao.SiceeDTipoDocAggDao;
import it.csi.sicee.siceeweb.business.dao.dao.SiceeTDocAggiuntivaDao;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocAgg;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntiva;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntivaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDocAggiuntivaDaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SiceeDTipoDocAggDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoDocAgg>, SiceeDTipoDocAggDao {
	protected JdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public SiceeDTipoDocAgg findByPrimaryKey(Integer idDoc) throws SiceeTDocAggiuntivaDaoException {
		try {
			List<SiceeDTipoDocAgg> list = jdbcTemplate.query("SELECT ID_TIPO_DOC_AGG,DESC_TIPO_DOCAGG FROM " + getTableName() + " WHERE ID_TIPO_DOC_AGG = ?", this,idDoc);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTDocAggiuntivaDaoException("Query failed", e);
		}
	}

	@Override
	public List<SiceeDTipoDocAgg> findAll() throws SiceeTDocAggiuntivaDaoException {
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_DOC_AGG,DESC_TIPO_DOCAGG FROM " + getTableName(), this);
		}
		catch (Exception e) {
			throw new SiceeTDocAggiuntivaDaoException("Query failed", e);
		}
	}

	@Override
	public SiceeDTipoDocAgg mapRow(ResultSet rs, int i) throws SQLException {
		SiceeDTipoDocAgg dto = new SiceeDTipoDocAgg();
		dto.setIdTipoDocAgg( rs.getInt( 1));
		dto.setDescTipoDocAgg( rs.getString( 2));
		return dto;
	}

	public String getTableName()
	{
		return "SICEE_D_TIPO_DOCAGG";
	}
}
