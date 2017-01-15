package xeredi.argo.model.item.service;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.dao.ItemTramiteDAO;
import xeredi.argo.model.item.dao.ItemTramiteDatoDAO;
import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class ItemTramiteServiceImpl implements ItemTramiteService {

	/** The ittr DAO. */
	@Inject
	private ItemTramiteDAO ittrDAO;

	/** The ittd DAO. */
	@Inject
	private ItemTramiteDatoDAO ittdDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemTramiteVO select(Long id, String idioma) throws InstanceNotFoundException {
		final ItemTramiteCriterioVO ittrCriterio = new ItemTramiteCriterioVO();

		ittrCriterio.setId(id);
		ittrCriterio.setIdioma(idioma);

		final ItemTramiteVO ittr = ittrDAO.selectObject(ittrCriterio);

		if (ittr == null) {
			throw new InstanceNotFoundException(MessageI18nKey.ittr, id);
		}

		ittrCriterio.setFechaVigencia(ittr.getFref());

		for (final ItemTramiteDatoVO ittd : ittdDAO.selectList(ittrCriterio)) {
			ittr.getIttdMap().put(ittd.getTpdtId(), ittd);
		}

		return ittr;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ItemTramiteVO> selectList(ItemTramiteCriterioVO criterio) {
		return ittrDAO.selectList(criterio);
	}
}
