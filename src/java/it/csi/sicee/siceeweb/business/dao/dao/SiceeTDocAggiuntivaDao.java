package it.csi.sicee.siceeweb.business.dao.dao;

import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntiva;
import it.csi.sicee.siceeweb.business.dao.dto.SiceeTDocAggiuntivaPk;
import it.csi.sicee.siceeweb.business.dao.exceptions.SiceeTDocAggiuntivaDaoException;

import java.util.List;

public interface SiceeTDocAggiuntivaDao {
	public SiceeTDocAggiuntivaPk insert(SiceeTDocAggiuntiva dto);

	public void update(SiceeTDocAggiuntivaPk pk, SiceeTDocAggiuntiva dto) throws SiceeTDocAggiuntivaDaoException;

	public void delete(SiceeTDocAggiuntivaPk pk) throws SiceeTDocAggiuntivaDaoException;

	public SiceeTDocAggiuntiva findByPrimaryKey(Integer idDoc) throws SiceeTDocAggiuntivaDaoException;

	public List<SiceeTDocAggiuntiva> findByApe(String idCertificatore, String progrCertificato, String anno) throws SiceeTDocAggiuntivaDaoException;
}
