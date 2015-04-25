package xeredi.integra.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadAccionBO;
import xeredi.integra.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
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
                entiDetail.setEntdList(new ArrayList<EntidadTipoDatoVO>());
            }

            if (entd.getTpdt() != null) {
                entd.setTpdt(TipoDatoProxy.select(entd.getTpdt().getId()));
            }

            entiDetail.getEntdList().add(entd);
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

        LOG.info("Carga de entidades OK");
    }

    /**
     * Load dependencies.
     *
     * @param entiMap
     *            the enti map
     */
    static void loadDependencies(final Map<Long, ? extends AbstractEntidadDetailVO> entiMap) {
        for (final AbstractEntidadDetailVO entidadDetail : entiMap.values()) {
            if (ENTIDAD_MAP.containsKey(entidadDetail.getEnti().getId())) {
                entidadDetail.setEntdList(ENTIDAD_MAP.get(entidadDetail.getEnti().getId()).getEntdList());
                entidadDetail.setEntiHijasList(ENTIDAD_MAP.get(entidadDetail.getEnti().getId()).getEntiHijasList());
                entidadDetail.setEntiPadresList(ENTIDAD_MAP.get(entidadDetail.getEnti().getId()).getEntiPadresList());
                entidadDetail.setEnacList(ENTIDAD_MAP.get(entidadDetail.getEnti().getId()).getEnacList());
                entidadDetail.setEnagList(ENTIDAD_MAP.get(entidadDetail.getEnti().getId()).getEnagList());
                entidadDetail.setEngdList(ENTIDAD_MAP.get(entidadDetail.getEnti().getId()).getEngdList());
            }
        }
    }
}
