package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.AspectoCargoBO;
import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoDetailAction.
 */
@Data
public final class AspectoDetailAction extends CrudDetailAction<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1363256002707100032L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.aspc;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The ascr list. */
    private List<AspectoCargoVO> ascrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AspectoBO aspcBO = new AspectoBO();

        model = aspcBO.select(model.getId(), model.getFref(), getIdioma());
        i18nMap = I18nBO.selectMap(ClassPrefix.aspv, model.getVersion().getId());

        final AspectoCargoBO ascrBO = new AspectoCargoBO();
        final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

        ascrCriterio.setAspcId(model.getId());
        ascrCriterio.setFechaVigencia(model.getFref());
        ascrCriterio.setIdioma(idioma);

        ascrList = ascrBO.selectList(ascrCriterio);
    }
}
