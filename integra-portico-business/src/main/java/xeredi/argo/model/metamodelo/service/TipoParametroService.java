package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.TipoParametroDAO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
@Singleton
public class TipoParametroService {

	/** The tppr DAO. */
	@Inject
	private TipoParametroDAO tpprDAO;

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Select label values.
	 *
	 * @param tpprCriterio
	 *            the tppr criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(final TipoParametroCriterioVO tpprCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoParametroVO tppr : selectList(tpprCriterio)) {
			list.add(new LabelValueVO(tppr.getNombre(), tppr.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpprCriterioVO
	 *            the tppr criterio VO
	 * @return the list
	 */
	public List<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO) {
		return tpprDAO.selectList(tpprCriterioVO);
	}

	/**
	 * Select list.
	 *
	 * @param tpprCriterioVO
	 *            the tppr criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO, int offset,
			int limit) {
		final int count = tpprDAO.count(tpprCriterioVO);

		return new PaginatedList<>(
				count > offset ? tpprDAO.selectList(tpprCriterioVO, new RowBounds(offset, limit)) : new ArrayList<>(),
				offset, limit, count);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo parametro VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoParametroVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final TipoParametroCriterioVO entiCriterio = new TipoParametroCriterioVO();

		entiCriterio.setId(id);
		entiCriterio.setIdioma(idioma);

		final TipoParametroVO enti = tpprDAO.selectObject(entiCriterio);

		if (enti == null) {
			throw new InstanceNotFoundException(MessageI18nKey.tppr, id);
		}

		return enti;
	}

	/**
	 * Insert.
	 *
	 * @param tppr
	 *            the tppr
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TipoParametroVO tppr, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (entiDAO.exists(tppr)) {
			throw new DuplicateInstanceException(MessageI18nKey.tppr, tppr);
		}

		IgUtilBO.assignNextVal(tppr);
		tppr.setTipo(TipoEntidad.P);

		entiDAO.insert(tppr);
		tpprDAO.insert(tppr);

		i18nService.insertMap(tppr, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param tppr
	 *            the tppr
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TipoParametroVO tppr, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(tppr.getId());

		if (tpprDAO.update(tppr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tppr, tppr);
		}

		entiDAO.update(tppr);
		i18nService.updateMap(tppr, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param tppr
	 *            the tppr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TipoParametroVO tppr) throws InstanceNotFoundException {
		Preconditions.checkNotNull(tppr.getId());

		if (tpprDAO.delete(tppr) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.tppr, tppr);
		}

		i18nService.deleteMap(tppr);
		entiDAO.delete(tppr);
	}
}
