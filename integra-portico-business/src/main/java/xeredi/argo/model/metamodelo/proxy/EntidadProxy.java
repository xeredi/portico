package xeredi.argo.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.EntidadAccionBO;
import xeredi.argo.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionVO;
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
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadBO.
 */
public final class EntidadProxy {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(EntidadProxy.class);

    /** The Constant LABEL_VALUE_LIST. */
    private static final List<LabelValueVO> LABEL_VALUE_LIST = new ArrayList<>();

    /** The Constant ENTIDAD_MAP. */
    private static final Map<Long, AbstractEntidadDetailVO> ENTIDAD_MAP = new HashMap<>();

    static {
        load();
    }

    /**
     * Select label values.
     *
     * @return the list
     */
    public static List<LabelValueVO> selectLabelValues() {
        return LABEL_VALUE_LIST;
    }

    /**
     * Select map.
     *
     * @return the map
     */
    public static Map<Long, AbstractEntidadDetailVO> selectMap() {
        return ENTIDAD_MAP;
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the entidad vo
     */
    public static AbstractEntidadDetailVO select(final Long id) {
        if (!ENTIDAD_MAP.containsKey(id)) {
            throw new Error(new InstanceNotFoundException(MessageI18nKey.enti, id));
        }

        return ENTIDAD_MAP.get(id);
    }

    /**
     * Load.
     */
    static void load() {
        LOG.info("Carga de Entidades");

        final EntidadBO entiBO = new EntidadBO();

        for (final EntidadVO enti : entiBO.selectList(new EntidadCriterioVO())) {
            final EntidadDetailVO entiDetail = new EntidadDetailVO();

            entiDetail.setEnti(enti);

            ENTIDAD_MAP.put(entiDetail.getEnti().getId(), entiDetail);
        }

        LABEL_VALUE_LIST.addAll(entiBO.selectLabelValues(new EntidadCriterioVO()));

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        for (final EntidadGrupoDatoVO engd : engdBO.selectList(new EntidadGrupoDatoCriterioVO())) {
            final AbstractEntidadDetailVO entidadDetail = ENTIDAD_MAP.get(engd.getEntiId());

            if (entidadDetail.getEngdList() == null) {
                entidadDetail.setEngdList(new ArrayList<EntidadGrupoDatoVO>());
            }

            entidadDetail.getEngdList().add(engd);
            engd.setEntiId(null);
        }

        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

        for (final EntidadTipoDatoVO entd : entdBO.selectList(new EntidadTipoDatoCriterioVO())) {
            final AbstractEntidadDetailVO entiDetail = ENTIDAD_MAP.get(entd.getEntiId());

            if (entiDetail.getEntdList() == null) {
                entiDetail.setEntdList(new ArrayList<Long>());
                entiDetail.setEntdGridList(new ArrayList<Long>());
                entiDetail.setEntdMap(new HashMap<Long, EntidadTipoDatoVO>());
            }

            if (entd.getTpdt() != null) {
                entd.setTpdt(TipoDatoProxy.select(entd.getTpdt().getId()));
            }

            if (entd.getGridable()) {
                entiDetail.getEntdGridList().add(entd.getTpdt().getId());
            }
            entiDetail.getEntdList().add(entd.getTpdt().getId());
            entiDetail.getEntdMap().put(entd.getTpdt().getId(), entd);
        }

        final EntidadEntidadBO enenBO = new EntidadEntidadBO();

        for (final EntidadEntidadVO enen : enenBO.selectList(new EntidadEntidadCriterioVO())) {
            final AbstractEntidadDetailVO entiDetailPadre = ENTIDAD_MAP.get(enen.getEntiPadreId());
            final AbstractEntidadDetailVO entiDetailHija = ENTIDAD_MAP.get(enen.getEntiHija().getId());

            if (entiDetailPadre.getEntiHijasList() == null) {
                entiDetailPadre.setEntiHijasList(new ArrayList<Long>());
            }
            entiDetailPadre.getEntiHijasList().add(entiDetailHija.getEnti().getId());

            if (entiDetailHija.getEntiPadresList() == null) {
                entiDetailHija.setEntiPadresList(new ArrayList<Long>());
            }
            entiDetailHija.getEntiPadresList().add(entiDetailPadre.getEnti().getId());
        }

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        for (final EntidadAccionVO enac : enacBO.selectList(new EntidadAccionCriterioVO())) {
            final AbstractEntidadDetailVO entiDetail = ENTIDAD_MAP.get(enac.getEntiId());

            if (entiDetail.getEnacList() == null) {
                entiDetail.setEnacList(new ArrayList<EntidadAccionVO>());
            }
            entiDetail.getEnacList().add(enac);
            enac.setEntiId(null);
        }

        final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

        for (final EntidadAccionGridVO enag : enagBO.selectList(new EntidadAccionGridCriterioVO())) {
            final AbstractEntidadDetailVO entiDetail = ENTIDAD_MAP.get(enag.getEntiId());

            if (entiDetail.getEnagList() == null) {
                entiDetail.setEnagList(new ArrayList<EntidadAccionGridVO>());
            }
            entiDetail.getEnagList().add(enag);
            enag.setEntiId(null);
        }

        final TramiteBO trmtBO = new TramiteBO();
        final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

        for (final TramiteVO trmt : trmtBO.selectList(trmtCriterio)) {
            final AbstractEntidadDetailVO entiDetail = ENTIDAD_MAP.get(trmt.getEntiId());

            if (entiDetail.getTrmtList() == null) {
                entiDetail.setTrmtList(new ArrayList<TramiteVO>());
            }

            entiDetail.getTrmtList().add(trmt);
            trmt.setEntiId(null);
        }

        LOG.info("Carga de entidades OK");
    }

    /**
     * Load dependencies.
     *
     * @param entiMap
     *            the enti map
     */
    static void loadDependencies(final Map<Long, ? extends AbstractEntidadDetailVO> entiMap) {
        for (final AbstractEntidadDetailVO entiDetail : entiMap.values()) {
            if (ENTIDAD_MAP.containsKey(entiDetail.getEnti().getId())) {
                entiDetail.setEntdList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEntdList());
                entiDetail.setEntdGridList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEntdGridList());
                entiDetail.setEntdMap(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEntdMap());
                entiDetail.setEntiHijasList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEntiHijasList());
                entiDetail.setEntiPadresList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEntiPadresList());
                entiDetail.setEnacList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEnacList());
                entiDetail.setEnagList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEnagList());
                entiDetail.setEngdList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEngdList());
                entiDetail.setTrmtList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getTrmtList());
            }
        }
    }
}
