package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.I18nUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoEditAction.
 */
@Data
public final class AspectoEditAction extends CrudEditAction<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6065040172880726006L;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The enti list. */
    private List<LabelValueVO> tpsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion != AccionCodigo.create) {
            Preconditions.checkNotNull(model.getId());

            final AspectoBO aspcBO = new AspectoBO();

            model = aspcBO.select(model.getId(), model.getFref(), getIdioma());
            i18nMap = I18nUtilBO.selectMap(model);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            tpsrList = TipoServicioProxy.selectLabelValues();
        }
    }
}
