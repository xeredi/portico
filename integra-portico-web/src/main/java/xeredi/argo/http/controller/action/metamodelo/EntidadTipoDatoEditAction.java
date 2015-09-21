package xeredi.argo.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoEditAction.
 */
public final class EntidadTipoDatoEditAction extends CrudEditAction<EntidadTipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3500048499586562595L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The engd list. */
    private final List<LabelValueVO> engdList = new ArrayList<>();

    /** The tpdt list. */
    private final List<LabelValueVO> tpdtList = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiId());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

            model = entdBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.entd, model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();
        final EntidadGrupoDatoCriterioVO engdCriterio = new EntidadGrupoDatoCriterioVO();

        engdCriterio.setEntiId(model.getEntiId());
        engdCriterio.setIdioma(getIdioma());

        engdList.addAll(engdBO.selectLabelValues(engdCriterio));

        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final TipoDatoCriterioVO tpdtCriterioVO = new TipoDatoCriterioVO();

        tpdtCriterioVO.setIdioma(getIdioma());

        tpdtList.addAll(tpdtBO.selectLabelValues(tpdtCriterioVO));
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Gets the engd list.
     *
     * @return the engd list
     */
    public List<LabelValueVO> getEngdList() {
        return engdList;
    }

    /**
     * Gets the tpdt list.
     *
     * @return the tpdt list
     */
    public List<LabelValueVO> getTpdtList() {
        return tpdtList;
    }
}
