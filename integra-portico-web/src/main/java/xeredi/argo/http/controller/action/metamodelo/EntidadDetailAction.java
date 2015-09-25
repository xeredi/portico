package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.bo.EntidadAccionBO;
import xeredi.argo.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.argo.model.metamodelo.vo.EntidadAccionVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadDetailAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class EntidadDetailAction<T extends EntidadVO> extends CrudDetailAction<T> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2541307413836565323L;

    /** The i18n map. */
    protected Map<String, I18nVO> i18nMap;

    /** The entd list. */
    protected List<EntidadTipoDatoVO> entdList;

    /** The engd list. */
    protected List<EntidadGrupoDatoVO> engdList;

    /** The enac list. */
    protected List<EntidadAccionVO> enacList;

    /** The enag list. */
    protected List<EntidadAccionGridVO> enagList;

    /** The acen list. */
    protected List<AccionEntidadVO> acenList;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        doSpecificDetail();

        i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());

        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();
        final EntidadTipoDatoCriterioVO entdCriterio = new EntidadTipoDatoCriterioVO();

        entdCriterio.setEntiId(model.getId());
        entdCriterio.setIdioma(idioma);

        entdList = entdBO.selectList(entdCriterio);

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();
        final EntidadGrupoDatoCriterioVO engdCriterio = new EntidadGrupoDatoCriterioVO();

        engdCriterio.setEntiId(model.getId());
        engdCriterio.setIdioma(idioma);

        engdList = engdBO.selectList(engdCriterio);

        final EntidadAccionBO enacBO = new EntidadAccionBO();
        final EntidadAccionCriterioVO enacCriterio = new EntidadAccionCriterioVO();

        enacCriterio.setEntiId(model.getId());
        enacCriterio.setIdioma(getIdioma());

        enacList = enacBO.selectList(enacCriterio);

        final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();
        final EntidadAccionGridCriterioVO enagCriterio = new EntidadAccionGridCriterioVO();

        enagCriterio.setEntiId(model.getId());
        enagCriterio.setIdioma(getIdioma());

        enagList = enagBO.selectList(enagCriterio);

        final AccionEntidadBO acenBO = new AccionEntidadBO();
        final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

        acenCriterio.setEntiId(model.getId());

        acenList = acenBO.selectList(acenCriterio);
    }

    /**
     * Do specific detail.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doSpecificDetail() throws ApplicationException;

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public final Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Gets the entd list.
     *
     * @return the entd list
     */
    public final List<EntidadTipoDatoVO> getEntdList() {
        return entdList;
    }

    /**
     * Gets the engd list.
     *
     * @return the engd list
     */
    public final List<EntidadGrupoDatoVO> getEngdList() {
        return engdList;
    }

    /**
     * Gets the enac list.
     *
     * @return the enac list
     */
    public final List<EntidadAccionVO> getEnacList() {
        return enacList;
    }

    /**
     * Gets the enag list.
     *
     * @return the enag list
     */
    public final List<EntidadAccionGridVO> getEnagList() {
        return enagList;
    }

    /**
     * Gets the acen list.
     *
     * @return the acen list
     */
    public final List<AccionEntidadVO> getAcenList() {
        return acenList;
    }
}
