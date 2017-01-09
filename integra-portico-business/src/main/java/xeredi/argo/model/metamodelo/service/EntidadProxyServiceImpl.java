package xeredi.argo.model.metamodelo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.argo.model.metamodelo.proxy.ValidacionProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

public class EntidadProxyServiceImpl implements EntidadProxyService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(EntidadProxyServiceImpl.class);

	/** The Constant LABEL_VALUE_LIST. */
	private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

	/** The Constant ENTIDAD_MAP. */
	private static final Map<Long, AbstractEntidadDetailVO> MAP = new HashMap<>();

	@Inject
	private EntidadService entiService;

	@Inject
	private EntidadGrupoDatoService engdService;

	@Inject
	private EntidadTipoDatoService entdService;

	@Inject
	private EntidadEntidadService enenService;

	@Inject
	private AccionEntidadService acenService;

	@Inject
	private AccionEspecialService acesService;

	@Inject
	private TramiteService trmtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractEntidadDetailVO select(Long id) {
		if (MAP.isEmpty()) {
			load();
		}

		if (!MAP.containsKey(id)) {
			throw new Error(new InstanceNotFoundException(MessageI18nKey.enti, id));
		}

		return MAP.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillDependencies(Map<Long, ? extends AbstractEntidadDetailVO> entiMap) {
		if (MAP.isEmpty()) {
			load();
		}

		for (final AbstractEntidadDetailVO entiDetail : entiMap.values()) {
			if (MAP.containsKey(entiDetail.getEnti().getId())) {
				entiDetail.setEntdList(MAP.get(entiDetail.getEnti().getId()).getEntdList());
				entiDetail.setEntdGridList(MAP.get(entiDetail.getEnti().getId()).getEntdGridList());
				entiDetail.setEntdMap(MAP.get(entiDetail.getEnti().getId()).getEntdMap());
				entiDetail.setEntiHijasList(MAP.get(entiDetail.getEnti().getId()).getEntiHijasList());
				entiDetail.setEntiPadresList(MAP.get(entiDetail.getEnti().getId()).getEntiPadresList());
				entiDetail.setAcenMap(MAP.get(entiDetail.getEnti().getId()).getAcenMap());
				entiDetail.setAcesList(MAP.get(entiDetail.getEnti().getId()).getAcesList());
				entiDetail.setEngdList(MAP.get(entiDetail.getEnti().getId()).getEngdList());
				entiDetail.setTrmtList(MAP.get(entiDetail.getEnti().getId()).getTrmtList());
			}
		}
	}

	private synchronized void load() {
		LOG.info("Entity Load");

		for (final EntidadVO enti : entiService.selectList(new EntidadCriterioVO())) {
			final EntidadDetailVO entiDetail = new EntidadDetailVO();

			entiDetail.setEnti(enti);

			MAP.put(entiDetail.getEnti().getId(), entiDetail);
		}

		LABEL_VALUE_LIST.addAll(entiService.selectLabelValues(new EntidadCriterioVO()));

		for (final EntidadGrupoDatoVO engd : engdService.selectList(new EntidadGrupoDatoCriterioVO())) {
			final AbstractEntidadDetailVO entidadDetail = MAP.get(engd.getEntiId());

			entidadDetail.getEngdList().add(engd);
			engd.setEntiId(null);
		}

		for (final EntidadTipoDatoVO entd : entdService.selectList(new EntidadTipoDatoCriterioVO())) {
			final AbstractEntidadDetailVO entiDetail = MAP.get(entd.getEntiId());

			if (entd.getTpdt() != null) {
				entd.setTpdt(TipoDatoProxy.select(entd.getTpdt().getId()));

				if (entd.getValidacion() != null) {
					entd.setVldn(ValidacionProxy.generate(entd.getTpdt().getTipoElemento(), entd.getValidacion()));
				}
			}

			if (entd.getGridable()) {
				entiDetail.getEntdGridList().add(entd.getTpdt().getId());
			}

			entiDetail.getEntdList().add(entd.getTpdt().getId());
			entiDetail.getEntdMap().put(entd.getTpdt().getId(), entd);
		}

		for (final EntidadEntidadVO enen : enenService.selectList(new EntidadEntidadCriterioVO())) {
			final AbstractEntidadDetailVO entiDetailPadre = MAP.get(enen.getEntiPadreId());
			final AbstractEntidadDetailVO entiDetailHija = MAP.get(enen.getEntiHija().getId());

			entiDetailPadre.getEntiHijasList().add(entiDetailHija.getEnti().getId());
			entiDetailHija.getEntiPadresList().add(entiDetailPadre.getEnti().getId());
		}

		for (final AccionEntidadVO acen : acenService.selectList(new AccionEntidadCriterioVO())) {
			final AbstractEntidadDetailVO entiDetail = MAP.get(acen.getEntiId());

			entiDetail.getAcenMap().put(acen.getAebs().getCodigo(), acen);
			acen.setEntiId(null);
		}

		for (final AccionEspecialVO aces : acesService.selectList(new AccionEspecialCriterioVO())) {
			final AbstractEntidadDetailVO entiDetail = MAP.get(aces.getEntiId());

			entiDetail.getAcesList().add(aces);
			aces.setEntiId(null);
		}

		for (final TramiteVO trmt : trmtService.selectList(new TramiteCriterioVO())) {
			final AbstractEntidadDetailVO entiDetail = MAP.get(trmt.getEntiId());

			entiDetail.getTrmtList().add(trmt);
			trmt.setEntiId(null);
		}

		LOG.info("Entity Load Success");
	}
}
