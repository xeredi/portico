package xeredi.argo.model.metamodelo.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
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
    public static AbstractEntidadDetailVO select(@NonNull final Long id) {
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

        for (final EntidadGrupoDatoVO engd : new EntidadGrupoDatoBO().selectList(new EntidadGrupoDatoCriterioVO())) {
            final AbstractEntidadDetailVO entidadDetail = ENTIDAD_MAP.get(engd.getEntiId());

            entidadDetail.getEngdList().add(engd);
            engd.setEntiId(null);
        }

        for (final EntidadTipoDatoVO entd : new EntidadTipoDatoBO().selectList(new EntidadTipoDatoCriterioVO())) {
            final AbstractEntidadDetailVO entiDetail = ENTIDAD_MAP.get(entd.getEntiId());

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

        for (final EntidadEntidadVO enen : new EntidadEntidadBO().selectList(new EntidadEntidadCriterioVO())) {
            final AbstractEntidadDetailVO entiDetailPadre = ENTIDAD_MAP.get(enen.getEntiPadreId());
            final AbstractEntidadDetailVO entiDetailHija = ENTIDAD_MAP.get(enen.getEntiHija().getId());

            entiDetailPadre.getEntiHijasList().add(entiDetailHija.getEnti().getId());
            entiDetailHija.getEntiPadresList().add(entiDetailPadre.getEnti().getId());
        }

        for (final AccionEntidadVO acen : new AccionEntidadBO().selectList(new AccionEntidadCriterioVO())) {
            final AbstractEntidadDetailVO entiDetail = ENTIDAD_MAP.get(acen.getEntiId());

            entiDetail.getAcenMap().put(acen.getAebs().getCodigo(), acen);
            acen.setEntiId(null);
        }

        for (final AccionEspecialVO aces : new AccionEspecialBO().selectList(new AccionEspecialCriterioVO())) {
            final AbstractEntidadDetailVO entiDetail = ENTIDAD_MAP.get(aces.getEntiId());

            entiDetail.getAcesList().add(aces);
            aces.setEntiId(null);
        }

        for (final TramiteVO trmt : new TramiteBO().selectList(new TramiteCriterioVO())) {
            final AbstractEntidadDetailVO entiDetail = ENTIDAD_MAP.get(trmt.getEntiId());

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
                entiDetail.setAcenMap(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getAcenMap());
                entiDetail.setAcesList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getAcesList());
                entiDetail.setEngdList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getEngdList());
                entiDetail.setTrmtList(ENTIDAD_MAP.get(entiDetail.getEnti().getId()).getTrmtList());
            }
        }
    }
}
