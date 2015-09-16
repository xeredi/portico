package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleEditAction.
 */
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
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getRgla1Id());

            model.getVersion().setFini(model.getFref());
        } else {
            Preconditions.checkNotNull(model.getId());

            final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
            final ReglaIncompatibleCriterioVO rginCriterio = new ReglaIncompatibleCriterioVO();

            rginCriterio.setId(model.getId());
            rginCriterio.setFechaVigencia(model.getFref());
            rginCriterio.setIdioma(idioma);

            model = rginBO.selectObject(rginCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final ReglaBO rglaBO = new ReglaBO();
        final ReglaCriterioVO rgla1Criterio = new ReglaCriterioVO();

        rgla1Criterio.setId(model.getRgla1Id());
        rgla1Criterio.setFechaVigencia(model.getFref());

        final ReglaVO rgla = rglaBO.selectObject(rgla1Criterio);

        final ReglaCriterioVO rgla2Criterio = new ReglaCriterioVO();

        rgla2Criterio.setCrgoId(rgla.getCrgo().getId());
        rgla2Criterio.setFechaVigencia(model.getFref());

        rgla2List = rglaBO.selectList(rgla2Criterio);
    }

    /**
     * Gets the rgla2 list.
     *
     * @return the rgla2 list
     */
    public List<ReglaVO> getRgla2List() {
        return rgla2List;
    }
}
