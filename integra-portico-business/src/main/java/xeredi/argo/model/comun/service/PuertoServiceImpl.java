package xeredi.argo.model.comun.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.dao.PuertoDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoServiceImpl.
 */
@Singleton
@Transactional
public class PuertoServiceImpl implements PuertoService {

	/** The prto DAO. */
	@Inject
	private PuertoDAO prtoDAO;

	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PuertoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoCriterio.setId(id);
		prtoCriterio.setIdioma(idioma);

		final PuertoVO prto = selectObject(prtoCriterio);

		if (prto == null) {
			throw new InstanceNotFoundException(MessageI18nKey.prto, id);
		}

		return prto;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PuertoVO selectObject(@NonNull final PuertoCriterioVO prtoCriterio) {
		return prtoDAO.selectObject(prtoCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PuertoVO> selectList(@NonNull final PuertoCriterioVO criterio) {
		return prtoDAO.selectList(criterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaginatedList<PuertoVO> selectList(@NonNull final PuertoCriterioVO criterio, int offset, int limit) {
		final int count = prtoDAO.count(criterio);

		return new PaginatedList<PuertoVO>(
				count >= offset ? prtoDAO.selectList(criterio, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final PuertoVO prto, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		Preconditions.checkNotNull(prto.getCodigo());
		Preconditions.checkNotNull(prto.getCodigoCorto());
		Preconditions.checkNotNull(prto.getSprt());
		Preconditions.checkNotNull(prto.getSprt().getId());

		if (prtoDAO.exists(prto)) {
			throw new DuplicateInstanceException(MessageI18nKey.prto, prto);
		}

		IgUtilBO.assignNextVal(prto);
		prtoDAO.insert(prto);
		I18nUtil.insertMap(i18nDAO, prto, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final PuertoVO prto, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(prto.getId());
		Preconditions.checkNotNull(prto.getCodigoCorto());
		Preconditions.checkNotNull(prto.getSprt());
		Preconditions.checkNotNull(prto.getSprt().getId());

		if (prtoDAO.update(prto) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.prto, prto);
		}

		I18nUtil.updateMap(i18nDAO, prto, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(PuertoVO prto) throws InstanceNotFoundException {
		Preconditions.checkNotNull(prto.getId());

		if (prtoDAO.delete(prto) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.prto, prto);
		}

		I18nUtil.deleteMap(i18nDAO, prto);
	}
}
