package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nUtil;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoServicioDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioServiceImpl.
 */
@Singleton
@Transactional
public class TipoServicioServiceImpl implements TipoServicioService {

	/** The tpsr DAO. */
	@Inject
	private TipoServicioDAO tpsrDAO;

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LabelValueVO> selectLabelValues(TipoServicioCriterioVO criterioVO) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoServicioVO tpsr : selectList(criterioVO)) {
			list.add(new LabelValueVO(tpsr.getNombre(), tpsr.getId()));
		}

		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TipoServicioVO> selectList(TipoServicioCriterioVO tpsrCriterio) {
		return tpsrDAO.selectList(tpsrCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<TipoServicioVO> selectList(TipoServicioCriterioVO tpsrCriterio, int offset, int limit) {
		final int count = tpsrDAO.count(tpsrCriterio);

		return new PaginatedList<>(
				count > offset ? tpsrDAO.selectList(tpsrCriterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoServicioVO select(Long id, String idioma) throws InstanceNotFoundException {
		final TipoServicioCriterioVO entiCriterio = new TipoServicioCriterioVO();

		entiCriterio.setId(id);
		entiCriterio.setIdioma(idioma);

		final TipoServicioVO enti = tpsrDAO.selectObject(entiCriterio);

		if (enti == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsr, id);
		}

		return enti;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(TipoServicioVO tpsr, Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
		if (entiDAO.exists(tpsr)) {
			throw new DuplicateInstanceException(MessageI18nKey.tpsr, tpsr);
		}

		IgUtilBO.assignNextVal(tpsr);
		tpsr.setTipo(TipoEntidad.T);

		entiDAO.insert(tpsr);
		tpsrDAO.insert(tpsr);
		I18nUtil.insertMap(i18nDAO, tpsr, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(TipoServicioVO tpsr, Map<String, I18nVO> i18nMap) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpsr.getId());

		if (tpsrDAO.update(tpsr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsr, tpsr);
		}

		entiDAO.update(tpsr);
		I18nUtil.updateMap(i18nDAO, tpsr, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(TipoServicioVO tpsr) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tpsr.getId());

		if (tpsrDAO.delete(tpsr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tpsr, tpsr);
		}

		I18nUtil.deleteMap(i18nDAO, tpsr);
		entiDAO.delete(tpsr);
	}
}
