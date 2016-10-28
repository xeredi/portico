package xeredi.argo.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoEditAction.
 */
@Data
public final class EntidadTipoDatoEditAction extends CrudEditAction<EntidadTipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3500048499586562595L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.entd;

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

        if (accion == AccionCodigo.create) {
            i18nMap = new HashMap<>();
        } else {
            Preconditions.checkNotNull(model.getId());

            final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

            model = entdBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(ClassPrefix.entd, model.getId());
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
}
