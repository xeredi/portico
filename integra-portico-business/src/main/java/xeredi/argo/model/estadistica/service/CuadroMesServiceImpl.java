package xeredi.argo.model.estadistica.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import xeredi.argo.model.estadistica.dao.CuadroMesDAO;
import xeredi.argo.model.estadistica.vo.CuadroMesVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesServiceImpl.
 */
@Singleton
@Transactional
public class CuadroMesServiceImpl implements CuadroMesService {

	/** The cdms DAO. */
	@Inject
	private CuadroMesDAO cdmsDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, List<CuadroMesVO>> selectMap(Long peprId) {
		final Map<String, List<CuadroMesVO>> cdmsMap = new HashMap<>();
		final PeriodoProcesoCriterioVO peprCriterio = new PeriodoProcesoCriterioVO();

		peprCriterio.setId(peprId);

		for (final CuadroMesVO cdmsVO : cdmsDAO.selectList(peprCriterio)) {
			final String cocuKey = cdmsVO.getCocu();

			if (!cdmsMap.containsKey(cocuKey)) {
				cdmsMap.put(cocuKey, new ArrayList<CuadroMesVO>());
			}

			cdmsMap.get(cocuKey).add(cdmsVO);
		}

		return cdmsMap;
	}
}
