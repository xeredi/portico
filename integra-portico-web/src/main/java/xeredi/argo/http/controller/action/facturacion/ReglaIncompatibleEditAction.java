package xeredi.argo.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleEditAction.
 */
@Data
public final class ReglaIncompatibleEditAction extends CrudEditAction<ReglaIncompatibleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3935107404576977395L;

    /** The rgla2 list. */
    private List<ReglaVO> rgla2List = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            Preconditions.checkNotNull(model.getRgla1Id());

            model.getVersion().setFini(model.getFref());
        } else {
            Preconditions.checkNotNull(model.getId());

            final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

            model = rginBO.select(model.getId(), model.getFref());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final ReglaBO rglaBO = new ReglaBO();
        final ReglaVO rgla = rglaBO.select(model.getRgla1Id(), model.getFref(), getIdioma());

        final ReglaCriterioVO rgla2Criterio = new ReglaCriterioVO();

        rgla2Criterio.setCrgoId(rgla.getCrgo().getId());
        rgla2Criterio.setFechaVigencia(model.getFref());
        rgla2Criterio.setIdioma(getIdioma());

        rgla2List = rglaBO.selectList(rgla2Criterio);
    }
}
