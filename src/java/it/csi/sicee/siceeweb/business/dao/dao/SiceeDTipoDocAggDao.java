package it.csi.sicee.siceeweb.business.dao.dao;



import it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoDocAgg;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntiva;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntivaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDocAggiuntivaDaoException;

import java.util.List;

public interface SiceeDTipoDocAggDao {
	public SiceeDTipoDocAgg findByPrimaryKey(Integer idDoc) throws SiceeTDocAggiuntivaDaoException;

	public List<SiceeDTipoDocAgg> findAll() throws SiceeTDocAggiuntivaDaoException;
}
