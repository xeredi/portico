package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

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
    @Getter
    protected Map<String, I18nVO> i18nMap;

    /** The entd list. */
    @Getter
    protected List<EntidadTipoDatoVO> entdList;

    /** The engd list. */
    @Getter
    protected List<EntidadGrupoDatoVO> engdList;

    /** The enac list. */
    @Getter
    protected List<AccionEspecialVO> acesList;

    /** The acen list. */
    @Getter
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

        final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

        acesCriterio.setEntiId(model.getId());
        acesCriterio.setIdioma(getIdioma());

        acesList = new AccionEspecialBO().selectList(acesCriterio);

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
}
